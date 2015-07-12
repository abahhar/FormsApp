<?xml version="1.0" encoding="UTF-8" ?>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Forms App - ${mcQuestion.text}?</title>

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
    	<h4>
    			<a href="<c:url value="/forms/details?id=${mcQuestion.form.id}"/>">Back to form</a>
		</h4>
    	<h3>${mcQuestion.text}</h3>
    	
    	<hr />
    	
    	<h2 class="text-center">Choose Answer</h2>
    	
    	<form class="form-horizontal" role="form" name="choiceAnswer" method="POST" action="<c:url value="/choiceAnswers/create"/>" >
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		    <c:forEach var="choice" items="${mcQuestion.choices}">
		    	<label class="control-label col-sm-2" for="text">
		    		<input type="radio" class="form-control" name="choice.id" id="text" value="${choice.id}" />${choice.text}
		      	</label>
		    </c:forEach>
		    </div>
		    <input type="hidden" name="mcQuestion.id" value="${mcQuestion.id}"/>
		  </div>
		  <div class="form-group"> 
		    <div class="col-sm-offset-5 col-sm-10">
		      <button type="submit" class="btn btn-default">Add Answer</button>
		    </div>
		  </div>
		</form>
    	
    	<hr />
    	
    	<h2 class="text-center">Answers</h2>
		
		<c:choose>
			<c:when test="${not empty mcQuestion.choiceAnswers}">
				<table class="table table-striped">
			    <thead>
			    	<tr style="font-size: 18px">
			    		<th>
			    			User
			    		</th>
			    		<th>
			    			Answer
			    		</th>
			    		<th>
			    			Manage
			    		</th>
			    	</tr>
			    </thead>
			    <tbody>
			      
			      <c:forEach var="choiceAnswer" items="${mcQuestion.choiceAnswers}">
			      	<tr>
			      		<td style="padding: 10px">
				        	${choiceAnswer.user.login}
				        </td>
				        <td style="padding: 10px">
				        	${choiceAnswer.choice.text}
				        </td>
				        <td style="padding: 10px">
				        	<a href="<c:url value="/choiceAnswers/delete?answerId=${choiceAnswer.id}&questionId=${mcQuestion.id}"/>" >Delete</a>
				        </td>
				    </tr>
			      </c:forEach>
			      
			    </tbody>
			  </table>
			</c:when>
			<c:otherwise>
				There are no answers
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