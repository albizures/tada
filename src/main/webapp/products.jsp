<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:layout>
    <jsp:body>
        <button class="button is-primary open-modal" data-modal="addProduct">Add</button>
        <table class="table">
            <thead>
                <tr>
                    <th><abbr title="ID">ID</abbr></th>
                    <th><abbr title="Name">Name</abbr></th>
                    <th><abbr title="Price">Price</abbr></th>
                    <th><abbr title="Category">Category</abbr></th>
                    <th><abbr title="Description">Description</abbr></th>
                    <th><abbr title="Stock">Stock</abbr></th>
                    <th><abbr></abbr></th>
                    <th><abbr></abbr></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <th>${product.getIdProduct()}</th>
                        <td>${product.getName()}</td>
                        <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${product.getPrice()}"/></td>
                        <td>${product.getStock()}</td>
                        <td>${product.getDescription()}</td>
                        <th><a href="?edit=${product.getIdProduct()}" class="button is-warning is-small">edit</a></th>
                        <th>
                            <t:delete action="/products">
                                <jsp:body>
                                    <input type="hidden" name="id" value="${product.getIdProduct()}" />
                                    <button class="delete"></button>
                                </jsp:body>
                            </t:delete>
                            
                        </th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <t:modal id="addProduct" active="${edit}" name="${edit ? 'Edit' : 'Add' } product">
            <jsp:body>
                <t:form action="/products" type="${edit ? 'PUT' : 'POST' }" >
                    <jsp:body>
                        <div class="control">
                            <div class="field">
                                <label class="label">Name</label>
                                <input name="name" required="true" class="input" value="${product.getName()}" type="text" placeholder="Enter the name">
                            </div>
                            <div class="field">
                                <label class="label">Price</label>
                                <fmt:formatNumber var="fmtPrice" type="number" groupingUsed="false" maxFractionDigits="2" value="${product.getPrice()}"/>
                                <input name="price" required="true" class="input" step="0.01" value="${fmtPrice}" type="number" placeholder="Enter the price">
                            </div>
                            <div class="field">
                                <label class="label">Description</label>
                                <div class="control">
                                    <textarea class="textarea" name="description">${product.getDescription()}</textarea>
                                </div>
                            </div>
                            <div class="field">
                                <label class="label">Stock</label>
                                <div class="control">
                                    <input name="stock" class="input" value="${product.getStock()}" type="number">
                                </div>
                            </div>
                            <div class="field">
                                <label class="label">Image url</label>
                                <div class="control">
                                    <input name="url" class="input" value="${product.getImage().getUrl()}" type="text">
                                </div>
                            </div>
                            <div class="field">
                                <label class="label">Category</label>
                                <div class="select">
                                    <select name="category">
                                        <c:forEach items="${categories}" var="category">
                                            <option value="${category.getIdCategory()}" ${category.getIdCategory() == product.getCategory().getIdCategory() ? "selected" : "" }>${category.getName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <c:if test="${edit}">
                               <input name="id" value="${product.getIdProduct()}" type="hidden">
                            </c:if>
                            <div class="field is-grouped">
                            <div class="control">
                                <button class="button is-primary" type="submit">Submit</button>
                            </div>
                            <div class="control">
                                <button class="button is-link close-modal" type="button">Cancel</button>
                            </div>
                          </div>
                        </div>
                    </jsp:body>
                </t:form>
            </jsp:body>
        </t:modal>
    </jsp:body>
</t:layout>