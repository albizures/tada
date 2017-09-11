<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<tag:layout>
    <jsp:body>        
        <form action="/products" method="post">
            <div class="field">
                <label class="label">Name</label>
                <div class="control">
                    <input name="name" class="input" type="text">
                </div>
            </div>
            <div class="field">
                <label class="label">Price</label>
                <div class="control">
                    <input name="price" class="input" type="text">
                </div>
            </div>
            <div class="field">
                <label class="label">Description</label>
                <div class="control">
                    <textarea class="textarea" name="description"></textarea>
                </div>
            </div>
            <div class="field">
                <label class="label">Stock</label>
                <div class="control">
                    <input name="stock" class="input" type="text">
                </div>
            </div>
            <div class="field">
                <label class="label">Category</label>
                <div class="select">
                    <select name="category">
                        <c:forEach items="${categories}" var="category">
                            <option value="${category.getIdCategory()}">${category.getName()}</option>
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
