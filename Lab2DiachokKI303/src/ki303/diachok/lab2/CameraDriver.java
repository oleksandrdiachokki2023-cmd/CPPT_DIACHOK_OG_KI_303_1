package ki303.diachok.lab2;

import java.io.IOException;

/**
 * Клас, що містить точку входу в програму для управління камерою.
 */
public class CameraDriver {
    /**
     * Основний метод, що запускає демонстрацію роботи класу {@link Camera}.
     *
     * @param args аргументи командного рядка (ігноруються).
     */
    public static void main(String[] args) {
        try {
            // Створення нового екземпляра камери з вимкненим станом
            Camera camera = new Camera(false);

            camera.turnOn();
            camera.takePhoto();
            camera.changeLens(new Lens(3));
            camera.chargeBattery();
            camera.formatMemory();
            camera.deleteLastPhoto();
            camera.checkStatus();
            camera.applyFilter("Нормальний");
            camera.startPhotoSession();
            camera.turnOff();

            camera.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}


