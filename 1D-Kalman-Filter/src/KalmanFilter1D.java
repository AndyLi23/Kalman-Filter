import java.util.ArrayList;

public class KalmanFilter1D {

    private ArrayList<State> states = new ArrayList<>();
    private double processNoiseVariance;

    public KalmanFilter1D(State initialState, double processNoiseVariance) {
        states.add(initialState);
        this.processNoiseVariance = processNoiseVariance;
    }

    public State update(double measuredPosition, double uncertainty, double deltaT) {
        State prev = states.get(states.size() - 1);

        states.add(prev.extrapolate(measuredPosition, uncertainty, processNoiseVariance, deltaT));
        return states.get(states.size() - 1);
    }
}
