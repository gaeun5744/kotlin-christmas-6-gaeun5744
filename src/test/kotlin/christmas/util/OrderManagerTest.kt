package christmas.util

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OrderManagerTest {

    @Test
    fun `총 주문 금액 반환 테스트`() {
        val order = mapOf("시저샐러드" to 1, "티본스테이크" to 1, "아이스크림" to 1)
        assertEquals(OrderManager.getTotalOrderAmount(order), 68_000)
    }
}