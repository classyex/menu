package cn.classyex.menu.domain.diet;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/11 9:44 <br>
 */
public class BmrCalculatorTest {

    @Test
    public void male_weight_70_height_175_age_29_bmr_should_be_1702_8() {
        Float bmr = new BmrCalculator(1, 70F, 175F, 29).calc();
        Assertions.assertThat(bmr).isEqualTo(1702.8F, Offset.offset(0.001F));
    }

    @Test
    public void female_weight_50_height_165_age_28_bmr_should_be_1702_8() {
        Float bmr = new BmrCalculator(2, 50F, 165F, 28).calc();
        Assertions.assertThat(bmr).isEqualTo(1300.4F, Offset.offset(0.001F));
    }

}
