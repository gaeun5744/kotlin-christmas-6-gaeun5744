package christmas.util

import christmas.util.ErrorMessage.INVALID_DATE_RANGE
import christmas.util.ErrorMessage.INVALID_MENU
import christmas.util.ErrorMessage.NOT_NUM

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

}