package cn.classyex.menu.application.member;

import cn.classyex.menu.domain.member.MemberRepository;
import cn.classyex.menu.domain.member.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/6 17:27 <br>
 */
@Configuration
public class MemberBeanConfig {

    @Bean
    MemberService memberService(MemberRepository memberRepository) {
        return new MemberService(memberRepository);
    }

}
