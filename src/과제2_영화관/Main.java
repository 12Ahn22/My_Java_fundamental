package 과제2_영화관;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 외부에서 입력받기 위한 변수
        Scanner sc = new Scanner(System.in);

        // 좌석 예약 여부 변수
        final int ROW = 4;
        final int COL = 5;
        boolean[][] seats = new boolean[ROW][COL];

        // 예매 번호 - 예매좌석 정보 변수
        Map<Integer, String> reservedSeatInformation = new HashMap<>();

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
//                영화 예매하기
                case "1":
                    System.out.println("1");
                    printSeatStatus(seats);
                    System.out.println("좌석을 선택해주세요. 예)1-1");
                    System.out.println("이미 예매된 좌석은 \"예매\"라고 표시됩니다.");

                    String input = sc.next();
                    // 예매 가능 여부 체크 하기
                    System.out.println(input);
                    String[] seatIndex = input.split("-");
                    boolean isSeat = seats[Integer.parseInt(seatIndex[0]) - 1][Integer.parseInt(seatIndex[1]) - 1];
                    // 예매 가능
                    if (!isSeat) {
                        System.out.println("예매가 가능합니다. 예매하시겠습니까?");
                        System.out.println("네(1), 아니오(2), 초기화면(0)중 하나를 입력해주세요");
                        switch (sc.next()) {
                            case "1":
                                // 예매 완료 시, 좌석 번호와 예매번호 출력하기(랜덤수)
                                int reservedCode = creatReservationCode();
                                reservedSeatInformation.put(reservedCode, "[" + seatIndex[0] + "-" + seatIndex[1] + "]"); // 랜덤 난수를 키값으로 예약된 seat 정보를 출력
                                seats[Integer.parseInt(seatIndex[0]) - 1][Integer.parseInt(seatIndex[1]) - 1] = true; // 화면을 위한 예약 처리
                                System.out.println("예매가 완료되었습니다.");
                                System.out.println("예매한 좌석 번호:" + "[" + seatIndex[0] + "-" + seatIndex[1] + "] / 예매번호:[" + reservedCode + "]");
                                break;
                            case "2":
                            case "0":
                                break;
                        }
                    } else {
                        System.out.println("예매가 불가능합니다.");
                    }
                    System.out.println("감사합니다.");
                    break;
//              예매 조회하기
                case "2":
                    System.out.println("예매번호를 입력해주세요.");
                    break;
//              예매 취소하기
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

    /**
     * 현재 좌석 상태들을 출력하는 메서드
     */
    public static void printSeatStatus(boolean[][] seats) {
        System.out.println("*********좌석 현황*********");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                if (!seats[i][j]) {
                    System.out.print("[" + (i + 1) + "-" + (j + 1) + "]"); // 최적화하기
                } else {
                    System.out.print("[예매]");
                }
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }

    /**
     * 예매 번호 생성 메서드
     */
    public static int creatReservationCode() {
        Random random = new Random();
        // 항상 8자리의 랜덤 난수를 생성하기 위한 제한값
        final int MIN = 10000000;
        final int MAX = 99999999;
        return random.nextInt(MAX - MIN + 1) + MIN;
    }

    ;
}

