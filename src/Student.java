public class Student {

    int id;
    String firstName;
    String lastName;
    String nation;
    String gender;
    String faculty;
    int admission;

    // POSTGRADUATE
    String supervisor;
    String topic;

    // UNDERGRADUATE
    String residential;

    boolean magister;

    public Student() {
    }

    // POSTGRADUATE
    public Student(int id, String firstName, String lastName, String nation, String gender, String faculty, int admission, String supervisor, String topic, boolean magister) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nation = nation;
        this.gender = gender;
        this.faculty = faculty;
        this.admission = admission;
        this.supervisor = supervisor;
        this.topic = topic;
        this.magister = magister;
    }

    // UNDERGRADUATE
    public Student(int id, String firstName, String lastName, String nation, String gender, String faculty, int admission, String residential, boolean magister) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nation = nation;
        this.gender = gender;
        this.faculty = faculty;
        this.admission = admission;
        this.residential = residential;
        this.magister = magister;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getAdmission() { return admission; }

    public void setAdmission(int admission) {
        this.admission = admission;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getResidential() {
        return residential;
    }

    public void setResidential(String residential) {
        this.residential = residential;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nation='" + nation + '\'' +
                ", gender='" + gender + '\'' +
                ", faculty='" + faculty + '\'' +
                ", admission='" + admission + '\'' +
                ", supervisor='" + supervisor + '\'' +
                ", topic='" + topic + '\'' +
                ", residential='" + residential + '\'' +
                '}';
    }
}