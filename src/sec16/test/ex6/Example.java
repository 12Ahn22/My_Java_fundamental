package sec16.test.ex6;

@FunctionalInterface
interface Function {
    double apply(double x, double y);
}

public class Example {
    // 외부 실행 시스템
    public static double calc(Function func) {
        double x = 10;
        double y = 4;
        return func.apply(x, y); // 콜백
    }

    public static void main(String[] args) {
        System.out.println(calc((a, b) -> a + b));
        System.out.println(calc((a, b) -> a - b));
        System.out.println(calc((a, b) -> a / b));
        System.out.println(calc((a, b) -> a * b));
    }
}
