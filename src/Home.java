import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Home extends JFrame implements ActionListener {
    static ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
    JButton viewDoctorBtn, bookingBtn, viewConsultBtn;
    public Home(){
        JPanel panel = new JPanel();

        add(panel);
        panel.setBackground(Color.WHITE);

        JLabel background = new JLabel();
        background.setSize(0,0);

        JLabel lbl1 = new JLabel("Skin Consultation Center",SwingConstants.CENTER);
        lbl1.setForeground(Color.BLACK);
        lbl1.setFont(new Font("Arial",Font.BOLD | Font.ITALIC,14));
        viewDoctorBtn = new JButton("View Doctor List");
        bookingBtn = new JButton("Book Consultation");
        viewConsultBtn = new JButton("View Consultations");

        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.insets = new Insets(20,20,20,20);
        gbc.gridwidth = 3;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(background,gbc);

        gbc.insets = new Insets(20,20,20,20);
        gbc.gridwidth = 3;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lbl1,gbc);

        gbc.insets = new Insets(10,30,10,0);
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        panel.add(viewDoctorBtn,gbc);

        gbc.insets = new Insets(10,30,10,0);
        gbc.gridy = 2;
        panel.add(bookingBtn,gbc);

        gbc.insets = new Insets(10,30,50,0);
        gbc.gridy = 3;
        panel.add(viewConsultBtn,gbc);

        viewDoctorBtn.addActionListener(this);
        bookingBtn.addActionListener(this);
        viewConsultBtn.addActionListener(this);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == viewDoctorBtn){
            this.dispose();
            new DoctorTable();
        } else if (e.getSource() == bookingBtn) {
            this.dispose();
            new BookConsultation();
        } else if (e.getSource() == viewConsultBtn) {
            this.dispose();
            new Consultation();
        }
    }

    public static void setDoctorList(ArrayList<Doctor> doctorList) {
        Home.doctorList = doctorList;
    }
}
