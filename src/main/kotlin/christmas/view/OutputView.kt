package christmas.view

import christmas.util.Badge
import java.text.DecimalFormat

class OutputView {
    fun printMenu(order: Map<String, Int>) {
        println("<주문 메뉴>")
        order.forEach { (menu, count) ->
            println("$menu ${count}개")
        }
    }

    fun printTotalOrderAmount(amount: Int) {
        println("<할인 전 총주문 금액>")
        println("${DecimalFormat("#,###").format(amount)}원")
    }

    fun printPresent(isPresent:Boolean){
        println("<증정 메뉴>")
        if (isPresent) println("샴페인 1개") else println("없음")
    }

    fun printBenefitDetails(benefits:Map<String,Int>){
        println("<혜택 내역>")
        if (benefits.isEmpty()) println("없음")
        benefits.forEach { (benefits, amount) ->
            println("$benefits: ${DecimalFormat("#,###").format(amount)}원")
        }
    }

    fun printTotalBenefit(totalBenefit:Int){
        println("<총혜택 금액>")
        println("${DecimalFormat("#,###").format(totalBenefit)}원")
    }

}