require 'minitest/autorun'
require_relative '../ruby_src/Ave'

class AveTest < Minitest::Test
  def setup
    @perico = Ave.new("Perico", 4, "Agaporni", 15)
  end

  def test_nombre
    assert_equal("Perico", @perico.nombre)
  end

  def test_edad
    assert_equal(4, @perico.edad)
  end

  def test_especie
    assert_equal("Agaporni", @perico.especie)
  end

  def test_envergadura_alas
    assert_equal(15, @perico.envergadura_alas)
  end

  def test_describir
    expected = "-----------------------------\nNombre: Perico\nEdad: 4\nEspecie: Agaporni\nEnvergadura de alas: 15cm\n-----------------------------\n"
    assert_equal(expected, @perico.describir)
  end

  def test_cambio_envergadura
    @perico.envergadura_alas = 20
    assert_equal(20, @perico.envergadura_alas)
  end
  
end