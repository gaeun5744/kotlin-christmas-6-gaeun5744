package christmas.util

object OrderManager {

    fun getTotalOrderAmount(order: Map<String, Int>): Int = order.map { (menu, count) ->
        val menu = DetailMenu.values().first { it.menuName == menu }
        menu.price * count
    }.sum()

    fun getRefinedOrder(order: String) = order.split(",").associate { order ->
        val (key, value) = order.split("-")
        key to value.toInt()
    }
}