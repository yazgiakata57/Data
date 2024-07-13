package main_structure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class fieldBased implements Filter{
    public static HashMap<dataType, dataType[]> fDB= new HashMap<>();
    public void setfDB(HashMap<dataType, dataType[]> fDB){
        this.fDB=fDB;
    }
    public HashMap<dataType, dataType[]> getfDB(){return this.fDB;}

    public static dataType[] COLUMNS;
    public void setCOLUMNS(dataType[] columns){
        this.COLUMNS=columns;
    }
    public static int columnNum;
    public void setColumnNum(int columnNum){
        this.columnNum=columnNum;
    }
    public int getColumnNum(){
        return this.columnNum;
    }
    public static int recordNum;
    public int getRecordNum(){
        return this.recordNum;
    }
    public void setRecordNum(int recordNum){
        this.recordNum=recordNum;
    }

    //This method recordBased DB to fieldBased DB
    //In this, it is assumed that the records do not have the columns
    public HashMap<dataType, dataType[]> recordToField(dataType[][] recordBasedDB){

        Iterator<dataType[]> rowIterator= Arrays.stream(recordBasedDB).iterator();
        int rowNum=-1;
        while (rowIterator.hasNext()){
            dataType[] row= rowIterator.next();
            rowNum++;
            for (int a=0; a<columnNum;a++){
                dataType columnInfo=COLUMNS[a];
                dataType toAdd= row[a];

                dataType[] theColumn= fDB.getOrDefault(columnInfo, new dataType[recordNum]);
                theColumn[rowNum]=toAdd;
                fDB.put(columnInfo,theColumn);
            }
        }
        return fDB;
    }


    @Override
    public DataBase filter(DataBase db, Where where) {
        HashMap<dataType, dataType[]> jj= db.fieldBasedDB.getfDB();
        dataType[][] kk= db.recordBasedDB.getMatrix();

        DataBase ret_val= new DataBase();
        ret_val.setRecordBasedDB(db.recordBasedDB);
        ret_val.setFieldBasedDB(new fieldBased());
        ret_val.fieldBasedDB.setfDB(new HashMap<>());
        ret_val.fieldBasedDB.setRecordNum(db.fieldBasedDB.getRecordNum());

        dataType[] theColumns=where.theColumns();

        HashMap<dataType, dataType[]> newDB= new HashMap<>();
        int col_num=0;
        for (dataType column:theColumns){
            col_num++;
            dataType[] theColumn= jj.getOrDefault(column,null);
            ret_val.fieldBasedDB.getfDB().put(column,theColumn);
        }
        ret_val.fieldBasedDB.setColumnNum(col_num);
        ret_val.fieldBasedDB.setCOLUMNS(theColumns);
        return ret_val;
    }
}
