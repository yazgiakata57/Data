package main_structure;

public class Condition {

    public int DATUM_DOUBLE=0;
    public int DATUM_INTEGER=1;
    public int DATUM_STRING=2;
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
