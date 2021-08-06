package cn.classyex.menu.application.food;

import org.springframework.data.repository.CrudRepository;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/6 12:29 <br>
 */
public interface FoodDAO extends CrudRepository<FoodDO, Long> {
}
