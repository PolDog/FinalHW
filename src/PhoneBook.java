import java.util.*;
import java.util.stream.Collectors;

public class PhoneBook {
    Map<String, Person> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void createRecord(String name, String phone) {
        Person person;
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).addPhone(phone);
        } else {
            person = new Person(name, phone);
        phoneBook.put(person.getName(), person);
        }
    }

    public void removeRecord(String name) {
        if (phoneBook.containsKey(name)) {
            System.out.println("Удаляем запись пользователя " + name);
            phoneBook.remove(name);
        } else {
            System.out.println("Такой записи " + name + " нет");
        }
    }

    public void show() {
        System.out.println("Выводим телефонную книгу:");
        ArrayList<String> names = getNames();
        HashMap<String, Integer> sort = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            Person person = phoneBook.get(names.get(i));
            sort.put(names.get(i), person.getAmountPhones());
        }

        Map<String, Integer> sortedMap = sort.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));
        Map<String, Person> sortPhoneBook = new HashMap<>();
//        System.out.println("========== after sort ==========");
        showRecord(getNames(sortedMap));
    }

    private ArrayList<String> getNames() {
        ArrayList names = new ArrayList<>();
        for (Map.Entry<String, Person> pair : phoneBook.entrySet()) {
            names.add(pair.getKey());
        }
        return names;
    }

    private ArrayList<String> getNames(Map<String, Integer> sort) {
        ArrayList names = new ArrayList<>();
        for (Map.Entry<String, Integer> pair : sort.entrySet()) {
            names.add(pair.getKey());
        }
        return names;
    }

    private void showRecord(ArrayList<String> names) {
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            Person person = phoneBook.get(name);
            System.out.println("    "+person.getName());
            for (int j = 0; j < person.getPhones().size(); j++) {
                System.out.println("         " + (person.getPhones()).get(j));
            }
        }
    }
}

