package christmas.model

import christmas.model.CalculateEventResult.Companion.getTotalOrderAmount


class SpecialEvent(private val date: Int, private val order: Map<String, Int>) {

    private val period = listOf(3, 10, 17, 24, 45, 31)
    private val benefitAmount = 1_000

    fun getBenefitAmount(): Int {
        if (!checkMatch()) return 0
        return -benefitAmount
    }

    fun checkMatch(): Boolean =
        date in period && getTotalOrderAmount(order) > 10_000

}