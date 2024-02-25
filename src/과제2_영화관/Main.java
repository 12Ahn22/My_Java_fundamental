package 과제2_영화관;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Reservation reservation = new Reservation(new ReservationManager(), new ReservationSeat(4,5));

        // 예약 프로그램 실행
        ReservationUI reservationUI = new ReservationUI(reservation);
        reservationUI.run();
    }
}

