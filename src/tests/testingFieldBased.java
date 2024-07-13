package tests;
import main_structure.*;
import org.junit.Test;

import java.util.HashMap;

public class testingFieldBased{
    @Test
    public void testOne(){
        dataType a= new dataType();
        a.setDataTypeInt(1);
        dataType b= new dataType();
        b.setDataTypeInt(2);
        dataType c= new dataType();
        c.setDataTypeInt(3);

        dataType d= new dataType();
        d.setDataTypeInt(4);
        dataType e= new dataType();
        e.setDataTypeInt(5);
        dataType f= new dataType();
        f.setDataTypeInt(6);

        dataType g= new dataType();
        g.setDataTypeInt(7);
        dataType h= new dataType();
        h.setDataTypeInt(8);
        dataType i= new dataType();
        i.setDataTypeInt(9);

        dataType[] row1= new dataType[3];
        dataType[] row2= new dataType[3];
        dataType[] row3= new dataType[3];

        row1[0]=a;
        row1[1]=b;
        row1[2]=c;

        row2[0]=d;
        row2[1]=e;
        row2[2]=f;

        row3[0]=g;
        row3[1]=h;
        row3[2]=i;

        dataType[][] theMatrix= new dataType[3][3];
        theMatrix[0]= row1;
        theMatrix[1]=row2;
        theMatrix[2]=row3;



        dataType field1= new dataType();
        field1.setDataTypeString("Column 1");
        dataType field2= new dataType();
        field2.setDataTypeString("Column 2");
        dataType field3= new dataType();
        field3.setDataTypeString("Column 3");

        dataType[] columns= new dataType[3];
        columns[0]=field1;
        columns[1]=field2;
        columns[2]=field3;

        fieldBased fieldBasedDB = new fieldBased();
        fieldBasedDB.setCOLUMNS(columns);
        fieldBasedDB.setColumnNum(3);
        fieldBasedDB.setRecordNum(3);

        HashMap<dataType, dataType[]> ret_val= fieldBasedDB.recordToField(theMatrix);

        System.out.println("all done!");
    }
    @Test
    public void testOneTwo(){
        DataBase db= new DataBase();
        db.setRecordBasedDB(new recordBased());
        db.setFieldBasedDB(new fieldBased());

        dataType a= new dataType();
        a.setDataTypeInt(1);
        dataType b= new dataType();
        b.setDataTypeInt(2);
        dataType c= new dataType();
        c.setDataTypeInt(3);

        dataType d= new dataType();
        d.setDataTypeInt(4);
        dataType e= new dataType();
        e.setDataTypeInt(5);
        dataType f= new dataType();
        f.setDataTypeInt(6);

        dataType g= new dataType();
        g.setDataTypeInt(7);
        dataType h= new dataType();
        h.setDataTypeInt(8);
        dataType i= new dataType();
        i.setDataTypeInt(9);

        dataType[] row1= new dataType[3];
        dataType[] row2= new dataType[3];
        dataType[] row3= new dataType[3];

        row1[0]=a;
        row1[1]=b;
        row1[2]=c;

        row2[0]=d;
        row2[1]=e;
        row2[2]=f;

        row3[0]=g;
        row3[1]=h;
        row3[2]=i;

        dataType[][] theMatrix= new dataType[3][3];
        theMatrix[0]= row1;
        theMatrix[1]=row2;
        theMatrix[2]=row3;

        db.recordBasedDB.setMatrix(theMatrix);
        db.recordBasedDB.setRecordNum(3);
        db.recordBasedDB.setColumnNum(3);
        //dataType[][] kk=db.recordBasedDB.getMatrix();

        dataType field1= new dataType();
        field1.setDataTypeString("Column 1");
        dataType field2= new dataType();
        field2.setDataTypeString("Column 2");
        dataType field3= new dataType();
        field3.setDataTypeString("Column 3");

        dataType[] columns= new dataType[3];
        columns[0]=field1;
        columns[1]=field2;
        columns[2]=field3;

        db.recordBasedDB.setCOLUMNS(columns);
        db.fieldBasedDB.setCOLUMNS(columns);
        db.fieldBasedDB.setColumnNum(3);
        db.fieldBasedDB.setRecordNum(3);
        db.fieldBasedDB.setfDB(db.fieldBasedDB.recordToField(db.recordBasedDB.getMatrix()));

        HashMap<dataType, dataType[]> jj= db.fieldBasedDB.getfDB();
        dataType[][] kk= db.recordBasedDB.getMatrix();

        Where where= new Where();
        dataType[] newColumns= new dataType[2];
        newColumns[0]=columns[0];
        newColumns[1]=columns[1];
        where.setCOLUMNS(newColumns);

        DataBase filtered=db.fieldBasedDB.filter(db,where);
        db=filtered;
        HashMap<dataType, dataType[]> mm= db.fieldBasedDB.getfDB();
        db.recordBasedDB.setRecordNum(3);
        db.recordBasedDB.setColumnNum(2);
        dataType[][] nn=db.recordBasedDB.fieldToRecord(mm);
        dataType[][] ll= db.recordBasedDB.getMatrix();
       // db.recordBasedDB.setMatrix(db.recordBasedDB.fieldToRecord(db.fieldBasedDB.getfDB()));
        //update the record num and column num


        System.out.println("all done!");
    }

}
