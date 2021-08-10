package cn.classyex.menu.domain.diet;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/7/28 17:26 <br>
 */
public class BmrCalculator {

    private Integer gender;
    private Double weight;
    private Integer height;
    private Integer age;

    public BmrCalculator(Integer gender, Double weight, Integer height, Integer age) {
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    public Double male() {
        return 13.7 * weight + 5 * height - 6.8 * age + 66;
    }

    public Double female() {
        return 9.6 * weight + 1.8 * height - 4.7 * age + 655;
    }

    public Double calc() {
        if (gender == 1) {
            return male();
        }
        return female();
    }
}
