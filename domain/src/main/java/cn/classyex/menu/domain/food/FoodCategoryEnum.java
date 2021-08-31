package cn.classyex.menu.domain.food;

import lombok.Getter;

/**
 * 食物分类枚举
 *
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/7/30 9:48 <br>
 */
@Getter
public enum FoodCategoryEnum {

    STAPLE_FOOD(0),
    MEAT(1),
    VEGETABLES(2);

    private int category;

    FoodCategoryEnum(int category) {
        this.category = category;
    }
}
