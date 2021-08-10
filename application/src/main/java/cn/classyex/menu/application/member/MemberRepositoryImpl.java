package cn.classyex.menu.application.member;

import cn.classyex.menu.domain.member.Member;
import cn.classyex.menu.domain.member.MemberRepository;
import lombok.AllArgsConstructor;
import org.hibernate.metamodel.model.domain.internal.SingularAttributeImpl;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Optional;

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

    @Override
    public Member getByOpenId(String openId) {
        MemberDO byOpenId = memberDAO.findByOpenIdAndStatus(openId, 1);
        return byOpenId.toEntity();
    }
}
