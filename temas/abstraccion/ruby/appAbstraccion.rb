require 'sinatra'
require_relative 'abstraccion.rb'

get '/' do
    erb :index
end

get '/Circulo/:radio' do
    radio = params[:radio]
    circulo = Figura::Circulo.new(radio)
    output = StringIO.new
    $stdout = output
    puts "Círculo: "
    puts "Área: #{circulo.area}"
    puts "Perímetro: #{circulo.perimetro}"
    $stdout = STDOUT
    output.string
end

get '/Rectangulo/:ancho/:alto' do
    ancho = params[:ancho]
    alto = params[:alto]
    rectangulo = Figura::Rectangulo.new(ancho, alto)
    output = StringIO.new
    $stdout = output
    puts "Rectángulo: "
    puts "Área: #{rectangulo.area}"
    puts "Perímetro: #{rectangulo.perimetro}"
    $stdout = STDOUT
    output.string
end

get '/Triangulo/:base/:altura/:lado1/:lado2/:lado3' do
    base = params[:base]
    altura = params[:altura]
    lado1 = params[:lado1]
    lado2 = params[:lado2]
    lado3 = params[:lado3]
    triangulo = Figura::Triangulo.new(base, altura, lado1, lado2, lado3)
    output = StringIO.new
    $stdout = output
    puts "Triángulo: "
    puts "Área: #{triangulo.area}"
    puts "Perímetro: #{triangulo.perimetro}"
    $stdout = STDOUT
    output.string
end

set :port, 4568