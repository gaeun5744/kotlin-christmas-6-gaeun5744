package christmas.model

import christmas.util.DecemberEventData
import christmas.util.Menu
import christmas.util.OrderManager.getTotalOrderAmount
import christmas.util.DecemberEvent

class WeekEvent(private val date: Int, private val order: Map<String, Int>): DecemberEvent() {

    override val period = DecemberEventData.WEEK_EVENT_DATA.period
    override val benefitAmount = DecemberEventData.WEEK_EVENT_DATA.benefitAmount

    override fun getBenefitAmount(): Int {
        if (!checkMatch()) return 0
        return -getCountDessert() * benefitAmount
    }

    override fun checkMatch(): Boolean =
        date in period && getCountDessert() > 0 && getTotalOrderAmount(order) > 10_000


    private fun getCountDessert(): Int {
        val dessertName = Menu.DESSERT.detailMenu.map { it.menuName }
        return dessertName.intersect(order.keys).sumOf { order[it]!! }
    }

}