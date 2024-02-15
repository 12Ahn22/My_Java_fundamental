package sec16;

@FunctionalInterface // 람다식을 위한 Calculable 인터페이스
public interface Calculable {
    //추상 메소드
    int calculate(int x, int y);
}