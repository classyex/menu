package cn.classyex.menu.domain.food;

import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/6 14:13 <br>
 */
@AllArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;


    public void save(Food food) {
        foodRepository.save(food);
    }

    public List<Food> findBreakfastFood() {
        return foodRepository.findBreakfastFood();
    }

    public List<Food> findLunchFood() {
        return foodRepository.findLunchFood();
    }

    public List<Food> findDinnerFood() {
        return foodRepository.findDinnerFood();
    }
}
