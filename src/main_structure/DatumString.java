package main_structure;

import java.util.ArrayList;
import java.util.HashMap;

public class DatumString extends Datum{
    @Override
    public void sigmaFilter(HashMap<String, ArrayList> columnsHash, ArrayList<ArrayList> listOfLists, String column, Datum val, Datum num_indicator) {
        ArrayList<ArrayList> ret_val = new ArrayList<>();
        ArrayList col= columnsHash.get(column);
        for (int a=0;a<col.size();a++){
            if (col.get(a).toString().equalsIgnoreCase(val.toString())){
                ret_val.add(listOfLists.get(a));
            }
        }
    }
}
