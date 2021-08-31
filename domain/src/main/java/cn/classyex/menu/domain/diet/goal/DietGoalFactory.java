package cn.classyex.menu.domain.diet.goal;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/7/28 13:48 <br>
 */
public class DietGoalFactory {

    public static final DietGoalFactory INSTANCE = new DietGoalFactory();

    private DietGoalFactory() {
    }

    public DietGoal newInstance(int goal, int suggestCalorie) {
        if (goal == LoseWeightGoal.GOAL) {
            return new LoseWeightGoal(suggestCalorie);
        }
        if (goal == GainWeightGoal.GOAL) {
            return new GainWeightGoal(suggestCalorie);
        }
        if (goal == BalanceGoal.GOAL) {
            return new BalanceGoal(suggestCalorie);
        }
        throw new IllegalArgumentException("非法goal:" + goal);
    }

}
