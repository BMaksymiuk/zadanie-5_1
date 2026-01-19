import java.util.Collection;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Service {

  public void addStudent(Student student) throws IOException {
    var f = new FileWriter("db.txt", true);
    var b = new BufferedWriter(f);

    b.append(student.toString());
    b.newLine();

    b.close();
  }

  public Collection<Student> getStudents() throws IOException {
    var ret = new ArrayList<Student>();
    var f = new FileReader("db.txt");
    var reader = new BufferedReader(f);
    String line = "";

    while (true) {
      line = reader.readLine();
      if (line == null)
        break;
      ret.add(Student.Parse(line));
    }

    reader.close();
    return ret;
  }
  

  public Student findStudentByName(String name) {
    try {
      var students = getStudents();
      for (Student student : students) {
        if (student.GetName().equals(name)) {
          return student;
        }
      }
    } catch (IOException e) {
      System.out.println("Błąd podczas odczytu pliku.");
    }
    return null;
    
  }
    public void removeStudentByName(String name) throws IOException {
        var students = getStudents();
        students.removeIf(s -> s.GetName().equals(name));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("db.txt"))) {
            for (Student s : students) {
                writer.write(s.toString());
                writer.newLine();
            }
        }
    }

  }




        
           
