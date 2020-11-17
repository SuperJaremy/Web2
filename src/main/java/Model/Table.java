package Model;

import java.util.Objects;

public class Table {
    private static final String header="<table><thead>" +
            "<tr><th>x</th><th>y</th><th>R</th><th>Результат</th></tr></thead>";
    private String table;
    private final static String footer = "</table>";
    public Table(){
        table="";
    }

    public String getTable() {
        return header+table+footer;
    }

    public void setTable(String x, String y, String r, String res){
        table=table+"<tr><td>"+x.toString()+"</td><td>"+y.toString()+"</td><td>"
                +r.toString()+"</td><td>"+res.toString()+"</td></tr>";
    }

    @Override
    public String toString() {
        return "Table{" +
                "table='" + table + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table1 = (Table) o;
        return Objects.equals(table, table1.table);
    }

    @Override
    public int hashCode() {
        return Objects.hash(table);
    }
}
