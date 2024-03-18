package 과제2_영화관.reservation;

import lombok.Getter;
import 과제2_영화관.RandomNumberGenerator;
import java.util.HashMap;
import java.util.Map;


/**
 * 예매 정보와 좌석 관련 클래스
 */
class Reservation {
    // 좌석 크기
    @Getter
    private final int row;
    @Getter
    private final int col;
    private final boolean[][] seats; // 좌석에 따른 예약 여부 배열
    private final Map<Integer, String> reservedSeatInformation = new HashMap<>(); // 예약 번호를 key로 사용하는 예약 정보 map
    
    public Reservation(int row, int col){
        this.row = row;
        this.col = col;
        this.seats = new boolean[row][col];
    }

    // 예매 기록이 존재하지 않음
    public boolean isEmpty() {
        return reservedSeatInformation.isEmpty();
    }

    // 키가 이미 예약된 상태인지 확인
    public boolean isReserved(int key){
        return reservedSeatInformation.containsKey(key);
    }

    // 해당 예매 번호를 가진 좌석 정보 반환
    public String getReservedSeat(int key) {
        return reservedSeatInformation.get(key);
    }

    // 예매
    public void addReservation(int key, String seat, int row, int col){
        seats[row][col] = true;
        reservedSeatInformation.put(key,seat);
    }

    public void cancelReservation(int key, int row, int col){
        seats[row][col] = false;
        reservedSeatInformation.remove(key);
    }

    public boolean isSeatAvailable(int row, int col) {
        return !seats[row][col];
    }

    public int generateReservationCode() {
        int key = RandomNumberGenerator.generateRandom8Digit();
        while (reservedSeatInformation.containsKey(key)) {
            key = RandomNumberGenerator.generateRandom8Digit();
        }
        return key;
    }
}
