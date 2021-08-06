package cn.classyex.menu.application.member;

import cn.classyex.menu.application.BaseFactory;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/6 16:56 <br>
 */
@Service
public class MemberFactory extends BaseFactory {

    private final MemberDAO memberDAO;

    public MemberFactory(MemberDAO memberDAO, JdbcTemplate jdbcTemplate) {
        this.memberDAO = memberDAO;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    protected String getTableName() {
        return "t_member";
    }

    public List<MemberDO> all() {
        return StreamSupport.stream(memberDAO.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
