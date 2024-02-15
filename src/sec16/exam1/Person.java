package sec16.exam1;

import sec16.exam1.Calcuable;
import sec16.exam1.Camparable;

public class Person {
    public void action(Calcuable calculable) {
        double result = calculable.calc(10, 4);
        System.out.println("결과: " + result);
    }

    public int ordering(Camparable comparable) {
        String a = "홍길동";
        String b = "김길동";

        return comparable.compare(a, b);
    }
}
