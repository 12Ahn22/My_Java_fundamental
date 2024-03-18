package 과제4_부서관리;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// DEPT 테이블과 연결하는 로직이 모여있는 곳
public class DeptDAO {
    private static Connection connection;
    private static PreparedStatement deptListPstmt;
    private static PreparedStatement deptReadPstmt;
    private static PreparedStatement deptCreatePstmt;
    private static PreparedStatement deptUpdatePstmt;
    private static PreparedStatement deptDeletePstmt;

    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            //연결하기
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xe",
                    "bituser", //계정이름
                    "1004" //계정비밀번호
            );
            connection.setAutoCommit(false);
            System.out.println("연결 성공");

            deptListPstmt = connection.prepareStatement("SELECT * FROM DEPT d");
            deptReadPstmt = connection.prepareStatement("SELECT * FROM DEPT WHERE deptno = ?");
            deptUpdatePstmt = connection.prepareStatement("UPDATE DEPT SET DNAME = ?, LOC = ? WHERE deptno = ?");
            deptCreatePstmt = connection.prepareStatement("INSERT INTO DEPT (DEPTNO, DNAME, LOC) VALUES (SEQ_DEPTNO.nextval,?,?)");
            deptDeletePstmt = connection.prepareStatement("DELETE FROM DEPT WHERE deptno = ?");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Dept> list() throws SQLException {
        List<Dept> list = new ArrayList<>();

        ResultSet rs = deptListPstmt.executeQuery();
        while (rs.next()){
            list.add(new Dept(
                    rs.getInt("deptno"),
                    rs.getString("dname"),
                    rs.getString("loc")
            ));
        }
        rs.close();
        return list;
    }

    public Dept read(int deptno) throws SQLException {
        Dept dept = null;
        deptReadPstmt.setInt(1, deptno);
        ResultSet rs = deptReadPstmt.executeQuery();

        if(rs.next()){
            dept = new Dept(
                    deptno,
                    rs.getString("dname"),
                    rs.getString("loc")
            );
            rs.close();
        }
        return dept;
    }

    public int create(Dept dept) throws SQLException {
        int row;
        try {
            deptCreatePstmt.setString(1, dept.getName());
            deptCreatePstmt.setString(2, dept.getLoc());
            row = deptCreatePstmt.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException(e);
        }
        return row;
    }

    public int update(Dept dept) throws SQLException {
        int row = 0;
        try {
            deptUpdatePstmt.setString(1, dept.getName());
            deptUpdatePstmt.setString(2, dept.getLoc());
            deptUpdatePstmt.setInt(3, dept.getDeptno());

            row = deptUpdatePstmt.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException(e);
        }
        return row;
    }

    public int delete(int deptno) throws SQLException {
        int row = 0;
        try {
            deptDeletePstmt.setInt(1,deptno);
            deptDeletePstmt.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException(e);
        }
        return row;
    }
}
