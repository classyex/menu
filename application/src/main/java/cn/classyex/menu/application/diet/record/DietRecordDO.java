package cn.classyex.menu.application.diet.record;

import cn.classyex.menu.domain.SystemDate;
import cn.classyex.menu.domain.diet.record.DietRecord;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/31 17:11 <br>
 */
@Builder
@Data
@Entity
@Table(name = "diet_record")
@AllArgsConstructor
@NoArgsConstructor
public class DietRecordDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(length = 3000)
    private String dietDetails;
    /** 是否最佳 */
    private Boolean isOptimal;

    private Integer status;
    private Boolean isDeleted;
    private String creator;
    private LocalDateTime createTime;
    private String updater;
    private LocalDateTime updateTime;

    public static DietRecordDO from(DietRecord entity) {
        LocalDateTime now = SystemDate.localDateTime();
        String date = DateUtil.format(now, DatePattern.NORM_DATE_PATTERN);
        String month = DateUtil.format(now, DatePattern.NORM_MONTH_PATTERN);
        return DietRecordDO.builder()
                .memberId(entity.getMemberId())
                .suggestCalorie(entity.getSuggestCalorie())
                .currentCalorie(entity.getCurrentCalorie())
                .dietGoal(entity.getDietGoal())
                .carbohydrate(entity.getCarbohydrate())
                .protein(entity.getProtein())
                .axunge(entity.getAxunge())
                .dietDetails(entity.getDietDetails())
                .dietDate(date)
                .dietMonth(month)
                .isOptimal(entity.getCurrentCalorie() <= entity.getSuggestCalorie())
                .status(1)
                .isDeleted(false)
                .createTime(now)
                .updateTime(now)
                .build();
    }
}
