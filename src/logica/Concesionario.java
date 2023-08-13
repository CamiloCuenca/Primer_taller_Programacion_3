package logica;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Concesionario {

    //Lista de Vehiculos disponibles
    public static List<Auto> autos = new ArrayList<>();
    public static List<Moto> motos = new ArrayList<>();
    public static List<Camion> camiones = new ArrayList<>();

    //Listas de vehiculos vendidos

    public static List<Vehiculo> vehiculosVendidos = new ArrayList<>();
    public static List<Auto> autosVendidos = new ArrayList<>();
    public static List<Moto> motosVendidas = new ArrayList<>();
    public static List<Camion> camionesvendidos = new ArrayList<>();


    public static void Menu (){
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {

            String menuMensaje = "Menú:\n" +
                    "1. registrar vehiculo\n" +
                    "2. buscar vehiculo\n" +
                    "3. listar vehiculos disponibles\n" +
                    "4. vender vehiculo\n" +
                    "5. cantidad de vehiculos disponibles\n" +
                    "6. actualizar datos\n" +
                    "7. ventas totales\n" +
                    "8. eliminar vehiculo\n" +
                    "9. salir\n" +
                    "Ingrese la opción:";

            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menuMensaje));

            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado la Opción 3.");

                    String tipoVehiculoMensaje = "Selecciona el tipo de vehículo:\n" +
                            "1. Auto\n" +
                            "2. Moto\n" +
                            "3. Camión";
                    int tipoVehiculo = Integer.parseInt(JOptionPane.showInputDialog(null, tipoVehiculoMensaje));

                    switch (tipoVehiculo) {
                        case 1:
                            String marca = JOptionPane.showInputDialog("Ingrese la marca");
                            String placa =  JOptionPane.showInputDialog("Ingrese la Placa");
                            String referencia =  JOptionPane.showInputDialog("Ingrese la referencia");
                            String modelo =  JOptionPane.showInputDialog("Ingrese el modelo");
                            int num_ruedas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de ruedas"));
                            int num_puertas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de puertas"));
                            String is_gasolina = JOptionPane.showInputDialog("¿El auto usa gasolina?" +"\n(si , no)");
                            boolean gasolina = false;
                            if(is_gasolina.toLowerCase().equals("si")){
                                gasolina = true;
                            }else if (is_gasolina.toLowerCase().equals("no")){
                                gasolina= false;
                            }

                            autos.add(new Auto(marca,placa,referencia,modelo,num_ruedas,num_puertas,gasolina));
                            System.out.println("Auto agregado al listado.");
                            break;
                        case 2:
                            String marca_moto = JOptionPane.showInputDialog("Ingrese la marca");
                            String placa_moto = JOptionPane.showInputDialog("Ingrese la placa");
                            String referencia_moto = JOptionPane.showInputDialog("Ingrese la referencia");
                            String modelo_moto = JOptionPane.showInputDialog("Ingrese el modelo");
                            int num_ruedas_moto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de ruedas"));
                            int cilindraje_moto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el cilindraje"));
                            double tamano_tanque = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el tamaño del tanque"));

                            motos.add(new Moto(marca_moto,placa_moto,referencia_moto,modelo_moto,num_ruedas_moto,cilindraje_moto,tamano_tanque));
                            System.out.println("Moto agregada al listado.");
                            break;
                        case 3:

                            String marca_camion = JOptionPane.showInputDialog("Ingrese la marca");
                            String placa_camion = JOptionPane.showInputDialog("Ingrese la placa");
                            String referencia_camion = JOptionPane.showInputDialog("Ingrese la referenia");
                            String modelo_camion = JOptionPane.showInputDialog("Ingrese el modelo");
                            int num_ruedas_camion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de ruedas"));
                            int  cap_carga = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad de carga"));

                            camiones.add(new Camion(marca_camion,placa_camion,referencia_camion,modelo_camion,num_ruedas_camion,cap_carga));
                            System.out.println("Camión agregado al listado.");
                            break;
                        default:
                            System.out.println("Tipo de vehículo no válido.");
                    }
                    break;

                case 2:
                    System.out.println("Has seleccionado la Opción 2.");
                    String placasBuscar = JOptionPane.showInputDialog("Ingrese la placa a buscar");
                    buscarVehiculo(autos, placasBuscar);
                    buscarVehiculo(motos, placasBuscar);
                    buscarVehiculo(camiones, placasBuscar);

                    break;
                case 3:
                    System.out.println("Vehículos en la lista de Autos:");
                    mostrarVehiculos(autos);
                    System.out.println("\nVehículos en la lista de Motos:");
                    mostrarVehiculos(motos);
                    System.out.println("\nVehículos en la lista de Camiones:");
                    mostrarVehiculos(camiones);
                    break;
                case 4:
                    System.out.println("Has seleccionado la Opción 4.");
                    String placasVehiculo = JOptionPane.showInputDialog("Ingrese la placa a buscar para vender el vehiculo");
                    venderVehiculo(autos,placasVehiculo,vehiculosVendidos);
                    break;
                case 5:
                    System.out.println("Has seleccionado la Opción 5.");
                    int total = autos.size()+motos.size()+camiones.size();
                    JOptionPane.showMessageDialog(null , "El total de vehiculos disponibles es: " + total);

                    break;
                case 6:
                    System.out.println("Has seleccionado la Opción 6.");
                    int opcionEditar = Integer.parseInt(JOptionPane.showInputDialog("Selecciona el tipo de vehículo:\n" +
                            "1. Auto\n" +
                            "2. Moto\n" +
                            "3. Camión"));

                    switch (opcionEditar){
                        case 1:
                            String placa_editar_auto = JOptionPane.showInputDialog("Ingree la placa del auto que quiere editar");
                            editarAuto(autos,placa_editar_auto);

                            break;
                        case 2:
                            String placa_editar_moto = JOptionPane.showInputDialog("Ingree la placa de la moto que quiere editar");
                            editarMoto(motos,placa_editar_moto);

                            break;
                        case 3:
                            String placa_editar_camion = JOptionPane.showInputDialog("Ingree la placa del camion que quiere editar");
                            editarCamion(camiones,placa_editar_camion);
                            break;
                    }

                    break;
                case 7:
                    System.out.println("Has seleccionado la Opción 7.");
                    JOptionPane.showMessageDialog(null , "La ventas totales son: "+vehiculosVendidos.size());
                    break;
                case 8:
                    System.out.println("Has seleccionado la Opcion 8. ");
                    String placasEliminar = JOptionPane.showInputDialog("Ingrese la placa a buscar para eliminar el vehiculo ");
                    eliminarVehiculo(autos,placasEliminar);
                    eliminarVehiculo(motos,placasEliminar);
                    eliminarVehiculo(camiones,placasEliminar);

                    break;

                case 9:
                    System.out.println("Se cerro el programa :)");;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
            }
        } while (opcion != 9);

        scanner.close();
    }

    private static <A extends Vehiculo> void buscarVehiculo(List<A> lista, String numPlacas) {
        for (Vehiculo vehiculo : lista) {
            if (vehiculo.getPlaca().equals(numPlacas)) {
                System.out.println("Vehículo encontrado: " + vehiculo.getMarca() + " "+ vehiculo.getModelo());

                return;
            }
        }
        System.out.println("Vehículo no encontrado con placas: " + numPlacas);
    }

    private static <A extends Vehiculo> void venderVehiculo(List<A> lista , String numPlacas,List<Vehiculo> listaVendidos){
        for(Vehiculo vehiculo:lista) {
            if (vehiculo.getPlaca().equals(numPlacas)) {
                listaVendidos.add(vehiculo);
                lista.remove(vehiculo);

                System.out.println("¡Vehiculo Vendido con exito!");
                return;
            }
            System.out.println("Vehículo no encontrado con placas: " + numPlacas);

        }
    }

    private static  void editarAuto(List<Auto> lista , String num_placa){
        for(Auto auto :lista){
            if(auto.getPlaca().equals(num_placa)){

                 String marca = JOptionPane.showInputDialog("Ingrese la marca",auto.getMarca());
                 String placa =  JOptionPane.showInputDialog("Ingrese la placa", auto.getPlaca());
                 String referencia =  JOptionPane.showInputDialog("Ingrese la referencia" , auto.getReferencia());
                 String modelo =  JOptionPane.showInputDialog("Ingrese el modelo" , auto.getModelo());
                 int num_ruedas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de ruedas" , auto.getNum_ruedas()));
                 int num_puertas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de puertas" , auto.getNum_puertas()));
                 String is_gasolina = JOptionPane.showInputDialog("¿El auto usa gasolina?" +"\n(si , no)");
                 boolean gasolina = false;
                 if(is_gasolina.toLowerCase().equals("si")){
                     gasolina = true;
                 }else if (is_gasolina.toLowerCase().equals("no")){
                     gasolina= false;
                 }

                 auto.setMarca(marca);
                 auto.setPlaca(placa);
                 auto.setReferencia(referencia);
                 auto.setModelo(modelo);
                 auto.setNum_ruedas(num_ruedas);
                 auto.setNum_puertas(num_puertas);
                 auto.setIs_gasolina(gasolina);

                 JOptionPane.showMessageDialog(null , "¡La edicion se completo con exito!");

            }
        }
    }

    private static void editarMoto(List<Moto> lista , String num_placa){
        for(Moto  moto :lista){
            if(moto.getPlaca().equals(num_placa)) {
                String marca = JOptionPane.showInputDialog("Ingrese la marca" , moto.getMarca());
                String placa = JOptionPane.showInputDialog("Ingrese la placa" , moto.getPlaca());
                String referencia = JOptionPane.showInputDialog("Ingrese la referencia" , moto.getReferencia());
                String modelo = JOptionPane.showInputDialog("Ingrese el modelo" , moto.getModelo());
                int num_ruedas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de ruedas" , moto.getNum_ruedas()));
                int cilindraje = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el cilindraje" , moto.getCilindraje()));
                double tamano_tanque = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el tamaño del tanque" , moto.getTamano_tanque()));

                moto.setMarca(marca);
                moto.setPlaca(placa);
                moto.setReferencia(referencia);
                moto.setModelo(modelo);
                moto.setNum_ruedas(num_ruedas);
                moto.setCilindraje(cilindraje);
                moto.setTamano_tanque(tamano_tanque);



                JOptionPane.showMessageDialog(null, "¡La edicion se completo con exito!");
            }
        }
    }


    private static void editarCamion(List<Camion> lista , String num_placa){

        for(Camion  camion :lista){
            if(camion.getPlaca().equals(num_placa)) {
                String marca = JOptionPane.showInputDialog("Ingrese la marca" , camion.getMarca());
                String placa = JOptionPane.showInputDialog("Ingrese la placa" , camion.getPlaca());
                String referencia = JOptionPane.showInputDialog("Ingrese la referencia" , camion.getReferencia());
                String modelo = JOptionPane.showInputDialog("Ingrese el modelo" , camion.getModelo());
                int num_ruedas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de puertas" , camion.getNum_ruedas()));
                int  cap_carga = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad de carga" , camion.getCap_carga()));

                camion.setMarca(marca);
                camion.setPlaca(placa);
                camion.setReferencia(referencia);
                camion.setModelo(modelo);
                camion.setNum_ruedas(num_ruedas);
                camion.setCap_carga(cap_carga);


                JOptionPane.showMessageDialog(null, "¡La edicion se completo con exito!");
            }
        }

    }

    private static <A extends Vehiculo> void  eliminarVehiculo (List<A> lista , String numPlacas){
        for(Vehiculo vehiculo:lista) {
            if (vehiculo.getPlaca().equals(numPlacas)) {
                lista.remove(vehiculo);

                System.out.println("¡Vehiculo eliminado con exito!");
                return;
            }
            System.out.println("Vehículo no encontrado con placas: " + numPlacas);

        }
    }

    private static <x extends Vehiculo> void mostrarVehiculos(List<x> lista) {
        for (Vehiculo vehiculo : lista) {
            System.out.println(vehiculo.getMarca()+" "+ vehiculo.getPlaca()+" "+vehiculo.getModelo());
        }
    }




}
