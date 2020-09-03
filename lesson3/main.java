package lesson3;

import java.util.*;

public class main {
    public static void main(String[] args) {
        String[] mechs = {"Adder", "Nova", "Adder", "Stormcrow", "Vulture", "Vulture",
                "Warhammer", "Warhammer", "Warhammer", "Thor", "Loki", "Madcat",
                "Madcat", "Shadowcat", "Cougar", "Sunspider"};

        ArrayList<String> mechslist = new ArrayList<>();
        HashMap<String, Integer> mechsCnt = new HashMap<>();

        mechslist = getUniqueMechs(mechs);
        System.out.println("Список уникальных: " + mechslist.toString());

        mechsCnt = countMechs(mechs);
        Set<Map.Entry<String, Integer>> set = mechsCnt.entrySet();
        Iterator<Map.Entry<String, Integer>> itr = set.iterator();

        while (itr.hasNext()) {
            Map.Entry<String, Integer> entry = itr.next();
            if (entry.getValue() == 1) {
                System.out.printf("%s Встречается %d раз\n", entry.getKey(), entry.getValue());
            } else {
                System.out.printf("%s Встречается %d раза\n", entry.getKey(), entry.getValue());
            }
        }

            PhoneBook phonebook = new PhoneBook();
            phonebook.add("Smith", "8-9998");
            phonebook.add("Smith", "8-9999");
            phonebook.add("Stone", "8-5554");

            System.out.println("phone Smith: " + phonebook.getPhones("Smith"));
            System.out.println("phone Stone: " + phonebook.getPhones("Stone"));
    }

    private static ArrayList<String> getUniqueMechs(String[] str) {

        ArrayList<String> mechslist = new ArrayList<>();

        for (int i = 0; i < str.length; i++) {
            if (!mechslist.contains(str[i])) mechslist.add(str[i]);
        }

        return mechslist;
    }

    private static HashMap<String, Integer> countMechs(String[] str) {

        HashMap<String, Integer> mechsCnt = new HashMap<String, Integer>();

        for (int i = 0; i < str.length; i++) {
            int cnt = 0;
            if (mechsCnt.containsKey(str[i])) {
                cnt = mechsCnt.get(str[i]);
            }
            mechsCnt.put(str[i], ++cnt);
        }
        return mechsCnt;
    }
}