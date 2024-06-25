import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Detergente detergente1 = new Detergente("A", 20.0);
        detergente1.setDescuento(10);

        Cereales cereales1 = new Cereales("B", 15.0, "espelta");
        cereales1.setCaducidad(new Date());

        Vino vino1 = new Vino("C", "tinto", 12, 30);
        vino1.setVolumen(750);
        vino1.setTipoEnvase("botella");
        vino1.setCaducidad(new Date());
        vino1.setDescuento(15);

        ArrayList<IAlimento> productosAlimenticios = new ArrayList<>();
        productosAlimenticios.add(cereales1);
        productosAlimenticios.add(vino1);

        int totalCalorias = 0;
        for (IAlimento alimento : productosAlimenticios) {
            totalCalorias += alimento.getCalorias();
        }

        System.out.println("La suma de las calorías de los productos alimenticios es: " + totalCalorias);

        System.out.println(detergente1);
        System.out.println(cereales1);
        System.out.println(vino1);
    }
}
