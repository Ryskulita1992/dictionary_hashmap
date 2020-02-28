package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // TODO: 24.02.2020
        //8)  (Дэдлайн 27.02.2020 23:59)
        //a)  Копировать все элементы словаря в большой словарь как они есть.
        //b)  Затем нужно написать алгоритм автоматического дополнения большого словаря, таким образом чтоб каждый из элементов массива синонимов по 1 разу выступил в роли КЛЮЧА
        //c)  Текущие ключи маленького словаря также должны будут перейти в массив на роль одного из синонимов.
        //d)  Подсказка массив легко конвертируется в ArrayList, для проверки правильности работы вашего алгоритма в конце распечатайте содержимое всего большого словар

        HashMap<String, String[]> dic = new HashMap<>();
        dic.put("beautiful", new String[]{"wonderful", "pretty", "gorgeous", "lovely"});
        dic.put("bad", new String[]{"eagle", "terrible", "horrible", "awful"});
        dic.put("smart", new String[]{"clever", "intelligent", "brilliant", "wise"});
        dic.put("stupid", new String[]{"bonehead", "mindless", "oafish", "dumb"});
        HashMap<String, String[]> bigDictionary = new HashMap();
        Set<String> keys = dic.keySet(); // getting all keys
        Iterator iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            String[] values = dic.get(key);
            bigDictionary.put(key, values); //putting in bigDictionary K & V
            for (int i = 0; i < values.length; i++) {
                String newKey = values[i];
                List<String> val = new ArrayList<>(values.length);      //length will be the same length of values
                val.addAll(Arrays.asList(values));
                val.remove(newKey);
                val.add(key);
                String[] newVal = new String[val.size()];
                newVal = val.toArray(newVal);
                bigDictionary.put(newKey, newVal); } }
        System.out.println("Type a word");
        Scanner scanner = new Scanner(System.in);
        String sentences = scanner.nextLine();
        String[] words = sentences.split(" ");
        Random r = new Random();
        for (int i = 0; i < words.length; i++) {
            String[] synonyms = bigDictionary.get(words[i]);
            if (synonyms != null) {
                int randomNumber = r.nextInt(synonyms.length);
                System.out.printf(synonyms[randomNumber] + " ");
            } else {
                System.out.println("There is no such a word!!! Try another one");
            }
        }
    }
}

