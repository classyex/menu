package cn.classyex.menu;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/4 12:16 <br>
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources"}
        , glue = {"cn.classyex.menu"},
        plugin = {"html:target/cucumber-report.html"})
public class RunCucumberTest {
}
