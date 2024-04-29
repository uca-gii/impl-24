require 'sinatra'

configure do
  set :static, true
end

def dividir(a, b)
  raise ArgumentError, "Los argumentos deben ser numéricos" unless num1.is_a?(Numeric) && num2.is_a?(Numeric)
  div = a / b
  rescue ZeroDivisionError => e
    puts "Division entre 0. Detalles {e.message}"
  rescue TypeError => error
    puts "Error: Tipo de datos incorrecto. Detalles del error: #{error.message}"
  else
    puts "El resultado de la división es: #{resultado}"
  ensure
    puts "¡Gracias por usar nuestra calculadora!"
end

def sumar(num1, num2)
  raise ArgumentError, "Los argumentos deben ser numéricos" unless num1.is_a?(Numeric) && num2.is_a?(Numeric)
  num1 + num2
rescue ArgumentError => error
  puts "Error: #{error.message}"
end

def restar(num1, num2)
  raise ArgumentError, "Los argumentos deben ser numéricos" unless num1.is_a?(Numeric) && num2.is_a?(Numeric)
  num1 - num2
rescue ArgumentError => error
  puts "Error: #{error.message}"
end

def multiplicar(num1, num2)
  raise ArgumentError, "Los argumentos deben ser numéricos" unless num1.is_a?(Numeric) && num2.is_a?(Numeric)
  num1 * num2
rescue ArgumentError => error
  puts "Error: #{error.message}"
end

get '/sumar/:num1/:num2' do
  sumar(params[:num1].to_i, params[:num2].to_i).to_s
end

get '/restar/:num1/:num2' do
  restar(params[:num1].to_i, params[:num2].to_i).to_s
end

get '/multiplicar/:num1/:num2' do
  multiplicar(params[:num1].to_i, params[:num2].to_i).to_s
end

get '/dividir/:a/:b' do
  dividir(params[:a].to_i, params[:b].to_i).to_s
end

get '/' do
  File.read('index.html')
end


