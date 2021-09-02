package cn.classyex.menu.application.diet.record;

import cn.classyex.menu.domain.diet.record.DietRecordService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/31 16:59 <br>
 */
@RestController
@RequestMapping("/diet-records")
@AllArgsConstructor
public class DietRecordController {

    private final DietRecordService dietRecordService;

    @PostMapping
    public void save(@RequestBody DietRecordAddForm form) {
        dietRecordService.save(form.toEntity());
    }

}
