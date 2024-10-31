import java.util.ArrayList;
import java.util.List;


public class Composition {

    static class Book {
        private String title;
        private String author;
        private int year;
        private CompositionStore store;

        public Book(String title, String author, int year, CompositionStore store) {
            this.title = title;
            this.author = author;
            this.year = year;
            this.store = store;
        }

        public String getTitle() {return title;}

        public String getAuthor() {return author;}

        public int getYear() {return year;}

        public CompositionStore getStore() {return store;}
    }


    static class CompositionStore {
        private String name;
        private String location;
        private List<Book> books;

        public CompositionStore(String name, String location) {
            this.name = name;
            this.location = location;
            this.books = new ArrayList<>();
        }

        public String getName() {return name;}

        public String getLocation() {return location;}

        public void addBook(String title, String author, int year) {
            Book book = new Book(title, author, year, this);
            books.add(book);
        }

        public List<Book> getBooks(){return this.books;}

        public void displayBooks() {
            System.out.println(name + " дэлгүүрт: ");
            for (Book book : books) {
                System.out.println("Нэр: " + book.getTitle() + " зохиогч: " + book.getAuthor() + " (" + book.getYear() + ")");
            }
        }
    }

    public static void main(String[] args) {

        CompositionStore store = new CompositionStore("Интерном", "БГ дүүрэг");

        store.addBook("Монгол түүх", "Бат", 1925);
        store.addBook("Түүвэр өгүүллэг", "Дорж", 1949);
        store.addBook("Оройгүй сүм", "Түдэв", 1960);

        store.displayBooks();

        Book firstBook = store.getBooks().get(0);
        System.out.println(firstBook.getTitle() + " ном - " + firstBook.getStore().getName() + " дэлгүүрт");
    }
}
