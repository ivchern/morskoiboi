package Ships;

import java.util.ArrayList;
import java.util.Arrays;

public class CellShipHelper {
    final private static ArrayList<String> horizontalIdentification =  new ArrayList<>(Arrays.asList("a", "b",
            "c", "d", "f", "e", "j", "k", "l", "m"));

    public static String[] NextCells(int lenghtShip, String pos, boolean isRight){
        int posLetter = horizontalIdentification.indexOf(pos);
        ArrayList<String> allLetter = new ArrayList<>();                          
        for (int i = 0; i < lenghtShip; i++) {
            if(isRight) {
                allLetter.add(horizontalIdentification.get(posLetter - i));
            }else {
                allLetter.add(horizontalIdentification.get(posLetter + i));
            }
        }
        return allLetter.toArray(new String[0]);
    }

    public static String[] NextCells(int lenghtShip, int pos, boolean isAbove){
        ArrayList<String> allHeaderLines = new ArrayList<>();
        for (int i = 0; i < lenghtShip; i++) {
            if(isAbove == true) {
                allHeaderLines.add(Integer.toString(pos + i));
            }else {
                allHeaderLines.add(Integer.toString(pos - 1));
            }
        }
        return allHeaderLines.toArray(new String[0]);
    }

    public static boolean CheckOverflowShips(int lenghtShip, int pos, boolean isAbove){
        for (int i = 0; i < lenghtShip; i++) {
            if(!isAbove) {
                if(pos - i < 0){ return  false; }
            }else {
                if(pos + i > 10){ return false; }
            }
        }
        return true;
    }

    public static boolean CheckOverflowShips(int lenghtShip, String pos, boolean isRight){
        int nextIndexLetter = horizontalIdentification.indexOf(pos);
        for (int i = 1; i <= lenghtShip; i++) {
            if(isRight) {
                if((nextIndexLetter - i ) < 0){ return false; }
            }else {
                if((nextIndexLetter + i ) > horizontalIdentification.size()){ return false; }
            }
        }
        return true;
    }

    public static String[] CellAround(int columnNum, String headerLetter) {
        int indexLetter = horizontalIdentification.indexOf(headerLetter);
        ArrayList<String> letterAround = new ArrayList<>();
        ArrayList<String> cellAround = new ArrayList<>();
        letterAround.add(headerLetter);

        if(indexLetter > 0) {
            letterAround.add(horizontalIdentification.get(indexLetter - 1));
        }
        if(indexLetter + 1 < horizontalIdentification.size()) {
            letterAround.add(horizontalIdentification.get(indexLetter + 1));
        }

        for (int i = 0; i < letterAround.size(); i++){
            if( columnNum - 1 > 0 ) {
                cellAround.add(letterAround.get(i) + (columnNum - 1));
            }
            cellAround.add(letterAround.get(i) + (columnNum));
            if (columnNum < 10) {
                cellAround.add(letterAround.get(i) + (columnNum + 1));
            }
        }
        return cellAround.toArray(new String[0]);
    }
}
