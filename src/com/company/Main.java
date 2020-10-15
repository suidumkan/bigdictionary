
package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<String, String[]> dictionary = new HashMap<>();
        Map<String, String[]> bigDictinary = new HashMap<>();

        dictionary.put("прекрасный ", new String[]{"отличный ", "блестящий ", "божественный ", "восхитительный "});
        dictionary.put("абитуриент ", new String[]{"выпускник ", "поступающий ", "претендент "});
        dictionary.put("веселый ", new String[]{"радостный ", "беспечальный ", "шутливый ", "счастливый "});
        dictionary.put("друг ", new String[]{"товарищ ", "приятель ", "сторонник "});

        for (Map.Entry<String, String[]> item: dictionary.entrySet()){
            System.out.println(item.getKey() + " - " + Arrays.toString(item.getValue()));

        }
        bigDictinary.putAll(dictionary);
        Set<String> keys = dictionary.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String oldKey = iterator.next();
            String[] oldValues = dictionary.get(oldKey);

            for (int i = 0; i < oldValues.length ; i++) {
                String newKey = oldValues[i];
                ArrayList<String> list = new ArrayList<>();
                list.addAll(Arrays.asList(oldValues));
                list.remove(newKey);
                list.add(oldKey);
                String[] newValues = new String[list.size()];
                list.toArray(newValues);
                bigDictinary.put(newKey, newValues);
            }
        }
        System.out.println("Результат___________________");
         for (Map.Entry<String, String[]> item: bigDictinary.entrySet()) {
             System.out.println(item.getKey() + " - " + Arrays.toString(item.getValue()));

         }
        while (true){
            System.out.println("Введите слово из словаря: ");
            Scanner scanner = new Scanner(System.in);
            String word = scanner.nextLine();
            String[] words = word.split(" ");
            for (String a : words){
                if (bigDictinary.get(a) != null){
                    String[] synonyms = bigDictinary.get(a);
                    Random random = new Random();
                    int x = random.nextInt(synonyms.length);
                    System.out.println(synonyms[x]);

                } else {
                    System.out.println("Такого слова нет в словаре! ");

                }
            }
        }



        }
    }



/*a)  Копировать все элементы словаря в большой словарь как они есть.
        b)  Затем нужно написать алгоритм автоматического дополнения большого словаря,
        таким образом чтоб каждый из элементов массива синонимов по 1 разу выступил в роли КЛЮЧА
        c)  Текущие ключи маленького словаря также должны будут перейти в массив на роль одного из синонимов.
        d)  Подсказка массив легко конвертируется в ArrayList
        e)  для проверки правильности работы вашего алгоритма
         в конце распечатайте содержимое всего большого словаря*/