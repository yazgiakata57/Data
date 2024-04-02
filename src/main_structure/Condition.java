package main_structure;

public class Condition {
    //by putting static create one of each global variable among all instances of Condition, makes it a global variable
    public static int DATUM_DOUBLE=0;
    public static int DATUM_INTEGER=1;
    public static int DATUM_STRING=2;
    public int data_type;
    public Datum val;
    public Datum num_indicator;

    Condition(int data_type, Datum val, Datum num_indicator){
        this.data_type= data_type;
        this.val=val;
        this.num_indicator=num_indicator;
    }
    public Datum returnType(){
        if (this.data_type==DATUM_DOUBLE){
            return new DatumDouble();
        }else if (this.data_type==DATUM_INTEGER){
            return new DatumInteger();
        }else if (this.data_type==DATUM_STRING){
            return new DatumString();
        }
        return new Datum();
    }
}
