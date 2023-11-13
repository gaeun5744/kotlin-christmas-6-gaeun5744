package christmas.model

import christmas.model.CalculateResult.getTotalOrderAmount


class SpecialEvent(private val date: Int, private val order: Map<String, Int>) {

    private val period = listOf(3, 10, 17, 24, 45, 31)
    private val benefitAmount = 1_000

}