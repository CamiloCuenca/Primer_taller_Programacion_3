package logica;

public class Camion extends Vehiculo{
    private int  cap_carga;



    public Camion(String marca, String placa, String referencia, String modelo, int num_placa, int cap_carga) {
        super(marca, placa, referencia, modelo, num_placa);
        this.cap_carga = cap_carga;
    }

    public Camion() {

    }
    @Override
    public void queSoy() {
        System.out.println("yo soy un camion");

    }

    public int getCap_carga() {
        return cap_carga;
    }

    public void setCap_carga(int cap_carga) {
        this.cap_carga = cap_carga;
    }
}
