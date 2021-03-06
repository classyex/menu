package cn.classyex.menu.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static cn.classyex.menu.domain.SystemDate.DATE_TIME_FORMATTER;

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
        Assertions.assertThat(SystemDate.now(DATE_TIME_FORMATTER)).isEqualTo(date);
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

    @Test
    public void preset_2021_08_11_18_00_00_then_date_should_be_1628676000000L() {
        String date = "2021-08-11 18:00:00";
        SystemDate.setNowSupplier(date);
        Assertions.assertThat(SystemDate.date().getTime()).isEqualTo(1628676000000L);
    }

    @Test
    public void preset_2021_08_11_18_11_59_then_localDateTime_should_be_2021_08_11_18_11_59() {
        String date = "2021-08-11 18:11:59";
        SystemDate.setNowSupplier(date);
        Assertions.assertThat(SystemDate.localDateTime()).isEqualTo(LocalDateTime.of(2021, 8, 11, 18, 11, 59));
    }

    @Test
    public void preset_2021_08_11_18_11_59_then_localDate_should_be_2021_08_11() {
        String date = "2021-08-11 18:11:59";
        SystemDate.setNowSupplier(date);
        Assertions.assertThat(SystemDate.localDate()).isEqualTo(LocalDate.of(2021, 8, 11));
    }


}
