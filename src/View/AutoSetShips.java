package View;

import java.util.*;
import Ships.SeparationOfCoordinates;
import Ships.CellShipHelper;

public class AutoSetShips {
    public AutoSetShips(Map<String, Integer> valuesCells) {
        this.valuesCells = valuesCells;
    }

    private Map<String, Integer> valuesCells;
    private ArrayList<ArrayList<String>> allShips= new ArrayList<>();

    private ArrayList<String> allFreeCells = new ArrayList<>();

    public void toArrayCellField(){
        for(Map.Entry<String, Integer> entry : valuesCells.entrySet()) {
            allFreeCells.add(entry.getKey());
        }
        Collections.shuffle(allFreeCells);
    }

    private void Direction(String headerLetter, int  columnNum, int lenghtShip){ //todo: поменять нейминг add interface
        Random rn = new Random();
        boolean isLetter = rn.nextBoolean();
        boolean isRight = rn.nextBoolean();
        boolean isAbove = isRight;
        boolean isHaveCell;

        String[] allLetter;

        if(isLetter) {
            isHaveCell = CellShipHelper.CheckOverflowShips(lenghtShip, headerLetter, isRight);
            if(isHaveCell){
                allLetter = CellShipHelper.NextCells(lenghtShip, headerLetter, isRight);
            }else {
                newShip(lenghtShip);
                return;
            }
        }else {
            isHaveCell = CellShipHelper.CheckOverflowShips(lenghtShip, columnNum, isAbove);
            if(isHaveCell) {
                allLetter = CellShipHelper.NextCells(lenghtShip, columnNum, isAbove);
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
        allShips.add(shipsCell);
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

    public ArrayList<ArrayList<String>> run(){                      //todo: interface
                                            //todo: rename method
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
        return allShips;
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
}
