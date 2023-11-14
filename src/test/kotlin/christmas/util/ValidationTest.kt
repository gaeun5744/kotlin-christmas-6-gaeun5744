package christmas.util

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidationTest {

    @ParameterizedTest
    @ValueSource(strings = ["날짜", "32", "0"])
    fun `날짜 입력 유효성 검증 테스트`(date: String) {
        assertThatThrownBy {
            Validation.checkDate(date)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining("[ERROR]")
    }

    @ParameterizedTest
    @ValueSource(strings = ["아스파라거스-1,해산물파스타-1", "타파스-0,티본스테이크-2", "시저샐러드 3개", "제로콜라-1/바비큐립-1"])
    fun `유효하지 않은 주문 테스트`(order: String) {
        assertThatThrownBy {
            Validation.checkMenu(order)
        }.hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
    }


}