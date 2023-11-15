package christmas.model

import christmas.util.DecemberEventData
import christmas.util.OrderManager.getTotalOrderAmount


class SpecialEvent(private val date: Int, private val order: Map<String, Int>) {

    private val period = DecemberEventData.SPECIAL_EVENT_DATA.period
    private val benefitAmount = DecemberEventData.SPECIAL_EVENT_DATA.benefitAmount

    fun getBenefitAmount(): Int {
        if (!checkMatch()) return 0
        return -benefitAmount
    }

    fun checkMatch(): Boolean =
        date in period && getTotalOrderAmount(order) > 10_000

}