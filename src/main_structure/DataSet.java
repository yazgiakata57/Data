package main_structure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DataSet {
    public HashMap<Integer, String> intOfColumn = new HashMap<>();
    public HashMap<String, Integer> String_to_Int = new HashMap<>();
    public HashMap<String, ArrayList> columnsHash = new HashMap<>();
    public HashMap<Integer, ArrayList> rowsHash = new HashMap<>();

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
}
