module Figura
  class Rectangulo
    attr_reader :ancho, :alto

    def initialize(ancho, alto)
      @ancho = ancho
      @alto = alto
    end

    def area
      @ancho * @alto
    end

    def perimetro
      2 * (@ancho + @alto)
    end
  end

  class Circulo
    attr_reader :radio

    def initialize(radio)
      @radio = radio
    end

    def area
      Math::PI * @radio**2
    end

    def perimetro
      2 * Math::PI * @radio
    end
  end

  class Triangulo
    attr_reader :base, :altura, :lado1, :lado2, :lado3

    def initialize(base, altura, lado1, lado2, lado3)
      @base = base
      @altura = altura
      @lado1 = lado1
      @lado2 = lado2
      @lado3 = lado3
    end

    def area
      0.5 * @base * @altura
    end

    def perimetro
      @lado1 + @lado2 + @lado3
    end
  end
end

# # Ejemplo de uso
# rectangulo = Figura::Rectangulo.new(5, 10)
# puts "Rectángulo:"
# puts "Área: #{rectangulo.area}"
# puts "Perímetro: #{rectangulo.perimetro}"

# circulo = Figura::Circulo.new(3)
# puts "\nCírculo:"
# puts "Área: #{circulo.area}"
# puts "Perímetro: #{circulo.perimetro}"

# triangulo = Figura::Triangulo.new(4, 6, 2, 5, 7)
# puts "\nTriángulo:"
# puts "Área: #{triangulo.area}"
# puts "Perímetro: #{triangulo.perimetro}"
