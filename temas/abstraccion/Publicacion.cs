public class Publicacion{
    public enum TipoPub{
        LIBRO,
        REVISTA
    }

    public DateTime fechaPublicacion;
    public int ejemplares;
    public string editorial;
    public int numero;
    public string autor;
    public string titulo;
    public TipoPub tipo;


    public Publicacion(DateTime f, int ej, string ed, int num, string au, string tit, TipoPub t){
        fechaPublicacion = f;
        ejemplares = ej;
        editorial = ed;
        numero = num;
        autor = au;
        titulo = tit;
        tipo = t;

    }
    public void mostrarDetalles(){
        if(tipo == TipoPub.LIBRO){
            Console.WriteLine("Libro:\n");
            Console.WriteLine("Fecha de publicación: " + fechaPublicacion + "\n");
            Console.WriteLine("Ejemplares: " + ejemplares + "\n");
            Console.WriteLine("Título: " + titulo + "\n");
            Console.WriteLine("Autor: " + autor + "\n");
        }
        else{
            Console.WriteLine("Revista:\n");
            Console.WriteLine("Fecha de publicación: " + fechaPublicacion + "\n");
            Console.WriteLine("Ejemplares: " + ejemplares + "\n");
            Console.WriteLine("Editorial: " + editorial + "\n");
            Console.WriteLine("Edición número: " + numero + "\n");
        }
    }
}