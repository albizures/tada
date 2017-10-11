<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<t:layout>
    <jsp:body>
        <div class="container">
            <label>Mostrar por pagina</label>
            <select>
                <option>10</option>
                <option>20</option>
                <option>30</option>
            </select>
        </div>
        <div class="columns is-desktop is-mobile is-multiline">
            <c:forEach items="${products}" var="product">
                <div class="column is-one-quarter">
                    <p>${product.getName()}</p>
                    <figure>
                        <img src="${product.getImage().getUrl()}" class="image is-128x128">
                    </figure>
                    <p>Price $<fmt:formatNumber type="number" maxFractionDigits="2" value="${product.getPrice()}"></fmt:formatNumber> - Stock ${product.getStock()}</p>
                    <div class="field is-grouped">
                        <button class="button is-success add-to-cart">Add to cart</button>
                        <button class="button is-info details">Details</button>
                    </div>
                </div>
            </c:forEach>
        </div>
        <script src="js/shopping.js"></script>
    </jsp:body>
</t:layout>