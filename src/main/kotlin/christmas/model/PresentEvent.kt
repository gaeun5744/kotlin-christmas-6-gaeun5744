package christmas.model

import christmas.model.CalculateResult.Companion.getTotalOrderAmount

class PresentEvent(private val date: Int, private val order: Map<String, Int>) {

    private val period = (1..31).toList()
    private val benefitAmount = 25_000

    fun getBenefitAmount(): Int {
        if (!checkMatch()) return 0
        return - benefitAmount
    }

    fun checkMatch(): Boolean =
        date in period  && getTotalOrderAmount(order) > 12_0000
}