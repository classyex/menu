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

    private List<Food> getVegetablesFoods() {
        List<Food> vegetables = new ArrayList<>();
        vegetables.add(createFood("生菜,94,13,1.3,1.3,0.3"));
        vegetables.add(createFood("韭菜,90,26,3.2,2.4,0.4"));
        return vegetables;
    }

    private List<Food> getMeatFoods() {
        List<Food> meat = new ArrayList<>();
        meat.add(createFood("猪瘦肉,100,143,1.5,20.3,6.2"));
        meat.add(createFood("鸡蛋,88,156,1.3,12.8,11.1"));
        meat.add(createFood("基围虾,60,101,3.9,18.2,1.4"));
        return meat;
    }

    private List<Food> getStapleFoods() {
        List<Food> stapleFood = new ArrayList<>();
        stapleFood.add(createFood("米饭,100,114,25.6,2.5,0.2"));
        stapleFood.add(createFood("玉米,46,106,19.9,4,1.2"));
        return stapleFood;
    }

    private Food createFood(String param) {
        String[] split = param.split(",");
        return Food.builder()
                .name(split[0])
                .weight(Integer.valueOf(split[1]))
                .calorie(Integer.valueOf(split[2]))
                .carbohydrate(Float.valueOf(split[3]))
                .protein(Float.valueOf(split[4]))
                .axunge(Float.valueOf(split[5]))
                .quantity(1F)
                .build();
    }


}
