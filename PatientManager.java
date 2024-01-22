import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientManager {
    private static List<Patient> patients;
    private List<Appointment> appointments;
    private static final String APPOINTMENTS_FILE = "appointments.txt";

    public PatientManager() {
        patients = new ArrayList<>();
        appointments = new ArrayList<>();
        loadAppointmentsFromFile();
    }
    public static void managePatients(Scanner input) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Patient Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. List Patient");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt(); input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter patient's name: ");
                    String name = input.nextLine();
                    System.out.print("Enter patients's age: ");
                    int age = input.nextInt(); input.nextLine();
                    addPatient(name, age);
                    break;
                case 2:
                    listPatients();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting Patient Management System...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again."); }
        }
    }

    public static void addPatient(String name, int age) {
        patients.add(new Patient(name, age));
    }

    public static void listPatients() {
        System.out.println("\nPatients:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }
    // Implement patient management (add, list, etc.) here if needed.

    public void saveAppointment(Appointment appointment) {
        appointments.add(appointment);
        saveAppointmentsToFile();
    }

    public void listAppointments() {
        System.out.println("\nAppointments:");
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    private void loadAppointmentsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(APPOINTMENTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String patientName = parts[0];
                    int patientAge = Integer.parseInt(parts[1]);
                    String doctorName = parts[2];
                    Doctor doctor = findDoctorByName(doctorName);

                    if (doctor != null) {
                        appointments.add(new Appointment(patientName, patientAge, doctor));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Doctor findDoctorByName(String doctorName) {
        return null;
    }

    private void saveAppointmentsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(APPOINTMENTS_FILE))) {
            for (Appointment appointment : appointments) {
                writer.println(appointment.getPatient().getName() + "," + appointment.getPatient().getAge() + "," + appointment.getDoctor().getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Doctor findDoctorByName(String doctorName, Doctor doctors[]) {
        for (Doctor doctor : doctors) {
            if (doctor.getName().equalsIgnoreCase(doctorName)) {
                return

                        doctor;
            }
        }
        return null;
    }

    public boolean isPatientAvailable(String name, int age) {
        for (Patient patient : patients) {
            if (patient.getName().equals(name) && patient.getAge() == age) {
                return true; // Patient with matching name and age found
            }
        }
        return false; // Patient not found or not available
    }

}
