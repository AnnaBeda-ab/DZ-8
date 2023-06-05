import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupOfStudents {
    /*
    Написати клас, який репрезентує групу студентів з наступними полями:
          * староста (тип студент)
          * список студентів (тип студент)
          * список завдань
          * Група не може існувати без старости.
     */
    List<Student> students = new ArrayList<>(); //список студентів
    List<String> tasks = new ArrayList<>(); //список завдань
    private Student starosta;
    /********************************************************************************
     * Задача із зірочкою -позначити завдання як виконане (для зазначеного студента)*
     *******************************************************************************/
    HashMap<String, List<Student>> tasksDone = new HashMap<>();
    /*
    я би створив у класі група поле мапу з ключем тип стрінг
     де зберігав би таску і значенням ліст студентів де би зберігав студентів які вже виконали її
    Треба дістати по ключу ліст і додати до ліста студента,
    якщо такого ліста по ключу немає то створити ліст додати студента і поставити ліст по ключу в мапу.
     */

    public void setTasksDone(String task, Student student) {
        if (tasksDone.containsKey(task)) { //перевіряємо, чи є дана задача у значенні всіх ключів мапи
            tasksDone.get(task).add(student); //додаємо студента у список студентів, якому ключем є ця задача
        } else {
            List<Student> studentsDoneTask = new ArrayList<>();
            studentsDoneTask.add(student); //додаємо студента у новий ліст студентів
            tasksDone.put(task, studentsDoneTask); //додаємо до мапи ключ(задача), значення (новий ліст студентів)
        }

    }
/****************************************/

    public GroupOfStudents(Student student) { //конструктор групи /створити групу
        this.starosta = student;
        students.add(starosta);
    }

    public Student getStarosta() { // отримати/узнати хто староста
        return starosta;
    }

    public void setNewStarosta(Student student) { // змінити (переопреділити) старосту
        this.starosta = student;
    }

    public void addStudent(Student student) {  //додати студента
        for (Student copyStudent : students) {
            if (student.equals(copyStudent)) {
                System.out.println("This student exist");
                return;
            }
        }
        students.add(student);
    }

    public void renameStudent(int studentId, String newName, String newSurname) { //перейменувати студента
        for (Student copyStudent : students) {
            if (copyStudent.getStudentId() == studentId) {
                copyStudent.setName(newName);
                copyStudent.setSurname(newSurname);
                System.out.println("The new data is:" + copyStudent.toString());
                return;
            }
            System.out.println("The student with this ID does not exist");
        }
    }

    public void deleteStudent(int studentId) {   //видалити студента
        if (studentId > 0) {
            for (Student copyStudent : students) {
                if (copyStudent.getStudentId() == studentId && starosta.equals(copyStudent)) {
                    System.out.println("The starosta was deleted. Set new starosta");
                    students.remove(copyStudent);
                    return;
                } else if (copyStudent.getStudentId() == studentId) {
                    students.remove(copyStudent);
                    return;
                } else {
                    System.out.println("The student with this ID does not exist");
                }
            }
        } else {
            System.out.println("Incorrect ID");
        }
    }

    public void printListOfGroup(String groupName) {
        System.out.println("The list of student of " + groupName);
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public void addTask(String task) {  // додати завдання
        tasks.add(task);

    }


    @Override
    public String toString() {
        return "GroupOfStudents{" + "\n" +
                "students=" + students + "," + "\n" +
                "task=" + tasks + "\n" +
                "starosta= " + starosta +
                '}';
    }
}


