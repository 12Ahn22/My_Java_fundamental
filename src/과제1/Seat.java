package 과제1;

public class Seat {
    public static void main(String[] args) {
        // 여러분 이름을 잘 모르겠습니다.
        String[] students = {"강연규", "박시은", "최정민", "이채은", "박종성", "박경덕","조성희","김혜진","안아영","정혜림","백승찬","이민영","자현","14번째","15번째","16번째","17번째","18번째"};
        String[] seats = new String[students.length];

        // 초기화
        System.arraycopy(students, 0, seats, 0, students.length);

        // 배열 섞기
        for (int i = seats.length - 1; i > 0; i--) {
            int randomIdx = (int) (Math.random() * (i + 1)); // 0~(i+1)까지 인덱스

            String temp = seats[i];
            seats[i] = seats[randomIdx];
            seats[randomIdx] = temp;
        }

        System.out.println("자리 배치 결과:");
        for(int i = 0; i < seats.length; i++){
            System.out.println("자리" + (i + 1) + "=" + seats[i]);
        }
    }
}
