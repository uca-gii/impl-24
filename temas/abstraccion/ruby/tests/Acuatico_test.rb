require 'minitest/autorun'
require_relative '../src/Acuatico'

class AcuaticoTest < Minitest::Test
  def setup
    @nemo = Acuatico.new("Nemo", 3, "Pez", 100)
  end

  def test_nombre
    assert_equal("Nemo", @nemo.nombre)
  end

  def test_edad
    assert_equal(3, @nemo.edad)
  end

  def test_especie
    assert_equal("Pez", @nemo.especie)
  end

  def test_profundidad_max
    assert_equal(100, @nemo.profundidad_max)
  end

  def test_describir
    expected = "-----------------------------\nNombre: Nemo\nEdad: 3\nEspecie: Pez\nProfundidad máxima: 100m\n-----------------------------\n"
    assert_equal(expected, @nemo.describir)
  end

  def test_cambio_profundidad
    @nemo.profundidad_max = 150
    assert_equal(150, @nemo.profundidad_max)
  end

end