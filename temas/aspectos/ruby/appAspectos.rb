require 'sinatra'

require_relative 'aspectos.rb'


get '/' do
  erb :index
end

get '/IniciarSesion/:username/:password' do
  username_ = params[:username]
  password_ = params[:password]
  output = StringIO.new
  $stdout = output
  $user = User.new(username_, password_)
  $user.login_account(username_, password_)
  $stdout = STDOUT
  output.string
end

get '/CambiarContraseña/:password' do
  new_password = params[:password]
  output = StringIO.new
  $stdout = output
  $user.update_account(new_password)
  $stdout = STDOUT
  output.string
end


set :port, 4568