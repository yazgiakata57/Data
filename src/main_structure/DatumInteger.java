package main_structure;

import java.util.ArrayList;
import java.util.HashMap;

public class DatumInteger extends Datum{
    @Override
    public void sigmaFilter(HashMap<String, ArrayList> columnsHash, ArrayList<ArrayList> listOfLists, String column, Datum val, Datum num_indicator) {
        //if num indicator>1 take the strictly greater than threshold/val
        //if num indicator 1 take the greater than or equal to threshold/val
        //if num indicator 0 take equal to threshold/val
        //if num indicator -1 take the less than or equal to threshold/val
        //if num indicator<-1 take the strictly less than threshold/val

        //MULTIPLE COLUMNS

        //THREE PARTS:
        //-GET ATTRIBUTE FROM THE ROW
        //-PERFORM COMPARISON
        //-FILTER INPUT DATA


        // FUNCTION: TAKES IN ROW RETURNS BOOLEAN (FILTER IT OR KEEP IT)


        ArrayList<ArrayList> ret_val = new ArrayList<>();
        int threshold = Integer.parseInt(val.toString());
        int num_indicator_int = Integer.parseInt(num_indicator.toString());

        if (num_indicator_int > 1) {
            sigmaFilterHelperStrictlyGreater(columnsHash,listOfLists, column, threshold);
        } else if (num_indicator_int == 1) {
            sigmaFilterHelperGreater(columnsHash,listOfLists, column, threshold);
        } else if (num_indicator_int == 0) {
            sigmaFilterHelperEqual(columnsHash,listOfLists, column, threshold);
        } else if (num_indicator_int == -1) {
            sigmaFilterHelperLess(columnsHash,listOfLists, column, threshold);
        } else {
            sigmaFilterHelperStrictlyLess(columnsHash,listOfLists, column, threshold);
        }
    }

    public void sigmaFilterHelperStrictlyGreater(HashMap<String, ArrayList> columnsHash, ArrayList<ArrayList> listOfLists, String column, int threshold) {
        ArrayList col= columnsHash.get(column);
        ArrayList<ArrayList> ret_val= new ArrayList<>();
        for (int a=0;a< col.size();a++){
            int value = Integer.parseInt(col.get(a).toString());
            if (value > threshold) {
                ret_val.add(listOfLists.get(a));
            }
        }
    }

    public void sigmaFilterHelperGreater(HashMap<String, ArrayList> columnsHash, ArrayList<ArrayList> listOfLists, String column, int threshold) {
        ArrayList col= columnsHash.get(column);
        ArrayList<ArrayList> ret_val= new ArrayList<>();
        for (int a=0;a< col.size();a++){
            int value = Integer.parseInt(col.get(a).toString());
            if (value >=threshold) {
                ret_val.add(listOfLists.get(a));
            }
        }
    }

    public void sigmaFilterHelperEqual(HashMap<String, ArrayList> columnsHash, ArrayList<ArrayList> listOfLists, String column, int threshold) {
        ArrayList col= columnsHash.get(column);
        ArrayList<ArrayList> ret_val= new ArrayList<>();
        for (int a=0;a< col.size();a++){
            int value = Integer.parseInt(col.get(a).toString());
            if (value == threshold) {
                ret_val.add(listOfLists.get(a));
            }
        }
    }

    public void sigmaFilterHelperLess(HashMap<String, ArrayList> columnsHash, ArrayList<ArrayList> listOfLists, String column, int threshold) {
        ArrayList col= columnsHash.get(column);
        ArrayList<ArrayList> ret_val= new ArrayList<>();
        for (int a=0;a< col.size();a++){
            int value = Integer.parseInt(col.get(a).toString());
            if (value <= threshold) {
                ret_val.add(listOfLists.get(a));
            }
        }
    }

    public void sigmaFilterHelperStrictlyLess(HashMap<String, ArrayList> columnsHash, ArrayList<ArrayList> listOfLists, String column, int threshold) {
        ArrayList col= columnsHash.get(column);
        ArrayList<ArrayList> ret_val= new ArrayList<>();
        for (int a=0;a< col.size();a++){
            int value = Integer.parseInt(col.get(a).toString());
            if (value < threshold) {
                ret_val.add(listOfLists.get(a));
            }
        }
    }
}
