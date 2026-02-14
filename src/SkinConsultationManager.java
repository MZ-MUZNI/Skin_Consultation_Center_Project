import java.io.IOException;
import java.text.ParseException;

public interface SkinConsultationManager {
    void addDoctor() throws ParseException;
    void deleteDoctor();
    void printDetails();
    void saveToFile() throws IOException;
    void loadFromFile() throws IOException;
}
