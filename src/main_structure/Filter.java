package main_structure;

public interface Filter {
    public DataSet filter(DataSet DataSet, String columnString, Expression expression);
}
