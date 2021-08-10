package cn.classyex.menu.application.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/6 17:12 <br>
 */
public interface MemberDAO extends JpaRepository<MemberDO, Long>, JpaSpecificationExecutor<MemberDO>, CrudRepository<MemberDO, Long> {

    MemberDO findByOpenIdAndStatus(String openId, int status);

}
