package 과제2_영화관;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 외부에서 입력받기 위한 변수
        Scanner sc = new Scanner(System.in);

        // 좌석 예약 여부 변수
        final int ROW = 4;
        final int COL = 5;
        Reservation reservation = new Reservation(ROW, COL);

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
                    reservation.printSeatStatus(); // 예매 현황 좌석 print
                    System.out.println("좌석을 선택해주세요. 예)1-1");
                    System.out.println("이미 예매된 좌석은 \"예매\"라고 표시됩니다.");

                    String input = sc.next();
                    
                    // 예매 가능 여부 체크 하기
                    String[] seatIndex = input.split("-"); // 입력값에서 idx를 가져오기
                    int rowIndex = Integer.parseInt(seatIndex[0]) - 1;
                    int colIndex = Integer.parseInt(seatIndex[1]) - 1;
                    // 예매 가능
                    if (reservation.isReservation(rowIndex, colIndex)) {
                        System.out.println("예매가 가능합니다. 예매하시겠습니까?");
                        System.out.println("네(1), 아니오(2), 초기화면(0)중 하나를 입력해주세요");
                        switch (sc.next()) {
                            case "1":
                                // 예매 완료 시, 좌석 번호와 예매번호 출력하기(랜덤수)
                                reservation.reserve(rowIndex, colIndex);
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
////              예매 조회하기
//                case "2":
//                    if (reservedSeatInformation.isEmpty()) {
//                        System.out.println("현재 예매된 좌석이 없습니다.");
//                        break;
//                    }
//
//                    System.out.println("예매번호를 입력해주세요.");
//                    input = sc.next();
//
//                    // 해당 예매번호를 키로 가지는 값이 있는 지 확인
//                    if (reservedSeatInformation.containsKey(Integer.parseInt(input))) {
//                        System.out.println("고객님이 예매하신 좌석은" + reservedSeatInformation.get(Integer.parseInt(input)) + "입니다.");
//                    } else {
//                        System.out.println("해당 번호로 예매된 좌석이 없습니다.");
//                    }
//                    break;
////              예매 취소하기
//                case "3":
//                    System.out.println("예매번호를 입력해주세요.");
//                    input = sc.next();
//
//                    // 해당 예매번호를 키로 가지는 값이 있는 지 확인
//                    int reservedCode = Integer.parseInt(input);
//                    if (reservedSeatInformation.containsKey(reservedCode)) {
//                        System.out.println("고객님이 예매하신 좌석은" + reservedSeatInformation.get(reservedCode) + "입니다.");
//                        System.out.println("예매를 취소하시겠습니까?");
//                        System.out.println("네(1), 아니오(2) 중 하나를 입력해주세요.");
//                        switch (sc.next()) {
//                            case "1":
//                                String[] deleteSeatIndex = reservedSeatInformation.get(reservedCode).split("-");
//                                reservedSeatInformation.remove(reservedCode);
//                                seats[Integer.parseInt(deleteSeatIndex[0]) - 1][Integer.parseInt(deleteSeatIndex[1]) - 1] = false;
//                                System.out.println("예매가 취소되었습니다. 감사합니다.");
//                                break;
//                            case "2":
//                                break;
//                        }
//                    } else {
//                        System.out.println("해당 번호로 예매된 좌석이 없습니다.");
//                    }
//                    break;
                case "4":
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("올바른 번호를 입력해주세요.");
            }
        }
    }
}

