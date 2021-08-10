package cn.classyex.menu.application.food;

import cn.classyex.menu.domain.food.Food;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/6 12:01 <br>
 */
@Data
public class NewFoodForm {

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

    public Food toEntity(String addSource) {
        return Food.builder()
                .addSource(addSource)
                .axunge(axunge)
                .calorie(calorie)
                .carbohydrate(carbohydrate)
                .category(category)
                .foodImage(foodImage)
                .gi(gi)
                .isBreakfast(isBreakfast)
                .isLunch(isLunch)
                .isDinner(isDinner)
                .protein(protein)
                .name(name)
                .quantity(quantity)
                .weight(weight)
                .unit(unit)
                .build();
    }
}
