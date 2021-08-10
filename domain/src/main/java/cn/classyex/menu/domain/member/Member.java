package cn.classyex.menu.domain.member;

import cn.classyex.menu.domain.diet.BmrCalculator;
import cn.classyex.menu.domain.diet.recommend.SuggestCalorieCalculator;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/6 17:23 <br>
 */
@Getter
@Builder
public class Member {

    private Long id;
    /** openId */
    private String openId;
    /** 昵称 */
    private String nickname;
    /** 头像 */
    private String avatar;
    /** 性别，1：男，2：女 */
    private Integer gender;
    /** 身高（cm) */
    private Float height;
    /** 体重（kg) */
    private Float weight;
    /** 生日 */
    private LocalDate birthday;
    /** 饮食目标 */
    private Integer dietGoal;

    public int suggestCalorieFor(Long lastWeekExerciseHour) {
        int age = birthday.until(LocalDate.now()).getYears();
        BmrCalculator calculator = new BmrCalculator(gender, weight, height, age);
        Float bmr = calculator.calc();
        SuggestCalorieCalculator calorieCalculator = new SuggestCalorieCalculator(bmr, lastWeekExerciseHour);
        return calorieCalculator.calc();
    }
}
