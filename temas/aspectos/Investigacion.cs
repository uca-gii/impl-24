public class Investigacion: ArchivoPolicial{
    int identificador;
    int idPolicia;
    int idSospechoso;
    DateTime fechaDelito;

    public Investigacion(int id, int p, int s, DateTime f){
        identificador = id;
        idPolicia = p;
        idSospechoso = s;
        fechaDelito = f;
    }
    public int getId(){
        return identificador;
    }

public void mostrarDetalles()
{
    Console.WriteLine("+--------------------------------------+");
    Console.WriteLine("|             Detalles de la Investigacion         |");
    Console.WriteLine("+--------------------------------------+");
    Console.WriteLine("| Id del Investigacion: " + identificador);
    Console.WriteLine("| Policia encargado: " + idPolicia);
    Console.WriteLine("| Sospechoso: " + idSospechoso);
    Console.WriteLine("| Fecha del delito: " + fechaDelito.ToShortDateString());
    Console.WriteLine("+--------------------------------------+");

    RegistradorAcciones.registrarAccion("Se han consultado los detalles de un archivo");
}

    public void solicitarRevision(){
        Console.WriteLine("+-------------------------------------------------+");
        Console.WriteLine("|                     Revisión                    |");
        Console.WriteLine("+-------------------------------------------------+");
        Console.WriteLine("| Enviado una solicitud de revisión de la investigacion");
        Console.WriteLine("+-------------------------------------------------+");

        RegistradorAcciones.registrarAccion("Se ha solicitado la revisión de un caso");
    }
}