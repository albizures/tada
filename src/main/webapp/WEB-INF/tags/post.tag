<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@tag description="post form " pageEncoding="UTF-8"%>

<%@attribute name="action" required="true"%>

<t:form action="${action}" type="POST">
    <jsp:body>
        <jsp:doBody />
    </jsp:body>
</t:form>
