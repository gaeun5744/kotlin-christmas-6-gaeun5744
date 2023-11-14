package christmas.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class WeekEventTest {

    @ParameterizedTest
    @MethodSource("provideCheckMatchExample")
    fun `평일 이벤트 적용 여부 테스트`(weekEvent: WeekEvent, expectedResult: Boolean) {
        assertThat(weekEvent.checkMatch()).isEqualTo(expectedResult)
    }

    companion object {
        @JvmStatic
        fun provideCheckMatchExample() = listOf(
            Arguments.of(WeekEvent(4, mapOf("양송이수프" to 1, "초코케이크" to 2, "제로콜라" to 1)), true),
            Arguments.of(WeekEvent(14, mapOf("바비큐립" to 3, "제로콜라" to 1)), false), // 주문에 디저트가 없는 경우
            Arguments.of(WeekEvent(8, mapOf("티본스테이크" to 1, "아이스크림" to 2)), false), // 주문 날짜가 이벤트에 해당하지 않는 경우
            Arguments.of(WeekEvent(11, mapOf("아이스크림" to 1)), false) // 총 주문 금액이 10000원 미만인 경우
        )
    }

}