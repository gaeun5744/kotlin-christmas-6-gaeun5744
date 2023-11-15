package christmas.model

import christmas.util.DecemberEvent
import christmas.util.DecemberEventData
import christmas.util.OrderManager.getTotalOrderAmount

class ChristmasEvent(private val date: Int, private val order: Map<String, Int>):DecemberEvent() {

    override val period = DecemberEventData.CHRISTMAS_EVENT_DATA.period
    override val benefitCriteria = DecemberEventData.CHRISTMAS_EVENT_DATA.benefitCriteria

    override fun getBenefit(): Int {
        if (!checkMatch()) return 0
        return -(benefitCriteria+ (date - 1) * 100)
    }

    override fun checkMatch(): Boolean =
        date in period && getTotalOrderAmount(order) > 10_000


}