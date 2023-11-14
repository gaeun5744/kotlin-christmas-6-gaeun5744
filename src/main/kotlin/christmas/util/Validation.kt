package christmas.util

import christmas.util.ErrorMessage.INVALID_DATE_RANGE
import christmas.util.ErrorMessage.INVALID_MENU
import christmas.util.ErrorMessage.NOT_NUM
import christmas.util.ErrorMessage.ORDER_MORE_20
import christmas.util.ErrorMessage.ORDER_ONLY_DRINK

object Validation {

    fun checkDate(date: String) {
        checkIsDigit(date)
        checkDateRange(date)
    }

    private fun checkIsDigit(date: String) {
        try {
            date.toInt()
        } catch (e: NumberFormatException) {
            throw NumberFormatException(NOT_NUM)
        }
    }

    private fun checkDateRange(date: String) {
        require(date.toInt() in 1..31) {
            INVALID_DATE_RANGE
        }
    }

    fun checkMenu(order: String) {
        checkValidForm(order)
        checkNotMenu(order)
        checkMenuCount(order)
        checkUniqueOrder(order)
        checkTotalCount(order)
        checkOnlyDrink(order)
    }

    private fun checkValidForm(order: String) {
        try {
            getRefinedOrder(order)
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(INVALID_MENU)
        }
    }

    private fun getRefinedOrder(order: String) = order.split(",").associate { order ->
        val (key, value) = order.split("-")
        key to value.toInt()
    }

    private fun checkNotMenu(order: String) {
        val refinedOrder = getRefinedOrder(order)
        val menuName = DetailMenu.values().map { it.menuName }
        refinedOrder.keys.forEach { menu ->
            require(menuName.contains(menu)) {
                INVALID_MENU
            }
        }
    }

    private fun checkMenuCount(order: String) {
        val refinedOrder = getRefinedOrder(order)
        refinedOrder.values.forEach { count ->
            require(count >= 1) {
                INVALID_MENU
            }
        }
    }

    private fun checkUniqueOrder(order: String) {
        val refinedOrder = getRefinedOrder(order)
        val menuName = DetailMenu.values().map { it.menuName }
        refinedOrder.keys.forEach { menu ->
            require(menuName.count { it == menu } == 1) {
                INVALID_MENU
            }
        }
    }

    private fun checkTotalCount(order: String) {
        val refinedOrder = getRefinedOrder(order)
        require(refinedOrder.values.sum() > 20) {
            ORDER_MORE_20
        }
    }

    private fun checkOnlyDrink(order: String) {
        val nonDrinkMenus = Menu.values().filter { it != Menu.DESSERT }.flatMap { it.detailMenu }.map { it.menuName }
        val orderMenu = getRefinedOrder(order).keys
        require(nonDrinkMenus.intersect(orderMenu).isNotEmpty()){
            ORDER_ONLY_DRINK
        }
    }

}