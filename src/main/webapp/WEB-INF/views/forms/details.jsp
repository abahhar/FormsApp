<?xml version="1.0" encoding="UTF-8" ?>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Forms App - ${form.title}</title>

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
    	<h2 class="text-center">${form.title}</h2>
    	
    	<h4>
    			<a href="<c:url value="/forms"/>">Back to forms</a>
		</h4>
		
		<sec:authorize access="hasRole('ROLE_ADMIN')">
		<p>
			<a href="<c:url value="/simpleQuestions/create?formId=${form.id}"/>" class="btn btn-default btn-lg">Create simple question</a>
			<a href="<c:url value="/mcQuestions/create?formId=${form.id}"/>" class="btn btn-default btn-lg">Create multiple choice question</a>
		</p>
		</sec:authorize>
		
		<c:choose>
			<c:when test="${not empty simpleQuestions}">
					<table class="table table-striped table-bordered" style="font-size: 18px">
				    <thead>
				      <tr>
				        <th>Simple questions</th>
				        <sec:authorize access="hasRole('ROLE_ADMIN')">
				        	<th colspan="2" class="text-center">Manage</th>
				      	</sec:authorize>
				      </tr>
				    </thead>
				    <tbody>
				      
				      <c:forEach var="simpleQuestion" items="${simpleQuestions}">
				      	<tr>
					        <td style="padding: 10px">
					        	<a href="<c:url value="../simpleQuestions/details?id=${simpleQuestion.id}" />" >
					        		${simpleQuestion.text}
					        	</a>
					        </td>
					        <sec:authorize access="hasRole('ROLE_ADMIN')">
				        		<td class="text-center">
				        			<a href="<c:url value="../simpleQuestions/update?id=${simpleQuestion.id}" />" >
					        			Edit
					        		</a>
				        		</td>
				        		<td class="text-center">
				        			<a href="<c:url value="../simpleQuestions/delete?id=${simpleQuestion.id}" />" >
					        			Delete
					        		</a>
				        		</td>
				      		</sec:authorize>
					      </tr>
				      </c:forEach>
				      
				    </tbody>
				  </table>
			</c:when>
			<c:otherwise>
				<div class="well">
					There are no written questions
				</div>
			</c:otherwise>
		</c:choose>
		
		<c:choose>
			<c:when test="${not empty mcQuestions}">
					<table class="table table-striped table-bordered" style="font-size: 18px">
				    <thead>
				      <tr>
				        <th>Multiple choice questions</th>
				        <sec:authorize access="hasRole('ROLE_ADMIN')">
				        	<th colspan="2" class="text-center">Manage</th>
				      	</sec:authorize>
				      </tr>
				    </thead>
				    <tbody>
				      
				      <c:forEach var="mcQuestion" items="${mcQuestions}">
				      	<tr>
					        <td style="padding: 10px">
					        	<a href="<c:url value="../mcQuestions/details?id=${mcQuestion.id}" />" >
					        		${mcQuestion.text}
					        	</a>
					        </td>
					        <sec:authorize access="hasRole('ROLE_ADMIN')">
				        		<td class="text-center">
				        			<a href="<c:url value="../mcQuestions/update?id=${mcQuestion.id}" />" >
					        			Edit
					        		</a>
				        		</td>
				        		<td class="text-center">
				        			<a href="<c:url value="../mcQuestions/delete?id=${mcQuestion.id}" />" >
					        			Delete
					        		</a>
				        		</td>
				      		</sec:authorize>
					      </tr>
				      </c:forEach>
				      
				    </tbody>
				  </table>
			</c:when>
			<c:otherwise>
				<div class="well">
					There are no multiple choice questions
				</div>
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