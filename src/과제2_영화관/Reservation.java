package 과제2_영화관;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
*  해당 클래스에서는 예매에 대한 정보와 로직을 저장하고 다루고 싶었다.
*   UI 관련 부분은 ReservationUI에서 실행하도록 하고 싶었다.
* */
public class Reservation implements ReservationService {
    // 좌석 크기
    @Getter
    private int row;
    @Getter
    private int col;
    private boolean[][] seats; // 좌석에 따른 예약 여부 배열

    private Map<Integer, String> reservedSeatInformation = new HashMap<>(); // 예약 번호를 key로 사용하는 예약 정보 map

    public Reservation(int row, int col){
        this.row = row;
        this.col = col;
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
     * 해당 예매번호(키)로 예매된 값을 반환하는 메서드
     */
    public String getReservedSeat(int key){
        return reservedSeatInformation.get(key);
    }

    /**
     * 좌석 예약 메서드
     */
    public Integer reserve(int row, int col, String option){
        switch (option) {
            case "1":
                // 예매 완료 시, 좌석 번호와 예매번호 출력하기(랜덤수)
                int reservedCode = creatReservationCode();
                reservedSeatInformation.put(reservedCode, (row + 1) + "-" + (col + 1));
                seats[row][col] = true; // 화면을 위한 예약 처리
                return reservedCode;
            case "2":
            case "0":
            default:
                return null;
        }
    }

    /**
     * 예약을 취소하는 메서드
     */
    public void cancle(int key, String option) {
        switch (option) {
            case "1":
                String[] deleteSeatIndex = reservedSeatInformation.get(key).split("-"); // 값에서 idx 가져오기
                reservedSeatInformation.remove(key);
                seats[Integer.parseInt(deleteSeatIndex[0]) - 1][Integer.parseInt(deleteSeatIndex[1]) - 1] = false;
                break;
            case "2":
                break;
        }
    }

    /**
     * 예매 번호 중복성 체크해 중복이 아닌 키를 반환하는 메서드
     */
    public int creatReservationCode() {
        int key = generateRandom8Digit();
        // 만약 생성한 난수가 이미 reservedSeatInformation에 key로 존재한다면,
        // 다시 생성한다.
        while (reservedSeatInformation.containsKey(key)) {
            key = generateRandom8Digit();
        }
        return key;
    }

    /**
     * 예매 번호 생성 메서드
     */
    public int generateRandom8Digit() {
        Random random = new Random();
        // 항상 8자리의 랜덤 난수를 생성하기 위한 제한값
        final int MIN = 10000000;
        final int MAX = 99999999;
        return random.nextInt(MAX - MIN + 1) + MIN;
    }

}
