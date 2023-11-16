package christmas.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class ChristmasEventTest {
    @ParameterizedTest
    @MethodSource("provideCheckMatchExample")
    fun `크리스마스 이벤트 적용 여부 테스트`(christmasEvent: ChristmasEvent, expectedResult: Boolean) {
        assertEquals(christmasEvent.checkMatch(), expectedResult)
    }

    @ParameterizedTest
    @MethodSource("provideGetBenefitExample")
    fun `크리스마스 이벡트 혜택 내역 테스트`(christmasEvent: ChristmasEvent, expectedResult: Int) {
        assertEquals(christmasEvent.getBenefit(), expectedResult)
    }

    companion object {
        @JvmStatic
        fun provideCheckMatchExample() = listOf(
            Arguments.of(ChristmasEvent(4, mapOf("양송이수프" to 1, "초코케이크" to 2, "제로콜라" to 1)), true),
            Arguments.of(
                ChristmasEvent(27, mapOf("티본스테이크" to 1, "아이스크림" to 2, "타파스" to 1)),
                false
            ), // 주문 날짜가 이벤트에 해당하지 않는 경우
            Arguments.of(ChristmasEvent(10, mapOf("시저샐러드" to 1)), false) // 총 주문 금액이 10000원 미만인 경우
        )

        @JvmStatic
        fun provideGetBenefitExample() = listOf(
            Arguments.of(ChristmasEvent(4, mapOf("양송이수프" to 1, "초코케이크" to 1, "레드와인" to 1)), -1_300),
            Arguments.of(ChristmasEvent(25, mapOf("초코케이크" to 3, "레드와인" to 1, "해산물파스타" to 2)), -3_400),
            Arguments.of(
                ChristmasEvent(28, mapOf("해산물파스타" to 1, "아이스크림" to 2, "타파스" to 1)),
                0
            ), // 주문 날짜가 이벤트에 해당하지 않는 경우
            Arguments.of(ChristmasEvent(11, mapOf("아이스크림" to 1, "제로콜라" to 1)), 0) // 총 주문 금액이 10000원 미만인 경우
        )
    }
}