package 과제1;

public class Lotto {
    public static void main(String[] args) {
//        1~45까지 가득 찬 배열을 만든다
        int[] balls = new int[45];
        for (int i = 0; i < balls.length; i++) {
            balls[i] = i + 1;
        }

//        랜덤으로 숫자를 6개 뽑는다.
//        뽑은 숫자들은 순서대로 balls[0~6]에 저장한다.
        for (int i = 0; i < 6; i++) {
            // 인덱스 하나 뽑기
            int idx = (int) (Math.random() * (balls.length - i)) + i; // i ~ 45까지 뽑기
//          뽑은 숫자와 원래 거기 있던 숫자 자리 바꾸기
            int temp = balls[i];
            balls[i] = balls[idx];
            balls[idx] = temp;
        }

        for (int i = 0; i < 6; i++) {
            System.out.print("[" + balls[i] + "]");
        }
    }
}
