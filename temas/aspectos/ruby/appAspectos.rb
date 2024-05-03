require 'sinatra'

require_relative 'aspectos.rb'



get '/' do
  erb :index
end

get '/IniciarSesion/:nombre/:username' do
  nombre_ = params[:nombre]
  username_ = params[:username]
  output = StringIO.new
  $stdout = output
  $user = User.new(nombre_, username_)
  $user.login_account(username_)
  $stdout = STDOUT
  output.string
end

get '/CambiarCuenta/:username' do
  new_username = params[:username]
  output = StringIO.new
  $stdout = output
  $user.update_account(new_username)
  $stdout = STDOUT
  output.string
end


set :port, 4568