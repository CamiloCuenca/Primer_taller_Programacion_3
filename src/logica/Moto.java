package logica;

public class Moto extends Vehiculo {
    private int cilindraje;
    private double tamano_tanque;

    /**
     * Constructor de la clase Moto.
     *
     * @param marca
     * @param placa
     * @param referencia
     * @param modelo
     * @param num_placa
     * @param cilindraje
     * @param tamano_tanque
     * @param precio
     */
    public Moto(String marca, String placa, String referencia, String modelo, int num_placa, int cilindraje, double tamano_tanque , double precio) {
        super(marca, placa, referencia, modelo, num_placa , precio);
        this.cilindraje = cilindraje;
        this.tamano_tanque = tamano_tanque;
    }

    /**
     * Constructor vacio.
     */
    public Moto(){

    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public double getTamano_tanque() {
        return tamano_tanque;
    }

    public void setTamano_tanque(double tamano_tanque) {
        this.tamano_tanque = tamano_tanque;
    }


    /**
     * Método que me retorna los datos de la moto.
     * @return
     */
    @Override
    public String toString() {
        return super.toString()+
                " cilindraje= " + cilindraje +
                " tamaño del tanque= " + tamano_tanque ;
    }
}
