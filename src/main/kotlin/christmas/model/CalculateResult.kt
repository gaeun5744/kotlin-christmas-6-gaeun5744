package christmas.model

import christmas.util.Badge
import christmas.util.DetailMenu

class CalculateResult(
    private val weekEvent: WeekEvent,
    private val weekendEvent: WeekendEvent,
    private val specialEvent: SpecialEvent,
    private val presentEvent: PresentEvent,
    private val christmasEvent: ChristmasEvent,
) {

    fun getTotalBenefit(
    ): Int =
        weekEvent.getBenefitAmount() + weekendEvent.getBenefitAmount() + specialEvent.getBenefitAmount() + presentEvent.getBenefitAmount() + christmasEvent.getDiscountAmount()


    fun getEventBadge(): Badge {
        val totalBenefit = -getTotalBenefit()
        return when {
            totalBenefit > Badge.SANTA.criteriaAmount -> Badge.SANTA
            totalBenefit > Badge.TREE.criteriaAmount -> Badge.TREE
            totalBenefit > Badge.STAR.criteriaAmount -> Badge.STAR
            else -> Badge.NOTHING
        }
    }


    companion object {
        fun getTotalOrderAmount(order: Map<String, Int>): Int = order.map { (menu, count) ->
            val menu = DetailMenu.values().first { it.menuName == menu }
            menu.price * count
        }.sum()

    }

}