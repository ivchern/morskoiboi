import View.Field;
import View.AutoSetShips;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Field field = new Field();
        AutoSetShips se = new AutoSetShips();

        field.BuildGrid();
        field.ViewField();
        field.fieldsMap = se.setValueCell(field.fieldsMap, field.valuesCells);
        field.ViewField();

    }


}