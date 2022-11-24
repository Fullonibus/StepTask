import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
        int userTempValue;
        StepTracker stepTracker = new StepTracker();
        while (userInput != 4) {
            if(userInput == 1){
                stepTracker.addStepPerDay();
            }
            else if(userInput == 2){
                System.out.println("Выберите месяц");
                System.out.println("0 - Январь, 1 - Февраль, 2 - Март, 3 - Апрель, 4 - Май, 5 - Июнь, 6 - Июль, 7 - Август, 8 - Сентябрь, 9 - Октябрь, 10 - Ноябрь, 11 - Декабрь");
                userTempValue = scanner.nextInt();
                if (0 <= userTempValue && userTempValue <= 12){
                    stepTracker.showMonthData(userTempValue);
                   stepTracker.showMonthSteps(userTempValue);
                }
            }
            else if (userInput == 3){

                stepTracker.setStepGoal();
            }
            else {
                System.out.println("Ты чево пишеш?");
            }
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println(" 1 - Ввести количество шагов за определенный день");
        System.out.println(" 2 - Напечатать статистику за определенный месяц");
        System.out.println(" 3 - Изменить цель по количеству шагов в день");
        System.out.println(" 4 - Выйти из приложения");
    }
}