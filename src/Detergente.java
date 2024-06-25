public class Detergente implements ILiquido, IDescuento{

    private String marca;
    private double precio;
    private String tipoEnvase;
    private float volumen;

    public Detergente(String marca, double precio) {
        this.marca = marca;
        this.precio = precio;
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

    public void setPrecio(double precio) {
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

    }

    @Override
    public float getDescuento() {
        return 0;
    }

    @Override
    public float getPrecioDescuento() {
        return 0;
    }

    @Override
    public String toString() {
        return "Detergente{" +
                "Marca='" + marca + '\'' +
                ", Precio=" + precio +
                '}';
    }


}
