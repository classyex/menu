package cn.classyex.menu.domain.diet;

import cn.classyex.menu.domain.RandomElement;
import cn.classyex.menu.domain.diet.recommend.DietRecommendOperator;
import cn.classyex.menu.domain.food.Food;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/7/29 14:12 <br>
 */
public class DietRecommendTest {

    @Test
    public void random_recommend_600_calorie_diet_total_calorie_should_between_480_and_600() {
        RandomElement.setResultSupplier(() -> 0);
        List<Food> stapleFood = getStapleFoods();
        List<Food> meat = getMeatFoods();
        List<Food> vegetables = getVegetablesFoods();
        int suggestCalorie = 600;
        DietRecommendOperator operator = new DietRecommendOperator(stapleFood, meat, vegetables);
        List<Food> recommendFoods = operator.recommend(suggestCalorie);

        Assertions.assertThat(recommendFoods.size()).isEqualTo(3);
        Assertions.assertThat(recommendFoods.get(0).getCalorie()).isEqualTo(228);
        Assertions.assertThat(recommendFoods.get(1).getCalorie()).isEqualTo(286);
        Assertions.assertThat(recommendFoods.get(2).getCalorie()).isEqualTo(26);
    }

    @Test
    public void random_recommend_800_calorie_diet_total_calorie_should_between_640_and_800() {
        RandomElement.setResultSupplier(() -> 1);
        List<Food> stapleFood = getStapleFoods();
        List<Food> meat = getMeatFoods();
        List<Food> vegetables = getVegetablesFoods();
        DietRecommendOperator operator = new DietRecommendOperator(stapleFood, meat, vegetables);
        int suggestCalorie = 800;
        List<Food> recommendFoods = operator.recommend(suggestCalorie);
        Assertions.assertThat(recommendFoods.size()).isEqualTo(3);
        Assertions.assertThat(recommendFoods.get(0).getCalorie()).isEqualTo(212);
        Assertions.assertThat(recommendFoods.get(1).getCalorie()).isEqualTo(468);
        Assertions.assertThat(recommendFoods.get(2).getCalorie()).isEqualTo(52);
    }

    @Test
    public void random_recommend_1800_calorie_diet_total_calorie_should_between_640_and_800() {
        RandomElement.setResultSupplier(() -> 1);
        List<Food> stapleFood = getStapleFoods();
        List<Food> meat = getMeatFoods();
        List<Food> vegetables = getVegetablesFoods();
        DietRecommendOperator operator = new DietRecommendOperator(stapleFood, meat, vegetables);
        int suggestCalorie = 1800;
        List<Food> recommendFoods = operator.recommend(suggestCalorie);
        Assertions.assertThat(recommendFoods.size()).isEqualTo(3);
        Assertions.assertThat(recommendFoods.get(0).getCalorie()).isEqualTo(106);
        Assertions.assertThat(recommendFoods.get(1).getCalorie()).isEqualTo(156);
        Assertions.assertThat(recommendFoods.get(2).getCalorie()).isEqualTo(26);
    }

    @Test
    public void random_recommend_1800_calorie_diet_should_default() {
        RandomElement.setResultSupplier(() -> 1);
        List<Food> stapleFood = getStapleFoods();
        List<Food> meat = getMeatFoods();
        List<Food> vegetables = getVegetablesFoods();
        DietRecommendOperator operator = new DietRecommendOperator(stapleFood, meat, vegetables);
        int suggestCalorie = 1800;
        List<Food> recommendFoods = operator.recommend(suggestCalorie);
        Assertions.assertThat(recommendFoods.size()).isEqualTo(3);
        Assertions.assertThat(recommendFoods.get(0).getCalorie()).isEqualTo(106);
        Assertions.assertThat(recommendFoods.get(1).getCalorie()).isEqualTo(156);
        Assertions.assertThat(recommendFoods.get(2).getCalorie()).isEqualTo(26);
    }

    private List<Food> getVegetablesFoods() {
        List<Food> vegetables = new ArrayList<>();
        vegetables.add(FoodFactory.lettuce);
        vegetables.add(FoodFactory.leek);
        return vegetables;
    }

    private List<Food> getMeatFoods() {
        List<Food> meat = new ArrayList<>();
        meat.add(FoodFactory.lean);
        meat.add(FoodFactory.egg);
        meat.add(FoodFactory.shrimp);
        return meat;
    }

    private List<Food> getStapleFoods() {
        List<Food> stapleFood = new ArrayList<>();
        stapleFood.add(FoodFactory.rice);
        stapleFood.add(FoodFactory.corn);
        return stapleFood;
    }

}
