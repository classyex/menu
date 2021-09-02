package cn.classyex.menu.application.diet.record;

import cn.classyex.menu.domain.diet.record.DietRecord;
import cn.classyex.menu.domain.diet.record.DietRecordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/9/2 10:23 <br>
 */
@Service
@AllArgsConstructor
public class DietRecordRepositoryImpl implements DietRecordRepository {

    private final DietRecordDAO dietRecordDAO;

    @Override
    public void save(DietRecord entity) {
        DietRecordDO recordDO = DietRecordDO.from(entity);
        dietRecordDAO.save(recordDO);
    }

}
