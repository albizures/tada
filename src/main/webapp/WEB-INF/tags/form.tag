<%@tag description="form" pageEncoding="UTF-8"%>

<%@attribute name="action" required="true"%>
<%@attribute name="type" required="true"%>

<form action="${action}" method="POST">
    <input type="hidden" name="actionType" value="${type}" />
    <jsp:doBody/>
</form>