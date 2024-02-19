package sec14.exam02;

public class ThreadNameEx {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName() + " 실행"); // main 실행

        for (int i = 0; i < 3; i++) {
            // 람다식
            Thread thread = new Thread(() -> {
                // Runnable을 구현한 것이라서 getName을 바로 사용할 수 없다.
                // getName은 thread의 메서드
                // 따라서 thread 객체 정보를 가져와야함
                System.out.println(Thread.currentThread().getName() + " 실행");
            });
            thread.start();
            // 스레드 실행 순서는 그때마다 달라질 수 있다.
            // 생성 순서대로 실행되는 것이 아니다.
//            Thread-0 실행
//            Thread-1 실행
//            Thread-2 실행
        }

        // 아예 Thread 클래스를 익명 객체로 사용할 수도 있다.
        Thread chatThread = new Thread(){
            @Override
            public void run(){
                System.out.println(getName() + " 실행");
            }
        };

        chatThread.setName("chat-thread"); // 스레드 실행 전에 이름 변경
        chatThread.start(); // 스레드 작동
    }
}
