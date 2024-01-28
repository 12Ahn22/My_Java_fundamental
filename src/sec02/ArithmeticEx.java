package sec02;

public class ArithmeticEx {
    public static void main(String[] args) {
        int x = 5;
        int r;
//  정수형을 0으로 /거나 %하는 경우에는 Arithmetic Exception이 발생한다.
//        r = x / 0;
//        System.out.println("r? " + r);

//  그러나 실수로 나누는 경우 예외가 발생하지않고 연산 결과가 Infinity 혹은 NaN이 된다.
        double y = 0.0;
        double z = x / y; // Infinity
        double q = x % y; // NaN

        System.out.println("x / 0.0 ?" + z);
        System.out.println("x % 0.0 ?" + q);

//  Infinity인지 NaN인지 검사하기
        if(Double.isInfinite(z) || Double.isNaN(z) ){
            System.out.println("값을 산출 할 수 없어요!");
        }else{
            System.out.println("z + 2 = " + (z + 2));
        }
    }
}
