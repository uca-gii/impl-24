using Herencia;

namespace Herencia
{
    public class Program {
    static void Main(string[] args) {
        var smartphone = new Smartphone("Sony", 12, 1080, "iOS");

        // No se puede acceder directamente a Id heredado porque es protegido
        // Console.WriteLine("Id del sensor de la cámara: " + smartphone.Id); 

        Console.WriteLine("Fabricante de la cámara: " + smartphone.fabricanteCamara);
        Console.WriteLine("Megapixeles: " + smartphone.Megapixeles);
        Console.WriteLine("Resolución: " + smartphone.Resolucion);
        Console.WriteLine("Sistema Operativo: " + smartphone.SistemaOperativo);
        smartphone.capturarImagen();
        // La salida no estará actualizada porque el método no estaba marcado como virtual
        smartphone.GrabarVideo(); 
    }
    }

}