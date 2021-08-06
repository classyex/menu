package cn.classyex.menu.application.food;

import cn.classyex.menu.domain.RandomString;
import cn.classyex.menu.domain.food.Food;
import cn.classyex.menu.domain.food.FoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/6 14:36 <br>
 */
@Service
@AllArgsConstructor
public class FoodRepositoryImpl implements FoodRepository {

    private final FoodDAO foodDAO;


    @Override
    public void save(Food food) {
        FoodDO foodDO = FoodDO.from(food);
        foodDO.setStatus(1);
        foodDO.setIsDeleted(false);
        foodDO.setCode(RandomString.randomUniqueString(3));
        foodDAO.save(foodDO);
    }

}
