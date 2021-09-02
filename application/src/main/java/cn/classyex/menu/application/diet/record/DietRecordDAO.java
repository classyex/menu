package cn.classyex.menu.application.diet.record;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/31 17:20 <br>
 */
public interface DietRecordDAO extends JpaRepository<DietRecordDO, Long>,
        JpaSpecificationExecutor<DietRecordDO>, CrudRepository<DietRecordDO, Long> {
}
