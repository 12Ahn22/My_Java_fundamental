package 과제4_부서관리;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
    private static Connection connection;

    private static PreparedStatement EmpListPstmt;
    private static PreparedStatement EmpReadPstmt;
    private static PreparedStatement EmpDeletePstmt;
    private static PreparedStatement EmpUpdatePstmt;
    private static PreparedStatement EmpCreatePstmt;
    private static PreparedStatement EmpClearPstmt;

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

            EmpListPstmt = connection.prepareStatement("SELECT * FROM EMP_TOTAL_VW");

            EmpReadPstmt = connection.prepareStatement("SELECT * FROM EMP_TOTAL_VW WHERE empno = ?");

            EmpDeletePstmt = connection.prepareStatement("DELETE FROM EMP WHERE empno = ?");

            EmpUpdatePstmt = connection.prepareStatement("UPDATE EMP SET ENAME = ?, MGR = ?,JOB = ?,HIREDATE = ?,SAL = ?,DEPTNO = ? WHERE EMPNO = ?");

            EmpCreatePstmt = connection.prepareStatement("INSERT INTO EMP (EMPNO,ENAME,MGR,JOB,HIREDATE,SAL,DEPTNO) VALUES(SEQ_EMPNO.nextval,?,?,?,SYSDATE,?,?)");

            EmpClearPstmt = connection.prepareStatement("DELETE FROM EMP");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Emp> list() throws SQLException {
        List<Emp> list = new ArrayList<>();
        ResultSet rs = EmpListPstmt.executeQuery();
        while (rs.next()) {
            list.add(new Emp(
                    rs.getInt("empno"),
                    rs.getString("ename"),
                    rs.getInt("mgr"),
                    rs.getString("job"),
                    rs.getString("date"),
                    rs.getInt("sal"),
                    rs.getString("dname"),
                    null,
                    rs.getString("loc"),
                    rs.getInt("grade")
            ));
        }
        return list;
    }

    public Emp read(int empno) throws SQLException {
        Emp emp = null;
        EmpReadPstmt.setInt(1, empno);
        ResultSet rs = EmpReadPstmt.executeQuery();
        if (rs.next()) {
            emp = new Emp(
                    rs.getInt("empno"),
                    rs.getString("ename"),
                    rs.getInt("mgr"),
                    rs.getString("job"),
                    rs.getString("date"),
                    rs.getInt("sal"),
                    rs.getString("dname"),
                    null,
                    rs.getString("loc"),
                    rs.getInt("grade")
            );
        }
        return emp;
    }

    public int delete(int empno) throws SQLException {
        int row = 0;
        try {
            EmpDeletePstmt.setInt(1,empno);
            row = EmpDeletePstmt.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException(e);
        }
        return 0;
    }

    public int update(Emp emp) throws SQLException {
        int row = 0;
        try {
            EmpUpdatePstmt.setString(1, emp.getName());
            EmpUpdatePstmt.setInt(2, emp.getMgr());
            EmpUpdatePstmt.setString(3,emp.getJob());
            EmpUpdatePstmt.setString(4,emp.getDate());
            EmpUpdatePstmt.setInt(5,emp.getSal());
            EmpUpdatePstmt.setInt(6,emp.getDeptno());
            EmpUpdatePstmt.setInt(7, emp.getEmpno());

            row = EmpUpdatePstmt.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException(e);
        }
        return row;
    }

    public int create(Emp emp) throws SQLException {
        int row = 0;
        try {
            EmpCreatePstmt.setString(1, emp.getName());
            EmpCreatePstmt.setInt(2, emp.getMgr());
            EmpCreatePstmt.setString(3,emp.getJob());
            EmpCreatePstmt.setInt(4,emp.getSal());
            EmpCreatePstmt.setInt(5,emp.getDeptno());

            row = EmpCreatePstmt.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException(e);
        }
        return row;
    }

    public int clear() throws SQLException {
        int row = 0;
        try {
            row = EmpClearPstmt.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException(e);
        }
        return row;
    }
}
