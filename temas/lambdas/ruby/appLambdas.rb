require 'sinatra'
require_relative 'lambdas.rb'

get '/' do
    erb :index
end

get '/IniciarSimulador' do
    output1 = StringIO.new
    $stdout1 = output1

    output2 = StringIO.new
    $stdout2 = output2

    sensor1_observable = simulate_temperature_sensor(1)
    sensor2_observable = simulate_temperature_sensor(2)

    sensor1_with_fahrenheit = sensor1_observable.map(&to_fahrenheit)
    sensor2_with_fahrenheit = sensor2_observable.map(&to_fahrenheit)

    anomalous_readings1 = sensor1_with_fahrenheit.select(&is_anomalous)
    anomalous_readings2 = sensor2_with_fahrenheit.select(&is_anomalous)

    subscription1 = anomalous_readings1.subscribe(
        subscribe_to_anomalous_readings.call(1), # on_next
        ->(error) { puts "Error en el sensor 1: #{error}" },  # on_error
        -> { puts "Sensor 1 - La secuencia ha finalizado" }  # on_completed
    )
    $stdout1 = STDOUT
    output1.string

    subscription2 = anomalous_readings2.subscribe(
        subscribe_to_anomalous_readings.call(2), # on_next
        ->(error) { puts "Error en el sensor 2: #{error}" },  # on_error
        -> { puts "Sensor 2 - La secuencia ha finalizado" }  # on_completed
    )
    $stdout2 = STDOUT
    output2.string
    sleep(18)

    subscription1.dispose
    subscription2.dispose

end

set :port, 4568