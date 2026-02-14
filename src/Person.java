import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private int mobileNumber;

    public Person(String name, String surname, Date dateOfBirth, int mobileNumber){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
    }
    public String getName() { return name; }
    public String getSurname() {
        return surname;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public int getMobileNumber() {
        return mobileNumber;
    }

    public static boolean checkName(String firstName,String surName){
        return !firstName.equals("") && !surName.equals("");
    }

    public static Date checkDOB(String DOB) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatter.parse(DOB);
        } catch (ParseException e) {
            return null;
        }
    }

    public static boolean checkMobileNumber(String mobileNumber){
        System.out.println(mobileNumber.length());
        if(mobileNumber.equals("")){
            return false;
        }else return (mobileNumber.length() == 10);
    }

    public static boolean checkAddress(String address){
        return !address.equals("");
    }

    public static Date checkBookingDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatter.parse(date);

        } catch (ParseException e) {
            return null;
        }
    }

    public static String checkNotes(String notes){
        if(notes.equals("")){
            return null;
        }else return notes;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", mobileNumber=" + mobileNumber +
                '}';
    }
}