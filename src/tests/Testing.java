package tests;

import main_structure.Data_Processing_Engine;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class Testing {
    @Test
    public void test1() throws IOException {
        String filename = "csv_files/industry.csv";
        Data_Processing_Engine dpe=new Data_Processing_Engine();
        dpe.readFile(filename);
        ArrayList<ArrayList> ret_val=dpe.getListOfLists();
        System.out.println(ret_val);
    }
    @Test
    public void test2() throws IOException {
        String filename = "csv_files/state_us.csv";
        Data_Processing_Engine dpe=new Data_Processing_Engine();
        dpe.readFile(filename);
        ArrayList<ArrayList> ret_val=dpe.getListOfLists();
        System.out.println(ret_val);
    }
}
