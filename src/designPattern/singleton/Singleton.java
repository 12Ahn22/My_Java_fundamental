package designPattern.singleton;

class Singleton {
    // 정적 멤버 중첩 클래스
    private static class singleInstanceHolder {
        private static final Singleton INSTANCE = new Singleton(); // 미리 생성
    }

    // synchronized - 스레드 동기화
    public static synchronized Singleton getInstance(){
        return singleInstanceHolder.INSTANCE;
    }
}
