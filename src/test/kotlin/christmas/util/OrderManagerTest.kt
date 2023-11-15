package christmas.util

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OrderManagerTest {

    @Test
    fun `총 주문 금액 반환 테스트`() {
        val order = TOTAL_ORDER_EXAMPLE
        assertEquals(OrderManager.getTotalOrderAmount(order), TOTAL_ORDER_ANSWER)
    }

    @Test
    fun `주문 String 데이터 Map 으로 변환 테스트`() {
        val order = REFINED_ORDER_EXAMPLE
        assertEquals(OrderManager.getRefinedOrder(order), REFINED_ORDER_ANSWER)
    }

    companion object {
        private val TOTAL_ORDER_EXAMPLE = mapOf("시저샐러드" to 1, "티본스테이크" to 1, "아이스크림" to 1)
        private const val TOTAL_ORDER_ANSWER = 68_000
        private const val REFINED_ORDER_EXAMPLE = "양송이수프-1,해산물파스타-1,샴페인-2"
        private val REFINED_ORDER_ANSWER = mapOf("양송이수프" to 1, "해산물파스타" to 1, "샴페인" to 2)
    }

}