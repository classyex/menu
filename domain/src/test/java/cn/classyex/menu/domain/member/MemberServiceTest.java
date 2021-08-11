package cn.classyex.menu.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/11 9:54 <br>
 */
public class MemberServiceTest {


    @Mock
    private MemberRepository memberRepository;
    @InjectMocks
    private MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void save_openId_123_should_invoke_1_times_repository_save() {
        String openId = "123";
        Member member = Member.builder().openId(openId).build();
        memberService.save(member);
        Mockito.verify(memberRepository, Mockito.times(1)).save(Mockito.eq(member));
    }

    @Test
    public void exist_openId_123_then_getOpenId_should_be_123() {
        String openId = "123";
        Member member = Member.builder().openId(openId).build();
        Mockito.when(memberRepository.getByOpenId(Mockito.eq(openId))).thenReturn(member);

        Member byOpenId = memberService.getByOpenId(openId);
        Assertions.assertThat(byOpenId.getOpenId()).isEqualTo(openId);
    }

}
