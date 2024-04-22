require 'sinatra'

class Product
  attr_reader :name, :price

  def initialize(name, price)
    @name = name
    @price = price
  end
end

class Order
  def initialize(products)
    @products = products
  end

  def total_price
    @products.sum(&:price)
  end
end

class ShoppingCart
  def initialize(products)
    @order = Order.new(products)
  end

  def total_price
    @order.total_price
  end
end

get '/checkout' do
  products = [Product.new('Laptop', 1000), Product.new('Mouse', 20)]
  cart = ShoppingCart.new(products)
  "Total Price: #{cart.total_price}"
end

__END__

@@checkout
<!DOCTYPE html>
<html>
<head>
  <title>Checkout</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 50px;
    }
    h1 {
      color: #333;
    }
    .total-price {
      font-size: 24px;
      color: #007bff;
    }
  </style>
</head>
<body>
  <h1>Checkout</h1>
  <p>Total Price: <span class="total-price"><%= total_price %></span></p>
</body>
</html>
