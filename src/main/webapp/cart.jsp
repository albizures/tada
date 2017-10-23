<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<tag:layout>
    <jsp:body>
        your cart
        <table class="table">
            <thead>
                <th>Article</th>
                <th>Price</th>
            </thead>
            <tbody>
                <c:forEach items="${cartList}" var="item" varStatus="index">
                    <tr>
                        <td>${item.getName()}</td> 
                        <td>
                            <span>$</span>
                            <fmt:formatNumber type="number" maxFractionDigits="2" value="${item.getPrice()}"></fmt:formatNumber>
                        </td>
                        <td>
                            <button data-index="${index.index}" class="remove-cart-item button is-danger">Quitar</button>    
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </jsp:body>
</tag:layout>