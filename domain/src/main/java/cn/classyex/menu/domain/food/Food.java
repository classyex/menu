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


}
