require 'minitest/autorun'
require_relative '../ruby_src/Animal'

class AnimalSinMas
  include Animal

  def initialize(nombre, edad, especie)
    super(nombre, edad, especie)    
  end

  def describir
    super + "-----------------------------\n"
  end
end

class AnimalTest < Minitest::Test
  def setup
    @lolo = AnimalSinMas.new("Lolo", 5, "Perro")
  end

  def test_nombre
    assert_equal("Lolo", @lolo.nombre)
  end

  def test_edad
    assert_equal(5, @lolo.edad)
  end

  def test_especie
    assert_equal("Perro", @lolo.especie)
  end

  def test_describir
    expected = "-----------------------------\nNombre: Lolo\nEdad: 5\nEspecie: Perro\n-----------------------------\n"
    assert_equal(expected, @lolo.describir)
  end

  def test_cambio_nombre
    @lolo.nombre = 'lolito'
    assert_equal('lolito', @lolo.nombre)
  end

  def test_cumpleaños
    age = @lolo.edad
    @lolo.cumpleaños
    assert_equal(age+1, @lolo.edad)
  end
  
end