package cn.classyex.menu.domain.diet.recommend;

import cn.classyex.menu.domain.food.Food;
import lombok.Data;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/10 12:03 <br>
 */
@Data
public class RecommendFoodVO {

    private Long id;
    /** 分类，0：主食，1：肉蛋奶，2：果蔬 */
    private Integer category;
    /** 名称 */
    private String name;
    /** 单位 */
    private String unit;
    /** 数量 */
    private Float quantity;
    /** 重量(g) */
    private Integer weight;
    /** 热量(kcal) */
    private Integer calorie;
    /** 碳水化合物(g) */
    private Float carbohydrate;
    /** 蛋白质(g) */
    private Float protein;
    /** 脂肪(g) */
    private Float axunge;
    /** GI值,0:低，1：中，2：高 */
    private Integer gi;
    /** 参考图片 */
    private String foodImage;
    /** 早餐 */
    private Boolean isBreakfast;
    /** 午餐 */
    private Boolean isLunch;
    /** 晚餐 */
    private Boolean isDinner;

    public static RecommendFoodVO from(Food food) {
        RecommendFoodVO vo = new RecommendFoodVO();
        vo.setId(food.getId());
        vo.setCategory(food.getCategory());
        vo.setName(food.getName());
        vo.setUnit(food.getUnit());
        vo.setAxunge(food.getAxunge());
        vo.setCalorie(food.getCalorie());
        vo.setCarbohydrate(food.getCarbohydrate());
        vo.setFoodImage(food.getFoodImage());
        vo.setGi(food.getGi());
        vo.setProtein(food.getProtein());
        vo.setQuantity(food.getQuantity());
        vo.setWeight(food.getWeight());
        return vo;
    }
}
