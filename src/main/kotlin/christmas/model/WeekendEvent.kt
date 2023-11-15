package christmas.model

import christmas.util.DecemberEvent
import christmas.util.DecemberEventData
import christmas.util.Menu
import christmas.util.OrderManager.getTotalOrderAmount

class WeekendEvent(private val date: Int, private val order: Map<String, Int>):DecemberEvent() {

    override val period = DecemberEventData.WEEKEND_EVENT_DATA.period
    override val benefitAmount = DecemberEventData.WEEKEND_EVENT_DATA.benefitAmount

    override fun getBenefitAmount(): Int {
        if (!checkMatch()) return 0
        return -getCountMain() * benefitAmount
    }

    override fun checkMatch(): Boolean =
        date in period && getCountMain() > 0 && getTotalOrderAmount(order) > 10_000


    private fun getCountMain(): Int {
        val mainName = Menu.MAIN.detailMenu.map { it.menuName }
        return mainName.intersect(order.keys).sumOf { order[it]!! }
    }
}