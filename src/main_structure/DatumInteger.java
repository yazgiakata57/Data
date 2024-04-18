package main_structure;

import java.util.ArrayList;
import java.util.HashMap;

public class DatumInteger extends Expression{
    @Override
    public void sigmaFilter(ArrayList arg, ArrayList<ArrayList> listOfLists, Expression val, Expression num_indicator) {
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
            sigmaFilterHelperStrictlyGreater(arg,listOfLists, threshold);
        } else if (num_indicator_int == 1) {
            sigmaFilterHelperGreater(arg,listOfLists, threshold);
        } else if (num_indicator_int == 0) {
            sigmaFilterHelperEqual(arg,listOfLists, threshold);
        } else if (num_indicator_int == -1) {
            sigmaFilterHelperLess(arg,listOfLists, threshold);
        } else {
            sigmaFilterHelperStrictlyLess(arg,listOfLists, threshold);
        }
    }

    public void sigmaFilterHelperStrictlyGreater(ArrayList arg, ArrayList<ArrayList> listOfLists,int threshold) {
        ArrayList<ArrayList> ret_val= new ArrayList<>();
        for (int a=0;a< arg.size();a++){
            int value = Integer.parseInt(arg.get(a).toString());
            if (value > threshold) {
                ret_val.add(listOfLists.get(a));
            }
        }
    }

    public void sigmaFilterHelperGreater(ArrayList arg, ArrayList<ArrayList> listOfLists, int threshold) {
        ArrayList<ArrayList> ret_val= new ArrayList<>();
        for (int a=0;a< arg.size();a++){
            int value = Integer.parseInt(arg.get(a).toString());
            if (value >=threshold) {
                ret_val.add(listOfLists.get(a));
            }
        }
    }

    public void sigmaFilterHelperEqual(ArrayList arg, ArrayList<ArrayList> listOfLists, int threshold) {
        ArrayList<ArrayList> ret_val= new ArrayList<>();
        for (int a=0;a< arg.size();a++){
            int value = Integer.parseInt(arg.get(a).toString());
            if (value == threshold) {
                ret_val.add(listOfLists.get(a));
            }
        }
    }

    public void sigmaFilterHelperLess(ArrayList arg, ArrayList<ArrayList> listOfLists, int threshold) {
        ArrayList<ArrayList> ret_val= new ArrayList<>();
        for (int a=0;a< arg.size();a++){
            int value = Integer.parseInt(arg.get(a).toString());
            if (value <= threshold) {
                ret_val.add(listOfLists.get(a));
            }
        }
    }

    public void sigmaFilterHelperStrictlyLess(ArrayList arg, ArrayList<ArrayList> listOfLists, int threshold) {
        ArrayList<ArrayList> ret_val= new ArrayList<>();
        for (int a=0;a< arg.size();a++){
            int value = Integer.parseInt(arg.get(a).toString());
            if (value < threshold) {
                ret_val.add(listOfLists.get(a));
            }
        }
    }
}
