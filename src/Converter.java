public class Converter {
    private final double calorieRatio = 50.0;
    private final int toKilo = 1000;
    private final double stepLength = 0.75;
     double getKKal(int steps){
        return  steps * calorieRatio / toKilo;
    }
     double getKilometres(int steps){
        return  steps * stepLength / toKilo;
    }
}
