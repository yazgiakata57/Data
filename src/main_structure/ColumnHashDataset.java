package main_structure;

public class ColumnHashDataset implements DataSet{
    @Override
    public Expression get(String columnString, Expression expression) {
        return null;
    }

    @Override
    public DataSet filterRows(String columnString, Expression expression) {
        return null;
    }

    @Override
    public DataSet filterColumns(String columnString, Expression expression) {
        return null;
    }

    @Override
    public RowHashDataset toRows() {
        return null;
    }

    @Override
    public ColumnHashDataset toColumns() {
        return null;
    }
}
