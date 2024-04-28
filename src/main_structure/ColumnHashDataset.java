package main_structure;

import java.util.ArrayList;
import java.util.HashMap;

public class ColumnHashDataset implements DataSet{
    public HashMap<String, ArrayList> columnHash;

    public ColumnHashDataset(HashMap<String, ArrayList> columnHash) {
        this.columnHash=columnHash;
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
        HashMap<Integer, ArrayList> rowsHash = new HashMap<>();

        for (String columnString: columnHash.keySet()){
            Integer columnInteger=String_to_Int.get(columnString);
            ArrayList<Expression> column= columnsHash.get(columnString);

            for (Integer rowInteger=0;rowInteger<column.size();rowInteger++){
                Expression element= column.get(rowInteger);

                ArrayList<Expression> row=rowsHash.getOrDefault(rowInteger, new ArrayList<>());
                row.add(columnInteger,element);
                rowsHash.put(rowInteger,row);
            }

        }
        RowHashDataset rowBasedRep=new RowHashDataset(rowsHash) ;
        return rowBasedRep;
    }

    @Override
    public ColumnHashDataset toColumns(HashMap<Integer, String> intOfColumn, HashMap<Integer, ArrayList> rowsHash) {
        return this;
    }
}
