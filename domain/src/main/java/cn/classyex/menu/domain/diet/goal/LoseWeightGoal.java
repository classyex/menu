package cn.classyex.menu.domain.diet.goal;

import cn.classyex.menu.domain.diet.recommend.DietIngredient;
import cn.classyex.menu.domain.diet.recommend.SuggestCalorieRange;
import cn.hutool.core.convert.Convert;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/7/28 12:25 <br>
 */
public class LoseWeightGoal implements DietGoal {

    public static final int GOAL = 0;
    private static final int CARBOHYDRATE_FACTOR = 4;
    private static final int PROTEIN_FACTOR = 4;
    private static final int AXUNGE_FACTOR = 10;
    private final int suggestCalorie;

    public LoseWeightGoal(int suggestCalorie) {
        this.suggestCalorie = suggestCalorie;
    }

    @Override
    public SuggestCalorieRange calcSuggestCalorieRange() {
        SuggestCalorieRange range = new SuggestCalorieRange();
        range.setFloor(0);
        range.setMinSuggest(Convert.toInt(adjustCalorie() * 0.8));
        range.setMaxSuggest(adjustCalorie());
        range.setCeiling(Convert.toInt(adjustCalorie() * 1.8));
        return range;
    }

    private int adjustCalorie() {
        return suggestCalorie - 400;
    }


    @Override
    public DietIngredient calcCarbohydrateIngredient(Float carbohydrate) {
        DietIngredient dietIngredient = new DietIngredient();
        dietIngredient.setValue(carbohydrate);
        dietIngredient.setMinSuggest(0F);
        dietIngredient.setMaxSuggest(suggestCalorie * dietIngredient.carbohydrateRate() / CARBOHYDRATE_FACTOR);
        return dietIngredient;
    }

    @Override
    public DietIngredient calcProteinIngredient(Float protein) {
        DietIngredient dietIngredient = new DietIngredient();
        dietIngredient.setValue(protein);
        dietIngredient.setMinSuggest(0F);
        dietIngredient.setMaxSuggest(suggestCalorie * dietIngredient.proteinRate() / PROTEIN_FACTOR);
        return dietIngredient;
    }

    @Override
    public DietIngredient calcAxungeIngredient(Float axunge) {
        DietIngredient dietIngredient = new DietIngredient();
        dietIngredient.setValue(axunge);
        dietIngredient.setMinSuggest(0F);
        dietIngredient.setMaxSuggest(suggestCalorie * dietIngredient.axungeRate() / AXUNGE_FACTOR);
        return dietIngredient;
    }
}
