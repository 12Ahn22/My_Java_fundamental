package 과제2_영화관;

import java.util.HashMap;
import java.util.Map;


/**
 * 예매 정보와 좌석 관련 클래스
 */
public class ReservationManager {
    private Map<Integer, String> reservedSeatInformation = new HashMap<>(); // 예약 번호를 key로 사용하는 예약 정보 map

    public boolean isEmpty() {
        return reservedSeatInformation.isEmpty();
    }

    public boolean isReserved(int key){
        return reservedSeatInformation.containsKey(key);
    }

    public String getReservedSeat(int key) {
        return reservedSeatInformation.get(key);
    }

    public void addReservation(int key, String seat){
        reservedSeatInformation.put(key,seat);
    }

    public void cancelReservation(int key){
        reservedSeatInformation.remove(key);
    }

    public int generateReservationCode() {
        int key = RandomNumberGenerator.generateRandom8Digit();
        while (reservedSeatInformation.containsKey(key)) {
            key = RandomNumberGenerator.generateRandom8Digit();
        }
        return key;
    }
}
