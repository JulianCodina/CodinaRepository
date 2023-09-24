package Prog2.Person;

public class Student extends Person{
    protected String program;
    protected int year;
    protected double fee;

    public Student(String name, String address, String program, int year, double fee) {
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Student[Prog2.Person[" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                "], program='" + program + '\'' +
                ", year=" + year +
                ", fee=" + fee +
                ']';
    }

    public String getProgram() {
        return program;
    }

    public int getYear() {
        return year;
    }

    public double getFee() {
        return fee;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
