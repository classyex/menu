package cn.classyex.menu.domain.diet.recommend;

import cn.classyex.menu.domain.food.Food;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/10 12:22 <br>
 */
@Data
public class DietMealVO {

    /** 早餐 */
    private List<RecommendFoodVO> breakfast;
    /** 午餐 */
    private List<RecommendFoodVO> lunch;
    /** 晚餐 */
    private List<RecommendFoodVO> dinner;

    public static DietMealVO from(DietMeal dietMeal) {
        DietMealVO dietMealVO = new DietMealVO();
        dietMealVO.breakfast = from(dietMeal.getBreakfast());
        dietMealVO.lunch = from(dietMeal.getLunch());
        dietMealVO.dinner = from(dietMeal.getDinner());
        return dietMealVO;
    }

    private static List<RecommendFoodVO> from(List<Food> breakfast) {
        return breakfast.stream().map(RecommendFoodVO::from).collect(Collectors.toList());
    }
}
