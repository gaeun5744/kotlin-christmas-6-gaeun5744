package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.util.OrderManager.getRefinedOrder
import christmas.util.Validation

class InputView {
    fun readDate(): Int {
        println(DATE_GUIDE)
        return getValidDate()
    }

    fun readOrder(): Map<String, Int> {
        println(ORDER_GUIDE)
        return getValidOrder()
    }

    private fun getValidDate(): Int {
        while (true) {
            try {
                val input = Console.readLine()
                Validation.checkDate(input)
                return input.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getValidOrder(): Map<String, Int> {
        while (true) {
            try {
                val input = Console.readLine()
                Validation.checkMenu(input)
                return getRefinedOrder(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    companion object {
        private const val DATE_GUIDE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"
        private const val ORDER_GUIDE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"
    }

}