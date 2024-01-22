import java.util.Scanner;
import java.util.InputMismatchException; // Import InputMismatchException for input validation

public class MedicalManagementSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PatientManager patientManager = new PatientManager();
        DoctorManager doctorManager = new DoctorManager();

        while (true) {
            try {
                System.out.println("\nMedical Management System");
                System.out.println("1. Manage Patients");
                System.out.println("2. Manage Doctors");
                System.out.println("3. Book an Appointment");
                System.out.println("4. List appointments");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = input.nextInt();
                input.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        PatientManager.managePatients(input);
                        break;
                    case 2:
                        doctorManager.manageDoctors(input);
                        break;
                    case 3:
                        bookAppointment(patientManager, doctorManager, input);
                        break;
                    case 4:
                        listAppointments(patientManager); // Call the new function to list appointments
                        break;
                    case 5:
                        System.out.println("Exiting the system.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
                input.nextLine(); // Consume invalid input
            }
        }
    }

    private static void bookAppointment(PatientManager patientManager, DoctorManager doctorManager, Scanner input) {
        try {
            System.out.println("\nBook an Appointment");
            System.out.print("Enter patient name: ");
            String patientName = input.nextLine();
            System.out.print("Enter patient age: ");
            int patientAge = input.nextInt();
            input.nextLine(); // Consume newline
            System.out.print("Enter specialization (e.g., Cardiologist): ");
            String specialization = input.nextLine();

            if (patientManager.isPatientAvailable(patientName, patientAge)) {
                Doctor preferredDoctor = doctorManager.selectDoctorBySpecialization(specialization, input);

                if (preferredDoctor != null) {
                    System.out.println("\nAppointment booked successfully!");
                    Appointment appointment = new Appointment(patientName, patientAge, preferredDoctor);
                    System.out.println(appointment.generateReceipt());
                    patientManager.saveAppointment(appointment);
                } else {
                    System.out.println("No doctors available in the specified specialization.");
                }
            } else {
                System.out.println("Patient not found or unavailable for an appointment.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid information.");
            input.nextLine(); // Consume invalid input
        }
    }

    private static void listAppointments(PatientManager patientManager) {
        System.out.println("\nList of Appointments:");
        patientManager.listAppointments();
    }
}
