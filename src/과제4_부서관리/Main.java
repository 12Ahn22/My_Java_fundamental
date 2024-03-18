package 과제4_부서관리;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    // Field
    private Scanner scanner = new Scanner(System.in);
    private DeptDAO deptDAO = new DeptDAO();
    private EmpDAO empDAO = new EmpDAO();

    public void mainMenu() throws SQLException {
        System.out.println();
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("메인 메뉴: 1.부서 관리 | 2.사원 관리 | 3.Exit");
        System.out.print("메뉴 선택: ");
        String menuNo = scanner.nextLine();
        System.out.println();

        switch (menuNo) {
            case "1" -> deptManager();
            case "2" -> empManager();
            case "3" -> exit();
        }
    }

    private void deptManager() throws SQLException {
        System.out.println("부서 관리");
        DeptService deptService = new DeptService(deptDAO);
        deptService.list();
    }

    private void empManager() throws SQLException {
        System.out.println("사원 관리");
        EmpService empService = new EmpService(empDAO, deptDAO);
        empService.list();
    }

    private void exit() {
        System.exit(0);
    }

    public static void main(String[] args) {
        try {
            new Main().mainMenu();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
