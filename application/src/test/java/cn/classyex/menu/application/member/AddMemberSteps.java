package cn.classyex.menu.application.member;

import cn.classyex.menu.application.AutoClear;
import cn.classyex.menu.application.RestCall;
import cn.classyex.menu.application.food.FoodDO;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/6 16:38 <br>
 */
public class AddMemberSteps {

    @Autowired
    RestCall restCall;
    @Autowired
    AutoClear autoClear;
    @Autowired
    MemberFactory memberFactory;

    @Before
    public void setup() {
        autoClear.clear(this);
    }

    @When("提交个人信息")
    public void 提交个人信息(String memberInfo) throws IOException {
        restCall.post("members", memberInfo);
    }

    @Then("有用户提交的个人信息")
    public void 有用户提交的个人信息(List<Map<String, String>> members) {
        List<MemberDO> allFoods = memberFactory.all();
        assertThat(allFoods.size()).isEqualTo(members.size());
        List<Map<String, String>> actual = allFoods.stream().map(member -> {
            Map<String, String> value = new HashMap<>();
            value.put("openId", member.getOpenId());
            value.put("昵称", member.getNickname());
            value.put("头像", member.getAvatar());
            value.put("性别", member.getGender().toString());
            value.put("身高", member.getHeight().toString());
            value.put("体重", member.getWeight().toString());
            value.put("生日", member.getBirthday().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            value.put("饮食目标", member.getDietGoal().toString());
            return value;
        }).collect(Collectors.toList());
        assertThat(actual).isEqualTo(members);
    }

}
