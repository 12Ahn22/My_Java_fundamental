package sec16;

public class LambdaEx3 {
    public static void main(String[] args) {
//        람다식 사용하기
//        int res1 = action(((x, y) -> x + y));
        int res1 = action((Integer::sum)); // 축약형
        System.out.println("AddCalculable 객체를 넘겨줌: " + res1);

        int res2 = action(((x, y) -> x - y));
        System.out.println("SubCalculable 객체를 넘겨줌: " + res2);
    }

    // 아래 코드는 내가 소유하지않고, 외부 시스템 부분이라고 가정한다.
    // 아래 코드는 수정 불가능, 즉 실행할 로직(calculate 메서드 부분)을
    // 매개 변수로 전달하는 것이다.
    public static int action(Calculable calculable) {
        int x = 10;
        int y = 4;
        // action에 Calculable 객체를 등록해주고, 내부에서는 실행만 해준다.
        return calculable.calculate(x, y);
    }
}

