package cn.classyex.menu.application.member;

import org.springframework.data.repository.CrudRepository;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/6 17:12 <br>
 */
public interface MemberDAO extends CrudRepository<MemberDO, Long> {
}
