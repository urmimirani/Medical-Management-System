public class Appointment {
    private Patient patient;
    private Doctor doctor;

    public Appointment(String patientName, int patientAge, Doctor doctor) {
        patient = new Patient(patientName, patientAge);
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }
    public String generateReceipt() {
        return "Appointment Receipt:\n" +
                "Patient: " + patient.getName() + " (Age: " + patient.getAge() + ")\n" +
                "Doctor: " + doctor.getName() + " (Specialization: " + doctor.getSpecialization() + ")";
    }
    @Override
    public String toString() {
        return "Patient: " + patient.getName() + " (Age: " + patient.getAge() + ")" +
                " -> Doctor: " + doctor.getName() + " (Specialization: " + doctor.getSpecialization() + ")";
    }
}