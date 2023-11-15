package christmas.model

import christmas.util.DecemberEvent
import christmas.util.DecemberEventData
import christmas.util.NO_BENEFIT
import christmas.util.OrderManager.getTotalOrderAmount

class PresentEvent(private val date: Int, private val order: Map<String, Int>):DecemberEvent() {

    override val period = DecemberEventData.PRESENT_EVENT_DATA.period
    override val benefitCriteria = DecemberEventData.PRESENT_EVENT_DATA.benefitCriteria

    override fun getBenefit(): Int {
        if (!checkMatch()) return NO_BENEFIT
        return -benefitCriteria
    }

    override fun checkMatch(): Boolean =
        date in period && getTotalOrderAmount(order) > MINIMUM_AMOUNT

    companion object {
        private const val MINIMUM_AMOUNT = 120_000
    }
}