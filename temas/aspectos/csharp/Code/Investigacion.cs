public class Investigacion: ArchivoPolicial{
    int idPolicia;
    int idSospechoso;
    DateTime fechaDelito;

    public Investigacion(int id, int p, int s, DateTime f){
        idArchivo= id;
        idPolicia = p;
        idSospechoso = s;
        fechaDelito = f;
    }

   [RegistroAspecto]
public override void mostrarDetalles(int numPlaca)
{
    Console.WriteLine("+--------------------------------------+");
    Console.WriteLine("|             Detalles de la Investigacion         |");
    Console.WriteLine("+--------------------------------------+");
    Console.WriteLine("| Id de la Investigacion: " + idArchivo);
    Console.WriteLine("| Policia encargado: " + idPolicia);
    Console.WriteLine("| Sospechoso: " + idSospechoso);
    Console.WriteLine("| Fecha del delito: " + fechaDelito.ToShortDateString());
    Console.WriteLine("+--------------------------------------+");
}


    [RegistroAspecto]
    public override void solicitarRevision(int numPlaca){
        Console.WriteLine("+-------------------------------------------------+");
        Console.WriteLine("|                     Revisión                    |");
        Console.WriteLine("+-------------------------------------------------+");
        Console.WriteLine("| Enviado una solicitud de revisión de la investigacion");
        Console.WriteLine("+-------------------------------------------------+");
    }
}