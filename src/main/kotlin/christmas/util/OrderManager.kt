package christmas.util

object OrderManager {

    private const val DIVIDE_MENU = ","
    private const val DIVIDE_COUNT = "-"

    fun getTotalOrderAmount(order: Map<String, Int>): Int = order.map { (menu, count) ->
        val menu = DetailMenu.values().first { it.menuName == menu }
        menu.price * count
    }.sum()

    fun getRefinedOrder(order: String) = order.split(DIVIDE_MENU).associate { order ->
        val (key, value) = order.split(DIVIDE_COUNT)
        key to value.toInt()
    }
}