import java.util.Scanner;

public class Catalog {
    private static Student[] studenti=new Student[0];
    private static Scanner scanner= new Scanner(System.in);

    public static void main(String[] args) {
        afisare("Catalog initial");
        citireStudenti();
        afisare("Catalog final");
    }

    static void afisare(String mesaj) {
        System.out.println(mesaj + ":");
        for(var student: studenti) {
            System.out.printf("%d %-15s Grupa %d Anul %d ",
                    student.getIdStudent(),student.getNume(),student.getGrupa(),student.getAnul());
            System.out.println();
            for(var nota:student.getNote()) {
                System.out.println(nota);
            }
        }
    }

    static void citireStudenti() {
        int numarStudenti=Integer.parseInt(scanner.nextLine());
        studenti=new Student[numarStudenti];
        for(int i=0;i<numarStudenti;i++) {
            String linieStudent= scanner.nextLine();
            String linieNote= scanner.nextLine();
            var student =new Student(
                    Integer.parseInt(linieStudent.split(",")[0]),
                    linieStudent.split(",")[1],
                    Integer.parseInt(linieStudent.split(",")[2]),
                    Integer.parseInt(linieStudent.split(",")[3]));
            //alta metoda de a face split si dupa a accesa elementele splituite
            var elementeNote=linieNote.split(",");
            //POO,9,BD,10 fac din 2 in 2 ca sa iau doar notele, adica poz 1,3 ... si dupa iau 0,2 adica disciplina
            for(int indexNote=1;indexNote< elementeNote.length;indexNote+=2) {
                var disciplina=elementeNote[indexNote-1];
                var nota=Integer.parseInt(elementeNote[indexNote]);
                student.addNota(new Nota(disciplina,nota));
            }
            studenti[i]=student;
        }
    }
}
