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

}