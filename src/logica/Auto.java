package logica;
public class Auto extends Vehiculo{
    private int num_puertas;
    private boolean is_gasolina;

    /**
     * Constructor vacio.
     */
    public Auto(){

    }

    /**
     * Constructor de la clase Auto.
     * @param marca
     * @param placa
     * @param referencia
     * @param modelo
     * @param num_placa
     * @param num_puertas
     * @param is_gasolina
     * @param precio
     */
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

    public boolean getIs_gasolina() {
        return is_gasolina;
    }

    public void setIs_gasolina(boolean is_gasolina) {
        this.is_gasolina = is_gasolina;
    }

    /**
     * Metodo toSring el cual me retorna os datos del auto.
     *
     * @return
     */
    @Override
    public String toString() {
        
        String gosolina = null;
        if(is_gasolina){
            gosolina = "si";
        } else if (!is_gasolina) {
            gosolina="no";
        }
        return super.toString()+
                " número puertas= " + num_puertas +
                " Usa gasolina= " + gosolina ;
    }
}
