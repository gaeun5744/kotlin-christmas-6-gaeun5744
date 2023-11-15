package christmas.controller

import christmas.model.*
import christmas.util.OrderManager.getTotalOrderAmount
import christmas.view.InputView
import christmas.view.OutputView

class EventController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {

    fun run() {
        val (date, order) = getInput()

        val weekEvent = WeekEvent(date, order)
        val weekendEvent = WeekendEvent(date, order)
        val specialEvent = SpecialEvent(date, order)
        val presentEvent = PresentEvent(date, order)
        val christmasEvent = ChristmasEvent(date, order)

        val calculateEventResult =
            CalculateEventResult(weekEvent, weekendEvent, specialEvent, presentEvent, christmasEvent)

        printResult(order, presentEvent, calculateEventResult)
    }

    private fun printResult(
        order: Map<String, Int>,
        presentEvent: PresentEvent,
        calculateEventResult: CalculateEventResult
    ) {
        outputView.printMenu(order).also { println() }
        outputView.printTotalOrderAmount(getTotalOrderAmount(order)).also { println() }
        outputView.printPresent(presentEvent.checkMatch()).also { println() }
        outputView.printBenefitDetails(calculateEventResult.getBenefitDetails()).also { println() }
        outputView.printTotalBenefit(calculateEventResult.getTotalBenefit()).also { println() }
        outputView.printActualPayment(getTotalOrderAmount(order) + calculateEventResult.getTotalBenefit())
            .also { println() }
        outputView.printBadge(calculateEventResult.getEventBadge())
    }

    private fun getInput(): Pair<Int, Map<String, Int>> {
        outputView.printIntroduce()
        val date = inputView.readDate()
        val order = inputView.readOrder()
        outputView.printEventGuide(date).also { println() }
        return Pair(date, order)
    }

}