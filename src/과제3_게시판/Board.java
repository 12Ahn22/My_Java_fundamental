package 과제3_게시판;

import lombok.AllArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@AllArgsConstructor
public class Board {
    private int bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private Date bdate;

    public void printBoard(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");

        System.out.printf("%-6s%-12s%-16s%-40s \n", bno, bwriter,dateFormat.format(bdate), bcontent);
    }

    public void updateBoard(String btitle, String bcontent, String bwriter ){
        this.btitle = btitle;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
        this.bdate = new Date();
    }
}