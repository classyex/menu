package cn.classyex.menu.domain.diet;

import cn.classyex.menu.domain.diet.recommend.CandidateFoodDistributor;
import cn.classyex.menu.domain.diet.recommend.CandidateFoodGroup;
import cn.classyex.menu.domain.food.Food;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/11 14:47 <br>
 */
public class CandidateFoodDistributorTest {

    @Test
    public void calorie_220_should_be_default_1_num_per_food() {
        Food staple = FoodFactory.rice;
        Food meat = FoodFactory.shrimp;
        Food vegetable = FoodFactory.lettuce;
        int suggestCalorie = 220;
        CandidateFoodGroup group = new CandidateFoodDistributor(staple, meat, vegetable, suggestCalorie).getOptimalCandidateFoodGroup();
        assertGroup(group, 0, 0, 1, 1, 1);
    }

    @Test
    public void calorie_600_should_be_staple_3_meat_2_vegetable_2() {
        Food staple = FoodFactory.rice;
        Food meat = FoodFactory.shrimp;
        Food vegetable = FoodFactory.lettuce;
        int suggestCalorie = 600;
        CandidateFoodGroup group = new CandidateFoodDistributor(staple, meat, vegetable, suggestCalorie).getOptimalCandidateFoodGroup();
        assertGroup(group, 570, 4714, 3, 2, 2);
    }

    @Test
    public void calorie_300_should_be_staple_1_meat_1_vegetable_2() {
        Food staple = FoodFactory.rice;
        Food meat = FoodFactory.shrimp;
        Food vegetable = FoodFactory.lettuce;
        int suggestCalorie = 300;
        CandidateFoodGroup group = new CandidateFoodDistributor(staple, meat, vegetable, suggestCalorie).getOptimalCandidateFoodGroup();
        assertGroup(group, 241, 4714, 1, 1, 2);
    }

    @Test
    public void calorie_2600_should_be_default_1_num_per_food() {
        Food staple = FoodFactory.rice;
        Food meat = FoodFactory.shrimp;
        Food vegetable = FoodFactory.lettuce;
        int suggestCalorie = 2600;
        CandidateFoodGroup group = new CandidateFoodDistributor(staple, meat, vegetable, suggestCalorie).getOptimalCandidateFoodGroup();
        assertGroup(group, 0, 0, 1, 1, 1);
    }

    private void assertGroup(CandidateFoodGroup group, Object... args) {
        Assertions.assertThat(group.getCalorie()).isEqualTo(args[0]);
        Assertions.assertThat(group.getDeviationValue()).isEqualTo(args[1]);
        Assertions.assertThat(group.getStapleNum()).isEqualTo(args[2]);
        Assertions.assertThat(group.getMeatNum()).isEqualTo(args[3]);
        Assertions.assertThat(group.getVegetableNum()).isEqualTo(args[4]);
    }


}
