package cn.classyex.menu.application.food;

import cn.classyex.menu.domain.food.FoodRepository;
import cn.classyex.menu.domain.food.FoodService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/6 15:04 <br>
 */
@Configuration
public class FoodBeanConfig {

    @Bean
    FoodService foodService(FoodRepository foodRepository) {
        return new FoodService(foodRepository);
    }

}
