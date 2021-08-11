package cn.classyex.menu.domain.diet;

import lombok.Getter;

/**
 * 餐次
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/7/30 11:31 <br>
 */
public enum MealEnum {

    BREAKFAST(1),
    LUNCH(2),
    DINNER(3);

    private int type;

    MealEnum(int type) {
        this.type = type;
    }
}
