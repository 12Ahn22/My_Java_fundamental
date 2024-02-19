package sec14.exam01;

// 직접 작업 클래스를 구현하는 방식
class WorkThread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("네트워크 작업");
        }
    }
}

class WorkThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("드로잉 작업");
        }
    }
}

public class Exam {
    public static void main(String[] args) {
        // 작업 스레드를 생성하기 ( 클래스 객체를 사용 )
        Thread thread1 = new Thread(new WorkThread1());
        Thread thread2 = new Thread(new WorkThread2());

        // 스레드 실행
        thread1.start();
        thread2.start();

        // 메인 스레드 작업
        for (int i = 0; i < 1000; i++) {
            System.out.println("메인 스레드 실행 중");
        }
        // 아래 처럼 코드를 쓰면, 동기적으로 작동하기 때문에 위 for문이 끝나야 아래 작업이 시작된다.
        // 그러나 이걸 스레드가 작업하도록 한다면, 동시에 작업이 가능하다.
//        for (int i = 0; i < 10000; i++) {
//            System.out.println("네트워크 작업");
//        }
//        for (int i = 0; i < 10000; i++) {
//            System.out.println("드로잉 작업");
//        }
    }
}
