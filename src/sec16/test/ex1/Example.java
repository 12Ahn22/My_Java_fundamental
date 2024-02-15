package sec16.test.ex1;

public class Example {
    public static void main(String[] args) {
        Button btnOk = new Button();
        btnOk.setClickListener(()-> System.out.println("OK 버튼 클릭"));
        btnOk.click();
        
        Button btnCancle = new Button();
        btnCancle.setClickListener(()-> System.out.println("Cancle 버튼 클릭"));
        btnCancle.click();
    }
}
