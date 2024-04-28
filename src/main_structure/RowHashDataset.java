package main_structure;

import java.util.ArrayList;
import java.util.HashMap;

public class RowHashDataset implements DataSet{
    public HashMap<Integer, ArrayList> rowsHash;

    public RowHashDataset(HashMap<Integer, ArrayList> rowsHash) {
        this.rowsHash=rowsHash;
    }

    @Override
    public Expression get(String columnString, Expression expression) {
        return null;
    }

    @Override
    public DataSet filterRows(String columnString, Expression expression) {
        return null;
    }

    @Override
    public DataSet filterColumns(String columnString) {
        return null;
    }

    @Override
    public RowHashDataset toRows(HashMap<String, ArrayList> columnsHash, HashMap<String, Integer> String_to_Int) {
        return this;
    }

    @Override
    public ColumnHashDataset toColumns(HashMap<Integer, String> intOfColumn, HashMap<Integer, ArrayList> rowsHash) {
        //HashMap<Integer, String> intOfColumn = new HashMap<>();
        HashMap<String, ArrayList> columnsHash = new HashMap<>(); // stores the dataset in relation to the columns //Maps Name of Column to the elements of the column
        //HashMap<Integer, ArrayList> rowsHash = new HashMap<>();

        for (Integer rowInteger=0; rowInteger<rowsHash.size();rowInteger++){
            ArrayList<Expression> row=rowsHash.get(rowInteger);
            for (int columnInteger=0; columnInteger<row.size();columnInteger++){
                String columnString= intOfColumn.get(columnInteger);
                Expression element= row.get(columnInteger);

                ArrayList<Expression> currentColumn=columnsHash.getOrDefault(columnString,new ArrayList<>());
                currentColumn.add(element);
                columnsHash.put(columnString,currentColumn);
            }
        }
        ColumnHashDataset columnBasedRep= new ColumnHashDataset(columnsHash);
        return columnBasedRep;
    }
}
