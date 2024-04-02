package main_structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DatumDouble extends Datum {
    public double epsilon = 0.0001;

    @Override
    public void sigmaFilter(HashMap<String, ArrayList> columnsHash, ArrayList<ArrayList> listOfLists, String column, Datum val, Datum num_indicator) {
        //if num indicator>1 take the strictly greater than threshold/val
        //if num indicator 1 take the greater than or equal to threshold/val
        //if num indicator 0 take the greater than or equal to threshold/val
        //if num indicator -1 take the less than or equal to threshold/val
        //if num indicator<-1 take the strictly less than threshold/val

        ArrayList<ArrayList> ret_val = new ArrayList<>();
        double threshold = Double.parseDouble(val.toString());
        int num_indicator_int = Integer.parseInt(num_indicator.toString());

        if (num_indicator_int > 1) {
            sigmaFilterHelperStrictlyGreater( columnsHash, listOfLists, column, threshold);
        } else if (num_indicator_int == 1) {
            sigmaFilterHelperGreater(columnsHash, listOfLists, column, threshold);
        } else if (num_indicator_int == 0) {
            sigmaFilterHelperEqual(columnsHash, listOfLists, column, threshold);
        } else if (num_indicator_int == -1) {
            sigmaFilterHelperLess(columnsHash, listOfLists, column, threshold);
        } else {
            sigmaFilterHelperStrictlyLess(columnsHash, listOfLists, column, threshold);
        }

    }
    public void sigmaFilterHelperStrictlyGreater(HashMap<String, ArrayList> columnsHash, ArrayList<ArrayList> listOfLists, String column, double threshold) {
        ArrayList<ArrayList> ret_val= new ArrayList<>();
        //get the specific column
        ArrayList<Double> values = columnsHash.get(column);
        for (int a=0; a<values.size();a++) {
            Double value= values.get(a);
            if (value > threshold) {
                ret_val.add(listOfLists.get(a));
            }
        }
    }

    public void sigmaFilterHelperGreater(HashMap<String, ArrayList> columnsHash, ArrayList<ArrayList> listOfLists, String column, double threshold) {
        ArrayList<ArrayList> ret_val= new ArrayList<>();
        //get the specific column
        ArrayList<Double> values = columnsHash.get(column);
        for (int a=0; a<values.size();a++) {
            Double value= values.get(a);
            if (value > threshold) {
                ret_val.add(listOfLists.get(a));
            }else if(Math.abs(value-threshold)<epsilon){
                ret_val.add(listOfLists.get(a));
            }
    }
    }

    public void sigmaFilterHelperEqual(HashMap<String, ArrayList> columnsHash, ArrayList<ArrayList> listOfLists, String column, double threshold) {
        ArrayList<ArrayList> ret_val= new ArrayList<>();
        //get the specific column
        ArrayList<Double> values = columnsHash.get(column);
        for (int a=0; a<values.size();a++) {
            Double value= values.get(a);
            if(Math.abs(value-threshold)<epsilon){
                ret_val.add(listOfLists.get(a));
            }
        }
    }

    public void sigmaFilterHelperLess(HashMap<String, ArrayList> columnsHash, ArrayList<ArrayList> listOfLists, String column, double threshold) {
        ArrayList<ArrayList> ret_val= new ArrayList<>();
        //get the specific column
        ArrayList<Double> values = columnsHash.get(column);
        for (int a=0; a<values.size();a++) {
            Double value= values.get(a);
            if (value < threshold) {
                ret_val.add(listOfLists.get(a));
            }else if(Math.abs(value-threshold)<epsilon){
                ret_val.add(listOfLists.get(a));
            }
        }
    }

    public void sigmaFilterHelperStrictlyLess(HashMap<String, ArrayList> columnsHash, ArrayList<ArrayList> listOfLists, String column, double threshold) {
        ArrayList<ArrayList> ret_val= new ArrayList<>();
        //get the specific column
        ArrayList<Double> values = columnsHash.get(column);
        for (int a=0; a<values.size();a++) {
            Double value= values.get(a);
            if (value < threshold) {
                ret_val.add(listOfLists.get(a));
            }
        }
    }
}
