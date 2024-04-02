package main_structure;

import java.util.ArrayList;
import java.util.Map;

public class DatumDouble extends Datum {
    public double epsilon = 0.0001;

    @Override
    public void sigmaFilter(int column_int, Datum val, Datum num_indicator) {
        //if num indicator>1 take the strictly greater than threshold/val
        //if num indicator 1 take the greater than or equal to threshold/val
        //if num indicator 0 take the greater than or equal to threshold/val
        //if num indicator -1 take the less than or equal to threshold/val
        //if num indicator<-1 take the strictly less than threshold/val

        ArrayList<ArrayList> ret_val = new ArrayList<>();
        double threshold = Double.parseDouble(val.toString());
        int num_indicator_int = Integer.parseInt(num_indicator.toString());

        if (num_indicator_int > 1) {
            sigmaFilterHelperStrictlyGreater(column_int, threshold, ret_val);
        } else if (num_indicator_int == 1) {
            sigmaFilterHelperGreater(column_int, threshold, ret_val);
        } else if (num_indicator_int == 0) {
            sigmaFilterHelperEqual(column_int, threshold, ret_val);
        } else if (num_indicator_int == -1) {
            sigmaFilterHelperLess(column_int, threshold, ret_val);
        } else {
            sigmaFilterHelperStrictlyLess(column_int, threshold, ret_val);
        }
        updateListOfLists(ret_val);

    }

    public void sigmaFilterHelperStrictlyGreater(String column, double threshold, ArrayList<ArrayList> ret_val) {

        for (ArrayList row : listOfLists) {
            double value = Double.parseDouble(row.get(column_int).toString());
            if (value > threshold) {
                ret_val.add(row);
            }
        }
    }

    public void sigmaFilterHelperGreater(int column_int, double threshold, ArrayList<ArrayList> ret_val) {
        for (ArrayList row : listOfLists) {
            double value = Double.parseDouble(row.get(column_int).toString());
            if (value > threshold) {
                ret_val.add(row);
            } else if (Math.abs(value - threshold) < epsilon) {
                ret_val.add(row);
            }
        }
    }

    public void sigmaFilterHelperEqual(int column_int, double threshold, ArrayList<ArrayList> ret_val) {
        for (ArrayList row : listOfLists) {
            double value = Double.parseDouble(row.get(column_int).toString());
            if (Math.abs(value - threshold) < epsilon) {
                ret_val.add(row);
            }
        }
    }

    public void sigmaFilterHelperLess(int column_int, double threshold, ArrayList<ArrayList> ret_val) {
        for (ArrayList row : listOfLists) {
            double value = Double.parseDouble(row.get(column_int).toString());
            if (value < threshold) {
                ret_val.add(row);
            } else if (Math.abs(value - threshold) < epsilon) {
                ret_val.add(row);
            }
        }
    }

    public void sigmaFilterHelperStrictlyLess(int column_int, double threshold, ArrayList<ArrayList> ret_val) {
        for (ArrayList row : listOfLists) {
            double value = Double.parseDouble(row.get(column_int).toString());
            if (value < threshold) {
                ret_val.add(row);
            }
        }
    }
}
