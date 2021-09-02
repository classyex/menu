package cn.classyex.menu.application.diet.record;

import cn.classyex.menu.domain.diet.record.DietRecordRepository;
import cn.classyex.menu.domain.diet.record.DietRecordService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/9/2 10:18 <br>
 */
@Configuration
public class DietRecordBeanConfig {

    @Bean
    DietRecordService dietRecordService(DietRecordRepository dietRecordRepository) {
        return new DietRecordService(dietRecordRepository);
    }

}
