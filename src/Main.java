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
                    + "|------------- MENU ---------------------------|\n"
                    + "|                                              |\n"
                    + "|    [1] Crear Detergente Automático           |\n"
                    + "|    [2] Crear Cereales Automático             |\n"
                    + "|    [3] Crear Vinos Automático                |\n"
                    + "|    [4] Crear Detergente Manual               |\n"
                    + "|    [5] Crear Cereales Manual                 |\n"
                    + "|    [6] Crear Vino Manual                     |\n"
                    + "|    [7] Salir                                 |\n"
                    + "|                                              |\n"
                    + "|----------------------------------------------|\n";

            System.out.print(menu);
            System.out.print("Elige una opción [1-7]:\n>: ");
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
                    crearDetergenteManual();
                    break;
                case 5:
                    productosAlimenticios.addAll(crearCerealesManual());
                    break;
                case 6:
                    productosAlimenticios.addAll(crearVinoManual());
                    break;
                case 7:
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
            detergente.setTipoEnvase("Botella");
            detergente.setDescuento(Math.round(random.nextFloat(5,25)));
            System.out.println(detergente);
        }
    }

    public static void crearDetergenteManual() {
        System.out.println("\nCreación de nuevo detergente:");

        System.out.print("Marca: ");
        String marca = scanner.nextLine();

        System.out.print("Precio: ");
        float precio = scanner.nextFloat();
        while (precio <= 0) {
            System.out.print("Ingrese un precio válido: ");
            precio = scanner.nextFloat();
            scanner.nextLine();

            if (precio <= 0) {
                System.out.println("El precio debe ser mayor que 0. Por favor, ingrese un precio válido.");
            }
        }

        Detergente detergente = new Detergente(marca, precio);
        detergente.setVolumen(1000);
        detergente.setTipoEnvase("Botella");
        detergente.setDescuento(Math.round(random.nextFloat(5,25)));

        System.out.println("\n¡Detergente creado correctamente");
        System.out.println(detergente);
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

    public static List<IAlimento> crearCerealesManual() {
        List<IAlimento> cerealesList = new ArrayList<>();
        System.out.println("\nCreación de nuevos cereales:");

        System.out.print("Marca: ");
        String marca = scanner.nextLine();

        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        while (precio <= 0) {
            System.out.print("Ingrese un precio válido: ");
            precio = scanner.nextDouble();
            scanner.nextLine();

            if (precio <= 0) {
                System.out.println("El precio debe ser mayor que 0. Por favor, ingrese un precio válido.");
            }
        }

        System.out.print("Tipo de cereal (espelta, maíz, trigo u otro): ");
        String tipoCereal = scanner.nextLine();

        Cereales cereales = new Cereales(marca, precio, tipoCereal);
        System.out.println("\n¡Cereales creados correctamente");
        cereales.setCaducidad(new Date());
        System.out.println(cereales);
        cerealesList.add(cereales);
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

    public static List<IAlimento> crearVinoManual() {
        List<IAlimento> vinosList = new ArrayList<>();

        System.out.println("\nCreación de nuevo vino:");

        System.out.print("Marca: ");
        String marca = scanner.nextLine();

        System.out.print("Tipo de vino (tinto, blanco o rosado): ");
        String tipoVino = scanner.nextLine();

        System.out.print("Grados de alcohol: ");
        int gradosAlcohol = scanner.nextInt();

        System.out.print("Precio: ");
        float precio = scanner.nextFloat();
        while (precio <= 0) {
            System.out.print("Ingrese un precio válido: ");
            precio = scanner.nextFloat();
            scanner.nextLine();

            if (precio <= 0) {
                System.out.println("El precio debe ser mayor que 0. Por favor, ingrese un precio válido.");
            }
        }

        Vino vino = new Vino(marca, tipoVino, gradosAlcohol, precio);
        vino.setVolumen(750.0f);
        vino.setTipoEnvase("Botella");
        vino.setCaducidad(new Date());
        vino.setDescuento(Math.round(random.nextFloat(5,25)));

        System.out.println("\n¡Vino creado correctamente");
        vinosList.add(vino);
        System.out.println(vino);
        return vinosList;
    }

}
