package cn.classyex.menu.domain.diet.recommend;

import lombok.Data;

/**
 * 卡路里建议访问
 *
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/7/28 11:30 <br>
 */
@Data
public class SuggestCalorieRange {

    /** 下限值 */
    private Integer floor;
    /** 最小建议值 */
    private Integer minSuggest;
    /** 最大建议值 */
    private Integer maxSuggest;
    /** 上限值 */
    private Integer ceiling;

}
