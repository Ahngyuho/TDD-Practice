import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    public void validatePasswordTest() {
        assertThatCode(() ->PasswordValidator.validate("ijkjke777"))
                .doesNotThrowAnyException();
    }

    @Test
    public void name() {
        assertThatCode(() -> PasswordValidator.validate("fejkdjfiejfi111"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
    }

    @DisplayName("경계값 test")
    @ParameterizedTest
    @ValueSource(strings = {"aaaaaaa","bbbbbbbbbbbbb"})
    public void BoundTest(String password) {
        assertThatCode(() -> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
    }
}
