require 'minitest/autorun'
require 'rx'

class TemperatureSensorTest < Minitest::Test
  def test_simulate_temperature_sensor
    # Mock de un observadora
    mock_observer = Minitest::Mock.new

    # Se esperan llamadas a on_next con hashes que contengan :sensor_id y :temperature
    mock_observer.expect(:on_next, nil, [{ sensor_id: 1, temperature: Integer }])
    mock_observer.expect(:on_next, nil, [{ sensor_id: 2, temperature: Integer }])

    # Se espera que se llame a on_completed en algún momento
    mock_observer.expect(:on_completed, nil).twice

    # Simulación de lecturas de temperatura de sensores
    sensor1_observable = simulate_temperature_sensor(1)
    sensor2_observable = simulate_temperature_sensor(2)

    # Nos suscribimos a los flujos de datos de lecturas anómalas
    subscription1 = sensor1_observable.subscribe(mock_observer)
    subscription2 = sensor2_observable.subscribe(mock_observer)

    # Esperamos un tiempo para que se emitan algunas lecturas anómalas
    sleep(2)

    # Cancelamos las suscripciones después de un tiempo
    subscription1.dispose
    subscription2.dispose

    # Verificamos que todas las expectativas se cumplieron
    mock_observer.verify
  end
end
