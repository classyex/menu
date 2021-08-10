package cn.classyex.menu.application.diet;

import cn.classyex.menu.domain.diet.recommend.DietRecommend;
import cn.classyex.menu.domain.diet.recommend.DietRecommendVO;
import cn.classyex.menu.domain.food.FoodService;
import cn.classyex.menu.domain.member.Member;
import cn.classyex.menu.domain.member.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/9 10:24 <br>
 */
@Service
@AllArgsConstructor
public class DietRecommendFacade {

    private final FoodService foodService;
    private final MemberService memberService;

    public DietRecommendVO recommendDiet(DietRecommendForm form) {
        Member member = memberService.getByOpenId(form.getOpenId());
        int suggestCalorie = member.suggestCalorieFor(queryLastWeekExerciseHour(member.getId()));
        DietRecommend dietRecommend = new DietRecommend(foodService, suggestCalorie, member.getDietGoal());
        return dietRecommend.toVO();
    }

    private Long queryLastWeekExerciseHour(Long memberId) {
        return 0L;
    }
}
