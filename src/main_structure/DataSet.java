package main_structure;

public interface DataSet {
    public Expression get(String columnString, Expression expression);
    public DataSet filterRows(String columnString, Expression expression);
    public DataSet filterColumns(String columnString, Expression expression);
    public RowHashDataset toRows();
    public ColumnHashDataset toColumns();
}
