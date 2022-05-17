public class State {
    private double value, covariance;

    public State(double value, double p) {
        this.covariance = p;
        this.value = value;
    }

    public State extrapolate(double measurement, double uncertainty, double processNoiseVariance, double deltaT) {
        double kalmanGain = covariance / (covariance + uncertainty);
        double curCovariance = (1 - kalmanGain) * covariance;
        double newCovariance = curCovariance + processNoiseVariance;

        double newValue = value + kalmanGain * (measurement - value);
        double predictedValue = newValue;

        return new State(predictedValue, newCovariance);
    }

    public double getValue() {
        return value;
    }
}
