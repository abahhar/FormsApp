<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Forms App - Home</title>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/heroic-features.css" />" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<c:url value="/" />">Forms App</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">About</a>
                    </li>
                    <li>
                        <a href="#">Services</a>
                    </li>
                    <li>
                        <a href="#">Contact</a>
                    </li>
                    <li>
                        <a href="<c:url value="/j_spring_security_logout" />">Logout</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">

        <!-- Jumbotron Header -->
        <header class="jumbotron hero-spacer">
            <h1>A Warm Welcome!</h1>
            <p>Welcome to Forms App, where you can interact with people through creating and answering questions!</p>
        </header>

        <hr>
        
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <!--
        	<h3>
    			<a href="<c:url value="/forms/create"/>">Create form</a>
			</h3>
			-->
			<p>
				<a href="<c:url value="/forms/create"/>" class="btn btn-default btn-lg">Create form</a>
			</p>
        </sec:authorize>

        <!-- Title -->
        <div class="row">
            <div class="col-lg-12">
                <h3>Latest Forms</h3>
            </div>
        </div>
        <!-- /.row -->
		<c:choose>
			<c:when test="${not empty forms }">
			
		        <!-- Page Features -->
		        <div class="row text-center">
		        
		        	<c:forEach var="form" items="${forms}">
		        	
		        	<a href="<c:url value="forms/details?id=${form.id}" />">
			            <div class="col-md-3 col-sm-6 hero-feature">
			                <div class="thumbnail">
			                    <img src="<c:url value="/resources/img/form-icon.png" />" alt="">
			                    <div class="caption">
			                        <h3>${form.title}</h3>
			                        <sec:authorize access="hasRole('ROLE_ADMIN')">
			                        	<p>
				                            <a href="<c:url value="forms/update?id=${form.id}"/>" class="btn btn-primary">Edit</a> <a href="<c:url value="forms/delete?id=${form.id}"/>" class="btn btn-default">Delete</a>
				                        </p>
			                        </sec:authorize>
			                    </div>
			                </div>
			            </div>
		            </a>
		            
		            </c:forEach>
		            
		        </div>
		        <!-- /.row -->
		        
	        </c:when>
	        <c:otherwise>
	        	There are no forms
	        </c:otherwise>
        </c:choose>

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Forms App 2015</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="<c:url value="/resources/js/jquery.js" />"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</body>

</html>