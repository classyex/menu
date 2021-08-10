package cn.classyex.menu.application.member;

import cn.classyex.menu.domain.member.Member;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/6 16:42 <br>
 */
@Getter
@Setter
public class NewMemberForm {

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

    public Member toEntity() {
        return Member.builder()
                .openId(openId)
                .nickname(nickname)
                .avatar(avatar)
                .gender(gender)
                .height(height)
                .weight(weight)
                .birthday(birthday)
                .dietGoal(dietGoal)
                .build();
    }
}
