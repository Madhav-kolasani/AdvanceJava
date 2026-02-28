<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    <h2>Your Cart</h2>

    <c:forEach var="item" items="${cartItems}">
        <p>
            ${item.product.name} |
            Price: ₹${item.product.price} |
            Quantity: ${item.quantity} |
            Total: ₹${item.totalPrice}
        </p>
    </c:forEach>

    <h3>Total Amount: ₹${total}</h3>

    <br>
    <a href="products">Back to Products</a>

</body>
</html>