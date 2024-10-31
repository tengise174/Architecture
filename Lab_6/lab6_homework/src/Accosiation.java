import java.util.ArrayList;
import java.util.List;


public class Accosiation {

    static class Book {
        private String title;
        private String author;
        private int year;
        private AssociationStore store;

        public Book(String title, String author, int year) {
            this.title = title;
            this.author = author;
            this.year = year;
            this.store = store;
        }

        public void setStore(AssociationStore store) {
            this.store = store;
            store.addBook(this);
        }

        public String getTitle() {return title;}

        public String getAuthor() {return author;}

        public int getYear() {return year;}

        public AssociationStore getStore() {return store;}

        @Override
        public String toString() {
            return "Нэр: " + title + " зохиогч: " + author + " (" + year + ")";
        }
    }

    static class AssociationStore {
        private String name;
        private String location;
        private List<Book> books;

        public AssociationStore(String name, String location) {
            this.name = name;
            this.location = location;
            this.books = new ArrayList<>();
        }

        public void addBook(Book book) {books.add(book);}

        public String getName() {return name;}

        public String getLocation() {return location;}

        public List<Book> getBooks() {return books;}

        @Override
        public String toString() {
            return name + " ном " + location + " дэлгүүрт";
        }
    }

    public static void main(String[] args) {
        AssociationStore store1 = new AssociationStore("Интерном", "БГ дүүрэг");
        AssociationStore store2 = new AssociationStore("Мирном", "СХ дүүрэг");

        Book book1 = new Book("Монгол түүх", "Бат", 1925);
        Book book2 = new Book("Түүвэр өгүүллэг", "Дорж", 1960);
        Book book3 = new Book("Оройгүй сүм", "Түдэв", 1949);

        book1.setStore(store1);
        book2.setStore(store1);
        book3.setStore(store2);

        System.out.println(store1.getName() + " дэлгүүрт:");
        for (Book book : store1.getBooks()) {
            System.out.println(book);
        }

        System.out.println(store2.getName() + " дэлгүүрт:");
        for (Book book : store2.getBooks()) {
            System.out.println(book);
        }

        System.out.println(book1.getTitle() + " ном - " + book1.getStore().getName() + " дэлгүүрт");
    }
}
