package sec14.exam04;

class SumThread extends Thread {
    private long sum;

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
    }
}

public class JoinEx {
    public static void main(String[] args) {
        SumThread sumThread = new SumThread(); // Thread
        sumThread.start();
    }
}
