<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<tag:layout>
    <jsp:body>
        <button class="button is-primary open-modal" data-modal="addCategory">Add</button> 
        <form action="/categories" method="post">
            <div class="field">
                
            </div>
            <div class="field is-grouped">
                <div class="control">
                  <button class="button is-primary">Create</button>
                </div>
             </div>
        </form>
        
        <table class="table">
            <thead>
              <tr>
                <th><abbr title="ID">ID</abbr></th>
                <th><abbr title="Name">Name</abbr></th>
                <th><abbr title="Name"></abbr></th>
              </tr>
            </thead>
            <tbody>
                <c:forEach items="${categories}" var="category">
                    <tr>
                        <th>${category.getIdCategory()}</th>
                        <td>${category.getName()}</td>
                        <th>
                            <form action="/categories" method="DELETE">
                                <input type="hidden" name="id" value="${category.getIdCategory()}" />
                                <button class="delete"></button>
                            </form>
                        </th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div id="addCategory" class="modal">
            <div class="modal-background"></div>
            <div class="modal-card">
              <header class="modal-card-head">
                <p class="modal-card-title">Add category</p>
                <button class="delete close-modal" aria-label="close" data-modal="addCategory"></button>
              </header>
              <section class="modal-card-body">
                <label class="label">Name</label>
                <div class="control">
                  <input name="name" class="input" type="text" placeholder="Enter the name">
                </div>
              </section>
              <footer class="modal-card-foot">
                <button class="button is-success">Save changes</button>
                <button class="button close-modal" data-modal="addCategory">Cancel</button>
              </footer>
            </div>
        </div>
    </jsp:body>
</tag:layout>