package cn.classyex.menu.domain.food;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/6 14:17 <br>
 */
@Getter
@Builder
public class Food {

    private final Long id;
    /** 分类，0：主食，1：肉蛋奶，2：果蔬 */
    private final Integer category;
    /** 名称 */
    private final String name;
    /** 单位 */
    private final String unit;
    /** 数量 */
    private final Float quantity;
    /** 重量(g) */
    private final Integer weight;
    /** 热量(kcal) */
    private final Integer calorie;
    /** 碳水化合物(g) */
    private final Float carbohydrate;
    /** 蛋白质(g) */
    private final Float protein;
    /** 脂肪(g) */
    private final Float axunge;
    /** GI值,0:低，1：中，2：高 */
    private final Integer gi;
    /** 参考图片 */
    private final String foodImage;
    /** 早餐 */
    private final Boolean isBreakfast;
    /** 午餐 */
    private final Boolean isLunch;
    /** 晚餐 */
    private final Boolean isDinner;
    /** 添加来源，system/用户id */
    private final String addSource;
    /** 原始id */
    private final String code;
    private final Integer status;
    private final Boolean isDeleted;
    private final String creator;
    private final LocalDateTime createTime;
    private final String updater;
    private final LocalDateTime updateTime;


    public Food newFoodForQuantity(float newQuantity) {
        return builder()
                .id(id)
                .category(category)
                .name(name)
                .unit(unit)
                .quantity(newQuantity)
                .weight((int) (weight * newQuantity))
                .calorie((int) (calorie * newQuantity))
                .carbohydrate(carbohydrate * newQuantity)
                .protein(protein * newQuantity)
                .axunge(axunge * newQuantity)
                .gi(gi)
                .foodImage(foodImage)
                .isBreakfast(isBreakfast)
                .isLunch(isLunch)
                .isDinner(isDinner)
                .addSource(addSource)
                .code(code)
                .status(status)
                .isDeleted(isDeleted)
                .creator(creator)
                .createTime(createTime)
                .updater(updater)
                .updateTime(updateTime)
                .build();
    }
}
