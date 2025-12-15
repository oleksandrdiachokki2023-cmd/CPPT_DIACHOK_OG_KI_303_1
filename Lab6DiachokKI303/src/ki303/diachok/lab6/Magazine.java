package ki303.diachok.lab6;

/**
 * Клас, що представляє журнал.
 * Містить інформацію про назву та номер випуску журналу та реалізує методи порівняння та представлення.
 * @version 1.1
 */
public class Magazine extends Item implements Comparable<Magazine> {
    private String name;
    private int issue;

    /**
     * Конструктор класу Magazine.
     * @param name назва журналу
     * @param issue номер випуску
     */
    public Magazine(String name, int issue) {
        this.name = name;
        this.issue = issue;
    }

    /**
     * Перетворює об'єкт Magazine на рядок для зручного виведення.
     * @return рядок з інформацією про журнал
     */
    @Override
    public String toString() {
        return "Журнал: " + name + ", випуск: " + issue;
    }

    /**
     * Порівнює поточний об'єкт Magazine з іншим за номером випуску.
     * @param other інший об'єкт Magazine для порівняння
     * @return результат порівняння номерів випусків
     */
    @Override
    public int compareTo(Magazine other) {
        return Integer.compare(this.issue, other.issue);
    }
}

