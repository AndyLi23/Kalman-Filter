public class Test {
    public static void main(String[] args) {
        double values[] = new double[]{4.3, 4.1, 3.9, 4.2, 3.6, 4, 4.2, 3.7, 4.1, 4.3, 3.8};

        State init = new State(0, 10);

        KalmanFilter1D filter = new KalmanFilter1D(init, 0);

        int t = 0;
        System.out.print("[");
        System.out.print("(0, " + init.getValue() + "), ");
        for(double v : values) {
            State cur = filter.update(v, 0.04, 1);
            t += 1;
            System.out.print("(" + t + ", " + cur.getValue() + (t == values.length ? ")" : "), "));
        }
        System.out.println("]");

    }
}
