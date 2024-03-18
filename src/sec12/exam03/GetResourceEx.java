package sec12.exam03;

public class GetResourceEx {
    public static void main(String[] args) {
        Class clazz = Car.class; // Class 객체 리플렉션

        // 경로는 절대 경로를 반환한다.
        // /D:/workplace/ex01/out/production/ex01/sec12/exam03/photo.jpg
        String photoPath = clazz.getResource("photo.jpg").getPath();

        System.out.println(photoPath);
    }
}
