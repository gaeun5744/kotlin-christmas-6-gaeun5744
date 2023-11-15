package christmas.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class PresentEventTest {

    @ParameterizedTest
    @MethodSource("provideCheckMatchExample")
    fun `증정 이벤트 적용 여부 테스트`(presentEvent: PresentEvent, expectedResult: Boolean) {
        assertEquals(presentEvent.checkMatch(), expectedResult)
    }

    @ParameterizedTest
    @MethodSource("provideGetBenefitExample")
    fun `증정 이벡트 혜택 내역 테스트`(presentEvent: PresentEvent, expectedResult: Int) {
        assertEquals(presentEvent.getBenefit(), expectedResult)
    }

    companion object {
        @JvmStatic
        fun provideCheckMatchExample() = listOf(
            Arguments.of(PresentEvent(4, mapOf("양송이수프" to 2, "초코케이크" to 2, "제로콜라" to 1, "티본스테이크" to 4)), true),
            Arguments.of(PresentEvent(10, mapOf("아이스크림" to 1, "타파스" to 1, "바비큐립" to 1)), false) // 총 주문 금액이 120000원 미만인 경우
        )

        @JvmStatic
        fun provideGetBenefitExample() = listOf(
            Arguments.of(PresentEvent(5, mapOf("양송이수프" to 1, "초코케이크" to 1, "레드와인" to 1, "바비큐립" to 2)), -25_000),
            Arguments.of(PresentEvent(9, mapOf("초코케이크" to 3, "레드와인" to 1, "해산물파스타" to 2, "시저샐러드" to 1, "티본스테이크" to 1)), -25_000),
            Arguments.of(PresentEvent(17, mapOf("초코케이크" to 1, "크리스마스파스타" to 1)), 0) // 총 주문 금액이 120000원 미만인 경우
        )
    }
}