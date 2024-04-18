package main_structure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DataSet {
    public ArrayList<ArrayList> listOfLists = new ArrayList<>();
    public HashMap<Integer, String> intOfColumn = new HashMap<>();
    public HashMap<String, ArrayList> columnsHash = new HashMap<>();
    String line = "";
    String splitBy = ",";

    public DataSet(String directory) throws IOException {
        readFile(directory);
    }
    public ArrayList<ArrayList> getLoL() {
        return listOfLists;
    }
    public HashMap<String, ArrayList> getHash() {
        return columnsHash;
    }

    //STRESS TEST THIS METHOD THO
    public void readFile(String directory) throws IOException {
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
                intOfColumn.put(Integer.valueOf(i),columns[i]);
                columnsHash.put(columns[i],new ArrayList());
            }

            line = br.readLine();
            while (line != null) {
                String[] rows = line.split(splitBy);
                ArrayList<Expression> new_row= new ArrayList(Arrays.asList(rows));
                listOfLists.add(new_row);
                for (int a=0; a<new_row.size();a++){
                    //get the column's title at the current index
                    String columnString=intOfColumn.get(a);
                    //get the array mapped from the columnString & add the value at the corresponding index in the current list
                    columnsHash.get(columnString).add(new_row.get(a));
                }
                line = br.readLine();
            }
        } catch (IOException e) {

        }
    }

}
