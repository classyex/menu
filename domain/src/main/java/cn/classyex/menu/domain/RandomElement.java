package cn.classyex.menu.domain;

import cn.hutool.core.util.RandomUtil;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

public class RandomElement {

    private static Supplier<Integer> resultSupplier;

    private RandomElement() {
    }

    public static void setResultSupplier(Supplier<Integer> resultSupplier) {
        RandomElement.resultSupplier = resultSupplier;
    }

    public static <T> T randomEle(List<T> list) {
        int random = RandomUtil.randomInt(0, list.size());
        if (resultSupplier != null) {
            random = resultSupplier.get();
        }
        return list.get(random);
    }

}
