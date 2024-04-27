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

class Terrestre
   include Animal
   attr_accessor :habitat

   def initialize(nombre, edad, especie, habitat)
      super(nombre, edad, especie)
      @habitat = habitat
   end

   def describir
      super + "Habitat: #{hebitat}\n-----------------------------\n"
   end
end

class Acuatico
   include Animal
   attr_accessor :profundidad_max

   def initialize(nombre, edad, especie, profundidad_max)
      super(nombre, edad, especie)
      @profundidad_max = profundidad_max
   end

   def describir
      super + "Profundidad máxima: #{profundidad_max}\n-----------------------------\n"
   end
end

class Ave
   include Animal
   attr_accessor :envergadura_alas

   def initialize(nombre, edad, especie, envergadura_alas)
      super(nombre, edad, especie)
      @envergadura_alas = envergadura_alas
   end

   def describir
      super + "Envergadura de alas: #{envergadura_alas}\n-----------------------------\n"
   end
end
