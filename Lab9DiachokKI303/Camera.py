class Camera:
    """
    Клас Camera представляє базовий функціонал фотоапарата.
    """

    def __init__(self, name, resolution, memory_capacity):
        """
        Ініціалізує об'єкт фотоапарата.

        :param name: Назва фотоапарата.
        :param resolution: Роздільна здатність фотоапарата (наприклад, '1080p', '4K').
        :param memory_capacity: Максимальна ємність пам'яті (ГБ).
        """
        self.name = name
        self.resolution = resolution
        self.memory_capacity = memory_capacity  # Гігабайти
        self.used_memory = 0  # Використана пам'ять (ГБ)

    def take_photo(self):
        """
        Робить фотографію, якщо вистачає пам'яті.

        :return: True, якщо фотографія зроблена успішно, False - якщо недостатньо пам'яті.
        """
        photo_size = 0.1  # Умовний розмір фотографії (ГБ)
        if self.used_memory + photo_size <= self.memory_capacity:
            self.used_memory += photo_size
            print(f"Фото зроблено на {self.name}!")
            return True
        else:
            print(f"Недостатньо пам'яті для зйомки фото на {self.name}")
            return False

    def clear_memory(self):
        """
        Очищує пам'ять фотоапарата.
        """
        self.used_memory = 0
        print(f"Пам'ять {self.name} очищено")

    def get_status(self):
        """
        Отримує поточний статус фотоапарата.

        :return: Строка із статусом фотоапарата та рівнем використаної пам'яті.
        """
        return f"Фотоапарат {self.name}: роздільна здатність {self.resolution}, пам'ять: {self.used_memory}/{self.memory_capacity} ГБ"