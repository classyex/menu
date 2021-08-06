package cn.classyex.menu.application.steps;

import cn.classyex.menu.application.AutoClear;
import cn.classyex.menu.application.RestCall;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

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
//    @Autowired
//    SectionFactory sectionFactory;

    @Given("食品库如下：")
    public void 食品库如下(List<Map<String, String>> foods) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }

    @Given("我的个人信息如下：")
    public void 我的个人信息如下(String memberInfoStr) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("我每天消耗热量为 {int} 千卡，查看系统给我推荐一天的饮食")
    public void 我每天消耗热量为_千卡_查看系统给我推荐一天的饮食(Integer calorie) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("我看到")
    public void 我看到(String result) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
