package cn.classyex.menu.domain.member;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/6 17:23 <br>
 */
@Getter
@Builder
public class Member {

    private Long id;
    /** openId */
    private String openId;
    /** 昵称 */
    private String nickname;
    /** 头像 */
    private String avatar;
    /** 性别，1：男，2：女 */
    private Integer gender;
    /** 身高（cm) */
    private Float height;
    /** 体重（kg) */
    private Float weight;
    /** 生日 */
    private LocalDate birthday;
    /** 饮食目标 */
    private Integer dietGoal;

}
