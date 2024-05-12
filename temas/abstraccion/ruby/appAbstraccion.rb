require 'sinatra'
require_relative 'abstraccion.rb'

get '/' do
    erb :index
end



set :port, 4568