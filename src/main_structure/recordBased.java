package main_structure;

import java.util.HashMap;
import java.util.Iterator;

public class recordBased {
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
    //This method fieldBased DB to recordBased DB
    //In this, it is assumed that the records do not have the columns
    public dataType[][] fieldToRecord(HashMap<dataType, dataType[]> fieldBasedDB){

        dataType[][] recordBasedDB= new dataType[recordNum][columnNum];

        for (int a=0; a< columnNum;a++){
            dataType columnName= COLUMNS[a];
            dataType[] column= fieldBasedDB.getOrDefault(columnName,null);
            for (int b=0; b<recordNum; b++) {
                recordBasedDB[a][b] = column[b];
            }
        }
        return recordBasedDB;
    }
}
