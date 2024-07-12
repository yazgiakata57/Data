package main_structure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class fieldBased{
    public static dataType[] COLUMNS;
    public void setCOLUMNS(dataType[] columns){
        this.COLUMNS=columns;
    }
    public static int columnNum;
    public void setColumnNum(int columnNum){
        this.columnNum=columnNum;
    }
    public static int recordNum;
    public void setRecordNum(int recordNum){
        this.recordNum=recordNum;
    }

    //This method recordBased DB to fieldBased DB
    //In this, it is assumed that the records do not have the columns
    public HashMap<dataType, dataType[]> recordToField(dataType[][] recordBasedDB){
        HashMap<dataType, dataType[]> ret_val= new HashMap<>();

        Iterator<dataType[]> rowIterator= Arrays.stream(recordBasedDB).iterator();
        int rowNum=-1;
        while (rowIterator.hasNext()){
            dataType[] row= rowIterator.next();
            rowNum++;
            for (int a=0; a<columnNum;a++){
                dataType columnInfo=COLUMNS[a];
                dataType toAdd= row[a];

                dataType[] theColumn= ret_val.getOrDefault(columnInfo, new dataType[recordNum]);
                theColumn[rowNum]=toAdd;
                ret_val.put(columnInfo,theColumn);
            }
        }
        return ret_val;
    }
}
