package christmas.view

import christmas.util.Badge
import java.text.DecimalFormat

class OutputView {

    fun printIntroduce() {
        println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")
    }

    fun printEventGuide(date: Int) {
        println("12월 ${date}일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!")
    }

    fun printMenu(order: Map<String, Int>) {
        println("<주문 메뉴>")
        order.forEach { (menu, count) ->
            println("$menu ${count}개")
        }.also { println() }
    }

    fun printTotalOrderAmount(amount: Int) {
        println("<할인 전 총주문 금액>")
        println("${formatComma(amount)}원").also { println() }
    }

    fun printPresent(isPresent: Boolean) {
        println("<증정 메뉴>")
        if (isPresent) println("샴페인 1개") else println("없음").also { println() }
    }

    fun printBenefitDetails(benefits: Map<String, Int>) {
        println("<혜택 내역>")
        if (benefits.isEmpty()) println("없음")
        benefits.forEach { (benefits, amount) ->
            println("$benefits: ${formatComma(amount)}원")
        }.also { println() }
    }

    fun printTotalBenefit(totalBenefit: Int) {
        println("<총혜택 금액>")
        println("${formatComma(totalBenefit)}원").also { println() }
    }

    fun printActualPayment(actualPayment: Int) {
        println("<할인 후 예상 결제 금액>")
        println("${formatComma(actualPayment)}원").also { println() }
    }

    private fun formatComma(actualPayment: Int): String = DecimalFormat("#,###").format(actualPayment)

    fun printBadge(badge: Badge) {
        println("<12월 이벤트 배지>")
        println(badge.badgeName)
    }
}