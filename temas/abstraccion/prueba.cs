public class pruebaEjemplo{
    public static void Main(){
        List<Publicacion> publicaciones  =
        [
            new Publicacion(DateTime.Now, 100, "", 1, "Juan Manuel Dodero", "Cómo aprobar IISS", Publicacion.TipoPub.LIBRO),
            new Publicacion(DateTime.Now, 500, "", 1, "Alejandro Sánchez", "Enum considered Harmfull", Publicacion.TipoPub.LIBRO),
            new Publicacion(DateTime.Now, 800, "UCA", 100, "", "", Publicacion.TipoPub.REVISTA),
            new Publicacion(DateTime.Now, 300, "National Geographic", 310, "", "", Publicacion.TipoPub.REVISTA),
        ];
        foreach(Publicacion p in publicaciones){
            p.mostrarDetalles();
        }
       
    }
}