public class Student {

  private String Name;
  private int Age;
  private String Surname;
  private String Dataur;

  public Student(String name, String surname, int age, String dataur) {
    Name = name;
    Surname = surname;
    Age = age;
    Dataur=dataur;
  }

  public String GetName() {
    return Name;
  }

  public String GetSurname() {
    return Surname;
  }

  public int GetAge() {
    return Age;
  }
  public String GetData(){
    return Dataur;
  }

  @Override
  public String toString() {
    return Name + " " + Surname + " " + Age+" "+Dataur;
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if (data.length != 4) 
      return new Student("Parse Error", "parse Error", -1, "parse Error");
    return new Student(data[0], data[1], Integer.parseInt(data[2]),data[3]);
  }
}