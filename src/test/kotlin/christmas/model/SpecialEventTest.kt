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

    @ParameterizedTest
    @MethodSource("provideGetBenefitExample")
    fun `특별 이벡트 혜택 내역 테스트`(specialEvent: SpecialEvent, expectedResult: Int) {
        assertEquals(specialEvent.getBenefitAmount(), expectedResult)
    }

    companion object {
        @JvmStatic
        fun provideCheckMatchExample() = listOf(
            Arguments.of(SpecialEvent(3, mapOf("양송이수프" to 1, "초코케이크" to 2, "제로콜라" to 1)), true),
            Arguments.of(SpecialEvent(8, mapOf("티본스테이크" to 1, "아이스크림" to 2, "시저샐러드" to 1)), false), // 주문 날짜가 이벤트에 해당하지 않는 경우
            Arguments.of(SpecialEvent(10, mapOf("타파스" to 1)), false) // 총 주문 금액이 10000원 미만인 경우
        )

        @JvmStatic
        fun provideGetBenefitExample() = listOf(
            Arguments.of(SpecialEvent(10, mapOf("양송이수프" to 1, "초코케이크" to 1, "레드와인" to 1)), -1_000),
            Arguments.of(SpecialEvent(17, mapOf("샴페인" to 1, "아이스크림" to 2, "시저샐러드" to 1, "바비큐립" to 3)), -1_000),
            Arguments.of(SpecialEvent(20, mapOf("티본스테이크" to 1, "아이스크림" to 2)), 0), // 주문 날짜가 이벤트에 해당하지 않는 경우
            Arguments.of(SpecialEvent(24, mapOf("시저샐러드" to 1)), 0) // 총 주문 금액이 10000원 미만인 경우
        )
    }
}