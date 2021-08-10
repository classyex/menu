package cn.classyex.menu.application.diet;

import cn.classyex.menu.domain.diet.BmrCalculator;
import cn.classyex.menu.domain.diet.goal.DietGoal;
import cn.classyex.menu.domain.diet.goal.DietGoalFactory;
import cn.classyex.menu.domain.diet.recommend.DietMeal;
import cn.classyex.menu.domain.diet.recommend.DietRecommend;
import cn.classyex.menu.domain.diet.recommend.DietRecommendOperator;
import cn.classyex.menu.domain.diet.recommend.SuggestCalorieCalculator;
import cn.classyex.menu.domain.food.Food;
import cn.classyex.menu.domain.food.FoodCategoryEnum;
import cn.classyex.menu.domain.food.FoodService;
import cn.classyex.menu.domain.member.Member;
import cn.classyex.menu.domain.member.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/9 10:24 <br>
 */
@Service
@AllArgsConstructor
public class DietRecommendFacade {

    private FoodService foodService;
    private MemberService memberService;

    public DietRecommendVO recommendDiet(DietRecommendForm form) {
        Member member = memberService.getByOpenId(form.getOpenId());
        Long lastWeekExerciseHour = queryLastWeekExerciseHour(member.getId());
        int suggestCalorie = getSuggestCalorie(member, lastWeekExerciseHour);
        DietGoal dietGoal = DietGoalFactory.INSTANCE.newInstance(member.getDietGoal(), suggestCalorie);

        DietMeal dietMeals = new DietMeal();
        dietMeals.setBreakfast(recommendBreakfast(suggestCalorie));
        dietMeals.setLunch(recommendLunch(suggestCalorie));
        dietMeals.setDinner(recommendDinner(suggestCalorie));

        DietRecommend dietRecommend = DietRecommend.builder()
                .dietGoal(member.getDietGoal())
                .suggestCalorie(suggestCalorie)
                .suggestCalorieRange(dietGoal.calcSuggestCalorieRange())
                .dietMeal(dietMeals)
                .currentCalorie(dietMeals.sumCalorieAmount())
                .axunge(dietGoal.calcAxungeIngredient(dietMeals.sumAxungeAmount()))
                .carbohydrate(dietGoal.calcCarbohydrateIngredient(dietMeals.sumCarbohydrateAmount()))
                .protein(dietGoal.calcProteinIngredient(dietMeals.sumProteinAmount()))
                .build();
        return DietRecommendVO.from(dietRecommend);
    }

    private List<Food> recommendDinner(int suggestCalorie) {
        int breakSuggestCalorie = (int) (suggestCalorie * 0.3);
        List<Food> foods = foodService.findDinnerFood();
        return recommendFoods(breakSuggestCalorie, foods);
    }

    private List<Food> recommendLunch(int suggestCalorie) {
        int breakSuggestCalorie = (int) (suggestCalorie * 0.4);
        List<Food> foods = foodService.findLunchFood();
        return recommendFoods(breakSuggestCalorie, foods);
    }

    private List<Food> recommendBreakfast(int suggestCalorie) {
        int breakSuggestCalorie = (int) (suggestCalorie * 0.3);
        List<Food> foods = foodService.findBreakfastFood();
        return recommendFoods(breakSuggestCalorie, foods);
    }

    private List<Food> recommendFoods(int breakSuggestCalorie, List<Food> foods) {
        List<Food> stapleFood = findFoods(foods, FoodCategoryEnum.STAPLE_FOOD.getCategory());
        List<Food> meat = findFoods(foods, FoodCategoryEnum.MEAT.getCategory());
        List<Food> vegetables = findFoods(foods, FoodCategoryEnum.VEGETABLES.getCategory());
        DietRecommendOperator operator = new DietRecommendOperator(stapleFood, meat, vegetables);
        return operator.recommend(breakSuggestCalorie);
    }

    private List<Food> findFoods(List<Food> foods, int category) {
        return foods.stream()
                .filter(food -> category == food.getCategory())
                .collect(Collectors.toList());
    }


    private int getSuggestCalorie(Member member, Long lastWeekExerciseHour) {
        int age = member.getBirthday().until(LocalDate.now()).getYears();
        BmrCalculator calculator = new BmrCalculator(member.getGender(), member.getWeight(), member.getHeight().intValue(), age);
        Float bmr = calculator.calc();
        SuggestCalorieCalculator calorieCalculator = new SuggestCalorieCalculator(bmr, lastWeekExerciseHour);
        return calorieCalculator.calc();
    }

    private Long queryLastWeekExerciseHour(Long memberId) {
        return 0L;
    }
}
