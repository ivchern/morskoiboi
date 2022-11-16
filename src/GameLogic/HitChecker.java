package GameLogic;

import java.util.ArrayList;
import java.util.Map;

import Ships.CellShipHelper;
import Ships.SeparationOfCoordinates;
import View.MarkCells;

public class HitChecker {
    private ArrayList<ArrayList<String>> allShips;
    private Map<String, Integer> valuesCells;
    public HitChecker(MarkCells mark, ArrayList<ArrayList<String>> allShips, Map<String, Integer> valuesCells) {
        this.mark = mark;
        this.allShips = allShips;
        this.valuesCells = valuesCells;
    }

    private ArrayList<String> allFreeCells = new ArrayList<>();

    public void toArrayCellField(){
        for(Map.Entry<String, Integer> entry : valuesCells.entrySet()) {
            allFreeCells.add(entry.getKey());
        }
    }

    private View.MarkCells mark;
    private ArrayList<String> oldVal= new ArrayList<>();

    public void checkInputString(String inputString){
        if(allFreeCells.size() == 0){ toArrayCellField(); }
        if(allFreeCells.contains(inputString)){
            allFreeCells.remove(inputString);
            checkMassiveValue(inputString);
        }
        else{
            System.out.println("Попробуйте другую ячейку");
        }
    }
    public boolean checkMassiveValue(String fieldCell){
        for (int i = 0; i < allShips.size(); i++) {
            if(allShips.get(i).contains(fieldCell)){
                mark.markCell(fieldCell, "X");
                oldVal.add(fieldCell);
                allShips.get(i).remove(fieldCell);
                checkFreeMassive();
                return true;
            }
        }
        mark.markCell(fieldCell, "*");
        return false;
    }

    void checkFreeMassive(){
        for (int i = 0; i < allShips.size(); i++) {
            if(allShips.get(i).size() == 0){
                for (int j = 0; j < oldVal.size(); j++) {
                    String[] cellAround = CellShipHelper.CellAround(
                            SeparationOfCoordinates.ColumnNum(oldVal.get(j)),
                            SeparationOfCoordinates.HeaderLetter(oldVal.get(j)));
                    for (int k = 0; k < cellAround.length; k++) {
                        String val = cellAround[k];
                        if(!oldVal.contains(val)){
                            mark.markCell(cellAround[k], "*");
                            allFreeCells.remove(cellAround[k]);
                        }else{
                            mark.markCell(cellAround[k], "X");
                        }
                    }
                }
                oldVal.clear();
            }
        }
    }
}
