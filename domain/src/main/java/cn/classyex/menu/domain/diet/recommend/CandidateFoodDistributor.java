package cn.classyex.menu.domain.diet.recommend;

import cn.classyex.menu.domain.food.Food;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/7/29 17:27 <br>
 */
public class CandidateFoodDistributor {

    public static final int MAX_STAPLE = 3;
    public static final int MAX_MEAT = 3;
    public static final int MAX_VEGETABLE = 2;
    public static final int MIN_NUM = 1;
    private final Food staple;
    private final Food meat;
    private final Food vegetable;
    private final int suggestCalorie;

    public CandidateFoodDistributor(Food staple, Food meat, Food vegetable, int suggestCalorie) {
        this.staple = staple;
        this.meat = meat;
        this.vegetable = vegetable;
        this.suggestCalorie = suggestCalorie;
    }

    private List<CandidateFoodGroup> assignCandidateFoodGroups() {
        List<CandidateFoodGroup> candidateFoodGroups = new ArrayList<>();
        for (int vegetableNum = MIN_NUM; vegetableNum <= getMaxVegetable(); vegetableNum++) {
            for (int stapleNum = MIN_NUM; stapleNum <= getMaxStaple(); stapleNum++) {
                int meatNum = calcMeatNum(vegetableNum, stapleNum);
                CandidateFoodGroup foodGroup = assignCandidateFoodGroup(vegetableNum, stapleNum, meatNum);
                if (foodGroup != null) {
                    candidateFoodGroups.add(foodGroup);
                }
            }
        }
        if (candidateFoodGroups.isEmpty()) {
            candidateFoodGroups.add(defaultFoodGroup());
        }
        return candidateFoodGroups;
    }

    private CandidateFoodGroup defaultFoodGroup() {
        return new CandidateFoodGroup(1, 1, 1, 0, 0);
    }

    private CandidateFoodGroup assignCandidateFoodGroup(int vegetableNum, int stapleNum, int meatNum) {
        if (meatNum > MAX_MEAT || meatNum < MIN_NUM) {
            return null;
        }
        int calorie = sumTotalCalorie(vegetableNum, stapleNum, meatNum);
        if (!isSuggestCalorieRange(calorie)) {
            return null;
        }
        int deviationValue = calcDeviationValue(vegetableNum, stapleNum, meatNum);
        return new CandidateFoodGroup(stapleNum, meatNum, vegetableNum, calorie, deviationValue);
    }

    private int calcDeviationValue(int vegetableNum, int stapleNum, int meatNum) {
        double deviationValue = new StandardDeviation(false).evaluate(new double[]{stapleNum, meatNum, vegetableNum});
        return (int) (deviationValue * 10000);
    }

    private int sumTotalCalorie(int vegetableNum, int stapleNum, int meatNum) {
        return staple.getCalorie() * stapleNum + meat.getCalorie() * meatNum + vegetable.getCalorie() * vegetableNum;
    }

    private int calcMeatNum(int vegetableNum, int stapleNum) {
        return (suggestCalorie - staple.getCalorie() * stapleNum - vegetable.getCalorie() * vegetableNum) / meat.getCalorie();
    }

    private int getMaxStaple() {
        return Math.min(MAX_STAPLE, suggestCalorie / staple.getCalorie());
    }

    private int getMaxVegetable() {
        return Math.min(MAX_VEGETABLE, suggestCalorie / vegetable.getCalorie());
    }

    private boolean isSuggestCalorieRange(int calorie) {
        return calorie >= suggestCalorie * 0.8 && calorie <= suggestCalorie;
    }

    public CandidateFoodGroup getOptimalCandidateFoodGroup() {
        List<CandidateFoodGroup> candidateFoodGroups = assignCandidateFoodGroups();
        sort(candidateFoodGroups);
        return candidateFoodGroups.get(0);
    }

    private void sort(List<CandidateFoodGroup> candidateFoodGroups) {
        candidateFoodGroups.sort(Comparator.comparing(Function.identity(), (a, b) -> {
            if (a.getDeviationValue() == b.getDeviationValue()) {
                return b.getCalorie() - a.getCalorie();
            }
            return a.getDeviationValue() - b.getDeviationValue();
        }));
    }

}
