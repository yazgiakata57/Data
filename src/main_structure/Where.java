package main_structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Where {
    public static dataType[] COLUMNS;
    public void setCOLUMNS(dataType[] columns){
        this.COLUMNS=columns;
    }
    public dataType[] theColumns(){return this.COLUMNS;}

    public static Condition[] CONDITIONS;
    public void setCONDITIONS(Condition[] conditions){
        this.CONDITIONS=conditions;
    }
    public void Where(){

    }
}
