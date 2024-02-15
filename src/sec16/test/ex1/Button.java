package sec16.test.ex1;

public class Button {
    // 정적 멤버 인터페이스(함수형 인터페이스)
    // 버튼과 연관이 있는 인터페이스이기 때문에 내부에 설정
    @FunctionalInterface
    public static interface ClickListener {
        void onClick();
    }
    
    private ClickListener clickListener; // 등록한 클릭리스너를 저장하는 멤버

    // 클릭 리스너를 등록해주기
    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    // 클릭 시, 등록된 clickListener의 콜백 함수를 호출하는 메서드
    public void click(){
        if(clickListener == null) return;
        clickListener.onClick(); // onClick은 내가 정의해서 등록한 콜백함수
    }

}
