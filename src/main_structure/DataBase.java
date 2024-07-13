package main_structure;

public class DataBase {
    public fieldBased fieldBasedDB;
    public recordBased recordBasedDB;
    public void setFieldBasedDB(fieldBased fDB){
        this.fieldBasedDB=fDB;
    }
    public void setRecordBasedDB(recordBased rDB){
        this.recordBasedDB=rDB;
    }
}
