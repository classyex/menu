package cn.classyex.menu.application.diet.record;

import cn.classyex.menu.application.AutoClear;
import cn.classyex.menu.application.RestCall;
import cn.classyex.menu.domain.SystemDate;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/31 16:00 <br>
 */
public class SaveDietRecordSteps {

    @Autowired
    RestCall restCall;
    @Autowired
    AutoClear autoClear;
    @Autowired
    DietRecordFactory dietRecordFactory;
    String dietRecord;

    @Before
    public void setup() {
        autoClear.clear(this);
    }

    @Given("我的饮食记录如下:")
    public void 我的饮食记录如下(String dietRecord) {
        this.dietRecord = dietRecord;
    }

    @When("保存为 {string} 日的饮食记录")
    public void 保存为_日的饮食记录(String date) throws IOException {
        SystemDate.setNowSupplier(date + " 11:22:54");
        restCall.post("diet-records", dietRecord);
    }

    @Then("有饮食记录：")
    public void 有饮食记录(List<Map<String, String>> expected) {
        List<DietRecordDO> allRecords = dietRecordFactory.all();
        assertThat(allRecords.size()).isEqualTo(expected.size());
        List<Map<String, String>> actual = allRecords.stream().map(record -> {
            Map<String, String> value = new HashMap<>();
            value.put("会员id", record.getMemberId().toString());
            value.put("饮食日期", record.getDietDate());
            value.put("饮食月份", record.getDietMonth());
            value.put("推荐摄入热量", record.getSuggestCalorie().toString());
            value.put("当前卡路里", record.getCurrentCalorie().toString());
            value.put("饮食目标", record.getDietGoal().toString());
            value.put("已选碳水化合物", record.getCarbohydrate().toString());
            value.put("已选蛋白质", record.getProtein().toString());
            value.put("已选脂肪", record.getAxunge().toString());
            value.put("饮食详情", record.getDietDetails());
            value.put("是否最佳", record.getIsOptimal().toString());
            return value;
        }).collect(Collectors.toList());
        assertThat(actual).isEqualTo(expected);
    }

}
