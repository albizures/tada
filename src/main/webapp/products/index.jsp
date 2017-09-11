<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="tag" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tag:layout>
    <jsp:body>
        <h1 class="title">Products</h1>
        <div>
            <a class="button is-primary" href="/products?action=create">Create</a>
        </div>
        <br>
        <div class="columns">
                <table class="table is-fullwidth">
                    <thead>
                        <th><abbr title="Name">Name</abbr></th>
                        <th><abbr title="Price">Price</abbr></th>
                        <th><abbr title="Stock">Stock</abbr></th>
                        <th><abbr title="Description">Description</abbr></th>
                    </thead>
                    <tbody>
                        <c:forEach items="${products}" var="product">
                            <tr>
                                <th>${product.getName()}</th>
                                <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${product.getPrice()}"/></td>
                                <td>${product.getStock()}</td>
                                <td>${product.getDescription()}</td>
                                <td>
                                    <a class="button is-warning is-small" href="/products?action=edit&id=${product.getIdProduct()}">Edit</a>
                                    <a class="button is-info is-small" href="/products?action=delete&id=${product.getIdProduct()}">Details</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
        </div>
    </jsp:body>
</tag:layout>