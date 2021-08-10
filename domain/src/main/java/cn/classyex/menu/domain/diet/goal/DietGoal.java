package cn.classyex.menu.domain.diet.goal;


import cn.classyex.menu.domain.diet.recommend.DietIngredient;
import cn.classyex.menu.domain.diet.recommend.SuggestCalorieRange;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/7/28 12:25 <br>
 */
public interface DietGoal {

    SuggestCalorieRange calcSuggestCalorieRange();

    DietIngredient calcCarbohydrateIngredient(Float carbohydrate);

    DietIngredient calcProteinIngredient(Float protein);

    DietIngredient calcAxungeIngredient(Float axunge);
}
