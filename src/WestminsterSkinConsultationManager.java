import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager{

    static Scanner input = new Scanner(System.in);
    static ArrayList<Doctor> doctorList = new ArrayList<Doctor>();

    @Override
    public void addDoctor() throws ParseException {
        if(doctorList.size()<=10){
            System.out.println("Enter Doctor's Name : ");
            String name = input.next();
            System.out.println("Enter Doctor's Surname : ");
            String surname = input.next();
            System.out.println("Enter Date of Birth (dd/mm/yyyy) : ");
            String birthDay = input.next();
            Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(birthDay);
            System.out.println("Enter License Number : ");
            int licenseNum = input.nextInt();
            System.out.println("Enter Mobile Number : ");
            int mobileNum = input.nextInt();
            System.out.println("Enter specialization : ");
            input.nextLine();
            String specialize = input.nextLine();
            Doctor doctor = new Doctor(name,surname,dateOfBirth,mobileNum,licenseNum,specialize);
            doctorList.add(doctor);
            System.out.println("\nDoctor's details added to the system.");
        } else {
            System.out.println("Maximum count of 10 Doctors added.\nDelete a doctor and try again.");
        }
    }

    @Override
    public void deleteDoctor() {
        try {
            System.out.println("Enter doctor's medical licence number : ");
            int licenceNum = input.nextInt();
            for (Doctor doctor : doctorList) {
                if (doctor.getMedicalLicenceNum() == licenceNum) {
                    doctorList.remove(doctor);
                    System.out.println("Dr. " + doctor.getName() + " " + doctor.getSurname() + " has removed from the system.");
                    break;
                }
            }
            System.out.println("\nTotal number of doctors in the centre : " + doctorList.size());
        } catch (InputMismatchException e){
            System.out.println("Please only enter an integer.");
            input.nextLine();
        }
    }

    @Override
    public void printDetails() {
        System.out.printf("%-20s %-15s %-15s %-15s %-25s %n","Name", "Date of Birth", "Licence No", "Mobile No", "Specialization");
        doctorList.sort(Comparator.comparing(Person::getSurname));
        for(Doctor doctor : doctorList){
            Date date = doctor.getDateOfBirth();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateOfBirth = dateFormat.format(date);
            String name = doctor.getName() +" " + doctor.getSurname();
            System.out.printf("%-20s %-15s %-15s %-15s %-25s %n",name, dateOfBirth, doctor.getMedicalLicenceNum(), doctor.getMobileNumber(), doctor.getSpecialization());
        }
    }

    @Override
    public void saveToFile() throws IOException {
        try{
            File file = new File("doctors.txt");
            FileOutputStream fileOut = new FileOutputStream(file,false);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            for (Doctor doctor : doctorList) {
                objectOut.writeObject(doctor);
            }
        }
        catch(IOException e){
            System.out.println("Error occurred.");
        }
    }

    @Override
    public void loadFromFile() throws IOException {
        try{
            FileInputStream fileInput = new FileInputStream("doctors.txt");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);

            while (true) {
                try {
                    Doctor doctor = (Doctor) objectInput.readObject();
                    System.out.println(doctor.getName());
                    doctorList.add(doctor);
                } catch (IOException | ClassNotFoundException e) {
                    break;
                }
            }
        } catch (EOFException | FileNotFoundException ignored) {
        }
    }

    public static ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }
}
