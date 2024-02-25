package 과제2_영화관;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Reservation {
    @Getter
    private boolean[][] seats;
    private Map<Integer, String> reservedSeatInformation = new HashMap<>();

    public Reservation(int row, int col) {
        this.seats = new boolean[row][col];
    }

    /*
     *  예약 가능 여부 확인 메서드
     * */
    public boolean isReservation(int row, int col) {
        return !seats[row][col];
    }

    /*
     *  좌석을 예약 하는 메서드
     * */
    public void reserve(int row, int col) {
        // 예매 완료 시, 좌석 번호와 예매번호 출력하기(랜덤수)
        int reservedCode = creatReservationCode();
        reservedSeatInformation.put(reservedCode, row + "-" + col);
        seats[row][col] = true; // 화면을 위한 예약 처리
        System.out.println("예매가 완료되었습니다.");
        System.out.println("예매한 좌석 번호:" + "[" + row + "-" + col + "] / 예매번호:[" + reservedCode + "]");
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
