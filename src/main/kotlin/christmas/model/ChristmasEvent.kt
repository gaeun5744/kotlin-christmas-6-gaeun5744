package christmas.model

import christmas.model.CalculateResult.getTotalOrderAmount

class ChristmasEvent(private val date: Int, private val order: Map<String, Int>) {

    private val period = (1..25).toList()
    private val discountAmount = 1_000

}