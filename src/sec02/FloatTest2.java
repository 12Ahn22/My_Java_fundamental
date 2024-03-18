package sec02;

public class FloatTest2 {
    public static void main(String[] args) {
        int apple = 1;
        int totalPieces = apple * 10; // 0.1을 한 조각으로 하는 것이 아니라 1을 한 조각으로 계산
        int number = 7;

        int result = totalPieces - number;
        // 실수로 나눠서 실수형으로 결과를 출력
        System.out.println("사과 1개에서 남은 양은? " + result / 10.0);
    }
}
