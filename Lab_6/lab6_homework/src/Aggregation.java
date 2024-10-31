import java.util.ArrayList;
import java.util.List;

public class Aggregation {

    static class Book {
        private String title;
        private String author;
        private int year;
        private AggregationStore store;

        public Book(String title, String author, int year) {
            this.title = title;
            this.author = author;
            this.year = year;
        }

        public void setStore(AggregationStore store) {
            this.store = store;
        }

        public String getTitle() {return title;}

        public String getAuthor() {return author;}

        public int getYear() {return year;}

        public AggregationStore getStore() {return store;}
    }


    static class AggregationStore {
        private String name;
        private String location;
        private List<Book> books;

        public AggregationStore(String name, String location, List<Book> books) {
            this.name = name;
            this.location = location;
            this.books = books;
            for(Book book : books) {
                book.setStore(this);
            }
        }

        public String getName() {return name;}

        public String getLocation() {return location;}

        public List<Book> getBooks() {return books;}

        public void addBook(Book book) {books.add(book);}

        public void displayBooks() {
            System.out.println(name + " дэлгүүрт: ");
            for (Book book : books) {
                System.out.println("Нэр: " + book.getTitle() + " Зохиогч: " + book.getAuthor() + " (" + book.getYear() + ")");
            }
        }
    }

    public static void main(String[] args) {

        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();

        Book book1 = new Book("Монгол түүх", "Бат", 1925);
        Book book2 = new Book("Түүвэр өгүүллэг", "Дорж", 1949);
        Book book3 = new Book("Оройгүй сүм", "Түдэв", 1960);

        books1.add(book1);
        books1.add(book2);
        books2.add(book3);

        AggregationStore store1 = new AggregationStore("Интерном", "БГ дүүрэг", books1);
        AggregationStore store2 = new AggregationStore("Мир ном", "СХ дүүрэг", books2);

        store1.displayBooks();
        System.out.println();
        store2.displayBooks();

        System.out.println(book1.getTitle() + " ном - " + book1.getStore().getName() + " дэлгүүрт");
    }
}
