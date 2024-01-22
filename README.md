# MEDICAL-MANAGEMENT-SYSTEM
In the contemporary healthcare industry, efficient management of patients, doctors, and appointments is crucial for providing quality care and ensuring the smooth operation of medical practices. This project aims to address these challenges by developing a Medical Management System. 

**OBJECTIVES**
- To create a user-friendly application for managing patient records. 
- To facilitate the management of doctor information and appointments. 
- To allow patients to book appointments with preferred doctors. 
- To generate appointment receipts for patients. 

**SYSTEM REQUIREMENTS**
 Functional Requirements-
- Patient Management: 
  - Add, view, and update patient records. 
- Doctor Management: 
  - Add, view, and update doctor information. 
- Appointment Booking: 
  - Allow patients to book appointments with preferred doctors. 
  - Check doctor availability. 
- Receipt Generation: 
  - Generate appointment receipts with patient and doctor details. 
- File I/O: 
  - Store and retrieve appointment data from a text file. 
- User Interface: 
  - Provide an intuitive text-based user interface for user interactions. 
 
 Non-Functional Requirements-
 - Usability: The system should be user-friendly and easy to navigate. 
- Performance: The application should handle multiple users efficiently. 
- Reliability: Ensure data integrity and robust error handling. 
- Security: Protect patient and doctor information from unauthorized access. 
- Portability: Run on multiple platforms with Java compatibility. 
 
 Hardware and Software Requirements-
- Hardware: Standard PC or laptop with Java runtime environment. 
- Software: Java Development Kit (JDK), integrated development environment (IDE), text editor.

**MODULES AND STAKEHOLDERS**
Modules:
1. Patient Management Module:
   - Responsible for adding, listing, and managing patient records. 
   - Allows users to view and edit patient information. 
 
2. Doctor Management Module: 
   - Handles the addition, listing, and management of doctor records. 
   - Provides functionality to view and edit doctor details. 
 
3. Appointment Booking Module
   - Enables patients to book appointments with doctors. 
   - Allows selection of doctors by specialization. 
   - Generates appointment receipts. 
 
4. File Handling Module:
   - Manages reading and writing of data to files (e.g., patient, doctor, appointment data). 
   - Ensures data persistence and retrieval. 
 
5. User Interface Module:
   - Provides a user-friendly text-based interface for interacting with the system. 
   - Displays menus, receives user input, and presents information to users. 
 
6. Exception Handling Module: 
   - Handles exceptions and errors that may occur during program execution. 
   - Ensures robust error management, graceful handling of issues, and user-friendly error messages. 
 
Stakeholders: 
1. Patients: 
   - End-users who use the system to book appointments, view their information, and access their appointment receipts. 
 
2. Doctors: 
   - Healthcare professionals whose information is stored in the system for patient appointment booking. 
 
3. Medical Staff/Administrators:
   - Responsible for managing patient and doctor records, ensuring data accuracy, and resolving any issues with the system. 
 
4. Developers/Programmers: 
   - The individuals or team responsible for designing, coding, testing, and maintaining the system. 
 
5. System Administrators: 
   - Individuals responsible for deploying and maintaining the application on the server, ensuring its availability and security. 
 
8. Healthcare Institutions/Hospitals (if applicable):
   - If the system is used in a healthcare institution, the institution itself may be a stakeholder, as it relies on the system for appointment management and patient-doctor interactions. 
  
These modules and stakeholders collectively contribute to the development, maintenance, and usage of the Java Medical Management System. Successful collaboration and communication among these groups are essential for the system's effectiveness and user satisfaction. Additionally, adherence to relevant healthcare regulations is crucial for data security and privacy. 


**BREAKDOWN OF CODE**
1. Main Class - MedicalManagementSystem.java
 
- This is the main class of the program where user interactions are handled. 
- It initializes instances of `PatientManager` and `DoctorManager` to manage patients and doctors, respectively. 
- Inside the `while` loop, the user is presented with options to manage patients, doctors, book an appointment, or exit the system. 
 
2. Abstract Class - Person.java 
 
- `Person` is an abstract class representing a generic person with attributes like name and age. 
- Both `Doctor` and `Patient` classes inherit from this abstract class. 
- The use of an abstract class allows us to define common attributes and methods for both doctors and patients. 
 
3. Doctor Class - Doctor.java 
 
- The `Doctor` class represents a doctor and inherits from the `Person` class. 
- It has an additional attribute, `specialization`, which represents the doctor's medical specialization. 
- A constructor is used to initialize a doctor's attributes (name, age, specialization). 
- The `toString` method is overridden to provide a meaningful string representation of the doctor. 
 
4. Patient Class - Patient.java 
 
- The `Patient` class represents a patient and also inherits from the `Person` class. 
- It does not have any additional attributes compared to the `Person` class. 
- A constructor is used to initialize a patient's attributes (name, age). 
- The `toString` method is overridden to provide a meaningful string representation of the patient. 
 
5. DoctorManager Class - DoctorManager.java 
 
- The `DoctorManager` class is responsible for managing doctors. 
- It maintains a list of doctors using the `List<Doctor>` data structure. 
- It provides methods to add doctors, list doctors, and select a doctor by specialization. 
- The `selectDoctorBySpecialization` method allows the user to choose a doctor based on their medical specialization. 
 
6. PatientManager Class - PatientManager.java 
 
- The `PatientManager` class is responsible for managing patients and appointments. 
- It maintains a list of patients using the `List<Patient>` data structure and a list of appointments. 
- The `loadAppointmentsFromFile` method reads appointments from a text file (`appointments.txt`) and populates the list of appointments. 
- The `saveAppointmentsToFile` method saves appointments to the same text file. 
- The `bookAppointment` method allows the user to book an appointment by selecting a doctor based on specialization and then generates a receipt. 
 
7. Appointment Class - Appointment.java 
 
- The `Appointment` class represents an appointment made by a patient with a doctor. 
- It contains references to both the patient and the doctor. 
- The `generateReceipt` method generates a receipt for the appointment. 
- The `toString` method provides a string representation of the appointment. 
 
8. File Handling 
 
- The program uses file handling to store and retrieve appointment data in a text file (`appointments.txt`). 
- When an appointment is booked, the data is written to the file. 
- When the program starts, it reads the appointments from the file into memory. 
 
9. User Interface 
 
- The program provides a simple text-based user interface that allows users to interact with the system. 
- Users can manage patients and doctors, book appointments, and view appointment details. 











