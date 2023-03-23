package TASK_2;
// 2. Реализуйте алгоритм сортировки пузырьком числового массива, 
// результат после каждой итерации запишите в лог-файл.

import java.util.logging.*;

public class task2 {
    private static final Logger logger = Logger.getLogger(task2.class.getName());

    public static void main(String[] args) throws Exception {
        Handler fileHandler = new FileHandler("TASK_2/loglog.txt");
        SimpleFormatter simForm = new SimpleFormatter();
        fileHandler.setFormatter(simForm);
        // logger.log(Level.INFO, "ergerg");
        // logger.addHandler(fileHandler);
        // logger.info("Шаг выполнен!!!");

        int[] lineNumber = new int[] { 3, 18, 6, 5, 14, 7, 12, 1, 9 };

        for (int i = 0; i < lineNumber.length; i++) {
            for (int j = 0; j < lineNumber.length - 1; j++) {
                if (lineNumber[j] > lineNumber[j + 1]) {
                    int temp = lineNumber[j];
                    lineNumber[j] = lineNumber[j + 1];
                    lineNumber[j + 1] = temp;
                    logger.addHandler(fileHandler);
                    logger.info("Шаг выполнен!!!");
                    // logger.log(Level.INFO, "");
                } 
                else {
                    logger.addHandler(fileHandler);
                    logger.info("Шаг не выполнен!!!");
                    // logger.log(Level.INFO, "");
                }
            }
        }
        System.out.print("[ ");
        for (int i : lineNumber) {
            System.out.printf("%d ", i);

        }
        System.out.println("]");
    }
}