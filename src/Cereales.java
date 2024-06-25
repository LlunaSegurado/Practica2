import java.util.Date;

public class Cereales implements IAlimento{

    private String marca;
    private double precio;
    private String tipoCereal;
    private int calorias;
    private Date caducidad;

    public Cereales(String marca, double precio, String tipoCereal) {
        this.marca = marca;
        this.precio = precio;
        this.tipoCereal = tipoCereal;
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTipoCereal() {
        return tipoCereal;
    }

    public void setTipoCereal(String tipoCereal) {
        this.tipoCereal = tipoCereal;
    }


    @Override
    public void setCaducidad(Date caducidad) {
        this.caducidad = caducidad;
    }

    @Override
    public Date getCaducidad() {
        return caducidad;
    }

    @Override
    public int getCalorias() {
        switch (tipoCereal) {
            case "espelta":
                return 5;
            case "maíz":
                return 8;
            case "trigo":
                return 12;
            default:
                return 15;
        }
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    @Override
    public String toString() {
        return "Cereales{" +
                "Marca: '" + marca + '\'' +
                ", Precio: " + precio + "€" +
                ", TipoCereal: '" + tipoCereal + '\'' +
                ", Calorias: " + getCalorias() +
                ", Caducidad: " + caducidad +
                '}';
    }
}
