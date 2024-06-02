public class Main {

    public static void main(String[] args) {
        System.out.println("My PhoneBook/ Final HW");
        System.out.println("--------------------------------");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.createRecord("Иван", "1-45-56");
        phoneBook.createRecord("Петр", "1-45-56");
        phoneBook.createRecord("Иван2", "999-88-77");
        phoneBook.createRecord("Петр", "2-88-77");
        phoneBook.createRecord("Петр", "2-88-77");
        phoneBook.createRecord("Петр", "3-88-77");
        phoneBook.createRecord("Петр", "4-88-77");
        phoneBook.createRecord("Иван", "2-45-56");
        System.out.println("--------------------------------");
        phoneBook.show();
        phoneBook.removeRecord("Иван2");
        phoneBook.removeRecord("Глеб");
        System.out.println("--------------------------------");
        phoneBook.show();
    }
}