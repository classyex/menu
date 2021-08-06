package cn.classyex.menu.application.food;

import cn.classyex.menu.domain.food.Food;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/6 12:17 <br>
 */
@Builder
@Data
@Entity
@Table(name = "diet_food")
@AllArgsConstructor
@NoArgsConstructor
public class FoodDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    /** 添加来源，system/用户id */
    private String addSource;
    /** 原始id */
    private String code;
    private Integer status;
    private Boolean isDeleted;
    private String creator;
    private LocalDateTime createTime;
    private String updater;
    private LocalDateTime updateTime;

    public static FoodDO from(Food food) {
        return builder()
                .category(food.getCategory())
                .name(food.getName())
                .unit(food.getUnit())
                .quantity(food.getQuantity())
                .weight(food.getWeight())
                .calorie(food.getCalorie())
                .carbohydrate(food.getCarbohydrate())
                .protein(food.getProtein())
                .axunge(food.getAxunge())
                .gi(food.getGi())
                .foodImage(food.getFoodImage())
                .isBreakfast(food.getIsBreakfast())
                .isLunch(food.getIsLunch())
                .isDinner(food.getIsDinner())
                .addSource(food.getAddSource())
                .build();
    }
}
