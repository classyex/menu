package cn.classyex.menu.domain.food;

import java.util.List;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/6 14:35 <br>
 */
public interface FoodRepository {


    void save(Food food);


    List<Food> findBreakfastFood();

    List<Food> findLunchFood();

    List<Food> findDinnerFood();

}
