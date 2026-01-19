import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Service s = new Service();
    Scanner scanner = new Scanner(System.in);

    String name;
    int age;
    String surname;
    String dataur;

    System.out.printf("Czy chcesz dodać studenta? (tak/nie)");
    String PierwszyWybor = scanner.nextLine();
    switch (PierwszyWybor) {
      case "tak":
        System.out.print("Podaj imię: ");
        name = scanner.nextLine();

        System.out.print("Podaj nazwisko: ");
        surname = scanner.nextLine();

        System.out.print("Podaj wiek: ");
        age = Integer.parseInt(scanner.nextLine());

        System.out.printf("podaj date urodzenia w formacie dd-mm-rrrr: ");
        dataur = scanner.nextLine();

        try {
          s.addStudent(new Student(name, surname, age, dataur));
          System.out.printf("Dodano studenta.");
        } catch (Exception e) {
          System.out.printf("Błąd podczas zapisu");
        }
        break;

      case "nie":
        System.out.printf("Pominięto dodawanie studenta.");
        break;

      default:
        System.out.printf("Nieznanaa opcja — pomijam dodawanie.");
    }

    while (true) {
      System.out.println("1. Dodaj studenta");
      System.out.println("2. Wyświetl waszystkich studentów");
      System.out.println("3. Zakończ");
      System.out.println("4. Wyszukaj studenta po imieniu");
      System.out.println("Wybór: ");

      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          System.out.print("Podaj imię: ");
          name = scanner.nextLine();

          System.out.print("Podaj nazwisko: ");
          surname = scanner.nextLine();

          System.out.print("Podaj wiek: ");
          age = Integer.parseInt(scanner.nextLine());

          System.out.printf("podaj date urodzenia w formacie rrr-mm-dd: ");
          dataur = scanner.nextLine();


          try {
            s.addStudent(new Student(name, surname, age, dataur));
            System.out.printf("Dodano studenta.");
          } catch (Exception e) {
            System.out.printf("Błąd zapisu");
          }
          break;

        case 2:
          try {
            var students = s.getStudents();
            System.out.printf("\n--- Lista studentów ---");
            for (Student st : students) {
              System.out.println(st);
            }
          } catch (Exception e) {
            System.out.println("Błąd podczas odczytu");
          }
          break;

        case 3:
          System.out.println("Koniec.");
          return;
        case 4:
          System.out.println("Podaj imię studenta do wyszukania: ");
          name = scanner.nextLine();
          Student foundStudent = s.findStudentByName(name);
          if (foundStudent != null) {
            System.out.println("Znaleziono studenta: " + foundStudent);
          } else {
            System.out.println("Nie znaleziono studenta o podanym imieniu.");
          }
          break;

        default:
          System.out.println("błąd");
      }
    }
  }
}