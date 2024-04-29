
# Calculator.rb

require 'optional'

class Calculator

    def divide(dividend, divisor)
        return Optional.empty unless dividend.is_a?(Numeric) && divisor.is_a?(Numeric)
        return Optional.empty if divisor == 0
        Optional.of( dividend / divisor )
    end

    def sum(a, b)
        return Optional.empty unless a.is_a?(Numeric) && b.is_a?(Numeric)
        Optional.of(a + b)
    end

    def subtract(a, b)
        return Optional.empty unless a.is_a?(Numeric) && b.is_a?(Numeric)
        Optional.of(a - b)
    end

    def multiply(a, b)
        return Optional.empty unless a.is_a?(Numeric) && b.is_a?(Numeric)
        Optional.of(a * b)
    end
