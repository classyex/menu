package cn.classyex.menu.application.diet.record;

import cn.classyex.menu.application.BaseFactory;
import cn.classyex.menu.application.food.FoodDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/31 16:51 <br>
 */
@Service
public class DietRecordFactory extends BaseFactory {

    private final DietRecordDAO dietRecordDAO;

    public DietRecordFactory(DietRecordDAO dietRecordDAO, JdbcTemplate jdbcTemplate) {
        this.dietRecordDAO = dietRecordDAO;
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    protected String getTableName() {
        return "diet_record";
    }

    public List<DietRecordDO> all() {
        return new ArrayList<>(dietRecordDAO.findAll());
    }

}
