package logica;

public class Auto extends Vehiculo{

    private int num_puertas;
    private boolean is_gasolina;

    public Auto(){

    }

    public Auto(String marca, String placa, String referencia, String modelo, int num_placa,  int num_puertas, boolean is_gasolina , double precio) {
        super(marca, placa, referencia, modelo, num_placa , precio);
        this.num_puertas = num_puertas;
        this.is_gasolina = is_gasolina;
    }

    public int getNum_puertas() {
        return num_puertas;
    }

    public void setNum_puertas(int num_puertas) {
        this.num_puertas = num_puertas;
    }

    public boolean isIs_gasolina() {
        return is_gasolina;
    }

    public void setIs_gasolina(boolean is_gasolina) {
        this.is_gasolina = is_gasolina;
    }

    @Override
    public void clacularPrecio() {
        System.out.println("El precio total esd de: " + getPrecio());

    }
}
