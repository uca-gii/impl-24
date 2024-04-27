require './Animal'

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