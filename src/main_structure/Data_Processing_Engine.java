package main_structure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Data_Processing_Engine {
    //method to parse the csv into list of lists

    String directory="";
    DataSet dataSet= new DataSet(directory);

    public Data_Processing_Engine() throws IOException {
    }

    //GET ATTRIBUTE
    public ArrayList projection(String attribute){
        return dataSet.getHash().get(attribute);
    }

    //integrate projection here and get started with or and stuff
    public void selection(String attribute,Condition condition ){
        ArrayList arg=projection(attribute);
        Expression ds= condition.returnType();
        ds.sigmaFilter(arg, dataSet.getLoL(), condition.val, condition.num_indicator);
    }
}