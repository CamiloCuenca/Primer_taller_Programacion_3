package logica;

public class Moto extends Vehiculo {

    private int cilindraje;
    private double tamano_tanque;

    public Moto(String marca, String placa, String referencia, String modelo, int num_placa, int cilindraje, double tamano_tanque , double precio) {
        super(marca, placa, referencia, modelo, num_placa , precio);
        this.cilindraje = cilindraje;
        this.tamano_tanque = tamano_tanque;
    }

    public Moto(){

    }

    public Moto(int cilindraje, double tamano_tanque) {
        this.cilindraje = cilindraje;
        this.tamano_tanque = tamano_tanque;
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



    @Override
    public String toString() {
        return super.toString()+
                "cilindraje=" + cilindraje +
                ",tamaño del tanque=" + tamano_tanque ;
    }
}
