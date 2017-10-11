<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<tag:layout>
    <jsp:attribute name="hero">
        <section class="hero is-primary is-medium">
            <div class="hero-body">
                <div class="container">
                    <h1 class="title">
                        Medium title Hero
                    </h1>
                    <h2 class="subtitle">
                        Medium subtitle
                    </h2>
                </div>
            </div>
        </section>
    </jsp:attribute>
    <jsp:body>
        :)
        <div>
            <a class="button is-large is-info" href="/shopping">Buy!</a>
        </div>
        <p>${sessionScope.email}</p>
    </jsp:body>
</tag:layout>