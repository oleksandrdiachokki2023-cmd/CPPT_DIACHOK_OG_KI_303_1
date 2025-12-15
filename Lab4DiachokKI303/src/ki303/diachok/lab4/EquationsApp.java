package ki303.diachok.lab4;

import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
/**
 * Драйвер для запуску програми обчислення виразу.
 * <p>
 * Клас Main відповідає за ініціалізацію обчислювача виразів та взаємодію з користувачем через консоль.
 * Користувач вводить значення змінної x, після чого програма обчислює значення виразу та виводить результат.
 * Також результат зберігається у файл.
 * </p>
 *
 * @version 1.0
 */
public class EquationsApp {

    /**
     * Точка входу до програми. Виконується отримання введеного користувачем значення,
     * обчислення результату виразу та запис результату у файл.
     *
     * @param args аргументи командного рядка
     */
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

            // Запис результату у файл
            String filePath = "result.txt";
            calculator.writeResultToFile(result, filePath);
            System.out.println("Результат записано у файл: " + filePath);

        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Помилка запису у файл: " + e.getMessage());
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
     * Записує результат обчислення у файл.
     *
     * @param result результат обчислення
     * @param filePath шлях до файлу
     * @throws IOException якщо виникає помилка при записі у файл
     */
    public void writeResultToFile(double result, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Результат обчислення: " + result);
        }
    }
}

