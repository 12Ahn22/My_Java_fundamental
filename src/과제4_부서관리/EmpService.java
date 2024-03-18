package 과제4_부서관리;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EmpService {
    private final Scanner scanner = new Scanner(System.in);
    private EmpDAO empDAO;
    private DeptDAO deptDAO;

    public EmpService(EmpDAO empDAO, DeptDAO deptDAO) {
        this.empDAO = empDAO;
        this.deptDAO = deptDAO;
    }

    public void list() throws SQLException {
        System.out.println();
        System.out.println("[사원 목록]");
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-6s%-12s%-6s%-10s%-16s%-6s%-10s%-10s%-6s\n", "no", "name", "mgr", "job", "hiredate", "sal", "dept", "loc", "grade");
        System.out.println("-----------------------------------------------------------------------");
        List<Emp> list = empDAO.list();
        for (Emp e : list) {
            e.print();
        }
        if (list.isEmpty()) System.out.println("사원 정보가 없습니다.");
        mainMenu();
    }

    private void mainMenu() throws SQLException {
        System.out.println();
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
        System.out.print("메뉴 선택: ");
        String menuNo = scanner.nextLine();
        System.out.println();

        switch (menuNo) {
            case "1" -> create();
            case "2" -> read();
            case "3" -> clear();
            case "4" -> exit();
        }
    }

    private void create() throws SQLException {
        // 보조 메뉴 출력
        System.out.println("-------------------------------------------------------------------");
        System.out.println("[ 생성 정보 입력 ]");
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("매니저 사번: ");
        int mgr = Integer.parseInt(scanner.nextLine());
        System.out.print("직업: ");
        String job = scanner.nextLine();
        System.out.print("급여(최소 700): ");
        int sal = Integer.parseInt(scanner.nextLine());
        System.out.print("부서번호: ");
        int deptno = Integer.parseInt(scanner.nextLine());

        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        String menuNo = scanner.nextLine();
        if (menuNo.equals("1")) {
            System.out.println("[부서 번호 확인중]");
            if (deptDAO.read(deptno) != null) {
                int updated = empDAO.create(new Emp(
                        null,
                        name,
                        mgr,
                        job,
                        null,
                        sal,
                        null,
                        deptno,
                        null,
                        null
                ));
                if (updated != 0) {
                    System.out.println("생성 완료");
                } else {
                    System.out.println("생성 실패");
                }
            }else{
                System.out.println("존재하지 않는 부서입니다.");
            }
        }
        list();
    }


    private void update(int empno) throws SQLException {
        // 보조 메뉴 출력
        System.out.println("-------------------------------------------------------------------");
        System.out.println("[ 수정 정보 입력 ]");
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("매니저 사번: ");
        int mgr = Integer.parseInt(scanner.nextLine());
        System.out.print("직업: ");
        String job = scanner.nextLine();
        System.out.print("입사일(yyyy/MM/dd): ");
        String date = scanner.nextLine();
        System.out.print("급여(최소 700): ");
        int sal = Integer.parseInt(scanner.nextLine());
        System.out.print("부서번호: ");
        int deptno = Integer.parseInt(scanner.nextLine());

        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        String menuNo = scanner.nextLine();
        if (menuNo.equals("1")) {
            System.out.println("[부서 번호 확인중]");
            if (deptDAO.read(deptno) != null) {
                int updated = empDAO.update(new Emp(
                        empno,
                        name,
                        mgr,
                        job,
                        date,
                        sal,
                        null,
                        deptno,
                        null,
                        null
                ));
                if (updated != 0) {
                    System.out.println("수정 완료");
                } else {
                    System.out.println("수정 실패");
                }
            }else{
                System.out.println("존재하지 않는 부서입니다.");
            }
        }
        list();
    }

    private void delete(int empno) throws SQLException {
        System.out.println("사원 삭제");
        // 보조 메뉴 출력
        System.out.println("-------------------------------------------------------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        String menuNo = scanner.nextLine();
        if (menuNo.equals("1")) {
            int updated = empDAO.delete(empno);
            if (updated != 0) System.out.println("삭제 성공");
            else System.out.println("삭제 실패");
        }
        list();
    }

    private void read() throws SQLException {
        System.out.println("[사원 정보 상세 보기]");
        System.out.print("Empno: ");
        int empno = Integer.parseInt(scanner.nextLine());
        Emp emp = empDAO.read(empno);
        if (emp != null) {
            emp.printDetail();
            System.out.println();
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("서브 메뉴: 1.Update | 2.Delete ");
            System.out.print("메뉴 선택: ");
            String menuNo = scanner.nextLine();
            System.out.println();
            switch (menuNo) {
                case "1" -> update(empno);
                case "2" -> delete(empno);
            }
        } else {
            System.out.println(empno + "번 사원은 존재하지 않습니다.");
            list();
        }
    }

    private void clear() throws SQLException {
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        String menuNo = scanner.nextLine();
        if (menuNo.equals("1")) {
            int updated = empDAO.clear();
            if (updated != 0) System.out.println("삭제 성공");
            else System.out.println("삭제 실패");
        }
        list();
    }

    private void exit() throws SQLException {
        System.exit(0);
        list();
    }
};


