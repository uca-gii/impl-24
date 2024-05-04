require 'aquarium'
# Aplicación de comercio electrónico separando mediante aspectos
# La lógica de auditoría de la lógica principal de la aplicación
class Auditor
  def self.log(message)
    puts "[AUDIT] #{message}"
  end
end

class User
  attr_accessor :nombre, :username
  def initialize(nombre, username)
    @nombre = nombre
    @username = username
  end
  def login_account(username)
    puts "¡Bienvenido #{username}!"
    # Lógica para crear la cuenta...
  end

  def update_account(username)
    @username = username
    puts "El nuevo nombre de la cuenta es #{username}"
    # Lógica para actualizar la información del usuario...
  end
end

# Configuración de aspectos con Aquarium
include Aquarium::Aspects

Aspect.new :after, :calls_to => :login_account, :for_types => [User] do |join_point, user|
  Auditor.log("El usuario #{user.nombre} ha iniciado sesión en la cuenta de #{user.username}")
end

Aspect.new :after, :calls_to => :update_account, :for_types => [User] do |join_point, user|
  Auditor.log("El usuario #{user.nombre} ha actualizado el nombre de su cuenta #{user.username}")
end

# Secuencia de datos para crear múltiples usuarios y actualizar su información
users_data = [
  User.new("Juan", "Juanito32"),
  User.new("Alberto", "Alberto33"),
  User.new("Antonio", "Antonito35")
]



users_data.each do |user|
  puts "Nombre de usuario: #{user.nombre}"
  user.login_account(user.username)
end

usuario2 = users_data[2]
username = "Antonito3456"

usuario2.update_account(username)