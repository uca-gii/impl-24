module Animal
    attr_accessor :nombre, :edad
    attr_reader :especie
 
    def initialize(nombre, edad, especie)
       @nombre = nombre
       @edad = edad
       @especie = especie
    end
 
    def describir
       "-----------------------------\nNombre: #{nombre}\nEdad: #{edad}\nEspecie: #{especie}\n"
    end
end