<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<tag:layout>
    <jsp:attribute name="hero">
        <section class="hero is-primary is-medium">
            <div class="hero-body">
                <div class="container">
                    <h1 class="title">
                        Medium title
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
        <p>${sessionScope.email}</p>
    </jsp:body>
</tag:layout>