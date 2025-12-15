package ki303.diachok.lab6;

/**
 * Клас, що представляє книгу.
 * Містить інформацію про назву та кількість сторінок книги, а також реалізує методи порівняння та представлення.
 * @version 1.1
 */
public class Book extends Item implements Comparable<Book> {
    private String title;
    private int pages;
    /**
     * Конструктор класу Book.
     * @param title назва книги
     * @param pages кількість сторінок
     */
    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
        if (minpages == 0 || this.pages < minpages)
        minpages=pages;
        	
        
    }

    /**
     * Перетворює об'єкт Book на рядок для зручного виведення.
     * @return рядок з інформацією про книгу
     */
    @Override
    public String toString() {
        return "Книга: " + title + ", сторінок: " + pages;
    }

    /**
     * Порівнює поточний об'єкт Book з іншим за кількістю сторінок.
     * @param other інший об'єкт Book для порівняння
     * @return результат порівняння кількості сторінок
     */
    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.pages, other.pages);
    }
}


