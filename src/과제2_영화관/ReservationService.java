package 과제2_영화관;

public interface ReservationService {
    boolean isReservation(int row, int col);

    boolean isEmpty();

    boolean containsKey(int key);

    String getReservedSeat(int key);

    Integer reserve(int row, int col, String option);

    void cancle(int key, String option);

    int creatReservationCode();

    int generateRandom8Digit();

    int getRow();

    int getCol();
}
