import java.util.Date;

public class Vino implements ILiquido, IDescuento, IAlimento {

    private String marca;
    private String tipoVino;
    private int gradosAlcohol;
    private float precio;
    private float volumen;
    private String tipoEnvase;
    private float descuento;
    private float precioDescuento;
    private int calorias;
    private Date caducidad;

    public Vino(String marca, String tipoVino, int gradosAlcohol, float precio) {
        this.marca = marca;
        this.tipoVino = tipoVino;
        this.gradosAlcohol = gradosAlcohol;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipoVino() {
        return tipoVino;
    }

    public void setTipoVino(String tipoVino) {
        this.tipoVino = tipoVino;
    }

    public double getGradosAlcohol() {
        return gradosAlcohol;
    }

    public void setGradosAlcohol(int gradosAlcohol) {
        this.gradosAlcohol = gradosAlcohol;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public void setVolumen(float volumen) {
        this.volumen = volumen;
    }

    @Override
    public float getVolumen() {
        return volumen;
    }

    @Override
    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    @Override
    public String getTipoEnvase() {
        return tipoEnvase;
    }

    @Override
    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    @Override
    public float getDescuento() {
        return descuento;
    }

    @Override
    public float getPrecioDescuento() {
        float parteDescuento = getPrecio() * (descuento / 100);
        precioDescuento = getPrecio() - parteDescuento;
        return precioDescuento;
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
        calorias = (10 * gradosAlcohol);
        return calorias;
    }

    @Override
    public String toString() {
        return "Vino{" +
                "Marca: '" + marca + '\'' +
                ", Tipo de Vino: '" + tipoVino + '\'' +
                ", Grados de Alcohol: " + gradosAlcohol + "%" +
                ", Precio: " + String.format("%.2f", precio) + "€" +
                ", Volumen: " + volumen +
                ", Tipo de Envase: '" + tipoEnvase + '\'' +
                ", Descuento: " + descuento  + "%" +
                ", Precio con Descuento: " + String.format("%.2f", getPrecioDescuento()) + "€" +
                ", Calorias: " + getCalorias() +
                ", Caducidad: " + caducidad +
                '}';
    }
}
