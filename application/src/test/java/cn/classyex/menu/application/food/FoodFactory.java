package cn.classyex.menu.application.food;

import cn.classyex.menu.application.BaseFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/6 12:07 <br>
 */
@Service
public class FoodFactory extends BaseFactory {

    private final FoodDAO foodDao;

    public FoodFactory(FoodDAO foodDao, JdbcTemplate jdbcTemplate) {
        this.foodDao = foodDao;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    protected String getTableName() {
        return "diet_food";
    }

    public List<FoodDO> all() {
        return StreamSupport.stream(foodDao.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
