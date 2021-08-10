package cn.classyex.menu.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/10 17:57 <br>
 */
public class SystemDateTest {

    @Test
    public void preset_2021_08_10_18_00_00_then_now_format_should_be_2021_08_10_18_00_00() {
        String date = "2021-08-10 18:00:00";
        SystemDate.setNowSupplier(date);
        Assertions.assertThat(SystemDate.now(SystemDate.DATE_TIME_FORMATTER)).isEqualTo(date);
    }

    @Test
    public void preset_1628589794489L_then_now_should_be_1628589794489L() {
        long time = 1628589794489L;
        SystemDate.setNowSupplier(() -> time);
        long now = SystemDate.now();
        Assertions.assertThat(now).isEqualTo(time);
    }

    @Test
    public void format_1628589794489L_should_be_2021_08_10() {
        Assertions.assertThat(SystemDate.format(1628589794489L)).isEqualTo("2021-08-10");
    }

    @Test
    public void preset_2021_08_11_18_00_00_then_today_should_be_2021_08_11() {
        String date = "2021-08-11 18:00:00";
        SystemDate.setNowSupplier(date);
        Assertions.assertThat(SystemDate.today()).isEqualTo("2021-08-11");
    }


}
