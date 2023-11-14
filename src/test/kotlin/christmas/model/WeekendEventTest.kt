package christmas.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class WeekendEventTest {

    @ParameterizedTest
    @MethodSource("provideCheckMatchExample")
    fun `주말 이벤트 적용 여부 테스트`(weekendEvent: WeekendEvent, expectedResult: Boolean) {
        assertEquals(weekendEvent.checkMatch(), expectedResult)
    }

    companion object {
        @JvmStatic
        fun provideCheckMatchExample() = listOf(
            Arguments.of(WeekendEvent(8, mapOf("양송이수프" to 1, "해산물파스타" to 2, "제로콜라" to 1)), true),
            Arguments.of(WeekendEvent(9, mapOf("양송이수프" to 2, "초코케이크" to 1, "제로콜라" to 1)), false), // 주문에 메인 메뉴가 없는 경우
            Arguments.of(WeekendEvent(10, mapOf("티본스테이크" to 1, "아이스크림" to 2)), false), // 주문 날짜가 이벤트에 해당하지 않는 경우
        )

    }
}