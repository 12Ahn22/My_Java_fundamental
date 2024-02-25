package 과제2_영화관;
import lombok.Getter;

/**
 * Seat 좌석에 대한 클래스
 */
public class ReservationSeat {
    // 좌석 크기
    @Getter
    private final int row;
    @Getter
    private final int col;
    private boolean[][] seats; // 좌석에 따른 예약 여부 배열

    public ReservationSeat(int row, int col){
        this.row = row;
        this.col = col;
        this.seats = new boolean[row][col];
    }

    /**
     * 해당 좌석이 예약 가능한 여부 확인 메서드
     */
    public boolean isSeatAvailable(int row, int col) {
        return !seats[row][col];
    }

    /**
     * 좌석 예매 취소 메서드
     */
    public void cancelReservation(int row, int col){
        seats[row][col] = false;
    }

    /**
     * 좌석 예매 메서드
     */
    public void reserveSeat(int row, int col){
        seats[row][col] = true;
    }
}
