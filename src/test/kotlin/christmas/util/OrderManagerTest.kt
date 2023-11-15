package christmas.util

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OrderManagerTest {

    @Test
    fun `총 주문 금액 반환 테스트`() {
        val order = mapOf("시저샐러드" to 1, "티본스테이크" to 1, "아이스크림" to 1)
        assertEquals(OrderManager.getTotalOrderAmount(order), 68_000)
    }

    @Test
    fun `주문 String 데이터 Map 으로 변환 테스트`() {
        val order = "양송이수프-1,해산물파스타-1,샴페인-2"
        assertEquals(OrderManager.getRefinedOrder(order), mapOf("양송이수프" to 1, "해산물파스타" to 1, "샴페인" to 2))
    }

}