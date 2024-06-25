public class Detergente implements ILiquido, IDescuento{

    private String marca;
    private float precio;
    private String tipoEnvase;
    private float volumen;
    private float descuento;
    private float precioDescuento;

    public Detergente(String marca, float precio) {
        this.marca = marca;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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
    public String toString() {
        return "Detergente{" +
                "Marca: '" + marca + '\'' +
                ", Precio: " + String.format("%.2f", precio) + "€" +
                ", Volumen: " + volumen +
                ", Tipo de Envase: '" + tipoEnvase + '\'' +
                ", Descuento: " + descuento  + "%" +
                ", Precio con Descuento: " + String.format("%.2f", getPrecioDescuento()) + "€" +
                '}';
    }


}
