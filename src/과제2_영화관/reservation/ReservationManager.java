package 과제2_영화관.reservation;

public class ReservationManager extends Reservation{
    public ReservationManager(int row, int col) {
        super(row, col);
    }

    // 예매 하기
    public int reservate(int row, int col) {
        int key = generateReservationCode();
        addReservation(key, (row + 1) + "-" + (col + 1), row, col); // 예매 번호 등록
        return key;
    }

    // 예악 취소하기
    public void cancel(int key) {
        String[] seatIndex = getReservedSeat(key).split("-"); // 입력값에서 idx를 가져오기
        int row = Integer.parseInt(seatIndex[0]) - 1;
        int col = Integer.parseInt(seatIndex[1]) - 1;
        cancelReservation(key, row, col);
    }

}
