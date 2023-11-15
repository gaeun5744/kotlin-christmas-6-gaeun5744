package christmas.model

import christmas.util.DecemberEvent
import christmas.util.OrderManager.getTotalOrderAmount


class SpecialEvent(private val date: Int, private val order: Map<String, Int>) {

    private val period = DecemberEvent.SPECIAL_EVENT.period
    private val benefitAmount = DecemberEvent.SPECIAL_EVENT.benefitAmount

    fun getBenefitAmount(): Int {
        if (!checkMatch()) return 0
        return -benefitAmount
    }

    fun checkMatch(): Boolean =
        date in period && getTotalOrderAmount(order) > 10_000

}