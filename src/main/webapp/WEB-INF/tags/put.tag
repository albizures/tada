<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@tag description="put form " pageEncoding="UTF-8"%>

<%@attribute name="action" required="true"%>

<t:form action="${action}" type="PUT">
    <jsp:body>
        <jsp:doBody />
    </jsp:body>
</t:form>
