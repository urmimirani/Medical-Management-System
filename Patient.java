public class Patient extends Person {
    public Patient(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Patient: " + getName() + " (Age: " + getAge() + ")";
    }
}