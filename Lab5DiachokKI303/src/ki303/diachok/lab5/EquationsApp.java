package ki303.diachok.lab5;

import java.io.IOException;
import java.util.Scanner;
import java.io.*;
/**
 * Драйвер для запуску програми обчислення виразу та тестування методів читання і запису.
 */
public class EquationsApp {
    public static void main(String[] args) {
        ExpressionCalculator calculator = new ExpressionCalculator();
        Scanner scanner = new Scanner(System.in);

        try {
            // Отримання значення x від користувача
            System.out.print("Введіть значення x: ");
            double x = scanner.nextDouble();

            // Обчислення результату
            double result = calculator.calculate(x);
            System.out.println("Результат: " + result);

            // Запис результату у текстовий файл
            String textFilePath = "result.txt";
            calculator.writeResultToFile(result, textFilePath);
            System.out.println("Результат записано у текстовий файл: " + textFilePath);

            // Запис результату у двійковий файл
            String binaryFilePath = "result.bin";
            calculator.writeResultToBinaryFile(result, binaryFilePath);
            System.out.println("Результат записано у двійковий файл: " + binaryFilePath);

            // Читання результату з текстового файлу
            double textResult = calculator.readResultFromFile(textFilePath);
            System.out.println("Результат, зчитаний з текстового файлу: " + textResult);

            // Читання результату з двійкового файлу
            double binaryResult = calculator.readResultFromBinaryFile(binaryFilePath);
            System.out.println("Результат, зчитаний з двійкового файлу: " + binaryResult);

        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Помилка запису або читання файлу: " + e.getMessage());
        } finally {
            // Закриття сканера для уникнення витоку ресурсів
            scanner.close();
        }
    }
}
/**
 * Клас для обчислення виразу y = sin(x) / sin(2x - 4).
 * Використовується для демонстрації механізму виключень і запису результатів у файл.
 */
    class ExpressionCalculator {

    /**
     * Обчислює вираз y = sin(x) / sin(2x - 4).
     *
     * @param x значення змінної x
     * @return результат обчислення виразу
     * @throws IllegalArgumentException якщо x = 0, оскільки вираз не визначений
     */
    	 public double calculate(double x) throws IllegalArgumentException {
 		    // 1️⃣ Перевірка x == 0
 		    if (x == 0) {
 		        throw new IllegalArgumentException("Значення x не може бути 0, оскільки вираз не визначений.");
 		    }
 		    

 		    // 2️⃣ Обчислення знаменника
 		    double denominator = Math.sin(2 * x - 4);

 		    // 3️⃣ Перевірка ділення на нуль
 		    if (Math.abs(denominator) < 1e-10) { // дуже близько до нуля
 		        throw new IllegalArgumentException("Знаменник дорівнює нулю — вираз не визначений для цього x.");
 		    }

 		    // 4️⃣ Обчислення результату
 		    return Math.sin(x) / denominator;
 		}

    /**
     * Записує результат обчислення у текстовий файл.
     *
     * @param result результат обчислення
     * @param filePath шлях до файлу
     * @throws IOException якщо виникає помилка при записі у файл
     */
    public void writeResultToFile(double result, String filePath) throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter(filePath);
            writer.write("Результат обчислення: " + result);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    /**
     * Записує результат обчислення у двійковий файл.
     *
     * @param result результат обчислення
     * @param filePath шлях до двійкового файлу
     * @throws IOException якщо виникає помилка при записі у файл
     */
    public void writeResultToBinaryFile(double result, String filePath) throws IOException {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(filePath));
            dos.writeDouble(result);
        } finally {
            if (dos != null) {
                dos.close();
            }
        }
    }

    /**
     * Читає результат з текстового файлу.
     *
     * @param filePath шлях до файлу
     * @return результат обчислення, зчитаний з файлу
     * @throws IOException якщо виникає помилка при читанні файлу
     */
    public double readResultFromFile(String filePath) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            return Double.parseDouble(line.replaceAll("[^\\d.-]", ""));
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    /**
     * Читає результат з двійкового файлу.
     *
     * @param filePath шлях до двійкового файлу
     * @return результат обчислення, зчитаний з файлу
     * @throws IOException якщо виникає помилка при читанні файлу
     */
    public double readResultFromBinaryFile(String filePath) throws IOException {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream(filePath));
            return dis.readDouble();
        } finally {
            if (dis != null) {
                dis.close();
            }
        }
    }
}

