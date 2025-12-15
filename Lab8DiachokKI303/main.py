from calc import calculate, write_to_text_file, read_from_text_file, write_to_binary_file, \
    read_from_binary_file


def main():
    """Головна функція програми."""
    try:
        # Введення значення x з клавіатури
        x = float(input("Введіть значення x: "))

        # Обчислення y = sin(x) / sin(2x - 4)
        y = calculate(x)
        results = [(x, y)]

        # Запис результатів у текстовий файл
        text_filename = "result.txt"
        write_to_text_file(text_filename, results)
        print(f"Результати записані у текстовий файл: {text_filename}")

        # Запис результатів у двійковий файл
        binary_filename = "result.bin"
        write_to_binary_file(binary_filename, results)
        print(f"Результати записані у двійковий файл: {binary_filename}")

        # Читання та виведення результатів із текстового файлу
        print("\nЗчитування з текстового файлу:")
        text_data = read_from_text_file(text_filename)
        for line in text_data:
            print(line.strip())

        # Читання та виведення результатів із двійкового файлу
        print("\nЗчитування з двійкового файлу:")
        binary_data = read_from_binary_file(binary_filename)
        for bx, by in binary_data:
            print(f"x: {bx}, y: {by}")

    except ValueError as e:
        print(f"Помилка: {e}")


if __name__ == "__main__":
    main()

