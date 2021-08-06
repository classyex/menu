package cn.classyex.menu.application.food;

import cn.classyex.menu.domain.food.Food;
import cn.classyex.menu.domain.food.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/6 11:58 <br>
 */
@RestController
@RequestMapping("/foods")
@AllArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @PostMapping
    public void save(@RequestBody NewFoodForm form) {
        Food food = form.toEntity("system");
        foodService.save(food);
    }

}
