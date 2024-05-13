require 'minitest/autorun'
require_relative '../ruby_src/Terrestre'

class TerrestreTest < Minitest::Test
  def setup
    @manolo = Terrestre.new("Manolo", 5, "León", "Selva")
  end

  def test_nombre
    assert_equal("Manolo", @manolo.nombre)
  end

  def test_edad
    assert_equal(5, @manolo.edad)
  end

  def test_especie
    assert_equal("León", @manolo.especie)
  end

  def test_habitat
    assert_equal("Selva", @manolo.habitat)
  end

  def test_describir
    expected = "-----------------------------\nNombre: Manolo\nEdad: 5\nEspecie: León\nHabitat: Selva\n-----------------------------\n"
    assert_equal(expected, @manolo.describir)
  end

  def test_cambio_habitat
    @manolo.habitat = 'Jungla'
    assert_equal('Jungla', @manolo.habitat)
  end
  
end