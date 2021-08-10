package cn.classyex.menu.domain.diet.recommend;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/7/28 17:35 <br>
 */
public class SuggestCalorieCalculator {

    private Float bmr;
    private Float factor;

    public SuggestCalorieCalculator(Float bmr, Long lastWeekExerciseHour) {
        this.bmr = bmr;
        this.factor = calcFactor(lastWeekExerciseHour);
    }

    private Float calcFactor(Long lastWeekExerciseTime) {
        if (lastWeekExerciseTime == null) {
            return 1.2F;
        }
        double hour = lastWeekExerciseTime / 3600D;
        if (hour >= 5) {
            return 1.65F;
        }
        if (hour >= 3) {
            return 1.55F;
        }
        if (hour >= 1) {
            return 1.45F;
        }
        if (hour > 0) {
            return 1.35F;
        }
        return 1.2F;
    }

    public int calc() {
        return (int) (bmr * factor);
    }

}
