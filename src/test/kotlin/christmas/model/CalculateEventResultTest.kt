package christmas.model

import christmas.model.CalculateEventResult.Companion.getTotalOrderAmount
import christmas.util.Badge
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
        assertEquals(calculateEventResult.getTotalBenefit(), -31_246)
    }

    @Test
    fun `이벤트 배지 테스트`(){
        assertEquals(calculateEventResult.getEventBadge(), Badge.SANTA)
    }

    @Test
    fun `총 주문 금액 테스트`(){
        assertEquals(getTotalOrderAmount(order), 142_000)
    }

    companion object {
        private val order = mapOf("티본스테이크" to 1, "바비큐립" to 1, "초코케이크" to 2, "제로콜라" to 1)
        private const val date = 3
    }
}