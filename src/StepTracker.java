import java.util.Arrays;
import java.util.Scanner;

public class StepTracker {

    private final MonthData[] monthToData;
    private int stepGoal;
    private final Converter converter = new Converter();

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
        stepGoal = 1;
    }

     private static class MonthData {
        int[] dayValue = new int[30];
    }

    public void showMonthData(int month) {
        if(month >=0 && month <=12){
                for (int j = 0; j < monthToData[month].dayValue.length; j++){
                    System.out.println("Month: " + month + " Day: " + (j+1) + " Value: " + monthToData[month].dayValue[j]);
                }
        }
    }
    void showMonthSteps(int month) {

        int stepsPassed = 0; // сумма шагов
        int maxSteps = 0; // максимальное значение шагов
        int currentMonthToDataDayValue; // значение с циклла
        int daysStreak = 0; // текущая серия
        int maxStreak = 0; // максимальная серия
        for(int i = 0; i < monthToData[month].dayValue.length; i++) {
            currentMonthToDataDayValue = monthToData[month].dayValue[i];
            stepsPassed += currentMonthToDataDayValue;
            if(maxSteps < currentMonthToDataDayValue){
                maxSteps = currentMonthToDataDayValue;
            }
            if (currentMonthToDataDayValue >= stepGoal){
                daysStreak += 1;
            }
            else {
                if (maxStreak < daysStreak){
                    maxStreak = daysStreak;
                }
                daysStreak = 0;
            }
        }
        if (maxStreak < daysStreak) {
            maxStreak = daysStreak;
        }


        double medianStepValue = stepsPassed / 30.0; //среднее значение
        System.out.println("Пройденные шаги за месяц: " + stepsPassed);
        System.out.println("Максимальное колличество шагов в день: "+ maxSteps);
        System.out.println("Среднее колличество пройденных шагов в день: " + medianStepValue );
        System.out.println("Пройденное растояние: " + converter.getKilometres(stepsPassed));
        System.out.println("Сожжено килокалорий: " + converter.getKKal(stepsPassed));
        System.out.println("Максимальный стрик - " + maxStreak);
    }

    void setStepGoal() {
        System.out.println("Введите цель шагов за день");
        Scanner scanner = new Scanner(System.in);
        int stepGoal1 = scanner.nextInt();
        if (stepGoal1 >= 0) {
            stepGoal = stepGoal1;
        }
        else System.out.println("Введено недопустимое значение");


        showStepGoal();
    }
    void showStepGoal() {

        System.out.println("Теперь ваша цель шагов - " + stepGoal);
    }

    void addStepPerDay() {
        System.out.println("Выберите месяц");
        System.out.println("0 - Январь, 1 - Февраль, 2 - Март, 3 - Апрель, 4 - Май, 5 - Июнь, 6 - Июль, 7 - Август, 8 - Сентябрь, 9 - Октябрь, 10 - Ноябрь, 11 - Декабрь");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        if (month >= 0 && month <= 12) {
            System.out.println("Выберите день в который хотите добавить количество шагов");
            int selectedDay = scanner.nextInt();
                if (selectedDay >0 && selectedDay <= 30) {
                    System.out.println("Сколько шагов?");
                    int stepCount = scanner.nextInt();
                    if ( stepCount >= 0) {
                        monthToData[month].dayValue[selectedDay-1] = stepCount;
                        System.out.println("Готово");
                    }
                    else {
                        System.out.println("Шагать надо вперед, а не назад");
                    }
                }
                else {
                    System.out.println("А в этом месяце точно есть " + selectedDay + " дней?");
                }
        }
        else {
            System.out.println("Неправвильный месяц");
        }
    }

}