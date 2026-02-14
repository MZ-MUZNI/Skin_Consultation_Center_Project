import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookConsultation extends JFrame implements ActionListener {

    JButton confirmBookingBtn, backBtn, uploadBtn;
    JTextField firstNameField, surnameField, DOBField, addressField,mobileNumberField,notesField,bookingDateField;

    public BookConsultation() {
        JPanel panel = new JPanel();

        add(panel);

        JLabel registrationForm = new JLabel("Registration Form", SwingConstants.CENTER);
        registrationForm.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));

        JLabel firstNameLbl = new JLabel("First Name", SwingConstants.LEFT);
        JLabel surNameLbl = new JLabel("Surname", SwingConstants.LEFT);
        JLabel DOBLbl = new JLabel("Date of Birth (dd/mm/yyyy)", SwingConstants.LEFT);
        JLabel addressLbl = new JLabel("Address", SwingConstants.LEFT);
        JLabel mobileNumberLbl = new JLabel("Mobile Number", SwingConstants.LEFT);
        JLabel notesLbl = new JLabel("Notes", SwingConstants.LEFT);
        JLabel bookingDateLbl = new JLabel("Booking date", SwingConstants.LEFT);
        JLabel selectImageLbl = new JLabel("Select an Image", SwingConstants.LEFT);

        firstNameField = new JTextField(15);
        surnameField = new JTextField();
        DOBField = new JTextField();
        addressField = new JTextField();
        mobileNumberField = new JTextField();
        notesField = new JTextField();
        bookingDateField = new JTextField();

        confirmBookingBtn = new JButton("Confirm Booking");
        backBtn = new JButton("Back");
        uploadBtn = new JButton("Upload");

        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.insets = new Insets(30, 20, 20, 20);
        gbc.gridwidth = 3;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(registrationForm, gbc);

        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(firstNameLbl, gbc);

        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(surNameLbl, gbc);

        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(DOBLbl, gbc);

        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(addressLbl, gbc);

        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(mobileNumberLbl, gbc);

        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(notesLbl, gbc);

        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(bookingDateLbl, gbc);

        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 10;
        panel.add(selectImageLbl, gbc);

        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(firstNameField, gbc);

        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(surnameField, gbc);

        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(DOBField, gbc);

        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(addressField, gbc);

        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(mobileNumberField, gbc);

        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(notesField, gbc);

        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 7;
        panel.add(bookingDateField, gbc);

        gbc.insets = new Insets(30, 0, 20, 3);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 11;
        panel.add(confirmBookingBtn, gbc);

        gbc.insets = new Insets(30, 0, 20, 0);
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 11;
        panel.add(backBtn, gbc);

        gbc.insets = new Insets(0, 0, 0, 3);
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 10;
        panel.add(uploadBtn, gbc);


        pack();
        setVisible(true);
        confirmBookingBtn.addActionListener(this);
        backBtn.addActionListener(this);
        uploadBtn.addActionListener(this);
    }

    public void confirmBooking(){
        String firstName = this.firstNameField.getText();
        String surName = this.surnameField.getText();
        String DOB = DOBField.getText();
        String mobileNumber = mobileNumberField.getText();
        String address = this.addressField.getText();
        String notes = this.notesField.getText();
        String date = bookingDateField.getText();

        if(Person.checkName(firstName,surName)){

            if(Person.checkDOB(DOB) != null){

                if(Person.checkAddress(address)){

                    if (Person.checkMobileNumber(mobileNumber)){

                        if(Person.checkBookingDate(date) != null){

                        } else if (Person.checkBookingDate(date) == null) {
                            JOptionPane.showMessageDialog(this,"Enter the booking date in dd/mm/yyyy format.");
                        }

                    } else if (!Person.checkMobileNumber(mobileNumber)) {
                        JOptionPane.showMessageDialog(this,"Enter a valid mobile number.");
                    }

                } else if (!Person.checkAddress(address)) {
                    JOptionPane.showMessageDialog(this,"Address Field is empty.");
                }

            } else if(Person.checkDOB(DOB) == null){
                JOptionPane.showMessageDialog(this,"Enter your date of birth in dd/mm/yyyy format.");
            }

        }else if (!Person.checkName(firstName,surName)){
            JOptionPane.showMessageDialog(this,"Enter your First name & Last name properly.");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == confirmBookingBtn){
            confirmBooking();
            this.dispose();
            new Home();

        }else if(e.getSource() == backBtn) {
            this.dispose();
            new Home();

        }else if(e.getSource() == uploadBtn) {
            this.dispose();
            //this.uploadPhoto();

        }
    }
}
