package Ships;

public class SeparationOfCoordinates {
    public static int ColumnNum(String shipStart){
        int columnNum;
        if(shipStart.length() == 2 ) {
            columnNum = Integer.parseInt(shipStart.substring(1,2));
        }else {
            columnNum = Integer.parseInt(shipStart.substring(1,3));
        }
        return columnNum;
    }

    public static String HeaderLetter(String shipStart){
        return shipStart.substring(0,1);
    }
}
