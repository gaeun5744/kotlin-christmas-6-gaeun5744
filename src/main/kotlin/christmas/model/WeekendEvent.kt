package christmas.model

import christmas.util.DecemberEvent
import christmas.util.Menu
import christmas.util.OrderManager.getTotalOrderAmount

class WeekendEvent(private val date: Int, private val order: Map<String, Int>) {

    private val period = DecemberEvent.WEEKEND_EVENT.period
    private val benefitAmount = DecemberEvent.WEEKEND_EVENT.benefitAmount

    fun getBenefitAmount(): Int {

        if (!checkMatch()) return 0
        return -getCountMain() * benefitAmount
    }

    fun checkMatch(): Boolean =
        date in period && getCountMain() > 0 && getTotalOrderAmount(order) > 10_000


    private fun getCountMain(): Int {
        val mainName = Menu.MAIN.detailMenu.map { it.menuName }
        return mainName.intersect(order.keys).sumOf { order[it]!! }
    }
}