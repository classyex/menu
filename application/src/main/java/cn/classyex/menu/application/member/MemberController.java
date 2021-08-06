package cn.classyex.menu.application.member;

import cn.classyex.menu.domain.member.Member;
import cn.classyex.menu.domain.member.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/6 16:41 <br>
 */
@RestController
@RequestMapping("/members")
@AllArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public void save(@RequestBody NewMemberForm form) {
        Member member = form.toEntity();
        memberService.save(member);
    }

}
