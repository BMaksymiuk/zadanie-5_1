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
      if (line.trim().isEmpty()) continue;
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
    
  public boolean removeStudentByName(String name) throws IOException {
      ArrayList<Student> students = new ArrayList<Student>(getStudents());
      boolean wasRemoved = students.removeIf(student -> student.GetName().equals(name));

      if (wasRemoved) {
        saveAllStudents(students); 
      }
      return wasRemoved;
    }
  public boolean updateStudentAge(String name, int newAge) throws IOException {
    ArrayList<Student> students = new ArrayList<Student>(getStudents());
    boolean wasUpdated = false;

    for (Student student : students) {
      if (student.GetName().trim().equalsIgnoreCase(name.trim())) {
        student.SetAge(newAge);
        wasUpdated = true;
        break; 
      }
    }
    if (wasUpdated) {
      saveAllStudents(students);
    }
    return wasUpdated;
  }
    

    private void saveAllStudents(Collection<Student> students) throws IOException {
      var f = new FileWriter("db.txt", false); 
      var b = new BufferedWriter(f);

      for (Student student : students) {
        b.write(student.toString());
        b.newLine();
      }

      b.close();
    }
  }



        
           
