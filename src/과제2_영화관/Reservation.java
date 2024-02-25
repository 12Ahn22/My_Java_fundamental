package 과제2_영화관;

public class Reservation {
    ReservationManager rm;
    ReservationSeat rs;

    public Reservation(ReservationManager rm, ReservationSeat rs) {
        this.rm = rm;
        this.rs = rs;
    }

    // 예매 하기
    public int reservate(int row, int col) {
        rs.reserveSeat(row, col); // 좌석 예매
        int key = rm.generateReservationCode();
        rm.addReservation(key, (row + 1) + "-" + (col + 1)); // 예매 번호 등록
        return key;
    }

    // 예악 취소하기
    public void cancel(int key) {
        String[] seatIndex = rm.getReservedSeat(key).split("-"); // 입력값에서 idx를 가져오기
        rm.cancelReservation(key);
        int rowIndex = Integer.parseInt(seatIndex[0]) - 1;
        int colIndex = Integer.parseInt(seatIndex[1]) - 1;
        rs.cancelReservation(rowIndex, colIndex);
    }

    // 예약 정보 반환
    public String getReservedSeat(int key) {
        return rm.getReservedSeat(key);
    }

    public boolean isReserved(int key) {
        return rm.isReserved(key);
    }

    public boolean isEmpty() {
        return rm.isEmpty();
    }

    // 좌석 현황을 위한 반환 메서드들
    public int getRow() {
        return rs.getRow();
    }

    public int getCol() {
        return rs.getCol();
    }

    public boolean isSeatAvailable(int row, int col) {
        return rs.isSeatAvailable(row, col);
    }
}
