import math
import struct

# Функція для обчислення y = sin(x) / sin(2x - 4)
def calculate(x):
    """Обчислює тангенс заданого значення x."""
    try:
        return math.sin(x) / math.sin(2*x - 4)
    except ValueError as e:
        raise ValueError(f"Помилка обчислення тангенса: {e}")

# Функція для запису результатів у текстовий файл
def write_to_text_file(filename, data):
    """Записує дані у текстовий файл."""
    with open(filename, "w", encoding="utf-8") as file:
        for x, y in data:
            file.write(f"x: {x}, y: {y}\n")

# Функція для читання даних із текстового файлу
def read_from_text_file(filename):
    """Зчитує дані з текстового файлу."""
    with open(filename, "r", encoding="utf-8") as file:
        return file.readlines()

# Функція для запису результатів у двійковий файл
def write_to_binary_file(filename, data):
    """Записує дані у двійковий файл."""
    with open(filename, "wb") as file:
        for x, y in data:
            # Записуємо як два числа з плаваючою крапкою
            file.write(struct.pack("ff", x, y))

# Функція для читання даних із двійкового файлу
def read_from_binary_file(filename):
    """Зчитує дані з двійкового файлу."""
    results = []
    with open(filename, "rb") as file:
        while chunk := file.read(8):  # Кожен запис - 8 байт (2 float)
            x, y = struct.unpack("ff", chunk)
            results.append((x, y))
    return results