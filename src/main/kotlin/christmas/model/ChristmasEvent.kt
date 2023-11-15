package christmas.model

import christmas.util.DecemberEvent
import christmas.util.OrderManager.getTotalOrderAmount

class ChristmasEvent(private val date: Int, private val order: Map<String, Int>) {

    private val period = DecemberEvent.CHRISTMAS_EVENT.period
    private val discountAmount = DecemberEvent.CHRISTMAS_EVENT.benefitAmount

    fun getBenefitAmount(): Int {
        if (!checkMatch()) return 0
        return -(discountAmount + (date - 1) * 100)
    }

    fun checkMatch(): Boolean =
        date in period && getTotalOrderAmount(order) > 10_000


}