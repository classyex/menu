package cn.classyex.menu.domain.diet.goal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/11 16:42 <br>
 */
public class DietGoalFactoryTest {

    @Test
    public void given_0_instance_should_be_loseWeightGoal() {
        DietGoal dietGoal = DietGoalFactory.INSTANCE.newInstance(LoseWeightGoal.GOAL, 0);
        Assertions.assertTrue(dietGoal instanceof LoseWeightGoal);
    }

    @Test
    public void given_1_instance_should_be_balanceGoal() {
        DietGoal dietGoal = DietGoalFactory.INSTANCE.newInstance(BalanceGoal.GOAL, 0);
        Assertions.assertTrue(dietGoal instanceof BalanceGoal);
    }

    @Test
    public void given_2_instance_should_be_gainWeightGoal() {
        DietGoal dietGoal = DietGoalFactory.INSTANCE.newInstance(GainWeightGoal.GOAL, 0);
        Assertions.assertTrue(dietGoal instanceof GainWeightGoal);
    }

    @Test
    public void given_3_instance_should_be_throw_exception() {
        int goal = 3;
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> DietGoalFactory.INSTANCE.newInstance(goal, 0));
        Assertions.assertEquals("非法goal:" + goal, exception.getMessage());
    }

}
