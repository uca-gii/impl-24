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