package 과제6_게시판JSP.main.java.com.example.boards.boards;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Boards {
    private String bno;
    private String title;
    private String content;
    private String writer;
    private String date;
}
