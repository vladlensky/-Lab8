import classes.NormalHuman;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
public class CollectTable extends AbstractTableModel{
    private static String col1=ResourceBundle.getBundle("Locale", Interface.getLocale()).getString("Name");
    private static String col2=ResourceBundle.getBundle("Locale", Interface.getLocale()).getString("Age");
    private static String col3=ResourceBundle.getBundle("Locale", Interface.getLocale()).getString("TroublesWithTheLaw");
    private Locale l = Interface.getLocale();
    public ArrayList<String []> data = new ArrayList<>();
    public CollectTable(){
        for(int i = 0;i < data.size();i++){
            data.add(new String[getColumnCount()]);
        }
    }
    @Override
    public int getRowCount() {return data.size();}
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return col1;
            case 1: return col2;
            case 2: return col3;
            default: return null;
        }
    }
    public void updateLanguage(){
        col1=ResourceBundle.getBundle("Locale", Interface.getLocale()).getString("Name");
        col2=ResourceBundle.getBundle("Locale", Interface.getLocale()).getString("Age");
        col3=ResourceBundle.getBundle("Locale", Interface.getLocale()).getString("TroublesWithTheLaw");
        for(int i = 0;i < data.size();i++){
            if(data.get(i)[2].equals(ResourceBundle.getBundle("Locale", l).getString("false")))
                data.get(i)[2] = ResourceBundle.getBundle("Locale", Interface.getLocale()).getString("false");
            else
                data.get(i)[2] = ResourceBundle.getBundle("Locale", Interface.getLocale()).getString("true");
        }
        l = Interface.getLocale();
        fireTableDataChanged();
        fireTableStructureChanged();
    }
    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex)[columnIndex];
    }
    public void removeData(int i){
        data.remove(i);
        fireTableDataChanged();
    }
    public void addData(String []row){
        data.add(row);
        fireTableDataChanged();
    }
    public  void addData(NormalHuman nh){
        String[] str= new String[3];
        str[0]=nh.getName();
        str[1]=nh.getAge().toString();
        str[2]=ResourceBundle.getBundle("Locale", Interface.getLocale()).getString(nh.getTroublesWithTheLaw().toString());
        data.add(str);
        fireTableDataChanged();
    }
    public void removeAll(){
        data.clear();
        fireTableDataChanged();
    }
    public void editData(String []row, int numberRow ){
        removeData(numberRow-1);
        data.add(numberRow-1,row);
        fireTableDataChanged();
    }
    public void editData(NormalHuman nh,int numberRow){
        String[] str= new String[3];
        str[0]=nh.getName();
        str[1]=nh.getAge().toString();
        str[2]=ResourceBundle.getBundle("Locale", Interface.getLocale()).getString(nh.getTroublesWithTheLaw().toString());
        removeData(numberRow);
        data.add(numberRow,str);
        fireTableDataChanged();
    }
    public void setData(int i, NormalHuman nh){
        String[] str = new String[3];
        str[0]=nh.getName();
        str[1]=nh.getAge().toString();
        str[2]=ResourceBundle.getBundle("Locale", Interface.getLocale()).getString(nh.getTroublesWithTheLaw().toString());

    }
    public String toString(){
        String s="";
        for(int i =0 ;i<data.size();i++){
            s=s+"\n" + data.get(i)[0]+ "  " + data.get(i)[1] + "  " + data.get(i)[2];
        }
        return s;
    }
}
