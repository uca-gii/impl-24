# Definimos una lista de números
numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

# Definimos una función lambda para filtrar números pares
filtrar_pares = ->(num) { num.even? }

# Filtramos la lista de números utilizando la función lambda
numeros_pares = numeros.select(&filtrar_pares)

# Imprimimos los números pares
puts "Números pares: #{numeros_pares}"
