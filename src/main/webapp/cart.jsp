<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<tag:layout>
    <jsp:body>
        your cart
        <table class="table">
            <thead>
                <th>Article</th>
                <th></th>
            </thead>
            <tbody>
                <c:forEach items="${cartList}" var="item" varStatus="index">
                    <tr>
                        <td>${item.getIdProduct()}</td> 
                        <td>
                            <button data-index="${index.index}"
                                    class="remove-cart-item button is-danger">Quitar</button>    
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </jsp:body>
</tag:layout>