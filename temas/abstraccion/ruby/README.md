# Abstracción en Ruby

Este directorio contiene ejemplos de cómo implementar el concepto de abstracción utilizando Ruby.

## Estructura del Directorio

- [`app/`](app/): Contiene el frontend y el backend implementado en JavaScript.
- [`ruby_src/`](ruby_src/): Contiene los archivos fuente de los ejemplos de Ruby.
- [`ruby_test/`](ruby_test/): Contiene los tests para los ejemplos de Ruby.
- [`Dockerfile`](Dockerfile): Configuración para Docker.
- [`terra.tf`](terra.tf): Configuración para Terraform.

## Contenido

### Código ejemplos

Los ejemplos que se han implementado para representar abstracción con Ruby son los siguientes:

[**Animal.rb**](ruby_src/Animal.rb)

```rb
module Animal
    attr_accessor :nombre
    attr_reader :especie, :edad
 
    def initialize(nombre, edad, especie)
       @nombre = nombre
       @edad = edad
       @especie = especie
    end

    def cumpleaños
      @edad = @edad +1
    end
 
    def describir
       "-----------------------------\nNombre: #{nombre}\nEdad: #{edad}\nEspecie: #{especie}\n"
    end
end
```
El código anterior define un módulo en Ruby llamado Animal.

Componentes del Módulo Animal:

`attr_accessor :nombre:`
Esto proporciona métodos getter y setter para el atributo nombre con los que puedes obtener el valor del nombre de un animal y también asignarle un nuevo valor.

`attr_reader :especie, :edad:`
Esto proporciona métodos getter para especie, puedes leer estos atributos, pero no modificarlos directamente desde fuera del módulo (sin un método específico que permita dicha modificación, como el método cumpleaños para edad).

`initialize(nombre, edad, especie):`
Este es el método inicializador que se llama cuando creas un nuevo objeto que incluye este módulo.

`cumpleaños:`
Este método incrementa el atributo edad en uno. 

`describir:`
Este método devuelve una cadena de texto que describe el animal, mostrando su nombre, edad y especie.

[**Terrestre.rb**](ruby_src/Terrestre.rb)

```rb
require_relative 'Animal'

class Terrestre
    include Animal
    attr_accessor :habitat
 
    def initialize(nombre, edad, especie, habitat)
       super(nombre, edad, especie)
       @habitat = habitat
    end
 
    def describir
       super + "Habitat: #{habitat}\n-----------------------------\n"
    end
end
```
El código anterior define la clase Terrestre que hace uso del módulo Animal.

Componentes de la clase Terrestre:

`require_relative 'Animal':`
Esta línea importa el módulo Animal.

`include Animal:`
Este código incluye el módulo Animal en la clase Terrestre, lo que significa que Terrestre hereda todos los métodos y atributos definidos en Animal.

`attr_accessor :habitat:`
Proporciona métodos getter y setter para el atributo habitat. Esto permite leer y modificar el habitat de una instancia de Terrestre.

`initialize(nombre, edad, especie, habitat):`
Este es el constructor de la clase Terrestre, que se utiliza para inicializar nuevas instancias. 

`describir:`
Este método sobrescribe el método describir del módulo Animal. Utiliza super para llamar al método original describir de Animal, y luego añade información sobre el habitat del animal.

Para los siguientes códigos no explico parte a parte su contenido debido a que siguen una estructura muy similar al anterior código.

[**Acuatico.rb**](ruby_src/Acuatico.rb)

```rb
require_relative 'Animal'

class Acuatico
    include Animal
    attr_accessor :profundidad_max
 
    def initialize(nombre, edad, especie, profundidad_max)
       super(nombre, edad, especie)
       @profundidad_max = profundidad_max
    end
 
    def describir
       super + "Profundidad máxima: #{profundidad_max}m\n-----------------------------\n"
    end
end
```

[**Ave.rb**](ruby_src/Ave.rb)

```rb
require_relative 'Animal'

class Ave
    include Animal
    attr_accessor :envergadura_alas
 
    def initialize(nombre, edad, especie, envergadura_alas)
       super(nombre, edad, especie)
       @envergadura_alas = envergadura_alas
    end
 
    def describir
       super + "Envergadura de alas: #{envergadura_alas}cm\n-----------------------------\n"
    end
end
```

