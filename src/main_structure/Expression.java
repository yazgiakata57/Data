package main_structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Expression {
    public void Expression(){

    }
    public void getRowHelper(ArrayList<Expression> column, HashSet<Integer> rowIndices, Expression expression ){
        for (int e = 0; e < column.size(); e++) {
            Expression currentExpression = column.get(e);
            if (currentExpression.equals(expression)) {
                if (!rowIndices.contains(e)){
                    rowIndices.add(e);}
            }
        }
    }
    public HashSet<Integer>getRow(DataSet DataSet, String columnString, Expression expression){
        HashSet<Integer> rowIndices = new HashSet<>();
        if (columnString != null) {
            ArrayList<Expression> column = DataSet.columnsHash.get(columnString);
            getRowHelper(column,rowIndices,expression);
        }else{
            for (String c: DataSet.columnsHash.keySet()){
                ArrayList<Expression> column = DataSet.columnsHash.get(c);
                getRowHelper(column,rowIndices,expression);
            }
        }
        return rowIndices;
    }
    public Expression get(DataSet DataSet, String columnString, Expression expression){
        //get column
        ArrayList<Expression> column=DataSet.columnsHash.get(columnString);
        //iterate column
        for (int e=0;e<column.size();e++){
            Expression currentExpression=column.get(e);
            if (currentExpression.equals(expression)){
                return currentExpression;
            }
        }
        return null;
    }

    public DataSet filter(DataSet DataSet, String columnString, Expression expression) {
        DataSet ret_val= new DataSet();
        HashMap<Integer, ArrayList> rowsHash = new HashMap<>();

        HashSet<Integer> rowIndices = getRow(DataSet, columnString, expression);
        for (Integer i : rowIndices) {
            rowsHash.put(i, DataSet.rowsHash.get(i));
        }
        ret_val.setRowsHash(rowsHash);
        ret_val.setColumnsHash(DataSet.columnsHash);
        ret_val.setString_to_Int(DataSet.String_to_Int);
        ret_val.setIntOfColumn(DataSet.intOfColumn);
        return ret_val;
    }


}
