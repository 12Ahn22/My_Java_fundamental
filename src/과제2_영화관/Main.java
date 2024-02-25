package 과제2_영화관;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 외부에서 입력받기 위한 변수
        Scanner sc = new Scanner(System.in);

        // 좌석 예약 여부 변수
        final int ROW = 4;
        final int COL = 5;
        boolean[][] seats = new boolean[COL][ROW];

        while (true) {
            // UI 프린트
            System.out.println("**********************************");
            System.out.println("**********영화 예매 시스템**********");
            System.out.println("**********************************");
            System.out.println("1. 예매하기\n");
            System.out.println("2. 예매조회\n");
            System.out.println("3. 예매취소\n");
            System.out.println("4. 프로그램 종료\n");
            System.out.print("> ");

            switch (sc.next()) {
                case "1":
                    System.out.println("1");
                    printSeatStatus(seats);
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
    
    /*
    * 현재 좌석 상태들을 출력하는 메서드
    * */
    public static void printSeatStatus (boolean[][] seats){
        System.out.println("*********좌석 현황*********");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                if(!seats[i][j]){
                    System.out.print("[" + (i + 1) + "-" + (j + 1) + "]");
                }else{
                    System.out.print("[예매]");
                }
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }
}

