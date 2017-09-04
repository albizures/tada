<%@tag description="global layout" pageEncoding="UTF-8"%>
<%@attribute name="hero" fragment="true" %>
<html>
    <head>
        <title>Tada</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="/css/bulma.min.css"/>
        <link rel="stylesheet" href="/css/index.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link href="/favicon.ico" rel="icon" type="image/x-icon" />
    </head>
    <body>

        <nav class="navbar">
            <div class="container">
               <div class="navbar-brand">
                    <a class="navbar-item" href="/">
                        <h1>Tada</h1>
                    </a>

                    <div class="navbar-burger">
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
                </div> 
                <div class="navbar-menu">
                    <div class="navbar-start">
                        <a class="navbar-item">
                          
                        </a>
                        <div class="field navbar-item has-addons">
                            <div class="control has-icons-left search-input">
                                <input class="input" type="text" placeholder="Text input">
                                <span class="icon is-small is-left">
                                    <i class="fa fa-search"></i>
                                </span>
                            </div>
                            <div class="control">
                                <button type="submit" class="button is-primary">Search</button>
                            </div>
                        </div>
                    </div>
                    <div class="navbar-end">
                        <a class="navbar-item" href="/cart">
                            Cart
                        </a>
                        <a class="navbar-item " href="/login">
                            Login
                        </a>
                    </div>
                </div>
            </div>       
        </nav>
        <jsp:invoke fragment="hero"/>
        <div class="container">
            <jsp:doBody/>
        </div>
        <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script> 
    </body>
</html>