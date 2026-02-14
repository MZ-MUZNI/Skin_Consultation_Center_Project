import java.util.Date;

public class Consultation {

    private String consultId;
    private Date consultDate;
    private Date consultTime;
    private String notes;

    public String getConsultId() {
        return consultId;
    }

    public void setConsultId(String consultId) {
        this.consultId = consultId;
    }

    public Date getConsultDate() {
        return consultDate;
    }

    public void setConsultDate(Date consultDate) {
        this.consultDate = consultDate;
    }

    public Date getConsultTime() {
        return consultTime;
    }

    public void setConsultTime(Date consultTime) {
        this.consultTime = consultTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
