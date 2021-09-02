package cn.classyex.menu.domain.diet.record;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/31 17:51 <br>
 */
@Getter
@Builder
public class DietRecord {

    private Long id;
    /** 用户id */
    private Long memberId;
    /** 饮食日期 */
    private String dietDate;
    /** 饮食月份 */
    private String dietMonth;
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
    private String dietDetails;
    /** 是否最佳 */
    private Boolean isOptimal;

    private Integer status;
    private Boolean isDeleted;
    private String creator;
    private LocalDateTime createTime;
    private String updater;
    private LocalDateTime updateTime;

}
