package cn.classyex.menu.application.diet;

import cn.classyex.menu.application.AutoClear;
import cn.classyex.menu.application.RestCall;
import cn.classyex.menu.application.member.NewMemberForm;
import cn.classyex.menu.domain.diet.recommend.DietRecommend;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/4 17:21 <br>
 */
public class DietRecommendSteps {

    @Autowired
    RestCall restCall;
    @Autowired
    AutoClear autoClear;
    NewMemberForm newMemberForm;
    DietRecommend dietRecommend;

    @Before
    public void setup() {
        autoClear.clear(this);
    }

    @Given("食品库如下：")
    public void 食品库如下(List<Map<String, String>> foods) {
        foods.forEach(food -> {
            try {
                restCall.post("foods", new ObjectMapper().writeValueAsString(food));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Given("我的个人信息如下：")
    public void 我的个人信息如下(String memberInfoStr) throws IOException {
        newMemberForm = JSONUtil.toBean(memberInfoStr, NewMemberForm.class);
        restCall.post("members", memberInfoStr);
    }

    @When("我每天消耗热量为 {int} 千卡，查看系统给我推荐一天的饮食")
    public void 我每天消耗热量为_千卡_查看系统给我推荐一天的饮食(Integer calorie) throws IOException {
        String response = restCall.get(String.format("diet-recommends?openId=%s&calorie=%s", newMemberForm.getOpenId(), calorie));
        Assertions.assertThat(response).isNotBlank();
        dietRecommend = JSONUtil.toBean(response, DietRecommend.class);
    }

    @Then("我看到")
    public void 我看到(String result) {
        Assertions.assertThat(JSONUtil.toJsonPrettyStr(dietRecommend)).isEqualTo(JSONUtil.toJsonPrettyStr(JSONUtil.parseObj(result)));
    }



}
