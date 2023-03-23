package TASK_3;

// 3. В файле содержится строка с данными:
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, 
// {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, 
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.
import java.io.*;

public class task3 {
    public static void main(String[] args) { // throws Exception {

        try (BufferedReader BufReader = new BufferedReader(new FileReader("TASK_3/file_text.txt"))) {
            StringBuilder strBuild = new StringBuilder();
            String strRead;
            while ((strRead = BufReader.readLine()) != null) {
                strBuild.append(strRead);
            }
            strBuild.deleteCharAt(strBuild.length() - 1)
                    .deleteCharAt(strBuild.length() - 1)
                    .replace(0, 1, "  ");

            String upgradeText = strBuild.toString();

            upgradeText = upgradeText.replace("}", "\n").replace("{", "")
                    .replace("фамилия", "Студент")
                    .replace("оценка", "получил")
                    .replace("предмет", "по предмету")
                    .replace("\"", "")
                    .replace(":", " ")
                    .replace(",", " ");
            try (FileWriter fw = new FileWriter("TASK_3/new_file_text.txt", false)) {
                fw.write(upgradeText);
                System.out.println(upgradeText);
            }
        } catch (IOException ex) {
            System.out.println("erroreeee");
        }
    }
}