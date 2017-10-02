<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
    <jsp:body>
        <button class="button is-primary open-modal" data-modal="addCategory">Add</button>
        <table class="table">
            <thead>
                <tr>
                    <th><abbr title="ID">ID</abbr></th>
                    <th><abbr title="Name">Name</abbr></th>
                    <th><abbr></abbr></th>
                    <th><abbr></abbr></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${categories}" var="category">
                    <tr>
                        <th>${category.getIdCategory()}</th>
                        <td>${category.getName()}</td>
                        <th><a href="?edit=${category.getIdCategory()}" class="button is-warning is-small">edit</a></th>
                        <th>
                            <t:delete action="/categories">
                                <jsp:body>
                                    <input type="hidden" name="id" value="${category.getIdCategory()}" />
                                    <button class="delete"></button>
                                </jsp:body>
                            </t:delete>
                            
                        </th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <t:modal id="addCategory" active="${edit}" name="${edit ? 'Edit' : 'Add' } category">
            <jsp:body>
                <t:form action="/categories" type="${edit ? 'PUT' : 'POST' }" >
                    <jsp:body>
                        <div class="control">
                            <div class="field">
                                <label class="label">Name</label>
                                <input name="name" required="true" class="input" value="${category.getName()}" type="text" placeholder="Enter the name">
                            </div>
                            <c:if test="${edit}">
                                <input name="id" value="${category.getIdCategory()}" type="hidden">
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