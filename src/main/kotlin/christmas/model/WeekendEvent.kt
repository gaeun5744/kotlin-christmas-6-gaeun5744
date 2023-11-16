package christmas.model

import christmas.util.*
import christmas.util.OrderManager.getTotalOrderAmount

class WeekendEvent(private val date: Int, private val order: Map<String, Int>) : DecemberEvent() {

    override val period = DecemberEventData.WEEKEND_EVENT_DATA.period
    override val benefitCriteria = DecemberEventData.WEEKEND_EVENT_DATA.benefitCriteria

    override fun getBenefit(): Int {
        if (!checkMatch()) return NO_BENEFIT
        return -getCountMain() * benefitCriteria
    }

    override fun checkMatch(): Boolean =
        date in period && getCountMain() >= MINIMUM_MAIN_COUNT && getTotalOrderAmount(order) >= MINIMUM_EVENT_AMOUNT


    private fun getCountMain(): Int {
        val mainName = Menu.MAIN.detailMenu.map { it.menuName }
        return mainName.intersect(order.keys).sumOf { order[it]!! }
    }

    companion object {
        private const val MINIMUM_MAIN_COUNT = 1
    }
}