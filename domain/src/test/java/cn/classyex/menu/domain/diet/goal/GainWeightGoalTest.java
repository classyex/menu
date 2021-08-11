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
public class GainWeightGoalTest {

    @Test
    public void suggestCalorie_2000_when_gainWeight_calcSuggestCalorieRange_max_should_be_2880() {
        DietGoal dietGoal = DietGoalFactory.INSTANCE.newInstance(GainWeightGoal.GOAL, 2000);
        SuggestCalorieRange suggestCalorieRange = dietGoal.calcSuggestCalorieRange();
        assertThat(suggestCalorieRange.getFloor()).isEqualTo(0);
        assertThat(suggestCalorieRange.getCeiling()).isEqualTo(4800);
        assertThat(suggestCalorieRange.getMinSuggest()).isEqualTo(1920);
        assertThat(suggestCalorieRange.getMaxSuggest()).isEqualTo(2880);
    }

    @Test
    public void suggestCalorie_2000_when_gainWeight_calcAxungeIngredient_max_should_be_33_33() {
        DietGoal dietGoal = DietGoalFactory.INSTANCE.newInstance(GainWeightGoal.GOAL, 2000);
        float axunge = 500F;
        DietIngredient ingredient = dietGoal.calcAxungeIngredient(axunge);
        assertThat(ingredient.getValue()).isEqualTo(axunge);
        assertThat(ingredient.getMinSuggest()).isEqualTo(0);
        assertThat(ingredient.getMaxSuggest()).isEqualTo(33.33F, Offset.offset(0.01F));
    }

    @Test
    public void suggestCalorie_2000_when_gainWeight_calcCarbohydrateIngredient_max_should_be_233_33() {
        DietGoal dietGoal = DietGoalFactory.INSTANCE.newInstance(GainWeightGoal.GOAL, 2000);
        float carbohydrate = 500F;
        DietIngredient ingredient = dietGoal.calcCarbohydrateIngredient(carbohydrate);
        assertThat(ingredient.getValue()).isEqualTo(carbohydrate);
        assertThat(ingredient.getMinSuggest()).isEqualTo(0);
        assertThat(ingredient.getMaxSuggest()).isEqualTo(233.33F, Offset.offset(0.01F));
    }

    @Test
    public void suggestCalorie_2000_when_gainWeight_calcProteinIngredient_max_should_be_266_66() {
        DietGoal dietGoal = DietGoalFactory.INSTANCE.newInstance(GainWeightGoal.GOAL, 2000);
        float protein = 500F;
        DietIngredient ingredient = dietGoal.calcProteinIngredient(protein);
        assertThat(ingredient.getValue()).isEqualTo(protein);
        assertThat(ingredient.getMinSuggest()).isEqualTo(0);
        assertThat(ingredient.getMaxSuggest()).isEqualTo(266.66F, Offset.offset(0.01F));
    }

}
