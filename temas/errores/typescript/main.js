// Fonction qui prend un tableau de nombres, filtre les nombres pairs et renvoie leur somme
function sumOfEvenNumbers(numbers) {
    if (!numbers || numbers.length === 0) {
        return { error: "Aucun nombre fourni." };
    }
    var evenNumbers = numbers.filter(function (num) { return num % 2 === 0; });
    if (evenNumbers.length === 0) {
        return { error: "Aucun nombre pair trouvé." };
    }
    var sum = evenNumbers.reduce(function (acc, curr) { return acc + curr; }, 0);
    return { value: sum };
}
// Exemple d'utilisation
var numbers = [1, 2, 3, 4, 5, 6];
var result = sumOfEvenNumbers(numbers);
if (result.value !== undefined) {
    console.log("La somme des nombres pairs est :", result.value);
}
else {
    console.error("Erreur :", result.error);
}
