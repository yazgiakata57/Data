package main_structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DatumDouble extends Expression {
    public double epsilon = 0.0001;

    @Override
    public void sigmaFilter(ArrayList arg, ArrayList<ArrayList> listOfLists, Expression val, Expression num_indicator) {
        //if num indicator>1 take the strictly greater than threshold/val
        //if num indicator 1 take the greater than or equal to threshold/val
        //if num indicator 0 take the greater than or equal to threshold/val
        //if num indicator -1 take the less than or equal to threshold/val
        //if num indicator<-1 take the strictly less than threshold/val

        ArrayList<ArrayList> ret_val = new ArrayList<>();
        double threshold = Double.parseDouble(val.toString());
        int num_indicator_int = Integer.parseInt(num_indicator.toString());

        if (num_indicator_int > 1) {
            sigmaFilterHelperStrictlyGreater( arg, listOfLists, threshold);
        } else if (num_indicator_int == 1) {
            sigmaFilterHelperGreater(arg, listOfLists, threshold);
        } else if (num_indicator_int == 0) {
            sigmaFilterHelperEqual(arg, listOfLists, threshold);
        } else if (num_indicator_int == -1) {
            sigmaFilterHelperLess(arg, listOfLists, threshold);
        } else {
            sigmaFilterHelperStrictlyLess(arg, listOfLists, threshold);
        }

    }
    // arg would be the column of the attributes
    public void sigmaFilterHelperStrictlyGreater(ArrayList arg, ArrayList<ArrayList> listOfLists, double threshold) {
        ArrayList<ArrayList> ret_val= new ArrayList<>();
        //get the specific column
        for (int a=0; a<arg.size();a++) {
            Double value= (Double) arg.get(a);
            if (value > threshold) {
                ret_val.add(listOfLists.get(a));
            }
        }
    }

    public void sigmaFilterHelperGreater(ArrayList arg, ArrayList<ArrayList> listOfLists, double threshold) {
        ArrayList<ArrayList> ret_val= new ArrayList<>();
        //get the specific column
        for (int a=0; a<arg.size();a++) {
            Double value= (Double) arg.get(a);
            if (value > threshold) {
                ret_val.add(listOfLists.get(a));
            }else if(Math.abs(value-threshold)<epsilon){
                ret_val.add(listOfLists.get(a));
            }
    }
    }

    public void sigmaFilterHelperEqual(ArrayList arg, ArrayList<ArrayList> listOfLists, double threshold) {
        ArrayList<ArrayList> ret_val= new ArrayList<>();
        //get the specific column
        for (int a=0; a<arg.size();a++) {
            Double value= (Double) arg.get(a);
            if(Math.abs(value-threshold)<epsilon){
                ret_val.add(listOfLists.get(a));
            }
        }
    }

    public void sigmaFilterHelperLess(ArrayList arg, ArrayList<ArrayList> listOfLists, double threshold) {
        ArrayList<ArrayList> ret_val= new ArrayList<>();
        //get the specific column
        for (int a=0; a<arg.size();a++) {
            Double value= (Double) arg.get(a);
            if (value < threshold) {
                ret_val.add(listOfLists.get(a));
            }else if(Math.abs(value-threshold)<epsilon){
                ret_val.add(listOfLists.get(a));
            }
        }
    }

    public void sigmaFilterHelperStrictlyLess(ArrayList arg, ArrayList<ArrayList> listOfLists,  double threshold) {
        ArrayList<ArrayList> ret_val= new ArrayList<>();
        //get the specific column
        for (int a=0; a<arg.size();a++) {
            Double value= (Double) arg.get(a);
            if (value < threshold) {
                ret_val.add(listOfLists.get(a));
            }
        }
    }
}