## Código tests

Para llevar a cabo los tests se ha utilizado el marco de pruebas de Ruby Minitest. A continuación se pueden ver los códigos de prueba.

[**Animal_test.rb**](ruby_test/Animal_test.rb)

```rb
require 'minitest/autorun'
require_relative '../ruby_src/Animal'

class AnimalSinMas
  include Animal

  def initialize(nombre, edad, especie)
    super(nombre, edad, especie)    
  end

  def describir
    super + "-----------------------------\n"
  end
end

class AnimalTest < Minitest::Test
  def setup
    @lolo = AnimalSinMas.new("Lolo", 5, "Perro")
  end

  def test_nombre
    assert_equal("Lolo", @lolo.nombre)
  end

  def test_edad
    assert_equal(5, @lolo.edad)
  end

  def test_especie
    assert_equal("Perro", @lolo.especie)
  end

  def test_describir
    expected = "-----------------------------\nNombre: Lolo\nEdad: 5\nEspecie: Perro\n-----------------------------\n"
    assert_equal(expected, @lolo.describir)
  end

  def test_cambio_nombre
    @lolo.nombre = 'lolito'
    assert_equal('lolito', @lolo.nombre)
  end

  def test_cumpleaños
    age = @lolo.edad
    @lolo.cumpleaños
    assert_equal(age+1, @lolo.edad)
  end
  
end
```

`Definición de la Clase AnimalSinMas:` Con el fin de poder probar el módulo se define una clase auxiliar que usa el módulo y poder trabajar con una instancia de dicha clase.

`setup:` Método que se ejecuta antes de cada prueba; crea una instancia de AnimalSinMas. Esta instancia es utilizada en las siguientes pruebas.

`test_nombre, test_edad, test_especie:` Métodos que verifican que los atributos del objeto @lolo sean inicializados correctamente.

`test_describir:` Verifica que el método describir de la instancia retorne la cadena esperada.

`test_cambio_nombre:` Prueba la funcionalidad del método nombre generado por attr_accessor en Animal.

`test_cumpleaños:` Prueba el método cumpleaños que incrementa la edad del objeto.

Como con los códigos de ejemplos, para los siguientes códigos no se explicará detenenidamente cada parte, solo se mostrarán.

[**Terrestre_test.rb**](ruby_test/Terrestre_test.rb)

```rb
require 'minitest/autorun'
require_relative '../ruby_src/Terrestre'

class TerrestreTest < Minitest::Test
  def setup
    @manolo = Terrestre.new("Manolo", 5, "León", "Selva")
  end

  def test_nombre
    assert_equal("Manolo", @manolo.nombre)
  end

  def test_edad
    assert_equal(5, @manolo.edad)
  end

  def test_especie
    assert_equal("León", @manolo.especie)
  end

  def test_habitat
    assert_equal("Selva", @manolo.habitat)
  end

  def test_describir
    expected = "-----------------------------\nNombre: Manolo\nEdad: 5\nEspecie: León\nHabitat: Selva\n-----------------------------\n"
    assert_equal(expected, @manolo.describir)
  end

  def test_cambio_habitat
    @manolo.habitat = 'Jungla'
    assert_equal('Jungla', @manolo.habitat)
  end
  
end
```

[**Acuatico_test.rb**](ruby_test/Acuatico_test.rb)

```rb
require 'minitest/autorun'
require_relative '../ruby_src/Acuatico'

class AcuaticoTest < Minitest::Test
  def setup
    @nemo = Acuatico.new("Nemo", 3, "Pez", 100)
  end

  def test_nombre
    assert_equal("Nemo", @nemo.nombre)
  end

  def test_edad
    assert_equal(3, @nemo.edad)
  end

  def test_especie
    assert_equal("Pez", @nemo.especie)
  end

  def test_profundidad_max
    assert_equal(100, @nemo.profundidad_max)
  end

  def test_describir
    expected = "-----------------------------\nNombre: Nemo\nEdad: 3\nEspecie: Pez\nProfundidad máxima: 100m\n-----------------------------\n"
    assert_equal(expected, @nemo.describir)
  end

  def test_cambio_profundidad
    @nemo.profundidad_max = 150
    assert_equal(150, @nemo.profundidad_max)
  end

end
```

