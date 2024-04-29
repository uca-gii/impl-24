require 'sinatra'

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
  
  get '/' do
    cuadrado = Cuadrado.new(5)
    circulo = Circulo.new(3)
    <<~HTML
    <h1>Áreas de formas geométricas</h1>
    <p>Área del cuadrado: #{cuadrado.area}</p>
    <p>Área del círculo: #{circulo.area}</p>
    HTML
  end