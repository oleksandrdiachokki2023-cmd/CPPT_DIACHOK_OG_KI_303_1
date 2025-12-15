package ki303.diachok.lab3;

import java.io.IOException;

/**
 * Клас, що містить точку входу в програму для управління камерою.
 */
public class DigitalVideoCameraDriver {
    /**
     * Основний метод, що запускає демонстрацію роботи класу {@link Camera}.
     *
     * @param args аргументи командного рядка (ігноруються).
     */
    public static void main(String[] args) {
        try {
            // Створення нового екземпляра камери з вимкненим станом
            DigitalVideoCamera camera = new DigitalVideoCamera(false);

            camera.turnOn();
            camera.takePhoto();
            camera.changeLens(new Lens(3));
            camera.chargeBattery();
            camera.formatMemory();
            camera.deleteLastPhoto();
            camera.checkStatus();
            camera.applyFilter("Нормальний");
            camera.startPhotoSession();

            // Демонстрація відеозапису
            camera.startRecording();
            Thread.sleep(2000); // Імітація 2 секунд запису
            camera.stopRecording();

            camera.checkStatus();
            camera.turnOff();

            camera.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}