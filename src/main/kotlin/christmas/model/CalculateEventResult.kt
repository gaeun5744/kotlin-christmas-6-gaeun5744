package christmas.model

import christmas.util.Badge
import christmas.util.DecemberEvent

class CalculateEventResult(
    private val weekEvent: WeekEvent,
    private val weekendEvent: WeekendEvent,
    private val specialEvent: SpecialEvent,
    private val presentEvent: PresentEvent,
    private val christmasEvent: ChristmasEvent,
) {

    fun getTotalBenefit(
    ): Int =
        weekEvent.getBenefitAmount() + weekendEvent.getBenefitAmount() + specialEvent.getBenefitAmount() + presentEvent.getBenefitAmount() + christmasEvent.getBenefitAmount()


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
        if (weekEvent.checkMatch()) benefitDetails[DecemberEvent.WEEK_EVENT.eventName] = weekEvent.getBenefitAmount()
        if (weekendEvent.checkMatch()) benefitDetails[DecemberEvent.WEEKEND_EVENT.eventName] = weekendEvent.getBenefitAmount()
        if (specialEvent.checkMatch()) benefitDetails[DecemberEvent.SPECIAL_EVENT.eventName] = specialEvent.getBenefitAmount()
        if (presentEvent.checkMatch()) benefitDetails[DecemberEvent.PRESENT_EVENT.eventName] = presentEvent.getBenefitAmount()
        if (christmasEvent.checkMatch()) benefitDetails[DecemberEvent.CHRISTMAS_EVENT.eventName] = christmasEvent.getBenefitAmount()
        return benefitDetails
    }

}