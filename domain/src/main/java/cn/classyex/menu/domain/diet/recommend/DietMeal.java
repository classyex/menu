package cn.classyex.menu.domain.diet.recommend;

import cn.classyex.menu.domain.food.Food;
import cn.hutool.core.convert.Convert;
import lombok.Data;

import java.util.List;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/7/28 11:44 <br>
 */
@Data
public class DietMeal {

    /** 早餐 */
    private List<Food> breakfast;
    /** 午餐 */
    private List<Food> lunch;
    /** 晚餐 */
    private List<Food> dinner;

    public Float sumProteinAmount() {
        return sumProtein(breakfast) + sumProtein(lunch) +  + sumProtein(dinner);
    }

    private Float sumProtein(List<Food> foods) {
        return Convert.toFloat(foods.stream().mapToDouble(Food::getProtein).sum(), 0F);
    }

    public Float sumCarbohydrateAmount() {
        return sumCarbohydrate(breakfast) + sumCarbohydrate(lunch) +  + sumCarbohydrate(dinner);
    }

    private Float sumCarbohydrate(List<Food> foods) {
        return Convert.toFloat(foods.stream().mapToDouble(Food::getCarbohydrate).sum(), 0F);
    }

    public Float sumAxungeAmount() {
        return sumAxunge(breakfast) + sumAxunge(lunch) + sumAxunge(dinner);
    }

    private Float sumAxunge(List<Food> foods) {
        return Convert.toFloat(foods.stream().mapToDouble(Food::getAxunge).sum(), 0F);
    }

    public Integer sumCalorieAmount() {
        return sumCalorie(breakfast) + sumCalorie(lunch) + sumCalorie(dinner);
    }

    private Integer sumCalorie(List<Food> foods) {
        return Convert.toInt(foods.stream().mapToInt(Food::getCalorie).sum(), 0);
    }

}
