package christmas.model

import christmas.model.CalculateResult.Companion.getTotalOrderAmount

class ChristmasEvent(private val date: Int, private val order: Map<String, Int>) {

    private val period = (1..25).toList()
    private val discountAmount = 1_000

    fun getDiscountAmount(): Int {
        if (!checkMatch()) return 0
        return -(discountAmount + (date - 1) * 100)
    }

    fun checkMatch(): Boolean =
        date in period && getTotalOrderAmount(order) > 10_000


}