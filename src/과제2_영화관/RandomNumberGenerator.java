package 과제2_영화관;

import java.util.Random;

public class RandomNumberGenerator {
    /**
     * 8자리 랜덤 난수를 발생시키는 메서드
     */
    public static int generateRandom8Digit() {
        Random random = new Random();
        // 항상 8자리의 랜덤 난수를 생성하기 위한 제한값
        final int MIN = 10000000;
        final int MAX = 99999999;
        return random.nextInt(MAX - MIN + 1) + MIN;
    }
}
