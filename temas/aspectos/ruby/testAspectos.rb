require 'minitest/autorun'
require_relative 'aspectos.rb'


class TestUser < Minitest::Test 
  def setup
    @user = User.new("Juan", "Juanito32")
  end

  def test_login_account
    assert_output(/¡Bienvenido Juanito32!/) { @user.login_account(@user.username)}
  end

  def test_update_account
    new_username = "Juanito3456"
    assert_output(/El nuevo nombre de la cuenta es Juanito3456/) { @user.update_account(new_username) }
    assert_equal new_username, @user.username
  end
end
