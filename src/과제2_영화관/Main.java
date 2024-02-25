package 과제2_영화관;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 외부에서 입력받기 위한 변수
        Scanner sc = new Scanner(System.in);

        Reservation reservation = new Reservation(); // 좌석 예약 정보를 가진 객체 reservation

        // 예약 프로그램 실행
        ReservationUI reservationUI = new ReservationUI(reservation);
        reservationUI.run();
    }
}

