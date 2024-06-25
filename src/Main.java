import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {

        List<IAlimento> productosAlimenticios = new ArrayList<>();

        while (true) {
            String menu = "\n"
                    + "|------------- MENU ------------|\n"
                    + "|                               |\n"
                    + "|    [1] Crear Detergente       |\n"
                    + "|    [2] Crear Cereales         |\n"
                    + "|    [3] Crear Vinos            |\n"
                    + "|    [4] Salir                  |\n"
                    + "|                               |\n"
                    + "|-------------------------------|\n";

            System.out.print(menu);
            System.out.print("Elige una opción [1-4]:\n>: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearDetergentes();
                    break;
                case 2:
                    productosAlimenticios.addAll(crearCereales());
                    break;
                case 3:
                    productosAlimenticios.addAll(crearVinos());
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    int totalCalorias = productosAlimenticios.stream().mapToInt(IAlimento::getCalorias).sum();
                    System.out.println("La suma de las calorías de los productos alimenticios es: " + totalCalorias);
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void crearDetergentes() {
        for (int i = 0; i < 3; i++) {
            Detergente detergente = new Detergente("D" + i, random.nextFloat() * 50);
            detergente.setVolumen(750);
            detergente.setTipoEnvase("botella");
            detergente.setDescuento(Math.round(random.nextFloat(5,25)));
            System.out.println(detergente);
        }
    }

    private static List<IAlimento> crearCereales() {
        List<IAlimento> cerealesList = new ArrayList<>();
        String[] tiposCereal = {"espelta", "maíz", "trigo", "avena", "arroz"};
        for (int i = 0; i < 3; i++) {
            Cereales cereales = new Cereales("C" + i, random.nextDouble() * 20, tiposCereal[random.nextInt(tiposCereal.length)]);
            cereales.setCaducidad(new Date());
            cerealesList.add(cereales);
            System.out.println(cereales);
        }
        return cerealesList;
    }

    private static List<IAlimento> crearVinos() {
        List<IAlimento> vinosList = new ArrayList<>();
        String[] tiposVino = {"tinto", "blanco", "rosado"};
        for (int i = 0; i < 3; i++) {
            Vino vino = new Vino("V" + i, tiposVino[random.nextInt(tiposVino.length)], random.nextInt(9,15), random.nextFloat() * 100);
            vino.setVolumen(750);
            vino.setTipoEnvase("botella");
            vino.setCaducidad(new Date());
            vino.setDescuento(Math.round(random.nextFloat(5,25)));
            vinosList.add(vino);
            System.out.println(vino);
        }
        return vinosList;
    }
}
