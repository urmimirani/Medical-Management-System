import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorManager {
    private List<Doctor> doctors;

    public DoctorManager() {
        doctors = new ArrayList<>();
    }
    public void manageDoctors(Scanner input) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Doctor Management System ---");
            System.out.println("1. Add Doctor");
            System.out.println("2. List Doctors");
            System.out.println("3. Select Doctor by Specialization");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt(); input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter doctor's name: ");
                    String name = input.nextLine();
                    System.out.print("Enter doctor's age: ");
                    int age = input.nextInt(); input.nextLine();
                    System.out.print("Enter doctor's specialization: ");
                    String specialization = input.nextLine();
                    addDoctor(name, age, specialization);
                    break;
                case 2:
                    listDoctors();
                    break;
                case 3:
                    System.out.print("Enter specialization: ");
                    String spec = input.nextLine();
                    Doctor selectedDoctor = selectDoctorBySpecialization(spec, input);
                    if (selectedDoctor != null) {
                        System.out.println("\nSelected Doctor: " + selectedDoctor);
                    }
                    else {
                        System.out.println("\nNo doctors found in " + spec + " specialization.");
                    }
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting Doctor Management System...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again."); }
        }
    }

    public void addDoctor(String name, int age, String specialization) {
        doctors.add(new Doctor(name, age, specialization));
    }

    public void listDoctors() {
        System.out.println("\nDoctors:");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    public Doctor selectDoctorBySpecialization(String specialization, Scanner input) {
        List<Doctor> availableDoctors = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if (doctor.getSpecialization().equalsIgnoreCase(specialization)) {
                availableDoctors.add(doctor);
            }
        }

        if (availableDoctors.isEmpty()) {
            return null;
        }

        System.out.println("\nAvailable Doctors in " + specialization + ":");
        for (int i = 0; i < availableDoctors.size(); i++) {
            System.out.println((i + 1) + ". " + availableDoctors.get(i).getName());
        }

        System.out.print("Choose a doctor (1-" + availableDoctors.size() + "): ");
        int choice = input.nextInt();
        input.nextLine(); // Consume newline

        if (choice < 1 || choice > availableDoctors.size()) {
            return null;
        }

        return availableDoctors.get(choice - 1);
    }
}