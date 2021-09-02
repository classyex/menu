package cn.classyex.menu.application.diet.record;

import cn.classyex.menu.domain.diet.record.DietRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/9/2 11:48 <br>
 */
public class DietRecordDoTest {

    @Test
    public void given_suggestCalorie_1_and_currentCalorie_2_then_isOptimal_should_be_false() {
        DietRecordDO from = DietRecordDO.from(DietRecord.builder().suggestCalorie(1).currentCalorie(2).build());
        Assertions.assertFalse(from.getIsOptimal());
    }

    @Test
    public void given_suggestCalorie_2_and_currentCalorie_2_then_isOptimal_should_be_true() {
        DietRecordDO from = DietRecordDO.from(DietRecord.builder().suggestCalorie(2).currentCalorie(2).build());
        Assertions.assertTrue(from.getIsOptimal());
    }

    @Test
    public void given_suggestCalorie_3_and_currentCalorie_2_then_isOptimal_should_be_true() {
        DietRecordDO from = DietRecordDO.from(DietRecord.builder().suggestCalorie(3).currentCalorie(2).build());
        Assertions.assertTrue(from.getIsOptimal());
    }

}
