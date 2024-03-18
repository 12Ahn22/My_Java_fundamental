package 과제6_게시판JSP.main.java.com.example.boards.boards;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardsDAO {
    private static Connection conn = null;
    private static PreparedStatement boardListPstmt = null;
    private static PreparedStatement boardInsertPstmt = null;
    private static PreparedStatement boardDeletePstmt = null;
    private static PreparedStatement boardDetailPstmt = null;

    private static PreparedStatement boardUpdatePstmt = null;

    static {

        try {
            System.out.println("===================================");
            // 1. JDBC 드라이버 로딩
            Class.forName("oracle.jdbc.OracleDriver");
            // 2. DB 연결
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xe",
                    "bituser", //계정이름
                    "1004" //계정비밀번호
            );
            // 3. SQL 실행 객체 준비
            // 4. SQL 실행
            System.out.println("연결 성공=================" + conn);
            conn.setAutoCommit(false);

            boardListPstmt = conn.prepareStatement("select bno, btitle, bcontent, bwriter, TO_CHAR(bdate,'YYYY-MM-DD') bdate from boards");
            boardInsertPstmt = conn.prepareStatement("insert into boards (bno, btitle, bcontent, bwriter, bdate) values (SEQ_BNO.nextval, ?, ?, ?,SYSDATE)");
            boardDetailPstmt = conn.prepareStatement("select bno, btitle, bcontent, bwriter, TO_CHAR(bdate,'YYYY-MM-DD') bdate from boards where bno=?");
            //delete 가 되지 않았던 이유: ? 개수에 맞춰서 setString() 을 해주어야 한다.
            boardDeletePstmt = conn.prepareStatement("delete from boards where bno=?");
            boardUpdatePstmt = conn.prepareStatement("update boards set btitle=?, bcontent=?,bwriter=?, bdate=sysdate where bno=?");
            // 5. 결과 처리
            // 6. 연결 해제
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public List<Boards> list() {
        List<Boards> list = new ArrayList<>();
        try {
            ResultSet rs = boardListPstmt.executeQuery();
            while (rs.next()) {
                Boards boards = new Boards(rs.getString("bno")
                        , rs.getString("btitle")
                        , rs.getString("bcontent")
                        , rs.getString("bwriter")
                        , rs.getString("bdate"));

                list.add(boards);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public int insert(Boards boards){
        int updated = 0;
        try{
            boardInsertPstmt.setString(1, boards.getTitle());
            boardInsertPstmt.setString(2, boards.getContent());
            boardInsertPstmt.setString(3, boards.getWriter());
            updated = boardInsertPstmt.executeUpdate();
            conn.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return updated;
    }
    public Boards read(String bno) {

        Boards boards = null;
        try {
            boardDetailPstmt.setString(1, bno);

            ResultSet rs = boardDetailPstmt.executeQuery();
            if (rs.next()) {
                boards = new Boards(rs.getString("bno")
                        , rs.getString("btitle")
                        , rs.getString("bcontent")
                        , rs.getString("bwriter")
                        , rs.getString("bdate"));
            }
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return boards;
    }

    public int update(Boards boards) {
        int updated = 0;
        try {
            boardUpdatePstmt.setString(1, boards.getTitle());
            boardUpdatePstmt.setString(2, boards.getContent());
            boardUpdatePstmt.setString(3, boards.getWriter());
            boardUpdatePstmt.setString(4, boards.getBno());
            updated = boardUpdatePstmt.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updated;

    }
//
    public int delete(String bno) {
        int updated = 0;

        try {
            boardDeletePstmt.setString(1, bno);
            updated = boardDeletePstmt.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updated;
    }
}
