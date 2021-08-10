package cn.classyex.menu.domain.diet;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/7/28 17:26 <br>
 */
public class BmrCalculator {

    private Integer gender;
    private Float weight;
    private Float height;
    private Integer age;

    public BmrCalculator(Integer gender, Float weight, Float height, Integer age) {
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    public Float male() {
        return 13.7F * weight + 5 * height - 6.8F * age + 66;
    }

    public Float female() {
        return 9.6F * weight + 1.8F * height - 4.7F * age + 655;
    }

    public Float calc() {
        if (gender == 1) {
            return male();
        }
        return female();
    }
}
