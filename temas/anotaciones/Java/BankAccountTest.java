import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BankAccountTest {
  
  public static void main(String[] args) throws Exception{

    System.out.println("Creamos 2 objetos con distinto id...");
    BankAccount ba1 = new BankAccount("1111");
    BankAccount ba2 = new BankAccount("2222");
    System.out.println("Les inyectamos los atributos de comparador por fecha y la fecha actual...\n");
    DependencyInjector.injectField(ba1);
    DependencyInjector.injectField(ba2);

    int res = ba1.compareTo(ba2);
    System.out.println("Resultado de compararlos mediante el comparador del primer objeto(fecha): "  + res);

    res = ba2.compareTo(ba1);
    System.out.println("Resultado de compararlos mediante el comparador del segundo objeto(fecha): "  + res);

    System.out.println("Inyectamos al primer objeto el comparador por id mediante metodo...");

    DependencyInjector.injectMethod(ba1);

    res = ba1.compareTo(ba2);
    System.out.println("Resultado de compararlos mediante el comparador del primer objeto(ID): "  + res);
    res = ba2.compareTo(ba1);
    System.out.println("De nuevo el resultado de compararlos mediante el comparador del segundo objeto(fecha): "  + res);
    
  }
}
