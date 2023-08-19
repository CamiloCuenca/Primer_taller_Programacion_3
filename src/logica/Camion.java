package logica;

public class Camion extends Vehiculo{
    private int  cap_carga;



    public Camion(String marca, String placa, String referencia, String modelo, int num_placa, int cap_carga , double precio) {
        super(marca, placa, referencia, modelo, num_placa , precio);
        this.cap_carga = cap_carga;
    }

    public Camion() {

    }
    public int getCap_carga() {
        return cap_carga;
    }

    public void setCap_carga(int cap_carga) {
        this.cap_carga = cap_carga;
    }

    @Override
    public String toString() {
        return super.toString()+
                "capacidad de carga=" + cap_carga;
    }
}
