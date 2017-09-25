<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<tag:layout>
    <jsp:body>       
        <form action="/products?" method="post">
            <input name="action" type="hidden" value="update">
            <input name="id" type="hidden" value="${product.getIdProduct()}">
            <div class="field">
                <label class="label">Name</label>
                <div class="control">
                    <input name="name" class="input" type="text" value="${product.getName()}">
                </div>
            </div>
            <div class="field">
                <label class="label">Price</label>
                <div class="control">
                    <input name="price" class="input" type="text" value="${product.getPrice()}">
                </div>
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
                    <input name="stock" class="input" type="text" value="${product.getStock()}">
                </div>
            </div>
            <div class="field">
                <label class="label">Category</label>
                <div class="select">
                    <select name="category">
                        <c:forEach items="${categories}" var="category">
                            <c:choose>
                                <c:when test="${category.getIdCategory() eq product.getIdCategory()}">
                                    <option value="${category.getIdCategory()}" selected>${category.getName()}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${category.getIdCategory()}">${category.getName()}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="field is-grouped">
                <div class="control">
                  <button class="button is-primary">Save</button>
                </div>
             </div>
        </form>
    </jsp:body>
</tag:layout>
