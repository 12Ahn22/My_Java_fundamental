package sec12.exam01;

public class GetClassEx {
    public static void main(String[] args) throws Exception {
//        how1
//        Class clazz = Car.class;
//        how2
        Class clazz = Class.forName("sec12.exam01.Car");
//        how3
//        Car car = new Car("현대");
//        Class clazz = car.getClass();

        System.out.println("getPackage().getName(): " + clazz.getPackage().getName());
        System.out.println("getPackageName: " + clazz.getPackageName());
        System.out.println("getSimpleName: " + clazz.getSimpleName());
        System.out.println("getName: " + clazz.getName());
    }
}
