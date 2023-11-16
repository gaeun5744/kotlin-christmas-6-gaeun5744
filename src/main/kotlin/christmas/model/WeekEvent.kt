package christmas.model

import christmas.util.*
import christmas.util.OrderManager.getTotalOrderAmount

class WeekEvent(private val date: Int, private val order: Map<String, Int>) : DecemberEvent() {

    override val period = DecemberEventData.WEEK_EVENT_DATA.period
    override val benefitCriteria = DecemberEventData.WEEK_EVENT_DATA.benefitCriteria

    override fun getBenefit(): Int {
        if (!checkMatch()) return NO_BENEFIT
        return -getCountDessert() * benefitCriteria
    }

    override fun checkMatch(): Boolean =
        date in period && getCountDessert() >= MINIMUM_DESSERT_COUNT && getTotalOrderAmount(order) >= MINIMUM_EVENT_AMOUNT


    private fun getCountDessert(): Int {
        val dessertName = Menu.DESSERT.detailMenu.map { it.menuName }
        return dessertName.intersect(order.keys).sumOf { order[it]!! }
    }

    companion object {
        private const val MINIMUM_DESSERT_COUNT = 1
    }

}