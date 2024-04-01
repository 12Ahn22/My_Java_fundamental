package 자바웹개발워크북.Enum;

// enum 매핑 클래스
public enum Season {
    // 아래 코드들은 생성자가 없다면 실행 안됨
    // 상수들을 생성자처럼쓰는건가?
    SPRING("봄"),
    SUMMER("여름"),
    FALL("가을"),
    WINTER("겨울");

    private String season;

    // enum에서 생성자는 항상 private이다.
    Season(String season){
        this.season = season;
    }

    public String getSeason(){
        return season;
    }
}
