package ki303.diachok.lab3;

import java.io.IOException;

/**
 * Інтерфейс VideoRecordable, який визначає основні операції для пристроїв, що можуть записувати відео.
 */
 interface VideoRecordable {

    /**
     * Метод для початку запису відео.
     *
     * @throws IOException якщо виникає помилка під час початку запису
     */
    void startRecording() throws IOException;

    /**
     * Метод для зупинки запису відео.
     *
     * @throws IOException якщо виникає помилка під час зупинки запису
     */
    void stopRecording() throws IOException;
}

/**
 * Клас, що представляє цифрову відеокамеру. Розширює абстрактний клас Camera
 * та реалізує інтерфейс VideoRecordable.
 */
public class DigitalVideoCamera extends Camera implements VideoRecordable {
    private boolean isRecording;

    /**
     * Конструктор для створення цифрової відеокамери.
     *
     * @param isOn початковий стан камери (увімкнено чи вимкнено)
     * @throws IOException якщо виникає помилка при створенні логера
     */
    public DigitalVideoCamera(boolean isOn) throws IOException {
        super(isOn);
        this.isRecording = false;
    }

    @Override
    public void turnOn() throws IOException {
        if (!isOn) {
            isOn = true;
            logger.log("Цифрова відеокамера увімкнена");
            System.out.println("Цифрова відеокамера увімкнена");
        } else {
            logger.log("Цифрова відеокамера вже увімкнена");
            System.out.println("Цифрова відеокамера вже увімкнена");
        }
    }

    @Override
    public void turnOff() throws IOException {
        if (isOn) {
            if (isRecording) {
                stopRecording();
            }
            isOn = false;
            logger.log("Цифрова відеокамера вимкнена");
            System.out.println("Цифрова відеокамера вимкнена");
        } else {
            logger.log("Цифрова відеокамера вже вимкнена");
            System.out.println("Цифрова відеокамера вже вимкнена");
        }
    }

    @Override
    public void takePhoto() throws IOException {
        if (isOn && battery.getCharge() > 0 && memory.getFreeSpace() > 0) {
            photosTaken++;
            battery.useCharge();
            memory.useSpace();
            logger.log("Зроблено фотографію. Всього фото: " + photosTaken);
            System.out.println("Зроблено фотографію. Всього фото: " + photosTaken);
        } else {
            logger.log("Неможливо зробити фото. Перевірте, чи камера увімкнена, заряд батареї та вільне місце");
            System.out.println("Неможливо зробити фото. Перевірте, чи камера увімкнена, заряд батареї та вільне місце");
        }
    }

    @Override
    public void startRecording() throws IOException {
        if (isOn && !isRecording && battery.getCharge() > 0 && memory.getFreeSpace() > 0) {
            isRecording = true;
            logger.log("Почато запис відео");
            System.out.println("Почато запис відео");
        } else {
            logger.log("Неможливо почати запис. Перевірте, чи камера увімкнена, не записує зараз, заряд батареї та вільне місце");
            System.out.println("Неможливо почати запис. Перевірте, чи камера увімкнена, не записує зараз, заряд батареї та вільне місце");
        }
    }

    @Override
    public void stopRecording() throws IOException {
        if (isRecording) {
            isRecording = false;
            logger.log("Зупинено запис відео");
            System.out.println("Зупинено запис відео");
        } else {
            logger.log("Запис відео не було розпочато");
            System.out.println("Запис відео не було розпочато");
        }
    }

    /**
     * Перевіряє стан цифрової відеокамери.
     *
     * @return рядок з інформацією про стан цифрової відеокамери
     * @throws IOException якщо виникає помилка при запису в лог
     */
    public String checkStatus() throws IOException {
        String info = "Стан цифрової відеокамери: " +
                "Увімкнено: " + isOn +
                ", Заряд батареї: " + battery.getCharge() + "%" +
                ", Вільне місце: " + memory.getFreeSpace() +
                ", Зроблено фото: " + photosTaken +
                ", Запис відео: " + (isRecording ? "Триває" : "Не ведеться");

        logger.log(info);
        System.out.println(info);
        return info;
    }
}
  