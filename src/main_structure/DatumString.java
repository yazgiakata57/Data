package main_structure;

import java.util.ArrayList;

public class DatumString extends Datum{
    @Override
    public void sigmaFilter(int column_int, Datum val, Datum num_indicator) {
        ArrayList<ArrayList> ret_val = new ArrayList<>();

        for (ArrayList row:listOfLists){
            if (row.get(column_int).toString().equalsIgnoreCase(val.toString())){
                ret_val.add(row);
            }
        }
        updateListOfLists(ret_val);
    }
}
