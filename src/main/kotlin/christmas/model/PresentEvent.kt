package christmas.model

import christmas.model.CalculateResult.getTotalOrderAmount

class PresentEvent(private val date: Int, private val order: Map<String, Int>) {

    private val period = (1..31).toList()
    private val benefitAmount = 25_000

}