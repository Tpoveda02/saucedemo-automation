Feature: Realizar una compra en saucedemo

  Background:
    Given un usuario se ingresó a la página de login


  Scenario Outline: Ordenar productos, agregar al carrito y realizar la compra
    When ingresa sus credenciales válidas: usuario "standard_user" y contraseña "secret_sauce"
    And agrega los productos "<product1>" y "<product2>" al carrito
    And realiza la compra con información "<first_name>", "<last_name>", "<postal_code>" y un total "<price_total>"
    Then debería ver el mensaje de confirmación de pedido "THANK YOU FOR YOUR ORDER"

    Examples:
      | product1                         | product2                   | first_name | last_name | postal_code | price_total  |
      | Sauce Labs Backpack              | Sauce Labs Bike Light      | John       | Doe       | 12345       | $10.79       |
      | Test.allTheThings() T-Shirt (Red)| Sauce Labs Fleece Jacket   | Carlos     | Brown     | 11223       | $53.99       |
