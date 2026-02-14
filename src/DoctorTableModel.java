import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class DoctorTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Name","Specialization","Medical Licence Number"};
    private ArrayList<Doctor> myList;

    public DoctorTableModel(ArrayList<Doctor> bkList) {
        myList = bkList;
    }
    public int getColumnCount() {
        return columnNames.length;
    }
    public int getRowCount() {
        return myList.size();
    }

    public Object getValueAt(int row, int col) {
        Object temp = null;
        if (col == 0) {temp = myList.get(row).getName();

        }else if (col == 1) {
            temp = myList.get(row).getSpecialization();

        }else if (col == 2) {
            temp = (myList.get(row).getMedicalLicenceNum());
        }return temp;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Class<?> getColumnClass(int col) {
        return String.class;
    }

}
