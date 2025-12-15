package ki303.diachok.lab6;

public class BoxDriver {
    public static void main(String[] args) {

        // Тестування з книгами
        Box<Book> bookBox = new Box<>();
        bookBox.addItem(new Book("Кобзар", 40));
        System.out.println(Book.minpages);
        bookBox.addItem(new Book("Захар Беркут", 180));
        System.out.println(Book.minpages);
        bookBox.addItem(new Book("Лісова пісня", 160));
        System.out.println(Book.minpages);
/*
        Book minBook = bookBox.findMin();  
        System.out.println("=== Тест коробки з книгами ===");
        bookBox.displayContents();
        System.out.println("\nКнига з найменшою кількістю сторінок: " + minBook);


        // Тестування з журналами
        Box<Magazine> magazineBox = new Box<>();
        magazineBox.addItem(new Magazine("Nature", 125));
        magazineBox.addItem(new Magazine("Science", 458));
        magazineBox.addItem(new Magazine("Discovery", 89));

        System.out.println("\n=== Тест коробки з журналами ===");
        magazineBox.displayContents();

        Magazine minMagazine = magazineBox.findMin(); 
        System.out.println("\nЖурнал з найменшим номером випуску: " + minMagazine);


        // Демонстрація видалення
        System.out.println("\nВидаляємо елемент з коробки книг:");
        Book removedBook = bookBox.removeItem(1);
        System.out.println("Видалено: " + removedBook);
        bookBox.displayContents(); 
        **/
    }
}
