package main_structure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Data_Processing_Engine {
    //method to parse the csv into list of lists
    ArrayList<ArrayList> listOfLists = new ArrayList<>();
    HashMap<String, Integer> intOfColumn = new HashMap<>();
    String line = "";
    String splitBy = ",";

    public ArrayList<ArrayList> getListOfLists() {
        return listOfLists;
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
                intOfColumn.put(columns[i], Integer.valueOf(i));
            }

            line = br.readLine();
            while (line != null) {
                String[] rows = line.split(splitBy);

                ArrayList<String> new_row= new ArrayList(Arrays.asList(rows));
                listOfLists.add(new_row);
                line = br.readLine();
            }
        } catch (IOException e) {

        }
    }


    //how do we apply this for integers or doubles//TYPEESSSSSS
    public ArrayList<ArrayList> piStrFilter(String column, String val){
        ArrayList<ArrayList> ret_val = new ArrayList<>();
        Integer column_int= intOfColumn.get(column);

        for (ArrayList row:listOfLists){
            if (row.get(column_int).toString().equalsIgnoreCase(val)){
                ret_val.add(row);
            }
        }
        return ret_val;
    }
    public ArrayList<ArrayList> sigma(String column){
        ArrayList<ArrayList> ret_val = new ArrayList<>();
        Integer column_int= intOfColumn.get(column);

        for (ArrayList row:listOfLists){
            ret_val.add((ArrayList)row.get(column_int));
        }
        return ret_val;
    }
}