<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<tag:layout>
    <jsp:body>
        <h1>Signup</h1>
        <form method="POST" action="/signup">
            <div class="field">
                <input type="text" placeholder="Nombres" name="first-name" autofocus="true">
            </div>
            <div class="field">
                <input type="text" placeholder="Apellidos" name="last-name">
            </div>
            <div class="field">
                <input type="tel" placeholder="Telefono" name="phone">
            </div>
            <div class="field">
                <textarea name="address">Direccion</textarea>
            </div>
            <div class="field">
                <input type="email" placeholder="Email" name="email">
            </div>
            <div class="field">
                <input type="password" placeholder="Contrasenia" name="password">
            </div>
            <div class="field">
                <div class="control">
                    <button type="submit" class="button is-success">Register</button>
                </div>
            </div>
        </form>
    </jsp:body>
</tag:layout>