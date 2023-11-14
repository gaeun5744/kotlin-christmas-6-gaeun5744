package christmas.model

import christmas.util.Badge
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CalculateResultTest {

    private lateinit var calculateResult: CalculateResult

    @BeforeEach
    fun setUp() {
        calculateResult = CalculateResult(
            WeekEvent(date, order),
            WeekendEvent(date, order),
            SpecialEvent(date, order),
            PresentEvent(date, order),
            ChristmasEvent(date, order)
        )
    }

    @Test
    fun `총 혜택 금액 반환 테스트`() {
        assertEquals(calculateResult.getTotalBenefit(), -31_246)
    }

    @Test
    fun `이벤트 배지 테스트`(){
        assertEquals(calculateResult.getEventBadge(), Badge.SANTA)
    }

    companion object {
        private val order = mapOf("티본스테이크" to 1, "바비큐립" to 1, "초코케이크" to 2, "제로콜라" to 1)
        private const val date = 3
    }
}