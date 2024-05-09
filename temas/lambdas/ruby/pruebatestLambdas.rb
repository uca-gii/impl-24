require 'minitest/autorun'
require 'rx'

class TestTemperatureSensor < Minitest::Test
  # Método para simular las lecturas de temperatura de un sensor
  def simulate_temperature_sensor(sensor_id)
    Rx::Observable.create do |observer|
      # Simulamos la generación de lecturas de temperatura cada segundo
      Thread.new do
        loop do
          temperature_celsius = rand(10..45)
          observer.on_next({ sensor_id: sensor_id, temperature_celsius: temperature_celsius }) # Emite un hash con el ID del sensor y la temperatura en Celsius
          sleep(1)
        end
      end

      Thread.new do
        sleep(15)
        observer.on_completed
      end
    end
  end

  # Método para probar la conversión de Celsius a Fahrenheit
  def test_celsius_to_fahrenheit_conversion
    data = { temperature_celsius: 20 } # Temperatura en Celsius para probar
    converted_data = to_fahrenheit.call(data)
    expected_fahrenheit = 68.0 # Valor esperado en Fahrenheit para 20°C
    assert_equal(expected_fahrenheit, converted_data[:temperature_fahrenheit])
  end

  # Método para probar la detección de lecturas anómalas
  def test_anomalous_reading_detection
    normal_data = { temperature_celsius: 30 } # Temperatura normal para probar
    anomalous_data = { temperature_celsius: 40 } # Temperatura anómala para probar
    assert_equal(false, is_anomalous.call(normal_data)) # La lectura normal no debe ser anómala
    assert_equal(true, is_anomalous.call(anomalous_data)) # La lectura anómala debe ser detectada como anómala
  end

  private

  # Definimos la constante para la conversión de Celsius a Fahrenheit
  CELSIUS_TO_FAHRENHEIT_CONSTANT = 32.0

  # Lambda para convertir la temperatura a grados Fahrenheit
  def to_fahrenheit
    ->(data) do
      temperature_fahrenheit = data[:temperature_celsius] * 9.0 / 5.0 + CELSIUS_TO_FAHRENHEIT_CONSTANT
      data.merge(temperature_fahrenheit: temperature_fahrenheit)
    end
  end

  # Lambda para verificar si una lectura es anómala
  def is_anomalous
    ->(data) { data[:temperature_celsius] > 35 }
  end
end
