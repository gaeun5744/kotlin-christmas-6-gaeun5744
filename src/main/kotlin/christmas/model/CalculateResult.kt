package christmas.model

import christmas.util.DetailMenu

object CalculateResult{

    fun getTotalOrderAmount(order: Map<String, Int>): Int = order.map { (menu, count) ->
        val menu = DetailMenu.values().first { it.menuName == menu }
        menu.price * count
    }.sum()

}