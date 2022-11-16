package View;

import java.util.*;
import Ships.SeparationOfCoordinates;
import Ships.CellShipHelper;

public class AutoSetShips {
    public Map<Integer, String> getFieldsMap() {
        return fieldsMap;
    }

    private Map<Integer, String> fieldsMap;
    private Map<String, Integer> valuesCells;
    private ArrayList<String> haveCell= new ArrayList<>();

    public AutoSetShips(Map<Integer, String> fieldsMap, Map<String, Integer> valuesCells) {
        this.fieldsMap = fieldsMap;
        this.valuesCells = valuesCells;
    }

    ArrayList<String> allFreeCells = new ArrayList<>();

    public void toArrayCellField(){
        for(Map.Entry<String, Integer> entry : valuesCells.entrySet()) {
            allFreeCells.add(entry.getKey());
        }
        Collections.shuffle(allFreeCells);
    }


    public void Direction(String headerLetter, int  columnNum, int lenghtShip){ //todo: поменять нейминг
        Random rn = new Random();
        boolean isLetter = rn.nextBoolean();
        boolean isRight = rn.nextBoolean();
        boolean isAbove = isRight;
        boolean isHaveCell;

        String[] allLetter;

        if(isLetter) {
            isHaveCell = CellShipHelper.CheckOverflowShips(lenghtShip, headerLetter, isRight);
            if(isHaveCell){
                allLetter = CellShipHelper.NextCell(lenghtShip, headerLetter, isRight);
            }else {
                newShip(lenghtShip);
                return;
            }
        }else {
            isHaveCell = CellShipHelper.CheckOverflowShips(lenghtShip, columnNum, isAbove);
            if(isHaveCell) {
                allLetter = CellShipHelper.NextCell(lenghtShip, columnNum, isAbove);
            }else {
                newShip(lenghtShip);
                return;
            }
        }
        ArrayList<String> shipsCell= new ArrayList<>();
        for (int i = 0; i < lenghtShip; i++) {
            if(isLetter == true) {
                shipsCell.add(allLetter[i] + columnNum);
            }else {
                shipsCell.add(headerLetter + allLetter[i]);
            }
        }
        if (!CellsCheck(shipsCell)){
            newShip(lenghtShip);
            return;
        }
        haveCell.addAll(shipsCell);
        System.out.println(shipsCell);
        for (int i = 0; i < shipsCell.size(); i++) {
            markCell(shipsCell.get(i), "X");
        }
    }

    private boolean CellsCheck(ArrayList<String> shipsCells) {
        for (int i = 0; i < shipsCells.size(); i++) {
            String[] cellAround = CellShipHelper.CellAround(
                    SeparationOfCoordinates.ColumnNum(shipsCells.get(i)),
                    SeparationOfCoordinates.HeaderLetter(shipsCells.get(i)));
            for (int j = 0; j < cellAround.length; j++) {
                if (!allFreeCells.contains(cellAround[j])){
                    return false;
                }
            }
        }
        allFreeCells.removeAll(shipsCells);
        return true;
    }

    public void run(){
        toArrayCellField();
        newShip(4);
        newShip(3);
        newShip(3);
        newShip(2);
        newShip(2);
        newShip(2);
        newShip(1);
        newShip(1);
        newShip(1);
        newShip(1);
    }

    int indexMassive = 0;
    public void newShip(int lenghtShip){
        String shipStart = allFreeCells.get(indexMassive);
        System.out.println(shipStart);
        indexMassive++;
        String verticalCoordinate = SeparationOfCoordinates.HeaderLetter(shipStart);
        int horizontalCoordinate = SeparationOfCoordinates.ColumnNum(shipStart);
        Direction(verticalCoordinate, horizontalCoordinate, lenghtShip);
        indexMassive = 0;
        System.out.println();
    }


    //mark = X - пробите, * - корабль
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
