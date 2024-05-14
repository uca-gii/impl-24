using Herencia;

namespace Herencia {
    // Clase derivada de "Camara" llamada "CamaraSmartphone"
    public class Smartphone : Camara {
        public string SistemaOperativo { get; set; }

        // método constructor de la clase "Smartphone"
        public Smartphone(string fabricanteCamara, int Megapixeles, int Resolucion, string SistemaOperativo) {
            this.fabricanteCamara = fabricanteCamara;
            this.Megapixeles = Megapixeles;
            this.Resolucion = Resolucion;
            this.SistemaOperativo = SistemaOperativo;
        }

        // Método sobreescrito/invalidado de la clase base "Camara"
        public override void capturarImagen() {
            Console.WriteLine("¡Capturando foto con el smartphone!");
        }

        // No se puede sobreescribir/invalidar ya que el método en la clase base "Camara" no está marcado como virtual
        /*
        public override void GrabarVideo() {
            Console.WriteLine("¡Grabando video con el smartphone!");
        }
        */
    }

}
// Clase derivada de "Camara" llamada "CamaraSmartphone"
public class Smartphone : Camara {
    public string SistemaOperativo { get; set; }

    // método constructor de la clase "Smartphone"
    public Smartphone(string fabricanteCamara, int Megapixeles, int Resolucion, string SistemaOperativo) {
        this.fabricanteCamara = fabricanteCamara;
        this.Megapixeles = Megapixeles;
        this.Resolucion = Resolucion;
        this.SistemaOperativo = SistemaOperativo;
    }

    // Método sobreescrito/invalidado de la clase base "Camara"
    public override void capturarImagen() {
        Console.WriteLine("¡Capturando foto con el smartphone!");
    }

    // No se puede sobreescribir/invalidar ya que el método en la clase base "Camara" no está marcado como virtual
    /*
    public override void GrabarVideo() {
        Console.WriteLine("¡Grabando video con el smartphone!");
    }
    */
}

