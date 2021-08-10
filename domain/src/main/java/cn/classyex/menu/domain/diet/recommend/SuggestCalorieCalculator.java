package cn.classyex.menu.domain.diet.recommend;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/7/28 17:35 <br>
 */
public class SuggestCalorieCalculator {

    private Double bmr;
    private Double factor;

    public SuggestCalorieCalculator(Double bmr, Long lastWeekExerciseHour) {
        this.bmr = bmr;
        this.factor = calcFactor(lastWeekExerciseHour);
    }

    private Double calcFactor(Long lastWeekExerciseTime) {
        if (lastWeekExerciseTime == null) {
            return 1.2;
        }
        double hour = lastWeekExerciseTime / 3600D;
        if (hour >= 5) {
            return 1.65;
        }
        if (hour >= 3) {
            return 1.55;
        }
        if (hour >= 1) {
            return 1.45;
        }
        if (hour > 0) {
            return 1.35;
        }
        return 1.2;
    }

    public int calc() {
        return (int) (bmr * factor);
    }

}
