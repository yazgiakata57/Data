package main_structure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Data_Processing_Engine {
    //method to parse the csv into list of lists
    public ArrayList<ArrayList> listOfLists = new ArrayList<>();
    public HashMap<Integer, String> intOfColumn = new HashMap<>();
    public HashMap<String, ArrayList> columnsHash = new HashMap<>();
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
                intOfColumn.put(Integer.valueOf(i),columns[i]);
                columnsHash.put(columns[i],new ArrayList());
            }

            line = br.readLine();
            while (line != null) {
                String[] rows = line.split(splitBy);
                ArrayList<Datum> new_row= new ArrayList(Arrays.asList(rows));
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
    //GET ATTRIBUTE
    public ArrayList projection(String attribute){
        return columnsHash.get(attribute);
    }
    //integrate projection here and get started with or and stuff
    public void selection(String attribute,Condition condition ){
        ArrayList arg=projection(attribute);
        Datum ds= condition.returnType();
        ds.sigmaFilter(arg, listOfLists, condition.val, condition.num_indicator);
    }
}