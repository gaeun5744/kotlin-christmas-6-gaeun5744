package christmas.model

import christmas.util.DecemberEvent
import christmas.util.DecemberEventData
import christmas.util.OrderManager.getTotalOrderAmount

class ChristmasEvent(private val date: Int, private val order: Map<String, Int>):DecemberEvent() {

    override val period = DecemberEventData.CHRISTMAS_EVENT_DATA.period
    override val benefitAmount = DecemberEventData.CHRISTMAS_EVENT_DATA.benefitAmount

    override fun getBenefitAmount(): Int {
        if (!checkMatch()) return 0
        return -(benefitAmount+ (date - 1) * 100)
    }

    override fun checkMatch(): Boolean =
        date in period && getTotalOrderAmount(order) > 10_000


}