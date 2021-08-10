package cn.classyex.menu.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/10 17:30 <br>
 */
public class RandomStringTest {

    @Test
    public void preset_abc_random_should_be_abc() {
        RandomString.setResultSupplier(() -> "abc");
        Assertions.assertThat(RandomString.randomUniqueString(3)).isEqualTo("abc");
    }

    @Test
    public void preset_123_random_should_be_123() {
        RandomString.setResultSupplier(() -> "123");
        Assertions.assertThat(RandomString.randomUniqueString(4)).isEqualTo("123");
    }

    @Test
    public void no_preset_random_3_length_should_be_39() {
        Assertions.assertThat(RandomString.randomUniqueString(3).length()).isEqualTo(39);
    }

}
