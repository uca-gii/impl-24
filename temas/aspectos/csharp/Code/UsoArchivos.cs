public class PruebaAspectos{
    public static void Main(){
        Investigacion Investigacion1 = new Investigacion(845 ,10,2,new DateTime(2024, 4, 1));
        Juicio juicio1 = new Juicio(376, Investigacion1, 50,  new DateTime(2024, 6, 1));

        Investigacion1.mostrarDetalles(58342);
        juicio1.mostrarDetalles(58342);
        Investigacion1.solicitarRevision(7699);
        juicio1.solicitarRevision(7699);
        //juicio1.setFecha(new DateTime(2024, 6, 14), "policia");
        juicio1.setFecha(new DateTime(2024, 6, 14), "contraseña");
        RegistradorAcciones.verAcciones();

    }
}