package christmas.model

import christmas.util.DecemberEvent
import christmas.util.DecemberEventData
import christmas.util.MINIMUM_EVENT_AMOUNT
import christmas.util.NO_BENEFIT
import christmas.util.OrderManager.getTotalOrderAmount

class ChristmasEvent(private val date: Int, private val order: Map<String, Int>) : DecemberEvent() {

    override val period = DecemberEventData.CHRISTMAS_EVENT_DATA.period
    override val benefitCriteria = DecemberEventData.CHRISTMAS_EVENT_DATA.benefitCriteria

    override fun getBenefit(): Int {
        if (!checkMatch()) return NO_BENEFIT
        return -(benefitCriteria + date * BENEFIT_UNIT)
    }

    override fun checkMatch(): Boolean =
        date in period && getTotalOrderAmount(order) > MINIMUM_EVENT_AMOUNT

    companion object {
        private const val BENEFIT_UNIT = 100
    }


}