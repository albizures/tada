<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@tag description="modal layout" pageEncoding="UTF-8"%>
<%@attribute name="id" required="true" %>
<%@attribute name="name" required="true" %>
<%@attribute name="active" %>

<div id="${id}" class="modal ${active ? 'is-active' : ''}">
    <div class="modal-background"></div>
    <div class="modal-card">
        <header class="modal-card-head">
            <p class="modal-card-title">${name}</p>
            <button class="delete close-modal" aria-label="close" data-modal="${id}" type="button"></button>
        </header>
        <section class="modal-card-body">
            <jsp:doBody/>
        </section>
        <footer class="modal-card-foot"></footer>
    </div>
</div>
