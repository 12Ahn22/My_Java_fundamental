package 과제2_영화관;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Reservation {
    private boolean[][] seats; // 화면 UI를 위한 예약 여부 배열

    private Map<Integer, String> reservedSeatInformation = new HashMap<>(); // 예약 번호를 key로 사용하는 예약 정보 map

    public Reservation(int row, int col) {
        this.seats = new boolean[row][col];
    }

    /**
     * 해당 좌석이 예약 가능한 여부 확인 메서드
     */
    public boolean isReservation(int row, int col) {
        return !seats[row][col];
    }

    /**
     * 예매 목록이 비어있는 지 확인하는 메서드
     */
    public boolean isEmpty() {
        return reservedSeatInformation.isEmpty();
    }

    /**
     * 해당 예매번호(키)가 예매 번호 목록에 있는지 확인하는 메서드
     */
    public boolean containsKey(int key) {
        return reservedSeatInformation.containsKey(key);
    }

    /**
     * 해당 예약 번호(키)로 예약된 좌석명 출력 메서드
     */
    public void printReservedSeat(int key) {
        System.out.println("고객님이 예매하신 좌석은" + reservedSeatInformation.get(key) + "입니다.");
    }

    /**
     * 좌석 예약 메서드 
     */
    public void reserve(int row, int col) {
        // 예매 완료 시, 좌석 번호와 예매번호 출력하기(랜덤수)
        int reservedCode = creatReservationCode();
        reservedSeatInformation.put(reservedCode, (row + 1) + "-" + (col + 1));
        seats[row][col] = true; // 화면을 위한 예약 처리
        System.out.println("예매가 완료되었습니다.");
        System.out.println("예매한 좌석 번호:" + "[" + (row + 1) + "-" + (col + 1) + "] / 예매번호:[" + reservedCode + "]");
    }

    /**
     * 예약을 취소하는 메서드
     */
    public void cancle(int key, String option){
        switch (option) {
            case "1":
                String[] deleteSeatIndex = reservedSeatInformation.get(key).split("-"); // 값에서 idx 가져오기
                reservedSeatInformation.remove(key);
                seats[Integer.parseInt(deleteSeatIndex[0]) - 1][Integer.parseInt(deleteSeatIndex[1]) - 1] = false;
                System.out.println("예매가 취소되었습니다. 감사합니다.");
                break;
            case "2":
                break;
        }
    }

    /**
     * 현재 좌석 상태들을 출력하는 메서드
     */
    public void printSeatStatus() {
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

}
