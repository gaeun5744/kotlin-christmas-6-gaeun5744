package christmas.model

import christmas.util.DecemberEventData
import christmas.util.Menu
import christmas.util.OrderManager.getTotalOrderAmount
import christmas.util.DecemberEvent
import christmas.util.MINIMUM_EVENT_AMOUNT

class WeekEvent(private val date: Int, private val order: Map<String, Int>): DecemberEvent() {

    override val period = DecemberEventData.WEEK_EVENT_DATA.period
    override val benefitCriteria = DecemberEventData.WEEK_EVENT_DATA.benefitCriteria

    override fun getBenefit(): Int {
        if (!checkMatch()) return 0
        return -getCountDessert() * benefitCriteria
    }

    override fun checkMatch(): Boolean =
        date in period && getCountDessert() > 0 && getTotalOrderAmount(order) > MINIMUM_EVENT_AMOUNT


    private fun getCountDessert(): Int {
        val dessertName = Menu.DESSERT.detailMenu.map { it.menuName }
        return dessertName.intersect(order.keys).sumOf { order[it]!! }
    }

}