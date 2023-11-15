package christmas.model

import christmas.util.Badge
import christmas.util.DetailMenu

class CalculateEventResult(
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

    fun getBenefitDetails(): Map<String, Int> {
        var benefitDetails = mutableMapOf<String, Int>()
        if (weekEvent.checkMatch()) benefitDetails["평일 할인"] = weekEvent.getBenefitAmount()
        if (weekendEvent.checkMatch()) benefitDetails["주말 할인"] = weekendEvent.getBenefitAmount()
        if (specialEvent.checkMatch()) benefitDetails["특별 할인"] = specialEvent.getBenefitAmount()
        if (christmasEvent.checkMatch()) benefitDetails["크리스마스 디데이 할인"] = christmasEvent.getDiscountAmount()
        return benefitDetails
    }

}