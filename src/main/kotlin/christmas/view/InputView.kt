package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.util.Validation

class InputView {
    fun readDate(): Int {
        println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)")
        return getValidDate()
    }

    private fun getValidDate(): Int {
        while (true) {
            try {
                val input = Console.readLine()
                Validation.checkDate(input)
                return input.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            } catch (e: IndexOutOfBoundsException) {
                println(e.message)
            }
        }
    }

}