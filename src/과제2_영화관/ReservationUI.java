package 과제2_영화관;

import java.util.Scanner;

public class ReservationUI {
    private final Reservation reservation;
    private Scanner sc;

    // 외부에서 이렇게 받는게 의존성 주입인가보다?
    public ReservationUI(Reservation reservation) {
        this.reservation = reservation;
        this.sc = new Scanner(System.in);
    }

    /**
     * 영화 예매 프로그램을 실행하는 메서드
     */
    public void run() {
        while (true) {
            // 기본 UI 프린트
            printMainOptionMessage();

            switch (sc.next()) {
//                영화 예매하기
                case "1":
                    reserveSeat();
                    break;
//              예매 조회하기
                case "2":
                    viewReservation();
                    break;
//              예매 취소하기
                case "3":
                    cancelReservation();
                    break;
                case "4":
                    System.out.println("프로그램 종료");
                    sc.close(); // 스트림 종료
                    return;
                default:
                    System.out.println("올바른 번호를 입력해주세요.");
            }
        }
    }

    /**
     * 영화 예매하는 메서드
     */
    private void reserveSeat() {
        printSeatStatus(); // 예매 현황 좌석 print
        System.out.println("좌석을 선택해주세요. 예)1-1");
        System.out.println("이미 예매된 좌석은 \"예매\"라고 표시됩니다.");

        // 예매 가능 여부 체크 하기
        String[] seatIndex = sc.next().split("-"); // 입력값에서 idx를 가져오기
        int rowIndex = Integer.parseInt(seatIndex[0]) - 1;
        int colIndex = Integer.parseInt(seatIndex[1]) - 1;

        if (reservation.isSeatAvailable(rowIndex, colIndex)) {
            System.out.println("예매가 가능합니다. 예매하시겠습니까?");
            System.out.println("네(1), 아니오(2), 초기화면(0)중 하나를 입력해주세요");
            switch (sc.next()) {
                case "1":
                    // 예매 하기
                    int key = reservation.reservate(rowIndex , colIndex );
                    System.out.println("예매가 완료되었습니다.");
                    System.out.println("예매한 좌석 번호:" + reservation.getReservedSeat(key) + "/ 예매번호:[" + key + "]");
                    break;
                case "2":
                default:
                    break;
            }
        } else {
            System.out.println("예매가 불가능합니다.");
        }
        System.out.println("감사합니다.");
    }

    /**
     * 예매 번호로 좌석을 확인하는 메서드
     *
     * @param sc
     */
    private void viewReservation() {
        if (reservation.isEmpty()) {
            System.out.println("현재 예매된 좌석이 없습니다.");
            return;
        }

        System.out.println("예매번호를 입력해주세요.");

        int key = Integer.parseInt(sc.next());
        if (reservation.isReserved(key)) {
            printReservedSeat(key); // 예약된 좌석 정보 print
        } else {
            System.out.println("해당 번호로 예매된 좌석이 없습니다.");
        }
    }

    /**
     * 예매 취소하는 메서드
     */
    private void cancelReservation() {
        System.out.println("예매번호를 입력해주세요.");

        // 해당 예매번호를 키로 가지는 값이 있는 지 확인
        int key = Integer.parseInt(sc.next());
        if (reservation.isReserved(key)) {
            printReservedSeat(key);
            System.out.println("예매를 취소하시겠습니까?");
            System.out.println("네(1), 아니오(2) 중 하나를 입력해주세요.");

            switch (sc.next()) {
                case "1":
                    reservation.cancel(key);
                    break;
                case "2":
                default:
                    break;
            }
            System.out.println("예매가 취소되었습니다. 감사합니다.");
        } else {
            System.out.println("해당 번호로 예매된 좌석이 없습니다.");
        }
    }

    /**
     * 현재 좌석 상태들을 출력하는 메서드
     */
    public void printSeatStatus() {
        System.out.println("*********좌석 현황*********");
        for (int i = 0; i < reservation.getRow(); i++) {
            for (int j = 0; j < reservation.getCol(); j++) {
                if (reservation.isSeatAvailable(i, j)) {
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
     * 해당 예약 번호(키)로 예약된 좌석명 출력 메서드
     */
    public void printReservedSeat(int key) {
        System.out.println("고객님이 예매하신 좌석은 " + reservation.getReservedSeat(key) + "입니다.");
    }

    private static void printMainOptionMessage() {
        System.out.println("**********************************");
        System.out.println("**********영화 예매 시스템**********");
        System.out.println("**********************************");
        System.out.println("1. 예매하기\n");
        System.out.println("2. 예매조회\n");
        System.out.println("3. 예매취소\n");
        System.out.println("4. 프로그램 종료\n");
        System.out.print("> ");
    }
}
