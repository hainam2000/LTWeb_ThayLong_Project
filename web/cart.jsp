<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="assets/css/cart.css">
  <script src="assets/js/cart.js"></script>
  <style>
    <%@include file="assets/css/header.css"%>
    <%@include file="assets/vendor/bootstrap/css/bootstrap.min.css"%>
    <%@include file="assets/css/shop-homepage.css"%>
    <%@include file="assets/css/font-awesome.min.css"%>
  </style>
  <title>Cart</title>
</head>

<body>
<jsp:include page="header.html"></jsp:include>
  <main>
    <div class="basket">
      <div class="basket-module" style="padding-top: 20px">
        <label for="promo-code">Enter a promotional code</label>
        <input id="promo-code" type="text" name="promo-code" maxlength="5" class="promo-code-field">
        <button class="promo-code-cta">Apply</button>
      </div>
      <div class="basket-labels">
        <ul>
          <li class="item item-heading">Item</li>
          <li class="price">Price</li>
          <li class="quantity">Quantity</li>
          <li class="subtotal">Subtotal</li>
        </ul>
      </div>
      <c:forEach items="${dataHDD}" var="d">
      <div class="basket-product" >
        <div class="item">
          <div class="product-image">
            <img src="${d.imgUrl}" alt="Placholder Image 2" class="product-frame"style="width: 100px; height: auto;">
          </div>
          <div class="product-details">
            <h1 style="font-size: 20px;"><span class="item-quantity">4</span> ${d.name}</h1>
            <p><strong>${d.description}</strong></p>
            <p>Product Code - 232321939</p>
          </div>
        </div>
        <div class="price">${d.price}</div>
        <div class="quantity">
          <input type="number" value="4" min="1" class="quantity-field">
        </div>
        <div class="subtotal">${d.price}</div>
        <div class="remove">
          <button>Remove</button>
        </div>
      </div>
      </c:forEach>
    </div>
    <aside>
      <div class="summary">
        <div class="summary-total-items"><span class="total-items"></span> Items in your Bag</div>
        <div class="summary-subtotal">
          <div class="subtotal-title">Subtotal</div>
          <div class="subtotal-value final-value" id="basket-subtotal">130.00</div>
          <div class="summary-promo hide">
            <div class="promo-title">Promotion</div>
            <div class="promo-value final-value" id="basket-promo"></div>
          </div>
        </div>
        <div class="summary-delivery">
          <select name="delivery-collection" class="summary-delivery-selection">
              <option value="0" selected="selected">Select Collection or Delivery</option>
             <option value="collection">Collection</option>
             <option value="first-class">Royal Mail 1st Class</option>
             <option value="second-class">Royal Mail 2nd Class</option>
             <option value="signed-for">Royal Mail Special Delivery</option>
          </select>
        </div>
        <div class="summary-total">
          <div class="total-title">Total</div>
          <div class="total-value final-value" id="basket-total">130.00</div>
        </div>
        <div class="summary-checkout">
          <button class="checkout-cta">Go to Secure Checkout</button>
        </div>
      </div>
    </aside>
  </main>
  <jsp:include page="footer.html"></jsp:include>
</body>

</html>