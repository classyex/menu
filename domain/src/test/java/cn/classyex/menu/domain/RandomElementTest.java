package cn.classyex.menu.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/9 12:11 <br>
 */
public class RandomElementTest {

    @Test
    public void preset_0_random_should_be_a() {
        RandomElement.setResultSupplier(() -> 0);
        List<String> list = Arrays.asList("a", "b", "c");
        String randomEle = RandomElement.randomEle(list);
        Assertions.assertThat(randomEle).isEqualTo("a");
    }

    @Test
    public void preset_1_random_should_be_b() {
        RandomElement.setResultSupplier(() -> 1);
        List<String> list = Arrays.asList("a", "b", "c");
        String randomEle = RandomElement.randomEle(list);
        Assertions.assertThat(randomEle).isEqualTo("b");
    }

    @Test
    public void preset_2_random_should_be_c() {
        RandomElement.setResultSupplier(() -> 2);
        List<String> list = Arrays.asList("a", "b", "c");
        String randomEle = RandomElement.randomEle(list);
        Assertions.assertThat(randomEle).isEqualTo("c");
    }

    @Test
    public void no_preset_random_should_be_random() {
        List<String> list = Arrays.asList("a", "b", "c");
        RandomElement.setResultSupplier(null);
        String randomEle = RandomElement.randomEle(list);
        Assertions.assertThat(randomEle).isIn(list);
    }


}
