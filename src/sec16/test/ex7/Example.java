package sec16.test.ex7;



public class Example {
    @FunctionalInterface
    private interface Operator {
        public int apply(int x, int y);
    }
    private static final int[] scores = {10, 50, 3};

    public static int maxOrMin(Operator op) {
        int res = scores[0];
        for (int score : scores) {
            res = op.apply(score, res);
        }
        return res;
    }

    public static void main(String[] args) {
        // 최대값
        System.out.println(maxOrMin(Math::max));
        // 최소값
        System.out.println(maxOrMin(Math::min));
    }
}
