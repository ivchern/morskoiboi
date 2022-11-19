import View.Field;
import View.AutoSetShips;
import View.MarkCells;
import GameLogic.HitChecker;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Field field = new Field();
        field.BuildGrid();
        AutoSetShips se = new AutoSetShips(field.valuesCells);
        ArrayList<ArrayList<String>> allShips;
        allShips = se.run();
        field.ViewField();
        MarkCells mark = new MarkCells(field.fieldsMap, field.valuesCells);
        HitChecker hits = new HitChecker(mark, allShips, field.valuesCells);

        Field field1 = new Field();
        field1.BuildGrid();
        AutoSetShips se1 = new AutoSetShips(field1.valuesCells);
        ArrayList<ArrayList<String>> allShips1;
        allShips1 = se1.run();
        field1.ViewField();
        MarkCells mark1 = new MarkCells(field1.fieldsMap, field1.valuesCells);
        HitChecker hits1 = new HitChecker(mark1, allShips1, field1.valuesCells);

        boolean isOkCell = true;
        boolean secondPlayer = false;
        for (int i = 0; i < 100; i++) {
            if(!secondPlayer) {
                System.out.println("First Player:");
                Scanner in = new Scanner(System.in);
                String cell = in.nextLine();
                isOkCell = hits.checkInputString(cell);
                field.setFieldsMap(mark.getFieldsMap());
                field.ViewField();
            }
            if(!secondPlayer){ continue;}
                System.out.println("Second Player:");
                Scanner in = new Scanner(System.in);
                String cell = in.nextLine();
                isOkCell = hits1.checkInputString(cell);
                secondPlayer = !isOkCell;
                field1.setFieldsMap(mark1.getFieldsMap());
                field1.ViewField();
            }

        }
    }
