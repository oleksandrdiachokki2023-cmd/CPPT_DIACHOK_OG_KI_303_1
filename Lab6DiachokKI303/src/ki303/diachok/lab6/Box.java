package ki303.diachok.lab6;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Параметризований клас, що реалізує контейнер-коробку
 * @param <T> тип елементів, які зберігаються в коробці (має реалізовувати Comparable)
 * @version 1.1
 */
public class Box<T extends Comparable<T>> {
    private ArrayList<T> items;

    /**
     * Конструктор класу Box
     */
    public Box() {
        items = new ArrayList<>();
    }

    /**
     * Додає елемент до коробки
     * @param item елемент для додавання
     */
    public void addItem(T Item ) {
        items.add(Item);
    }
    /**
     * Виймає елемент з коробки за індексом
     * @param index індекс елемента
     * @return видалений елемент
     * @throws IndexOutOfBoundsException якщо індекс невірний
     */
    public T removeItem(int index) {
        return items.remove(index);
    }

    /**
     * Знаходить мінімальний елемент у коробці
     * @return мінімальний елемент або null якщо коробка пуста
     */
    public T findMin() {
        if (items.isEmpty()) {
            return null;
        }
        return Collections.min(items);
    }

    /**
     * Повертає розмір коробки
     * @return кількість елементів у коробці
     */
    public int size() {
        return items.size();
    }

    /**
     * Виводить вміст коробки
     */
    public void displayContents() {
        System.out.println("Вміст коробки:");
        for (T item : items) {
            System.out.println(item);
        }
    }
}
