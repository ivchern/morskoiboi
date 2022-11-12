package View;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.IntStream;


public class Field {
    public Map<Integer, String> fieldsMap = new LinkedHashMap<Integer, String>();
    //ЭТО типо мапа которая дает ключ от другой мапы :facepalm
    public Map<String, Integer> valuesCells = new HashMap<String, Integer>();

    public void BuildGrid(){
        final String[] horizontalIdentification = { "a", "b", "c", "d", "f", "e", "j",
                "k", "l", "m"};
        final int[] verticalIdentification = IntStream.rangeClosed(1, 10).toArray();

        //22 горизонтальных символа, 22 вертикальных поля=>
        //3 справа занято, 1 сверху занят, 1 снизу занят, остальное поле /2
        int k = 0;
        int countElem = 0;
        while (k < 22) {
            for (int i = 0; i < 22; i++) {
                countElem++;
                if(k == 0 ) {
                    SetHeaderLine(i, horizontalIdentification, countElem);
                } else if( k % 2 != 0 ) {
                    SetVericalBorder(i, countElem);
                } else if( i == 0 ){
                    countElem = SetVerticalHeaderItem(k, countElem, verticalIdentification);
                }  else if( i % 2 != 0 ){
                    fieldsMap.put(countElem, "|");
                } else if( i % 2 == 0 && i != 20 ){
                    SetFieldValue(i,k,countElem,verticalIdentification, horizontalIdentification);
                }
            }
            fieldsMap.put(countElem++, "\n");
            k++;
        }
    }

    public void ViewField(){
        String lineField = "";
        for (Map.Entry entry: fieldsMap.entrySet()) {
            lineField += entry.getValue();
        }
        System.out.println(lineField);
    }

    public void SetHeaderLine(int index_vertical, String[] horizontalIdentification, int countElem){
        if ( index_vertical == 0 || index_vertical == 1 || index_vertical == 2){
            fieldsMap.put(countElem, " ");
        }else{
            if( index_vertical % 2 != 0 ) {
                String value = horizontalIdentification[(index_vertical-3)/2];
                fieldsMap.put(countElem, value);
            }else{
                fieldsMap.put(countElem, " ");
            }
        }
    }

    public void SetVericalBorder(int index_vertical, int countElem){
        if( index_vertical == 0 || index_vertical == 1 || index_vertical == 2){
            fieldsMap.put(countElem, " ");
        }else{
            fieldsMap.put(countElem, "-");
        }
    }

    public int SetVerticalHeaderItem(int index_horizontal, int countElem, int[]verticalIdentification){
        String value = Integer.toString(verticalIdentification[(index_horizontal-2)/2]);
        if( verticalIdentification[(index_horizontal-2)/2] < 10 ){
            fieldsMap.put(countElem, " ");
            countElem++;
            fieldsMap.put(countElem, value);
        }else{
            fieldsMap.put(countElem, value);
        }
        return countElem;
    }

    public void SetFieldValue(int index_horizontal, int index_vertical,
                              int countElem, int[]verticalIdentification,
                              String[] horizontalIdentification){
        String id_cell = horizontalIdentification[(index_horizontal-2)/2] + verticalIdentification[(index_vertical-2)/2];
        fieldsMap.put((countElem), " ");
        valuesCells.put(id_cell, countElem);
    }
}

