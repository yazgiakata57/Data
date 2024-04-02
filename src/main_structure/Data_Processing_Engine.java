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
    public void selection(String attribute ){
    }

//    public void piMainFilter(Datum column, Datum val, int datum_type ){
//        int column_int=0;
//        //if you are filtering by the string in the given column
//        if (datum_type==0){
//            DatumString data_edited= new DatumString();
//            data_edited.updateListOfLists(listOfLists);
//            data_edited.sigmaFilter(column_int,val,new Datum());
//        }
//    }

    //how do we apply this for integers or doubles//TYPEESSSSSS
    //DO TYPECASTING FOR THIS
//    public ArrayList<ArrayList> piStrFilter(String column, String val){
//        ArrayList<ArrayList> ret_val = new ArrayList<>();
//        Integer column_int= intOfColumn.get(column);
//
//        for (ArrayList row:listOfLists){
//            if (row.get(column_int).toString().equalsIgnoreCase(val)){
//                ret_val.add(row);
//            }
//        }
//        return ret_val;
//    }
//    public ArrayList<ArrayList> sigma(String column){
//        ArrayList<ArrayList> ret_val = new ArrayList<>();
//        Integer column_int= intOfColumn.get(column);
//
//        for (ArrayList row:listOfLists){
//            ret_val.add((ArrayList)row.get(column_int));
//        }
//        return ret_val;
//    }
}