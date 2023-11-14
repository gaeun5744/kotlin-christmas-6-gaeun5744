package christmas.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SpecialEventTest{
    @ParameterizedTest
    @MethodSource("provideCheckMatchExample")
    fun `특별 이벤트 적용 여부 테스트`(specialEvent: SpecialEvent, expectedResult: Boolean) {
        assertEquals(specialEvent.checkMatch(), expectedResult)
    }

    companion object {
        @JvmStatic
        fun provideCheckMatchExample() = listOf(
            Arguments.of(SpecialEvent(3, mapOf("양송이수프" to 1, "초코케이크" to 2, "제로콜라" to 1)), true),
            Arguments.of(SpecialEvent(8, mapOf("티본스테이크" to 1, "아이스크림" to 2, "시저샐러드" to 1)), false), // 주문 날짜가 이벤트에 해당하지 않는 경우
            Arguments.of(SpecialEvent(10, mapOf("타파스" to 1)), false) // 총 주문 금액이 10000원 미만인 경우
        )

    }
}