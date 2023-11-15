package christmas.model

import christmas.util.Badge
import christmas.util.OrderManager.getTotalOrderAmount
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CalculateEventResultTest {

    private lateinit var calculateEventResult: CalculateEventResult

    @BeforeEach
    fun setUp() {
        calculateEventResult = CalculateEventResult(
            WeekEvent(date, order),
            WeekendEvent(date, order),
            SpecialEvent(date, order),
            PresentEvent(date, order),
            ChristmasEvent(date, order)
        )
    }

    @Test
    fun `총 혜택 금액 반환 테스트`() {
        assertEquals(calculateEventResult.getTotalBenefit(), TOTAL_BENEFIT_ANSWER)
    }

    @Test
    fun `총 할인 금액 반환 테스트`() {
        assertEquals(calculateEventResult.getTotalDiscount(), TOTAL_DISCOUNT_ANSWER)
    }

    @Test
    fun `이벤트 배지 테스트`() {
        assertEquals(calculateEventResult.getEventBadge(), Badge.SANTA)
    }

    @Test
    fun `총 주문 금액 테스트`() {
        assertEquals(getTotalOrderAmount(order), TOTAL_ORDER_ANSWER)
    }

    companion object {
        private val order = mapOf("티본스테이크" to 1, "바비큐립" to 1, "초코케이크" to 2, "제로콜라" to 1)
        private const val date = 3
        private const val TOTAL_BENEFIT_ANSWER = -31_246
        private const val TOTAL_DISCOUNT_ANSWER = -6_246
        private const val TOTAL_ORDER_ANSWER = 142_000
    }
}