package sec14.exam01;

public class Exam2 {
    public static void main(String[] args) {
        // 작업 스레드를 생성하기 - 익명객체와 람다식 사용하기
        // Runnable이 함수형 인터페이스이기 때문에 람다식이 사용 가능하다.
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("네트워크 작업");
            }
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("드로잉 작업");
        });

        // 스레드 실행
        thread1.start();
        thread2.start();

        // 메인 스레드 작업
        for (int i = 0; i < 1000; i++) {
            System.out.println("메인 스레드 실행 중");
        }
    }
}
