// Définition de l'interface du service
trait Service {
  def operation(): Unit
}

// Implémentation du service
class ServiceImpl extends Service {
  override def operation(): Unit = {
    println("Opération effectuée par le service")
  }
}

// Classe utilisant la délégation pour déléguer l'opération à un service
class Client(service: Service) {
  def performOperation(): Unit = {
    service.operation()
  }
}

// Application principale
object Main extends App {
  // Création d'une instance du service
  val service = new ServiceImpl()

  // Création d'une instance du client en lui fournissant le service
  val client = new Client(service)

  // Appel de la méthode pour effectuer l'opération
  client.performOperation()
}
