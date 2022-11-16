import View.Field;
import View.AutoSetShips;
import View.MarkCells;
import GameLogic.HitChecker;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Field field = new Field();
        field.BuildGrid();

        AutoSetShips se = new AutoSetShips(field.valuesCells);
        ArrayList<ArrayList<String>> allShips;
        allShips = se.run();
        field.ViewField();

        MarkCells mark = new MarkCells(field.fieldsMap, field.valuesCells);
        HitChecker hits = new HitChecker(mark, allShips, field.valuesCells);
        for (int i = 0; i < 100; i++) {
            Scanner in = new Scanner(System.in);
            String cell = in.nextLine();
            hits.checkInputString(cell);
            field.setFieldsMap(mark.getFieldsMap());
            field.ViewField();
        }
    }
}