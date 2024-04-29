class Forma
    def area
      raise NotImplementedError, "El método 'area' debe ser implementado por las subclases."
    end
  end
  
  class Cuadrado < Forma
    def initialize(lado)
      @lado = lado
    end
  
    def area
      @lado * @lado
    end
  end
  
  class Circulo < Forma
    def initialize(radio)
      @radio = radio
    end
  
    def area
      Math::PI * @radio * @radio
    end
  end
  
  cuadrado = Cuadrado.new(5)
  puts "Área del cuadrado: #{cuadrado.area}"  # Output: Área del cuadrado: 25
  
  circulo = Circulo.new(3)
  puts "Área del círculo: #{circulo.area}"    # Output: Área del círculo: 28.274333882308138
  