<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<tag:layout>
    <jsp:body>
        <h1 class="title is-1 has-text-centered">Signup</h1>
        <div class="columns">
            <div class="column is-one-quarter"></div>
            <div class="column">
            <form method="POST" action="/signup">
                <div class="field">
                    <div class="control">
                        <input type="text" name="first-name" autofocus="true" 
                               class="input" placeholder="First name">
                    </div>
                </div>
                <div class="field">
                    <div class="control">
                        <input type="text" name="last-name" class="input"
                               placeholder="Last name">
                    </div>
                </div>
                <div class="field">
                    <div class="control">
                        <input type="tel" name="phone" class="input"
                               placeholder="Phone number">
                    </div>
                </div>
                <div class="field">
                    <textarea name="address" class="textarea" placeholder="Address"></textarea>
                </div>
                <div class="field">
                    <div class="control">
                        <input type="email" placeholder="Email" name="email" class="input">
                    </div>
                </div>
                <div class="field">
                    <div class="control">
                        <input type="password" placeholder="Password" name="password" class="input">
                    </div>
                </div>
                <div class="field">
                    <div class="control">
                        <button type="submit" class="button is-success">Register</button>
                    </div>
                </div>
            </form>
            </div>
            <div class="column is-one-quarter"></div>
        </div>
    </jsp:body>
</tag:layout>