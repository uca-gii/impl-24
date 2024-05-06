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