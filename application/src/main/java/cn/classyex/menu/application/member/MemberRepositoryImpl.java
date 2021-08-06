package cn.classyex.menu.application.member;

import cn.classyex.menu.domain.member.Member;
import cn.classyex.menu.domain.member.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/6 17:30 <br>
 */
@Service
@AllArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private MemberDAO memberDAO;

    @Override
    public void save(Member member) {
        MemberDO memberDO = MemberDO.from(member);
        memberDO.setStatus(1);
        memberDO.setIsDeleted(false);
        memberDAO.save(memberDO);
    }
}
