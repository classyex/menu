package cn.classyex.menu.domain.diet.record;

/**
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/31 17:50 <br>
 */
public class DietRecordService {

    private final DietRecordRepository dietRecordRepository;

    public DietRecordService(DietRecordRepository dietRecordRepository) {
        this.dietRecordRepository = dietRecordRepository;
    }

    public void save(DietRecord entity) {
        dietRecordRepository.save(entity);
    }



}
