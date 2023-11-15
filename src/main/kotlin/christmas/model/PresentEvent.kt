package christmas.model

import christmas.util.DecemberEvent
import christmas.util.OrderManager.getTotalOrderAmount

class PresentEvent(private val date: Int, private val order: Map<String, Int>) {

    private val period = DecemberEvent.PRESENT_EVENT.period
    private val benefitAmount = DecemberEvent.PRESENT_EVENT.benefitAmount

    fun getBenefitAmount(): Int {
        if (!checkMatch()) return 0
        return -benefitAmount
    }

    fun checkMatch(): Boolean =
        date in period && getTotalOrderAmount(order) > 12_0000
}