package cn.classyex.menu.application.member;

import cn.classyex.menu.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/6 17:06 <br>
 */
@Builder
@Data
@Entity
@Table(name = "t_member")
@AllArgsConstructor
@NoArgsConstructor
public class MemberDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Double height;
    /** 体重（kg) */
    private Double weight;
    /** 生日 */
    private LocalDate birthday;
    /** 饮食目标 */
    private Integer dietGoal;
    private Integer status;
    private Boolean isDeleted;
    private String creator;
    private LocalDateTime createTime;
    private String updater;
    private LocalDateTime updateTime;

    public static MemberDO from(Member member) {
        return MemberDO.builder()
                .openId(member.getOpenId())
                .nickname(member.getNickname())
                .avatar(member.getAvatar())
                .gender(member.getGender())
                .height(member.getHeight())
                .weight(member.getWeight())
                .birthday(member.getBirthday())
                .dietGoal(member.getDietGoal())
                .build();
    }
}
