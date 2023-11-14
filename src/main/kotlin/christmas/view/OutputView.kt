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

}