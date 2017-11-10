<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<tag:layout>
    <jsp:body>
        <h2>Credit cards</h2>
        <form action="/cards" method="POST">
            <input type="hidden">
            <input name="name" type="text">
            <input name="number" type="text" placeholder="Enter without -">
            <input name="year" type="text" placeholder="Year">
            <input name="month" type="text" placeholder="Month">
            <button type="submit">Guardar</button>
        </form>
        <br>
        <table>
            <thead>
                <th>Nombre</th>
                <th>Numero</th>
            </thead>
            <tbody>
                <c:forEach items="${cards}" var="card">
                    <tr>
                        <th>${card.getName()}</th>
                        <td>${card.getNumber()}</td>
                        <th><a href="?edit=${card.getId_card()}" class="button is-warning is-small">edit</a></th>
                        <th>
                            
                        </th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </jsp:body>
</tag:layout>