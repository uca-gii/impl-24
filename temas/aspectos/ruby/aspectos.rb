require 'aquarium'

class Foo
  include Aquarium::DSL
  def critical_operation(a, b)
    suma = a + b
    resta = a - b
    p "Suma: #{suma}, Resta: #{resta}"
  end
end

class Foo
  around :critical_operation do |join_point, object, *args|
    p "Entering: critical_operation"
    result = join_point.proceed
    p "Leaving: critical_operation"
    result
  end
end

foo = Foo.new

foo.critical_operation(3, 5)