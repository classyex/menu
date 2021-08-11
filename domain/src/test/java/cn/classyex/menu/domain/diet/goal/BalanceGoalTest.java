package cn.classyex.menu.domain.diet.goal;

import cn.classyex.menu.domain.diet.recommend.DietIngredient;
import cn.classyex.menu.domain.diet.recommend.SuggestCalorieRange;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/11 16:09 <br>
 */
public class BalanceGoalTest {

    @Test
    public void suggestCalorie_2000_when_balance_calcSuggestCalorieRange_max_should_be_3600() {
        DietGoal dietGoal = DietGoalFactory.INSTANCE.newInstance(BalanceGoal.GOAL, 2000);
        SuggestCalorieRange suggestCalorieRange = dietGoal.calcSuggestCalorieRange();
        assertThat(suggestCalorieRange.getFloor()).isEqualTo(0);
        assertThat(suggestCalorieRange.getCeiling()).isEqualTo(3600);
        assertThat(suggestCalorieRange.getMinSuggest()).isEqualTo(1600);
        assertThat(suggestCalorieRange.getMaxSuggest()).isEqualTo(2000);
    }

    @Test
    public void suggestCalorie_2000_when_balance_calcAxungeIngredient_max_should_be_29_62() {
        DietGoal dietGoal = DietGoalFactory.INSTANCE.newInstance(BalanceGoal.GOAL, 2000);
        float axunge = 500F;
        DietIngredient ingredient = dietGoal.calcAxungeIngredient(axunge);
        assertThat(ingredient.getValue()).isEqualTo(axunge);
        assertThat(ingredient.getMinSuggest()).isEqualTo(0);
        assertThat(ingredient.getMaxSuggest()).isEqualTo(29.62F, Offset.offset(0.01F));
    }

    @Test
    public void suggestCalorie_2000_when_balance_calcCarbohydrateIngredient_max_should_be_233_33() {
        DietGoal dietGoal = DietGoalFactory.INSTANCE.newInstance(BalanceGoal.GOAL, 2000);
        float carbohydrate = 500F;
        DietIngredient ingredient = dietGoal.calcCarbohydrateIngredient(carbohydrate);
        assertThat(ingredient.getValue()).isEqualTo(carbohydrate);
        assertThat(ingredient.getMinSuggest()).isEqualTo(0);
        assertThat(ingredient.getMaxSuggest()).isEqualTo(233.33F, Offset.offset(0.01F));
    }

    @Test
    public void suggestCalorie_2000_when_balance_calcProteinIngredient_max_should_be_200_0() {
        DietGoal dietGoal = DietGoalFactory.INSTANCE.newInstance(BalanceGoal.GOAL, 2000);
        float protein = 500F;
        DietIngredient ingredient = dietGoal.calcProteinIngredient(protein);
        assertThat(ingredient.getValue()).isEqualTo(protein);
        assertThat(ingredient.getMinSuggest()).isEqualTo(0);
        assertThat(ingredient.getMaxSuggest()).isEqualTo(200.0F, Offset.offset(0.01F));
    }

}
