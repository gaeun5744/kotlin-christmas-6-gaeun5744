package christmas.model

import christmas.util.DecemberEvent
import christmas.util.DecemberEventData
import christmas.util.OrderManager.getTotalOrderAmount

class PresentEvent(private val date: Int, private val order: Map<String, Int>):DecemberEvent() {

    override val period = DecemberEventData.PRESENT_EVENT_DATA.period
    override val benefitCriteria = DecemberEventData.PRESENT_EVENT_DATA.benefitCriteria

    override fun getBenefit(): Int {
        if (!checkMatch()) return 0
        return -benefitCriteria
    }

    override fun checkMatch(): Boolean =
        date in period && getTotalOrderAmount(order) > 12_0000
}