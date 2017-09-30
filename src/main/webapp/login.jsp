<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<tag:layout>
    <jsp:body>
        <h1 class="title is-1 has-text-centered">Login</h1>
        <div class="columns">
            <div class="column is-one-quarter"><%-- to push the login --%></div>
            <div class="column">
                <form action="/login" method="post">
                    <div class="field">
                        <p class="control has-icons-left has-icons-right">
                            <input name="email" class="input" required="true" type="email" placeholder="Email">
                            <span class="icon is-small is-left">
                                <i class="fa fa-envelope"></i>
                            </span>
<!--                            <span class="icon is-small is-right">
                                <i class="fa fa-check"></i>
                            </span>-->
                        </p>
                    </div>
                    <div class="field">
                        <p class="control has-icons-left">
                            <input name="password" class="input" required="true" type="password" placeholder="Password">
                            <span class="icon is-small is-left">
                                <i class="fa fa-lock"></i>
                            </span>
                        </p>
                    </div>
                    <div class="field">
                        <p class="control">
                            <button type="submit" class="button is-success">
                                Login
                            </button>
                            <a class="button is-link is-pulled-right" href="/signup">
                                Create account
                            </a>
                        </p>
                    </div>
                    <c:if test="${error}">
                        <p class="has-text-danger">Email and password didn't match!</p>
                    </c:if>
                    
                </form>
            </div>
            <div class="column is-one-quarter"><%-- to push the login --%></div>
         </div>
        
    </jsp:body>
</tag:layout>