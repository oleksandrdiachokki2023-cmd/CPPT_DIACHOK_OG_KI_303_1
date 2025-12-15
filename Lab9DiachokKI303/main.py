from DigitalVideoCamera import DigitalVideoCamera

if __name__ == "__main__":
    # Створюємо цифрову відеокамеру
    # Параметри: назва, роздільна здатність, обсяг пам'яті (ГБ), тривалість запису (хв)
    camera = DigitalVideoCamera("Sony Alpha", "4K", 128, 120)

    # Виводимо початковий стан
    print("\n1. Початковий стан камери:")
    print(camera.get_status())

    # Робимо фотографію
    print("\n2. Робимо фотографію:")
    camera.take_photo()
    print(camera.get_status())

    # Записуємо відео
    print("\n3. Записуємо відео:")
    camera.record_video(30)
    print(camera.get_status())

    # Спробуємо записати відео, яке перевищує доступну пам'ять
    print("\n4. Спроба запису відео на 100 хвилин:")
    camera.record_video(100)
    print(camera.get_status())

    # Очищуємо пам'ять
    print("\n5. Очищуємо пам'ять:")
    camera.clear_memory()
    print(camera.get_status())

    # Робимо ще фотографії
    print("\n6. Робимо кілька фотографій:")
    for _ in range(5):
        camera.take_photo()
    print(camera.get_status())

    # Перевіряємо статус камери
    print("\n7. Фінальний стан камери:")
    print(camera.get_status())

