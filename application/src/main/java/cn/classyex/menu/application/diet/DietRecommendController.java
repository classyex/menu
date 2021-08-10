package cn.classyex.menu.application.diet;

import cn.classyex.menu.domain.diet.recommend.DietRecommendVO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/9 10:13 <br>
 */
@RestController
@RequestMapping("diet-recommends")
@AllArgsConstructor
public class DietRecommendController {

    private DietRecommendFacade dietRecommendFacade;

    @GetMapping
    public DietRecommendVO recommend(DietRecommendForm form) {
        return dietRecommendFacade.recommendDiet(form);
    }

}
