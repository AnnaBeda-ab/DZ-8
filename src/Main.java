public class Main {

    /**
     * Написати мінімальний клас студент, який має: ідентифікатор студента (тобто, унікальний), ім'я, прізвище.
     * Написати клас, який репрезентує групу студентів з наступними полями:
     * староста (тип студент)
     * список студентів (тип студент)
     * список завдань
     * Група не може існувати без старости.
     * Методи класу:
     * змінити старосту
     * додати/видалити/перейменувати студента,
     * додати завдання (для всієї групи)
     * позначити завдання як виконане (для зазначеного студента)
     * - Староста та студенти є об'єктами класу студент.
     * - Завдання є простими рядками (приклад: вивчити інкапсуляцію).
     * Зробити цей клас максимально інкапсульованим.
     * Забезпечити максимальну безпеку стану класу.
     * Формат здачі: Прикріпити посилання на Pull request з файлами на GitHub.
     * Будуть два класи і в класі група буде два поля типу ліст.
     * В мейн методі можна буде створити обєкти типу студент і ініціалізувати їх імя призивещем і тд
     * Потрібно пройтися по полю students за допомогою if
     * перевіряти чи той студент що потрібно по айді, якщо той змінити імя прізвище якщо не той нічого не робити.
     * позначити завдання як виконане (для зазначеного студента)-додати групі поле типу мап де ключем
     * буде завдання а значенням ліст студентів які виконали це завдання
     */
    public static void main(String[] args) {
        Student student = new Student("Anna", "Beda");
        Student student1 = new Student("Natalia", "Taran");
        Student student3 = new Student("Sofia","Bovenko");

        GroupOfStudents newGroup = new GroupOfStudents(student);
        GroupOfStudents newGroup1 = new GroupOfStudents(student1);
        newGroup.addStudent(student);
        newGroup.addStudent(student1);
        newGroup.addStudent(student3);
        newGroup1.addStudent(student1);
        newGroup1.addStudent(student3);

        newGroup.printListOfGroup("newGroup");
        newGroup1.printListOfGroup("newGroup1");


        newGroup1.deleteStudent(3);
        newGroup1.printListOfGroup("newGroup1");


        newGroup1.setNewStarosta(student1);

        newGroup1.addTask("Вивчити поліморфізм");
        newGroup1.addTask("Вивчити інкапсуляцію");
        newGroup1.addTask("Вивчити абстракцію");
        System.out.println(newGroup1.toString());

    }
}
