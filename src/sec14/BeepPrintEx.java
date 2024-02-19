package sec14;

import java.awt.*;

public class BeepPrintEx {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("띵");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        });
        
        // 작업 스레드 시작 - 띵을 출력
        thread.start();
        
        // 메인 스레드가 작업하는 부분
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
        // 띵과 Beep소리가 동시에 들린다.
    }
}
