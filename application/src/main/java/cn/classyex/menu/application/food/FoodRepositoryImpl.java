package cn.classyex.menu.application.food;

import cn.classyex.menu.domain.RandomString;
import cn.classyex.menu.domain.food.Food;
import cn.classyex.menu.domain.food.FoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/6 14:36 <br>
 */
@Service
@AllArgsConstructor
public class FoodRepositoryImpl implements FoodRepository {

    private final FoodDAO foodDAO;

    @Override
    public void save(Food food) {
        FoodDO foodDO = FoodDO.from(food);
        foodDO.setStatus(1);
        foodDO.setIsDeleted(false);
        foodDO.setCode(RandomString.randomUniqueString(3));
        foodDAO.save(foodDO);
    }

    @Override
    public List<Food> findBreakfastFood() {
        List<FoodDO> all = foodDAO.findAll((Specification<FoodDO>) (root, query, criteriaBuilder) -> {
            Predicate isDeleted = criteriaBuilder.equal(root.get("isDeleted").as(Boolean.class), false);
            Predicate status = criteriaBuilder.equal(root.get("status").as(Integer.class), 1);
            Predicate isBreakfast = criteriaBuilder.equal(root.get("isBreakfast").as(Boolean.class), true);
            return query.where(isDeleted, status, isBreakfast).getRestriction();
        });
        return all.stream().map(FoodDO::toEntity).collect(Collectors.toList());
    }

    @Override
    public List<Food> findLunchFood() {
        List<FoodDO> all = foodDAO.findAll((Specification<FoodDO>) (root, query, criteriaBuilder) -> {
            Predicate isDeleted = criteriaBuilder.equal(root.get("isDeleted").as(Boolean.class), false);
            Predicate status = criteriaBuilder.equal(root.get("status").as(Integer.class), 1);
            Predicate isBreakfast = criteriaBuilder.equal(root.get("isLunch").as(Boolean.class), true);
            return query.where(isDeleted, status, isBreakfast).getRestriction();
        });
        return all.stream().map(FoodDO::toEntity).collect(Collectors.toList());
    }

    @Override
    public List<Food> findDinnerFood() {
        List<FoodDO> all = foodDAO.findAll((Specification<FoodDO>) (root, query, criteriaBuilder) -> {
            Predicate isDeleted = criteriaBuilder.equal(root.get("isDeleted").as(Boolean.class), false);
            Predicate status = criteriaBuilder.equal(root.get("status").as(Integer.class), 1);
            Predicate isBreakfast = criteriaBuilder.equal(root.get("isDinner").as(Boolean.class), true);
            return query.where(isDeleted, status, isBreakfast).getRestriction();
        });
        return all.stream().map(FoodDO::toEntity).collect(Collectors.toList());
    }

}
