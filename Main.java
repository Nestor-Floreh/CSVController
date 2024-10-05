import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Champion> champions = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String archCSV = "Your Path";
        CSVController reader = new CSVController();

        champions = reader.readCSV(archCSV);

        int opcion = -1;
        String frase = "\n--- Champions ---\n" + "\n1. Search champions" + "\n2. Print all champions" + "\n3. Create champion" + "\n4. Exit" + "\n\nEnter an option: ";


        while (opcion != 4) {
            System.out.print(frase);
            opcion = sc.nextInt();
            sc.nextLine();  // Esto consume el salto de línea después de ingresar un número
            switch(opcion) {
                case 1:
                    System.out.print("\nEnter your search: ");
                    String search = sc.nextLine();  // Cambiado a nextLine() para capturar toda la frase

                    for (Champion champion : champions) {
                        if (champion.matches(search)) {
                            System.out.println(champion.toString());
                        }
                    }
                    break;
                case 2:
                    for (Champion champion : champions) {
                        System.out.println(champion.toString());
                    }
                    break;
                case 3:
                    String name;
                    String title;
                    String role;
                    float difficulty;
                    int nSkins;
                    boolean reworked;
                    String urlImage;
                    try{
                        System.out.print("\nEnter their name: ");
                        name = sc.nextLine();
                        System.out.print("Enter their title: ");
                        title = sc.nextLine();
                        System.out.print("Enter their role: ");
                        role = sc.nextLine();
                        System.out.print("Enter their difficulty: ");
                        difficulty = sc.nextFloat();
                        System.out.print("Enter their number of skins: ");
                        nSkins = sc.nextInt();
                        System.out.print("Enter their reworked: ");
                        reworked = sc.nextBoolean();
                        sc.nextLine();
                        System.out.print("Enter their urlImage: ");
                        urlImage = sc.nextLine();
                        Champion newChampion = new Champion(name, title, role, difficulty, nSkins, reworked, urlImage);
                        champions.add(newChampion);
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    finally {
                        sc.close();
                    }
                    break;
                case 4:
                    System.out.println("Bye");
                    reader.writeCSV(champions, archCSV);
                    break;
            }
        }
    }
}
