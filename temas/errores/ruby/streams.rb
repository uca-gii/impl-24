require 'optional'
require 'rx'
require './calculator'

calculator = Calculator.new

numbers = Rx::Observable.from_array([1, 0, 2, 3, 0, 4])

valid_results = []

numbers
  .map do |number|
    x = calculator.divide(number, number + 1)
    if x.some?
      puts "La division entre #{number} y #{number + 1} es valida."
      x.value
    else
      next
    end
  end
  .subscribe(
    lambda { |result|
      valid_results << result if result
    },
    lambda { # On error
      puts "Error en el flujo de datos."
    },
    lambda { # On complete
      puts "Flujo de datos completado: #{valid_results.inspect}"
    }
  )
