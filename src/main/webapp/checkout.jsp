<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<tag:layout>
    <jsp:body>
        <form method="POST" action="/payment">
            <input type="hidden">
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
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <label>Choose credit card </label>
            <select name="card">
                <c:forEach items="${cards}" var="card">
                    <option value="${card.getId_card()}">${card.getNumber()}</option>
                </c:forEach>
            </select>
            <button type="submit" class="button" id="checkout-cart">Pay</button>
        </form>
    </jsp:body>
</tag:layout>>