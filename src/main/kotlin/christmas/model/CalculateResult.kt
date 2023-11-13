package christmas.model

import christmas.util.DetailMenu

object CalculateResult{

    fun getTotalBenefit(
        weekEvent: Int,
        weekendEvent: Int,
        specialEvent: Int,
        presentEvent: Int,
        christmasEvent: Int
    ): Int {
        return weekEvent + weekendEvent + specialEvent + presentEvent + christmasEvent
    }

    fun getTotalOrderAmount(order: Map<String, Int>): Int = order.map { (menu, count) ->
        val menu = DetailMenu.values().first { it.menuName == menu }
        menu.price * count
    }.sum()


}