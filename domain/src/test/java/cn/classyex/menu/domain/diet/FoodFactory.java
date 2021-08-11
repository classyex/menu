package cn.classyex.menu.domain.diet;

import cn.classyex.menu.domain.food.Food;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/11 14:56 <br>
 */
public class FoodFactory {

    public static Food rice = createFood("米饭,100,114,25.6,2.5,0.2");
    public static Food corn = createFood("玉米,46,106,19.9,4,1.2");
    public static Food lean = createFood("猪瘦肉,100,143,1.5,20.3,6.2");
    public static Food egg = createFood("鸡蛋,88,156,1.3,12.8,11.1");
    public static Food shrimp = createFood("基围虾,60,101,3.9,18.2,1.4");
    public static Food lettuce = createFood("生菜,94,13,1.3,1.3,0.3");
    public static Food leek = createFood("韭菜,90,26,3.2,2.4,0.4");

    private static Food createFood(String param) {
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
