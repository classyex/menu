package cn.classyex.menu.domain.diet.recommend;

import cn.classyex.menu.domain.RandomElement;
import cn.classyex.menu.domain.food.Food;

import java.util.ArrayList;
import java.util.List;

import static cn.classyex.menu.domain.RandomElement.randomEle;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/7/29 15:04 <br>
 */
public class DietRecommendOperator {
    private final List<Food> stapleFood;
    private final List<Food> meats;
    private final List<Food> vegetables;

    public DietRecommendOperator(List<Food> stapleFood, List<Food> meats, List<Food> vegetables) {
        this.stapleFood = stapleFood;
        this.meats = meats;
        this.vegetables = vegetables;
    }

    public List<Food> recommend(int suggestCalorie) {
        return assignQuantity(randomEle(stapleFood), randomEle(meats), randomEle(vegetables), suggestCalorie);
    }

    private List<Food> assignQuantity(Food staple, Food meat, Food vegetable, int suggestCalorie) {
        CandidateFoodGroup foodGroup = new CandidateFoodDistributor(staple, meat, vegetable, suggestCalorie)
                .getOptimalCandidateFoodGroup();
        List<Food> result = new ArrayList<>(3);
        result.add(staple.newFoodForQuantity((float) foodGroup.getStapleNum()));
        result.add(meat.newFoodForQuantity((float) foodGroup.getMeatNum()));
        result.add(vegetable.newFoodForQuantity((float) foodGroup.getVegetableNum()));
        return result;
    }

}
