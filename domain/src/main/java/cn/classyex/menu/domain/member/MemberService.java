package cn.classyex.menu.domain.member;

import lombok.AllArgsConstructor;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/6 17:26 <br>
 */
@AllArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void save(Member member) {
        memberRepository.save(member);
    }
}
