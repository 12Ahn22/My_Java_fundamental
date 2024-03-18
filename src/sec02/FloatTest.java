package sec02;

public class FloatTest {
    public static void main(String[] args){
        System.out.println("실수 연산 테스트");
        int apple = 1;
        double pieceUnit = 0.1; // 사과 한 조각 크기 (사과는 총 10조각)
        int pieceCnt = 7; // 7조각

        double result = apple - pieceCnt * pieceUnit;
        System.out.println("사과 1개에서 남은 양:" + result); // 0.29999999999999993
    }
}
