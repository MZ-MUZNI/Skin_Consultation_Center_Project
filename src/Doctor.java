import java.util.Date;

public class Doctor extends Person{

    private int medicalLicenceNum;
    private String specialization;

    public Doctor(String name, String surname, Date dateOfBirth, int mobileNumber, int medicalLicenceNum, String specialization) {
        super(name, surname, dateOfBirth, mobileNumber);
        this.medicalLicenceNum = medicalLicenceNum;
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getMedicalLicenceNum() {
        return medicalLicenceNum;
    }
    public void setMedicalLicenceNum(int medicalLicenceNum) {
        this.medicalLicenceNum = medicalLicenceNum;
    }

    @Override
    public String toString() {
        return "Doctor{" + super.toString() + " " +
                "medicalLicenceNum = " + medicalLicenceNum +
                ", specialization = " + specialization + '\'' +
                '}';
    }
}