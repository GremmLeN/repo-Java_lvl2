package lesson3;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private final HashMap<String, ArrayList<Contact>> entries = new HashMap<>();

    public void add(String surname, String phone) {
        if (entries.containsKey(surname)) {
            ArrayList<Contact> persons = entries.get(surname);
            persons.add(new Contact(surname, phone));
        } else {
            ArrayList<Contact> persons = new ArrayList<>();
            persons.add(new Contact(surname, phone));
            entries.put(surname, persons);
        }
    }


    public ArrayList<String> getPhones(String surname) {
        if (!entries.containsKey(surname)) return null;

        ArrayList<Contact> persons = entries.get(surname);
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < persons.size(); i++) {
            result.add(persons.get(i).phone);
        }
        return result;
    }
}
