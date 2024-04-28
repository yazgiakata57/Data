package main_structure;

import java.util.ArrayList;
import java.util.HashMap;

public interface DataSet {
    public Expression get(String columnString, Expression expression);
    public DataSet filterRows(String columnString, Expression expression);
    public DataSet filterColumns(String columnString);
    public RowHashDataset toRows(HashMap<String, ArrayList> columnsHash, HashMap<String, Integer> String_to_Int); //column implementation to row implementation
    public ColumnHashDataset toColumns(HashMap<Integer, String> intOfColumn, HashMap<Integer, ArrayList> rowsHash);//row implementation to column implementation
}
