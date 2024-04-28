package main_structure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class DataSet1 {
    public HashMap<Integer, String> intOfColumn = new HashMap<>();
    public HashMap<String, Integer> String_to_Int = new HashMap<>();
    public HashMap<String, ArrayList> columnsHash = new HashMap<>(); // stores the dataset in relation to the columns //Maps Name of Column to the elements of the column
    public HashMap<Integer, ArrayList> rowsHash = new HashMap<>(); // // stores the dataset in relation to the rows //Maps Integer of row to the elements of the row

    String line = "";
    String splitBy = ",";

    public HashMap<String, ArrayList> getHash() {
        return columnsHash;
    }
    public void setIntOfColumn(HashMap<Integer, String> intOfColumn ){
        this.intOfColumn=intOfColumn;
    }
    public void setString_to_Int(HashMap<String, Integer> String_to_Int){
        this.String_to_Int=String_to_Int;
    }
    public void setRowsHash(HashMap<Integer, ArrayList> rowsHash){
        this.rowsHash=rowsHash;
    }
    public void setColumnsHash( HashMap<String , ArrayList> columnsHash){
        this.columnsHash=columnsHash;
    }

    public void DataSet(String directory) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(directory));

            line = br.readLine();
            //do u even need this part?
            if (line == null) {
                return;
            }

            String[] columns = line.split(splitBy);
            //what if there are two of the same columns?
            for (int i = 0; i < columns.length; i++) {
                intOfColumn.put(Integer.valueOf(i), columns[i]);
                String_to_Int.put(columns[i], Integer.valueOf(i));
                columnsHash.put(columns[i], new ArrayList());
            }

            line = br.readLine();
            Integer k = 0;
            while (line != null) {
                String[] rows = line.split(splitBy);
                ArrayList<Expression> new_row = new ArrayList(Arrays.asList(rows));
                rowsHash.put(k, new_row);
                for (int a = 0; a < new_row.size(); a++) {
                    //get the column's title at the current index
                    String columnString = intOfColumn.get(a);
                    //get the array mapped from the columnString & add the value at the corresponding index in the current list
                    columnsHash.get(columnString).add(new_row.get(a));
                }
                k++;
                line = br.readLine();
            }
        } catch (IOException e) {
            setIntOfColumn(new HashMap<>());
            setString_to_Int(new HashMap<>());
            setColumnsHash(new HashMap<>());
            setRowsHash(new HashMap<>());
        }
    }
    private void getRowHelper(ArrayList<Expression> column, HashSet<Integer> rowIndices, Expression expression ){
        for (int e = 0; e < column.size(); e++) {
            Expression currentExpression = column.get(e);
            if (currentExpression.equals(expression)) {
                if (!rowIndices.contains(e)){
                    rowIndices.add(e);}
            }
        }
    }
    private HashSet<Integer>getRow(String columnString, Expression expression){
        HashSet<Integer> rowIndices = new HashSet<>();
        if (columnString != null) {
            ArrayList<Expression> column = this.columnsHash.get(columnString);
            getRowHelper(column,rowIndices,expression);
        }else{
            for (String c: this.columnsHash.keySet()){
                ArrayList<Expression> column = this.columnsHash.get(c);
                getRowHelper(column,rowIndices,expression);
            }
        }
        return rowIndices;
    }
    public Expression get(String columnString, Expression expression){
        //get column
        ArrayList<Expression> column=this.columnsHash.get(columnString);
        //iterate column
        for (int e=0;e<column.size();e++){
            Expression currentExpression=column.get(e);
            if (currentExpression.equals(expression)){
                return currentExpression;
            }
        }
        return null;
    }
    public DataSet1 filter(String columnString, Expression expression) {
        DataSet1 ret_val= new DataSet1();
        HashMap<Integer, ArrayList> rowsHash = new HashMap<>();

        HashSet<Integer> rowIndices = getRow(columnString, expression);
        for (Integer i : rowIndices) {
            rowsHash.put(i, this.rowsHash.get(i));
        }
        ret_val.setRowsHash(rowsHash);
        ret_val.setColumnsHash(this.columnsHash);
        ret_val.setString_to_Int(this.String_to_Int);
        ret_val.setIntOfColumn(this.intOfColumn);
        return ret_val;
    }
    //generate another method to make rowhash and columnhash consistent
}
