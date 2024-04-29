module Education
  def engineer
    puts "I'm engineer"
  end
end

class Person
  include Education
end

class Student < Person
  def engineer
    puts "I'm studying to become an engineer"
  end
end

File.open('index.html', 'w') do |file|
  file.puts "<!DOCTYPE html>"
  file.puts "<html>"
  file.puts "<head>"
  file.puts "<title>Herencia en Ruby</title>"
  file.puts "</head>"
  file.puts "<body>"
  file.puts "<h1>Herencia en Ruby</h1>"
  file.puts "<p>La clase Student hereda de la clase Person y sobrescribe el método engineer:</p>"
  file.puts "<p>Person.new.engineer:</p>"
  file.puts "<p>"
  Person.new.engineer
  file.puts "</p>"
  file.puts "<p>Student.new.engineer:</p>"
  file.puts "<p>"
  Student.new.engineer
  file.puts "</p>"
  file.puts "</body>"
  file.puts "</html>"
end
