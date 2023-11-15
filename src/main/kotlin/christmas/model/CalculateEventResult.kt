package christmas.model

import christmas.util.Badge
import christmas.util.DecemberEventData

class CalculateEventResult(
    private val weekEvent: WeekEvent,
    private val weekendEvent: WeekendEvent,
    private val specialEvent: SpecialEvent,
    private val presentEvent: PresentEvent,
    private val christmasEvent: ChristmasEvent,
) {

    fun getTotalBenefit(
    ): Int =
        weekEvent.getBenefit() + weekendEvent.getBenefit() + specialEvent.getBenefit() + presentEvent.getBenefit() + christmasEvent.getBenefit()


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
        if (weekEvent.checkMatch()) benefitDetails[DecemberEventData.WEEK_EVENT_DATA.eventName] = weekEvent.getBenefit()
        if (weekendEvent.checkMatch()) benefitDetails[DecemberEventData.WEEKEND_EVENT_DATA.eventName] = weekendEvent.getBenefit()
        if (specialEvent.checkMatch()) benefitDetails[DecemberEventData.SPECIAL_EVENT_DATA.eventName] = specialEvent.getBenefit()
        if (presentEvent.checkMatch()) benefitDetails[DecemberEventData.PRESENT_EVENT_DATA.eventName] = presentEvent.getBenefit()
        if (christmasEvent.checkMatch()) benefitDetails[DecemberEventData.CHRISTMAS_EVENT_DATA.eventName] = christmasEvent.getBenefit()
        return benefitDetails
    }

    fun getPresent():String =
        if (presentEvent.checkMatch()) WIN_PRESENT_EVENT else FAIL_PRESENT_EVENT


    companion object {
        private const val WIN_PRESENT_EVENT = "샴페인 1개"
        private const val FAIL_PRESENT_EVENT = "없음"
    }

}