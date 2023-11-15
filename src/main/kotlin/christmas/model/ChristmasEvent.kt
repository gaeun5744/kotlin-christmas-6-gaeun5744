package christmas.model

import christmas.util.DecemberEventData
import christmas.util.OrderManager.getTotalOrderAmount

class ChristmasEvent(private val date: Int, private val order: Map<String, Int>) {

    private val period = DecemberEventData.CHRISTMAS_EVENT_DATA.period
    private val discountAmount = DecemberEventData.CHRISTMAS_EVENT_DATA.benefitAmount

    fun getBenefitAmount(): Int {
        if (!checkMatch()) return 0
        return -(discountAmount + (date - 1) * 100)
    }

    fun checkMatch(): Boolean =
        date in period && getTotalOrderAmount(order) > 10_000


}