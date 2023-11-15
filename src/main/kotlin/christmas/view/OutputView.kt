package christmas.view

import christmas.util.Badge
import java.text.DecimalFormat

class OutputView {

    fun printIntroduce() {
        println(INTRODUCE_MESSAGE)
    }

    fun printEventGuide(date: Int) {
        println(getEventGuideMessage(date))
    }

    fun printMenu(order: Map<String, Int>) {
        println(TITLE_ORDER)
        order.forEach { (menu, count) ->
            println(getOrderMessage(menu, count))
        }.also { println() }
    }

    fun printTotalOrderAmount(amount: Int) {
        println(TITLE_ORDER_PAYMENT)
        println("${formatComma(amount)}$MONETARY_UNIT").also { println() }
    }

    fun printPresent(eventResult:String) {
        println(TITLE_PRESENT)
        println(eventResult)
    }

    fun printBenefitDetails(benefits: Map<String, Int>) {
        println(TITLE_BENEFIT_DETAIL)
        if (benefits.isEmpty()) println(FAIL_EVENT)
        benefits.forEach { (benefits, amount) ->
            println("$benefits: ${formatComma(amount)}$MONETARY_UNIT")
        }.also { println() }
    }

    fun printTotalBenefit(totalBenefit: Int) {
        println(TITLE_TOTAL_BENEFIT)
        println("${formatComma(totalBenefit)}$MONETARY_UNIT").also { println() }
    }

    fun printActualPayment(actualPayment: Int) {
        println(TITLE_REAL_PAYMENT)
        println("${formatComma(actualPayment)}$MONETARY_UNIT").also { println() }
    }

    private fun formatComma(actualPayment: Int): String = DecimalFormat("#,###").format(actualPayment)

    fun printBadge(badge: Badge) {
        println(TITLE_BADGE)
        println(badge.badgeName)
    }

    companion object {
        private const val INTRODUCE_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."
        private const val TITLE_ORDER = "<주문 메뉴>"
        private const val TITLE_ORDER_PAYMENT = "<할인 전 총주문 금액>"
        private const val TITLE_PRESENT = "<증정 메뉴>"
        private const val TITLE_BENEFIT_DETAIL = "<혜택 내역>"
        private const val TITLE_TOTAL_BENEFIT = "<총혜택 금액>"
        private const val TITLE_REAL_PAYMENT = "<할인 후 예상 결제 금액>"
        private const val TITLE_BADGE = "<12월 이벤트 배지>"

        private const val FAIL_EVENT = "없음"

        private const val MONETARY_UNIT = "원"
        fun getEventGuideMessage(date: Int) = "12월 ${date}일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"
        fun getOrderMessage(menu: String, count: Int) = "$menu ${count}개"
    }
}