import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, String[]> dictionary = new HashMap<>();
        Map<String, String[]> newDictionary = new HashMap<>();


        dictionary.put("большой", new String[]{"огромный", "громадный", "великий", "колосальный"});
        dictionary.put("человек", new String[]{"персона", "миледи", "личность", "гражданин"});
        dictionary.put("красивый", new String[]{"привлекательный", "обоятельный", "симпатичный", "прекрасный", "приятный"});
        dictionary.put("Дом ", new String[]{"жилище", "помещение", "логово", "кров"});
        dictionary.put("Тратить", new String[]{"Одолжит", "Продать", "Дават в взаимы"});
        dictionary.put("Думать", new String[]{"Мыслить", "Задумыватся", "предпологать", "ощущать"});
        dictionary.put("Компьютер", new String[]{"Ноутбук", "Телефон", "Гаджет", "Планшет"});
        dictionary.put("Обычная Вода", new String[]{"Холодная вода", "Теплая вода", "Заморожонная вода", "Кипящая вода"});
        dictionary.put("Летать", new String[]{" Прыгать", " Скакать", "Бегать", "Двигаться"});


        Set<String> keys = dictionary.keySet();
        Iterator iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            String[] values = dictionary.get(key);
            newDictionary.put(key, values);

            for (int i = 0; i < values.length; i++) {
                String newKeys = values[i];
                ArrayList<String> ArrayKeys = new ArrayList<>(values.length);
                ArrayKeys.addAll(Arrays.asList(values));
                ArrayKeys.remove(newKeys);

                ArrayKeys.add(key);
                String[] ArrayValuesStill = new String[ArrayKeys.size()];
                ArrayValuesStill = ArrayKeys.toArray(ArrayValuesStill);
                newDictionary.put(newKeys, ArrayValuesStill);

            }
        }

        for (Map.Entry<String, String[]> item : newDictionary.entrySet()
        ) {
            System.out.println("" + item.getKey() + "" + Arrays.toString((item.getValue())));

        }


        System.out.println("Введите любое слово из словаря:");
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        for (int i = 0; i < words.length; i++) {
            String[] synonyms = newDictionary.get(words[i]);
            if (synonyms != null) {
                Random random = new Random();
                int randomIndex = random.nextInt(synonyms.length);
                System.out.print(synonyms[randomIndex] + " ");
            } else {
                System.out.print("Слово не найдено ");
            }
        }

    }
}
