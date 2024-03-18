package 과제2_영화관;

import 과제2_영화관.reservation.ReservationManager;
import 과제2_영화관.reservation.ReservationUI;

public class Main {
    public static void main(String[] args) {
        ReservationManager reservationManager = new ReservationManager(4,5);

        // 예약 프로그램 실행
        ReservationUI reservationUI = new ReservationUI(reservationManager);
        reservationUI.run();
    }
}