[**Ave_test.rb**](ruby_test/Ave_test.rb)

```rb
require 'minitest/autorun'
require_relative '../ruby_src/Ave'

class AveTest < Minitest::Test
  def setup
    @perico = Ave.new("Perico", 4, "Agaporni", 15)
  end

  def test_nombre
    assert_equal("Perico", @perico.nombre)
  end

  def test_edad
    assert_equal(4, @perico.edad)
  end

  def test_especie
    assert_equal("Agaporni", @perico.especie)
  end

  def test_envergadura_alas
    assert_equal(15, @perico.envergadura_alas)
  end

  def test_describir
    expected = "-----------------------------\nNombre: Perico\nEdad: 4\nEspecie: Agaporni\nEnvergadura de alas: 15cm\n-----------------------------\n"
    assert_equal(expected, @perico.describir)
  end

  def test_cambio_envergadura
    @perico.envergadura_alas = 20
    assert_equal(20, @perico.envergadura_alas)
  end
  
end
```

## Código APP Web

Para la aplicación web se ha usado Node.js y React, los ficheros que conforman la aplicación son los siguientes:

[**package.json**](app/src/package.json)

Es un archivo de configuración esencial en proyectos que utilizan Node.js y React. Define el nombre, versión, punto de entrada principal del código, scripts para operaciones comunes como iniciar, construir, probar y desplegar la aplicación, así como las dependencias necesarias para el funcionamiento del servidor y la interfaz de usuario. 

[**backend.js**](app/src/backend.js)

Es un script del servidor creado con Node.js que utiliza el framework Express para manejar solicitudes HTTP. Define rutas API para leer y enviar código Ruby y resultados de pruebas desde archivos específicos, y ejecutar pruebas Ruby, respondiendo con los resultados de la ejecución.

[**App.js**](app/src/App.js)

Es un componente principal en React que gestiona la interfaz de usuario para visualizar y ejecutar código y pruebas de Ruby mediante llamadas API. El usuario puede seleccionar diferentes archivos de Ruby a través de un componente Select. Al seleccionar un archivo, la aplicación realiza solicitudes HTTP para obtener el código fuente y los códigos de prueba correspondientes. Además, incluye un botón que, al ser pulsado, ejecuta las pruebas del archivo seleccionado y muestra los resultados.

[**index.js**](app/src/index.js)

Es el punto de entrada para la aplicación React, donde se realiza la renderización del componente principal App en el DOM. Utiliza ReactDOM.render para inyectar el componente App dentro del elemento HTML con id root.

[**index.html**](app/public/index.html)

Este sirve como plantilla base para la aplicación React, definiendo el esqueleto HTML sobre el cual React construirá la interfaz de usuario. Contiene un div con id root, que es el punto de montaje para el componente React principal (App) renderizado por index.js.

## Cómo Ejecutar

### Requisitos

- Ruby 3.0
- Docker
- Terraform

### -EJECUCIÓN SIMPLE DESDE TERMINAL-

1. Nos movemos al directorio de trabajo en caso de no estar ya en él:
    ```bash
    cd temas/abstraccion/ruby
    ```
2. Ejecutamos los test con ruby:
    ```bash
    for file in ruby_test/*_test.rb; do 
        echo "------------------------------------"
        echo -e "Corriendo test de $file\n" 
        ruby $file -v
        echo -e "------------------------------------\n\n"
    done    
    ```
   
Tras seguir los dos pasos anteriores podrás visualizar en la terminal los resultados de cada test realizado.

### -EJECUCIÓN DESDE APP WEB-

1. Construye y corre el contenedor Docker con Terraform:

   ```bash
   cd temas/abstraccion/ruby # Nos movemos al directorio de trabajo
   terraform init # Iniciamos terraform
   terraform apply # Lanzamos el docker
   ```
2. Accede desde tu navegador a la dirección localhost:3000

3. En la casilla de selección del inicio de la página elige el nombre del ejemplo que quieres probar. 
    
4. Visualiza el código del ejemplo y el código de los tests.

5. Al final de la página presiona el botón "EJECUTAR TESTS".

6. Visualiza los resultados de la ejecución de los tests para el ejemplo seleccionado a continuación.

