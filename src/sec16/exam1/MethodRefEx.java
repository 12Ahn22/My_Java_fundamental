package sec16.exam1;

public class MethodRefEx {
    public static void main(String[] args) {
        Person person = new Person();

        // 정적 메서드 메서드 참조하기
        // 람다식을 쓰는 경우
        person.action((x, y) -> Cumputer.staticMethod(x, y));
        // 메서드 참조를 사용하는 경우
        person.action(Cumputer::staticMethod);

        // 인스턴스 메서드 참조하기
        Cumputer c = new Cumputer();
        // 람다식을 쓰는 경우
        person.action((x, y) -> c.instanceMethod(x, y));
        // 메서드 참조를 사용하는 경우
        person.action(c::instanceMethod);

        person.ordering((a, b) -> a.compareTo(b)); // compareTo는 String 클래스에 있는 메서드
        // 그래서 String 클래스를 사용한 메서드 참조
        person.ordering(String::compareTo); 
        person.ordering(String::compareToIgnoreCase);
    }
}
