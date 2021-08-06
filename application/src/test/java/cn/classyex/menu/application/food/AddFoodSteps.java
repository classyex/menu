package cn.classyex.menu.application.food;

import cn.classyex.menu.application.AutoClear;
import cn.classyex.menu.application.RestCall;
import cn.classyex.menu.domain.RandomString;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/6 11:51 <br>
 */
public class AddFoodSteps {

    @Autowired
    RestCall restCall;
    @Autowired
    AutoClear autoClear;
    @Autowired
    FoodFactory foodFactory;


    @Before
    public void setup() {
        autoClear.clear(this);
    }

    @When("保存食品")
    public void 保存食品(String food) throws IOException {
        RandomString.setResultSupplier(() -> "123");
        restCall.post("foods", food);
    }

    @Then("有填写的食品")
    public void 有填写的食品(List<Map<String, String>> foods) {
        List<FoodDO> allFoods = foodFactory.all();
        assertThat(allFoods.size()).isEqualTo(foods.size());
        List<Map<String, String>> actual = allFoods.stream().map(food -> {
            Map<String, String> value = new HashMap<>();
            value.put("分类", food.getCategory().toString());
            value.put("名称", food.getName());
            value.put("单位", food.getUnit());
            value.put("数量", food.getQuantity().toString());
            value.put("重量", food.getWeight().toString());
            value.put("热量", food.getCalorie().toString());
            value.put("碳水化合物", food.getCarbohydrate().toString());
            value.put("蛋白质", food.getProtein().toString());
            value.put("脂肪", food.getAxunge().toString());
            value.put("GI值", food.getGi().toString());
            value.put("参考图片", food.getFoodImage());
            value.put("早餐", food.getIsBreakfast().toString());
            value.put("午餐", food.getIsLunch().toString());
            value.put("晚餐", food.getIsDinner().toString());
            value.put("来源", food.getAddSource());
            value.put("状态", food.getStatus().toString());
            value.put("删除", food.getIsDeleted().toString());
            value.put("编号", food.getCode());
            return value;
        }).collect(Collectors.toList());
        assertThat(actual).isEqualTo(foods);
    }

}
