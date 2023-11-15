package christmas.model

import christmas.util.DecemberEvent
import christmas.util.Menu
import christmas.util.OrderManager.getTotalOrderAmount

class WeekEvent(private val date: Int, private val order: Map<String, Int>) {

    private val period = DecemberEvent.WEEK_EVENT.period
    private val benefitAmount = DecemberEvent.WEEK_EVENT.benefitAmount

    fun getBenefitAmount(): Int {
        if (!checkMatch()) return 0
        return -getCountDessert() * benefitAmount
    }

    fun checkMatch(): Boolean =
        date in period && getCountDessert() > 0 && getTotalOrderAmount(order) > 10_000


    private fun getCountDessert(): Int {
        val dessertName = Menu.DESSERT.detailMenu.map { it.menuName }
        return dessertName.intersect(order.keys).sumOf { order[it]!! }
    }


}