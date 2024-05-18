// Définition d'une interface pour représenter un résultat pouvant être une valeur ou une erreur
interface Result<T, E> {
    value?: T;
    error?: E;
  }
  
  // Fonction qui prend un tableau de nombres, filtre les nombres pairs et renvoie leur somme
  function sumOfEvenNumbers(numbers: number[]): Result<number, string> {
    if (!numbers || numbers.length === 0) {
      return { error: "Aucun nombre fourni." };
    }
  
    const evenNumbers = numbers.filter(num => num % 2 === 0);
    if (evenNumbers.length === 0) {
      return { error: "Aucun nombre pair trouvé." };
    }
  
    const sum = evenNumbers.reduce((acc, curr) => acc + curr, 0);
    return { value: sum };
  }
  
  // Exemple d'utilisation
  const numbers = [1, 2, 3, 4, 5, 6];
  const result = sumOfEvenNumbers(numbers);
  
  if (result.value !== undefined) {
    console.log("La somme des nombres pairs est :", result.value);
  } else {
    console.error("Erreur :", result.error);
  }  