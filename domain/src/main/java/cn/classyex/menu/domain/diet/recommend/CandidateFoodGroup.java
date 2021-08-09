package cn.classyex.menu.domain.diet.recommend;

import lombok.Getter;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/7/29 17:25 <br>
 */
@Getter
public class CandidateFoodGroup {

    private int stapleNum;
    private int meatNum;
    private int vegetableNum;
    private int calorie;
    private int deviationValue;

    public CandidateFoodGroup(int stapleNum, int meatNum, int vegetableNum, int calorie, int deviationValue) {
        this.stapleNum = stapleNum;
        this.meatNum = meatNum;
        this.vegetableNum = vegetableNum;
        this.calorie = calorie;
        this.deviationValue = deviationValue;
    }

}
