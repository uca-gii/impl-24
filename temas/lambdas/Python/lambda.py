
print("Probamos la sintaxis basica de las lambdas...")
#Sintaxis básica
double = lambda x: x * 2
print(double(5), "\n") # Salida: 10

print("Probamos a introducir bucles y llamadas a funciones")
#introducimos bucles
dobleSumaDigitos = lambda n: sum([int(x)*2 for x in str(n)])
print("dobleSumaDigitos():", dobleSumaDigitos(210), "\n") # Salida: 6

print("Utilizamos una lambda como parámetro")
#sorted puede recibir una fuinción en el parámetro key
#  que indique como se debe ordenar
miLista = [(1, 5), (2, 3), (3, 1), (4, 2)]
listaOrdenada = sorted(miLista, key=lambda x: x[1])
print(listaOrdenada, "\n") # Salida: [(3, 1), (4, 2), (2, 3), (1, 5)]

print("\nAhora probamos el uso de Generators con un bucle")

def numerosPares(limite):
    n=0
    while n < limite:
        yield n
        n = n+2

for value in numerosPares(10):
    print(value) 

print("Probamos el generator usando la funcion next() para llenar una lista")
generator = numerosPares(10)
listaInput = [next(generator), next(generator), next(generator), next(generator), next(generator)]

print(listaInput)
print("\nA partir de la lista anterior generamos una list comprehesion con los multiplos de 4...")

lista_comp = [value for value in listaInput if value % 4 == 0]

print(lista_comp)
