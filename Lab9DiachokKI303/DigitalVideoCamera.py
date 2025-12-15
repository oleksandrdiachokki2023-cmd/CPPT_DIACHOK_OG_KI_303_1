from Camera import Camera


class DigitalVideoCamera(Camera):
    """
    Клас DigitalVideoCamera розширює функціональність базового класу Camera,
    додаючи можливість запису відео.
    """

    def __init__(self, name, resolution, memory_capacity, max_video_length):
        """
        Ініціалізує об'єкт цифрової відеокамери.

        :param name: Назва камери.
        :param resolution: Роздільна здатність камери.
        :param memory_capacity: Максимальна ємність пам'яті (ГБ).
        :param max_video_length: Максимальна тривалість запису відео (хвилин).
        """
        super().__init__(name, resolution, memory_capacity)
        self.max_video_length = max_video_length  # хвилини

    def record_video(self, duration):
        """
        Записує відео, якщо вистачає пам'яті та тривалість не перевищує ліміт.

        :param duration: Тривалість запису відео (хвилини).
        :return: True, якщо відео успішно записано, False - якщо недостатньо пам'яті або перевищено тривалість.
        """
        video_size_per_minute = 0.2  # Умовний розмір відео на хвилину (ГБ)
        required_memory = duration * video_size_per_minute

        if duration > self.max_video_length:
            print(f"Запис відео перевищує максимальну тривалість ({self.max_video_length} хв)")
            return False
        if self.used_memory + required_memory > self.memory_capacity:
            print(f"Недостатньо пам'яті для запису відео тривалістю {duration} хв")
            return False

        self.used_memory += required_memory
        print(f"Записано відео тривалістю {duration} хв на {self.name}")
        return True

    def get_status(self):
        """
        Отримує поточний статус цифрової відеокамери.

        :return: Строка із статусом камери, рівнем використаної пам'яті та максимальним часом запису.
        """
        basic_status = super().get_status()
        return f"{basic_status}, максимальна тривалість запису: {self.max_video_length} хв"