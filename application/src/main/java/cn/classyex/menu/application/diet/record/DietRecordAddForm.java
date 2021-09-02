package cn.classyex.menu.application.diet.record;

import cn.classyex.menu.domain.diet.recommend.DietIngredient;
import cn.classyex.menu.domain.diet.recommend.DietMealVO;
import cn.classyex.menu.domain.diet.recommend.SuggestCalorieRange;
import cn.classyex.menu.domain.diet.record.DietRecord;
import cn.hutool.json.JSONUtil;
import lombok.Data;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/31 17:31 <br>
 */
@Data
public class DietRecordAddForm {

    private Long memberId;
    /** 推荐摄入热量 */
    private Integer suggestCalorie;
    /** 当前卡路里 */
    private Integer currentCalorie;
    /** 饮食目标，0：减重，1：均衡，2：增重 */
    private Integer dietGoal;
    /** 已选碳水化合物(g) */
    private Float carbohydrate;
    /** 已选蛋白质(g) */
    private Float protein;
    /** 已选脂肪(g) */
    private Float axunge;
    /** 饮食详情 */
    private DietMealVO dietMeal;

    public DietRecord toEntity() {
        return DietRecord.builder()
                .memberId(memberId)
                .suggestCalorie(suggestCalorie)
                .currentCalorie(currentCalorie)
                .dietGoal(dietGoal)
                .carbohydrate(carbohydrate)
                .protein(protein)
                .axunge(axunge)
                .dietDetails(JSONUtil.toJsonStr(dietMeal))
                .build();
    }
}
