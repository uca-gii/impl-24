require './Animal'

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