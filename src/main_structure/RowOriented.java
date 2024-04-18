package main_structure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class RowOriented extends DataSet{
    @Override
    public void filter(String attribute,Condition condition) {
        ArrayList arg=this.getHash().get(attribute);
        Expression ds= condition.returnType();
        ds.sigmaFilter(arg, this.getLoL(), condition.val, condition.num_indicator);
    }
}
