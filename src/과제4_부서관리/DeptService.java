package 과제4_부서관리;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class DeptService {
    private final Scanner scanner = new Scanner(System.in);
    private DeptDAO deptDAO;

    public DeptService(DeptDAO deptDAO){
        this.deptDAO = deptDAO;
    }

    public void list() throws SQLException {

        System.out.println();
        System.out.println("[부서 목록]");
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-6s%-12s%-16s\n", "no", "name", "loc");
        System.out.println("-----------------------------------------------------------------------");
        List<Dept> list = deptDAO.list();
        if(list.size() == 0){
            System.out.println("현재 부서가 존재하지 않습니다.");
        }
        for(Dept dept : list){
            dept.print();
        }
        mainMenu();
    }

    private void mainMenu() throws SQLException {
        System.out.println();
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Exit");
        System.out.print("메뉴 선택: ");
        String menuNo = scanner.nextLine();
        System.out.println();

        switch (menuNo) {
            case "1" -> create();
            case "2" -> read();
            case "3" -> exit();
        }
    }

    private void create() throws SQLException {
        System.out.println("[생성 내용 입력]");
        System.out.print("부서명: ");
        String dname = scanner.nextLine();
        System.out.print("지역: ");
        String loc = scanner.nextLine();

        // 보조 메뉴 출력
        System.out.println("-------------------------------------------------------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        String menuNo = scanner.nextLine();
        if (menuNo.equals("1")) {
            int updated = deptDAO.create(new Dept(null, dname, loc));
            if(updated != 0){
                System.out.println("생성 완료");
            }else{
                System.out.println("생성 실패");
            }
        }
        list();
    };

    private void update(int deptno) throws SQLException {
        // 수정 내용 입력 받기
        System.out.println("[수정 내용 입력]");
        System.out.print("부서명: ");
        String dname = scanner.nextLine();
        System.out.print("지역: ");
        String loc = scanner.nextLine();

        // 보조 메뉴 출력
        System.out.println("-------------------------------------------------------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        String menuNo = scanner.nextLine();
        if (menuNo.equals("1")) {
            int updated = deptDAO.update(new Dept(deptno, dname, loc));
            if(updated != 0){
                System.out.println("수정 완료");
            }else{
                System.out.println("수정 실패");
            }
        }
        list();
    }
    
    private void delete(int deptno) throws SQLException {
        System.out.println("부서 삭제");
        // 보조 메뉴 출력
        System.out.println("-------------------------------------------------------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        String menuNo = scanner.nextLine();
        if (menuNo.equals("1")) {
            int updated = deptDAO.delete(deptno);
            if(updated != 0){
                System.out.println("삭제 완료");
            }else{
                System.out.println("삭제 실패");
            }
        }
        list();
    }
    private void read() throws SQLException {
        System.out.println("[부서 상세 보기]");
        System.out.print("Deptno: ");
        int deptno = Integer.parseInt(scanner.nextLine());
        Dept dept = deptDAO.read(deptno);

        if(dept != null){
            dept.printDetail();
            System.out.println();
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("서브 메뉴: 1.Update | 2.Delete ");
            System.out.print("메뉴 선택: ");
            String menuNo = scanner.nextLine();
            System.out.println();
            switch (menuNo) {
                case "1" -> update(deptno);
                case "2" -> delete(deptno);
            }
        }else{
            System.out.println( deptno + "번을 가진 부서는 존재하지 않습니다.");
        }
    };

    private void exit() {
        System.out.println("프로그램 종료");
        System.exit(0);
    }
}
