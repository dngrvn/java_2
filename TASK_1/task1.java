package TASK_1;

// 1. В файле содержится строка с исходными данными в такой форме: 
// {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
// SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
// Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder. 
// Значения null не включаются в запрос.
import java.io.*;

public class task1 {

    public static void main(String[] args) {

        try (FileReader fr = new FileReader("TASK_1/file_text.txt")) {
            StringBuilder str = new StringBuilder();
            int i;
            while ((i = fr.read()) != -1) {
                str.append((char) i);
            }
            str.delete(54, 72);
            str.deleteCharAt(1)
                    .deleteCharAt(5)
                    .deleteCharAt(16)
                    .deleteCharAt(23)
                    .deleteCharAt(34)
                    .deleteCharAt(38);
            String upgradeText = str.toString();

            upgradeText = upgradeText.replaceAll(",", "")
                    .replace("{", "")
                    .replace("}", "")
                    .replace(" ", " AND ")
                    .replace(":", " = ")
                    .replace(" \"age\" = \"null\"", "");
            try (FileWriter fw = new FileWriter("TASK_1/new_file_text.txt", false)) {
                fw.write("SELECT * FROM students WHERE " + upgradeText + ";");
            }
        } catch (IOException ex) {
            System.out.println("erroreeee");
        }
    }
}