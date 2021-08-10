package cn.classyex.menu.domain.diet.recommend;

import cn.classyex.menu.domain.diet.goal.DietGoal;
import cn.classyex.menu.domain.diet.goal.DietGoalFactory;
import cn.classyex.menu.domain.food.Food;
import cn.classyex.menu.domain.food.FoodCategoryEnum;
import cn.classyex.menu.domain.food.FoodService;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/9 10:19 <br>
 */
public class DietRecommend {

    private final FoodService foodService;
    /** 推荐摄入热量 */
    private final Integer suggestCalorie;
    /** 建议卡路里区间 */
    private final SuggestCalorieRange suggestCalorieRange;
    /** 当前卡路里 */
    private final Integer currentCalorie;
    /** 饮食目标，0：减重，1：均衡，2：增重 */
    private final Integer dietGoal;
    /** 已选碳水化合物(g) */
    private final DietIngredient carbohydrate;
    /** 已选蛋白质(g) */
    private final DietIngredient protein;
    /** 已选脂肪(g) */
    private final DietIngredient axunge;
    /** 饮食详情 */
    private final DietMeal dietMeal;


    public DietRecommend(FoodService foodService, int suggestCalorie, Integer goal) {
        this.foodService = foodService;
        DietGoal dietGoal = DietGoalFactory.INSTANCE.newInstance(goal, suggestCalorie);
        DietMeal dietMeals = recommendMeal(suggestCalorie);
        this.dietGoal = goal;
        this.suggestCalorie = suggestCalorie;
        this.suggestCalorieRange = dietGoal.calcSuggestCalorieRange();
        this.dietMeal = dietMeals;
        this.currentCalorie = dietMeals.sumCalorieAmount();
        this.axunge = dietGoal.calcAxungeIngredient(dietMeals.sumAxungeAmount());
        this.carbohydrate = dietGoal.calcCarbohydrateIngredient(dietMeals.sumCarbohydrateAmount());
        this.protein = dietGoal.calcProteinIngredient(dietMeals.sumProteinAmount());
    }

    private DietMeal recommendMeal(int suggestCalorie) {
        DietMeal dietMeals = new DietMeal();
        dietMeals.setBreakfast(recommendBreakfast(suggestCalorie));
        dietMeals.setLunch(recommendLunch(suggestCalorie));
        dietMeals.setDinner(recommendDinner(suggestCalorie));
        return dietMeals;
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

    public DietRecommendVO toVO() {
        DietRecommendVO recommendVO = new DietRecommendVO();
        recommendVO.setAxunge(axunge);
        recommendVO.setCarbohydrate(carbohydrate);
        recommendVO.setCurrentCalorie(currentCalorie);
        recommendVO.setDietGoal(dietGoal);
        recommendVO.setProtein(protein);
        recommendVO.setSuggestCalorie(suggestCalorie);
        recommendVO.setSuggestCalorieRange(suggestCalorieRange);
        recommendVO.setDietMeal(DietMealVO.from(dietMeal));
        return recommendVO;
    }
}
