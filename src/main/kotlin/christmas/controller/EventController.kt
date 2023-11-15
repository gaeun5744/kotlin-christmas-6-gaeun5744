package christmas.controller

import christmas.model.*
import christmas.model.CalculateEventResult.Companion.getTotalOrderAmount
import christmas.view.InputView
import christmas.view.OutputView

class EventController {

    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")
        val date = inputView.readDate()
        val order = inputView.readOrder()
        println("12월 ${date}일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!").also { println() }

        val weekEvent = WeekEvent(date, order)
        val weekendEvent = WeekendEvent(date, order)
        val specialEvent = SpecialEvent(date, order)
        val presentEvent = PresentEvent(date, order)
        val christmasEvent = ChristmasEvent(date, order)

        val calculateEventResult = CalculateEventResult(weekEvent, weekendEvent, specialEvent, presentEvent, christmasEvent)

        outputView.printMenu(order).also { println() }
        outputView.printTotalOrderAmount(getTotalOrderAmount(order)).also { println() }
        outputView.printPresent(presentEvent.checkMatch()).also { println() }
        outputView.printBenefitDetails(calculateEventResult.getBenefitDetails()).also { println() }
        outputView.printTotalBenefit(calculateEventResult.getTotalBenefit()).also { println() }
        outputView.printActualPayment(getTotalOrderAmount(order) + calculateEventResult.getTotalBenefit()).also { println() }
        outputView.printBadge(calculateEventResult.getEventBadge())
    }

}