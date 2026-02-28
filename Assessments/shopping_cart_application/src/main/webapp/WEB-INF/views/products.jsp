<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    <h2>Product List</h2>

    <c:forEach var="product" items="${products}">
        <form action="add-to-cart" method="post">
            <p>
                ${product.name} - ₹${product.price}
                Quantity: <input type="number" name="quantity" value="1" min="1" />
                <input type="hidden" name="productId" value="${product.id}" />
                <input type="submit" value="Add to Cart" />
            </p>
        </form>
    </c:forEach>

    <br>
    <a href="cart">View Cart</a>

</body>
</html>