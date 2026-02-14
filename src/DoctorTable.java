import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DoctorTable extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JButton back;
    JTable table;

    public DoctorTable() {
        initializer();
        add(panel);
        back = new JButton("Back");

        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridwidth = 3;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(table.getTableHeader(),gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(table,gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 3;
        gbc.gridy = 2;
        panel.add(back,gbc);

        pack();
        setVisible(true);
        back.addActionListener(this);
    }

    public  void initializer() {
        ArrayList<Doctor> myList = new ArrayList<>();

        ArrayList<Doctor> doctors = WestminsterSkinConsultationManager.doctorList;
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i)!=null) {
                myList.add(doctors.get(i));
            }
        }

        DoctorTableModel tableModel = new DoctorTableModel(myList);
        table = new JTable(tableModel);
        table.setFillsViewportHeight(true);

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(70);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(150);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
        new Home();
    }

}
