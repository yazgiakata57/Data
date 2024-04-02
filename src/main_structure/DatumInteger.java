package main_structure;

import java.util.ArrayList;

public class DatumInteger extends Datum{
    @Override
    public void sigmaFilter(int column_int, Datum val, Datum num_indicator) {
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
            piFilterHelperStrictlyGreater(column_int, threshold, ret_val);
        } else if (num_indicator_int == 1) {
            piFilterHelperGreater(column_int, threshold, ret_val);
        } else if (num_indicator_int == 0) {
            piFilterHelperEqual(column_int, threshold, ret_val);
        } else if (num_indicator_int == -1) {
            piFilterHelperLess(column_int, threshold, ret_val);
        } else {
            piFilterHelperStrictlyLess(column_int, threshold, ret_val);
        }
        updateListOfLists(ret_val);
    }

    public void piFilterHelperStrictlyGreater(int column_int, int threshold, ArrayList<ArrayList> ret_val) {
        for (ArrayList row : listOfLists) {
            int value = Integer.parseInt(row.get(column_int).toString());
            if (value > threshold) {
                ret_val.add(row);
            }
        }
    }

    public void piFilterHelperGreater(int column_int, int threshold, ArrayList<ArrayList> ret_val) {
        for (ArrayList row : listOfLists) {
            int value = Integer.parseInt(row.get(column_int).toString());
            if (value >= threshold) {
                ret_val.add(row);
            }
        }
    }

    public void piFilterHelperEqual(int column_int, int threshold, ArrayList<ArrayList> ret_val) {
        for (ArrayList row : listOfLists) {
            int value = Integer.parseInt(row.get(column_int).toString());
            if (value == threshold) {
                ret_val.add(row);
            }
        }
    }

    public void piFilterHelperLess(int column_int, double threshold, ArrayList<ArrayList> ret_val) {
        for (ArrayList row : listOfLists) {
            int value = Integer.parseInt(row.get(column_int).toString());
            if (value <= threshold) {
                ret_val.add(row);
            }
        }
    }

    public void piFilterHelperStrictlyLess(int column_int, double threshold, ArrayList<ArrayList> ret_val) {
        for (ArrayList row : listOfLists) {
            int value = Integer.parseInt(row.get(column_int).toString());
            if (value < threshold) {
                ret_val.add(row);
            }
        }
    }
}
