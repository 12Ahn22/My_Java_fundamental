package 과제2_영화관;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 외부에서 입력받기 위한 변수
        Scanner sc = new Scanner(System.in);
        while(true){
            // UI 프린트
            System.out.println("**********************************");
            System.out.println("**********영화 예매 시스템**********");
            System.out.println("**********************************");
            System.out.println("1. 예매하기\n");
            System.out.println("2. 예매조회\n");
            System.out.println("3. 예매취소\n");
            System.out.println("4. 프로그램 종료\n");
            System.out.print("> ");
            
            switch (sc.next()){
                case "1":
                    System.out.println("1");
                    break;
                case "2":
                    System.out.println("2");
                    break;
                case "3":
                    System.out.println("3");
                    break;
                case "4":
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("올바른 번호를 입력해주세요.");
            }
        }
    }
}
