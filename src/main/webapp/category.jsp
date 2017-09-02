<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<tag:layout>
    <jsp:body>
        <form action="/category" method="post">
            <div class="field">
                <label class="label">Name</label>
                <div class="control">
                  <input name="name" class="input" type="text" placeholder="Enter the name">
                </div>
            </div>
            <div class="field is-grouped">
                <div class="control">
                  <button class="button is-primary">Create</button>
                </div>
             </div>
        </form>
        
        <table class="table">
            <thead>
              <tr>
                <th><abbr title="ID">ID</abbr></th>
                <th><abbr title="Name">Name</abbr></th>
              </tr>
            </thead>
            <tbody>
                <c:forEach items="${categories}" var="category">
                    <tr>
                        <th>${category.getIdCategory()}</th>
                        <td>${category.getName()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </jsp:body>
</tag:layout>