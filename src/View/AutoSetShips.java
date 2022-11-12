package View;

import java.util.*;

public class AutoSetShips {

    String[] allCells = new String[400]; //todo: переписать на эррей лист

    public void SearchFreeShip(Map<String, Integer> valuesCells){
        int i = 0;
        for(Map.Entry<String, Integer> entry : valuesCells.entrySet()) {
            String key = entry.getValue().toString();
            allCells[i] = key; //todo: переписать на эррей лист
        }
    }

   /*
   public void set1cellShipp(Map<String, Integer> valuesCells, Map<Integer, String> fieldsMap ){

        Random rn = new Random();
        int Ship = rn.nextInt(allCells.length);





        //Ищем все ячейки
        //Раскладываем цифру
        //а1
        int columnNum;
        String headerLetter;
        if(allCells[Ship].length() == 2 ) {
            columnNum = Integer.getInteger(allCells[Ship].substring(1, 2));
        }else {
            headerLetter = allCells[Ship].substring(1,1);
        }
        //ищем ячейки вокруг a1
        //Скрываем а2, b1

        //ищем ячейки вокруг a2
        //Скрываем а1, a3, b1, b2, b3

        //ищем ячейки вокруг d2
        //Скрываем c1 d1 f1 // c2 f2 // c3 d3 f3

        //ищем ячейки l10
        //Скрываем k10 // k9 l9

        // ищем буквы -> скрытия их 3 или 2 в пограничном случае.
        // ищем индекс буквы, получаем индекс буквы, получаем значения по - 1 и +1
        // ищем строки, получаем индекс цифры, получаем значения по -1 и + 1
        // конкатенируем
        // добавляем в эррей лист, удаляем из array list со всеми эллементами


        ArrayList<String> arrays = new ArrayList<String>();

        //   ------------------------------
        // Устанавливаем коробли по нарастающи
        // Установка коробля с 2 и более ячейками
        // Получаем длинну коробля
        // Выбираем ячейку
        // Выбираем рандомно лево или право, верх или низ
        // Проверяем последующие ячейки на длинну коробля


        //    -----------------------------
        // Проверка убит ли корабль
        // Вокруг только пустые ячейки, а в этой содержалось значение коробля


        }

    }
    */

public Map<Integer, String> setValueCell(Map<Integer, String> fieldsMap, Map<String, Integer> valuesCells  ) {
        int cell = valuesCells.get("a1").intValue();
        fieldsMap.replace(cell, "X");
        return fieldsMap;
    }



}
