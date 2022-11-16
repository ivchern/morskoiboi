package View;

import java.util.Map;

//mark = X - пробите, * - корабль
public class MarkCells {
    public MarkCells(Map<Integer, String> fieldsMap, Map<String, Integer> valuesCells) {
        this.fieldsMap = fieldsMap;
        this.valuesCells = valuesCells;
    }

    public Map<Integer, String> getFieldsMap() {
        return fieldsMap;
    }

    private Map<Integer, String> fieldsMap;
    private Map<String, Integer> valuesCells;


    public void markCell(String cell, String mark) {
        try {
            int cellNum = valuesCells.get(cell).intValue();
            fieldsMap.replace(cellNum, mark);
        }
        catch ( RuntimeException runtimeException){
            System.out.println(cell);
            System.out.println(valuesCells.toString());
        }
    }
}
