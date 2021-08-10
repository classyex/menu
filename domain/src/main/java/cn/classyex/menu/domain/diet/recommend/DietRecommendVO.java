package cn.classyex.menu.domain.diet.recommend;

import lombok.Data;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/10 12:03 <br>
 */
@Data
public class DietRecommendVO {

    /** 推荐摄入热量 */
    private Integer suggestCalorie;
    /** 建议卡路里区间 */
    private SuggestCalorieRange suggestCalorieRange;
    /** 当前卡路里 */
    private Integer currentCalorie;
    /** 饮食目标，0：减重，1：均衡，2：增重 */
    private Integer dietGoal;
    /** 已选碳水化合物(g) */
    private DietIngredient carbohydrate;
    /** 已选蛋白质(g) */
    private DietIngredient protein;
    /** 已选脂肪(g) */
    private DietIngredient axunge;
    /** 饮食详情 */
    private DietMealVO dietMeal;


}
