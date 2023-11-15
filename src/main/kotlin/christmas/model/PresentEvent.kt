package christmas.model

import christmas.util.DecemberEventData
import christmas.util.OrderManager.getTotalOrderAmount

class PresentEvent(private val date: Int, private val order: Map<String, Int>) {

    private val period = DecemberEventData.PRESENT_EVENT_DATA.period
    private val benefitAmount = DecemberEventData.PRESENT_EVENT_DATA.benefitAmount

    fun getBenefitAmount(): Int {
        if (!checkMatch()) return 0
        return -benefitAmount
    }

    fun checkMatch(): Boolean =
        date in period && getTotalOrderAmount(order) > 12_0000
}