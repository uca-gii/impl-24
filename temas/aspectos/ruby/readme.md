# Aspectos en Ruby #
## Ejemplo ##
Este ejemplo trata sobre una interfaz de login. Se requiere que el sistema registre cada acción que realice el usuario tales como el inicio de sesión o la modificación de contraseñas. Por tanto, se utilizará un aspecto que tendrá como objetivo registrar las acciones de los usuarios sin tener que modificar nada del código original. Para ello, se ha utilizado la gema aquarium, la cual provee de herramientas útiles para la definición de aspectos tales como :after, :calls_to, join_point, etc.. 

```
require 'aquarium'

class Auditor
  def self.log(message)
    puts "[AUDIT] #{message}"
  end
end

class User
  attr_accessor :username, :password

  def initialize(username, password)
    @username = username
    @password = password
  end

  def login_account(username, password)
    if @username == username && @password == password
      puts "¡Bienvenido #{username}!"
      # Lógica para iniciar sesión...
      
    else
      puts "Nombre de usuario o contraseña incorrectos."
    end
  end

  def update_account(password)
    @password = password
    puts "La contraseña se ha modificado"
    # Lógica para actualizar la información del usuario...
  end
end

# Configuración de aspectos con Aquarium
include Aquarium::Aspects

Aspect.new :after, :calls_to => :login_account, :for_types => [User] do |join_point, user,_, password|
  if password == user.password
    Auditor.log("El usuario '#{user.username}' ha iniciado sesión correctamente")
  else
    Auditor.log("Intento de inicio de sesión fallido para el usuario '#{user.username}'")
  end
end

Aspect.new :after, :calls_to => :update_account, :for_types => [User] do |join_point, user|
  Auditor.log("El usuario '#{user.username}' ha actualizado su contraseña de cuenta a '#{user.password}'")
end

# Secuencia de datos para crear múltiples usuarios y actualizar su información
users_data = [
  User.new("Juanito32", "contraseña123"),
  User.new("Alberto33", "clave456"),
  User.new("Antonito35", "secreto789")
]

# Uso de los usuarios
users_data.each do |user|
  puts "Nombre de cuenta: #{user.username}"
  user.login_account(user.username, user.password) # Se pasa también la contraseña
end

# Actualización de la contraseña de la cuenta
usuario2 = users_data[1]
new_password = "secrete"
error_password = "secrete1"
usuario2.update_account(new_password)
usuario2.login_account(usuario2.username, new_password)
usuario2.login_account(usuario2.username, error_password)
```

## Explicación ##

```
require 'aquarium'
```
Se importa la gema aquarium que provee de herramientas útiles para la definición de aspectos en Ruby.

```
class Auditor
  def self.log(message)
    puts "[AUDIT] #{message}"
  end
end
```
La clase Auditor será la que registre las acciones que realice el usuario.

```
class User
  attr_accessor :username, :password

  def initialize(username, password)
    @username = username
    @password = password
  end

  def login_account(username, password)
    if @username == username && @password == password
      puts "¡Bienvenido #{username}!"
      # Lógica para iniciar sesión...
      
    else
      puts "Nombre de usuario o contraseña incorrectos."
    end
  end

  def update_account(password)
    @password = password
    puts "La contraseña se ha modificado"
    # Lógica para actualizar la información del usuario...
  end
end
```
La clase User está compuesta del nombre de usuario (o de cuenta) y de la contraseña del mismo.

La función login_account se encarga del inicio de sesión del usuario en la aplicación devolviendo un mensaje de bienvenida si fue correcta la contraseña y en caso contrario un mensaje de contraseña incorrecta.

La función update_account cambia la contraseña que tiene el usuario a una nueva que se le pasa por parámetro.

```
# Configuración de aspectos con Aquarium
include Aquarium::Aspects

Aspect.new :after, :calls_to => :login_account, :for_types => [User] do |join_point, user,_, password|
  if password == user.password
    Auditor.log("El usuario '#{user.username}' ha iniciado sesión correctamente")
  else
    Auditor.log("Intento de inicio de sesión fallido para el usuario '#{user.username}'")
  end
end

Aspect.new :after, :calls_to => :update_account, :for_types => [User] do |join_point, user|
  Auditor.log("El usuario '#{user.username}' ha actualizado su contraseña de cuenta a '#{user.password}'")
end
```
Se incluye de la gema aquarium la clase Aspects que servirá para definir los aspectos.

Explicación de las herramientas de Aquarium:
- :after --> Especifica que el aspecto asociado se ejecutará después del punto de unión declarado.
- :calls_to => 'FUNCIÓN' --> Especifica que el punto de unión es una llamada a la FUNCIÓN correspondiente.
- :for_types => [Clase] --> Especifica que el aspecto solo se aplicará a objeto de la clase 'Clase'.
- do | | --> Los argumentos que se le pasan al aspecto.
- join_point --> Argumento que representa el punto de unión en el flujo de ejecución del programa.
- clase --> Argumento que representa una instancia de la clase 'Clase'.
- _ --> Marcador de posición para argumentos adicionales (por si queremos algún atributo determinado de la clase).




## Desplegar Web ##

Para desplegar la web necesitamos ejecutar el terraform con estos comandos:

```terraform
terraform init
terraform apply
```
Una vez que Terraform haya completado el despliegue, la web estará disponible en la siguiente dirección: 

`https:localhost/4568`

Nota: Este Terraform ha sido creado para máquinas que utilicen Windows como SO. Para poder ejecutar el Terraform en otros SO, modificar los comandos de instalación según lo requiera su SO.