import View.Field;
import View.AutoSetShips;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Field field = new Field();
        field.BuildGrid();


        AutoSetShips se = new AutoSetShips( field.fieldsMap, field.valuesCells);
        se.run();
        field.setFieldsMap(se.getFieldsMap());
        field.ViewField();



    }





}