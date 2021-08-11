package cn.classyex.menu.domain.diet;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/11 9:40 <br>
 */
public class MealEnumTest {

    @Test
    public void should_be_3_length() {
        Assertions.assertThat(MealEnum.values().length).isEqualTo(3);
    }

    @Test
    public void should_be_in_order() {
        Assertions.assertThat(MealEnum.values()).containsExactly(MealEnum.BREAKFAST, MealEnum.LUNCH, MealEnum.DINNER);
    }

}
