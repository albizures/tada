<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<t:layout>
    <jsp:attribute name="hero">
        <section class="hero is-primary is-medium">
            <div class="hero-body">
                <div class="container">
                    <h1 class="title">
                        Medium title Hero
                    </h1>
                    <h2 class="subtitle">
                        Medium subtitle
                    </h2>
                </div>
            </div>
        </section>
    </jsp:attribute>
    <jsp:body>
        <div class="columns is-multiline">
            <c:forEach items="${products}" var="product">
                <div class="column is-narrow">
                    <div class="tile is-parent">
                        <div class="tile box is-child">
                            <p class="title">${product.getName()}</p>
                            <figure>
                                <img src="${product.getImage().getUrl()}" class="image is-128x128">
                            </figure>
                            <p>Price <fmt:formatNumber type="number" maxFractionDigits="2" value="${product.getPrice()}"></fmt:formatNumber> - Stock ${product.getStock()}</p>
                            <div class="field is-grouped">
                                <button class="button is-success add-to-cart" 
                                        data-product="${product.getIdProduct()}" 
                                        data-price="${product.getPrice()}"
                                        data-name="${product.getName()}">
                                    <i class="fa fa-cart-plus" aria-hidden="true"></i>
                                </button>
                                <button class="button is-info details">Details</button>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </jsp:body>
</t:layout>