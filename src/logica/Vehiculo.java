package logica;

public abstract class Vehiculo {

    private String marca;
    private String placa;
    private String referencia;
    private String modelo;
    private int num_ruedas;


    public Vehiculo(String marca, String placa, String referencia, String modelo, int num_placa) {
        this.marca = marca;
        this.placa = placa;
        this.referencia = referencia;
        this.modelo = modelo;
        this.num_ruedas = num_placa;
    }


    public Vehiculo() {

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNum_ruedas() {
        return num_ruedas;
    }

    public void setNum_ruedas(int num_placa) {
        this.num_ruedas = num_placa;
    }

    public abstract void queSoy();


}
