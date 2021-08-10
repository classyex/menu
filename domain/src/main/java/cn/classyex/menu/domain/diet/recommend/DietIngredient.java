package cn.classyex.menu.domain.diet.recommend;

import lombok.Data;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/7/28 11:40 <br>
 */
@Data
public class DietIngredient {

    /** 已选值 */
    private Float value;
    /** 最小建议值 */
    private Float minSuggest;
    /** 最大建议值 */
    private Float maxSuggest;

    public float carbohydrateRate() {
        return 14F / 30;
    }

    public float proteinRate() {
        return 12F / 30;
    }

    public float axungeRate() {
        return 4F / 30;
    }

}
