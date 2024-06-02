import java.util.ArrayList;

public class Person {
    String name;
    ArrayList<String> phones;
    int amountPhones = 0;

    public Person(String name, String phoneNumber) {
        phones = new ArrayList<>();
        this.name = name;
        System.out.println("Создаем нового пользователя " + name);
        addPhone(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public int getAmountPhones() {
        return amountPhones;
    }

    public ArrayList getPhones() {
        return phones;
    }

    public void addPhone(String phoneNumber) {
        if (!(phones.contains(phoneNumber))) {
            System.out.println("Добовляем новый телефон для " + name);
            phones.add(phoneNumber);
            amountPhones++;
        }
    }
}
