package cn.classyex.menu.domain.diet;

import cn.classyex.menu.domain.diet.recommend.SuggestCalorieCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/11 15:54 <br>
 */
public class SuggestCalorieCalculatorTest {

    @Test
    public void given_bmr_100F_exerciseSeconds_0_when_calc_then_should_be_120() {
        Assertions.assertThat(new SuggestCalorieCalculator(100F, 0L).calc()).isEqualTo(120);
    }

    @Test
    public void given_bmr_100F_exerciseSeconds_null_when_calc_then_should_be_120() {
        Assertions.assertThat(new SuggestCalorieCalculator(100F, null).calc()).isEqualTo(120);
    }

    @Test
    public void given_bmr_100F_exerciseSeconds_3599_when_calc_then_should_be_135() {
        Assertions.assertThat(new SuggestCalorieCalculator(100F, 3599L).calc()).isEqualTo(135);
    }

    @Test
    public void given_bmr_100F_exerciseSeconds_3600_when_calc_then_should_be_145() {
        Assertions.assertThat(new SuggestCalorieCalculator(100F, 3600L).calc()).isEqualTo(145);
    }

    @Test
    public void given_bmr_100F_exerciseHours_3_when_calc_then_should_be_155() {
        Assertions.assertThat(new SuggestCalorieCalculator(100F, 3*3600L).calc()).isEqualTo(155);
    }

    @Test
    public void given_bmr_100F_exerciseHours_5_when_calc_then_should_be_165() {
        Assertions.assertThat(new SuggestCalorieCalculator(100F, 5*3600L).calc()).isEqualTo(165);
    }

}
