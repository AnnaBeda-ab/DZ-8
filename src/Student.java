import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {
    //Написати мінімальний клас студент, який має: ідентифікатор студента (тобто, унікальний), ім'я, прізвище.
    private int studentId; // унікальний для кожного об'єкту
    private static int studentIdBase = 0; //для всіх студентів
    private String name;
    private String surname;

    public Student(String name, String surname) {
        studentIdBase++;
        this.studentId = studentIdBase;
        this.name = name;
        this.surname = surname;
    }
    public int getStudentId() {
        return studentId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override // порівнюватими об'єкти як одне ціле (всі поля одного об'єкту з усіма аналогічними поліми іншого)/через generate
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId && Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, name, surname);
    }
}
