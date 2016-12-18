<%-- 
    Document   : insert
    Created on : 14 déc. 2015, 16:47:29
    Author     : ABDALLAH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html ng-app="app">
	<head>
		<title>CRUD Mongo</title>
		<link href="include/styles.css" rel="stylesheet">
		<!-- Use Bootstrap -->
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular.min.js"></script>
		<script type="text/javascript" src="RestClient.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
	</head>
    <body ng-controller="HttpCtrl as app">
  	<div class="container">
		<div class="header">
			<h1 class="custom"front color="blue" >New Movie</h1>
		</div>
    <form id="main">
				<table>
					<tr>
						<td class="display_bold"><label for="movie.title">Title:</label></td>
					</tr>
					<tr>
						<td class="display"><input id="id" type="text" ng-model="title" size="4"></td>
					</tr>
					<tr>
						<td class="display_bold"><label for="name">Year:</label></td>
					</tr>
					<tr>
						<td class="display"><input type="text" ng-model="year" size="30"></td>
					</tr>
					<tr>
						<td class="display_bold"><label for="name">Genre:</label></td>
					</tr>
					<tr>
						<td class="display"><input type="text" ng-model="genre" size="40"></td>
					</tr>
					<tr>
						<td class="display_bold"><label for="name">Summary:</label></td>
					</tr>
					<tr>
						<td class="display"><input type="text" ng-model="summary" size="20"></td>
					</tr>
					<tr>
						<td class="display_bold"><label for="name">Country</label></td>
					</tr>
					<tr>
						<td class="display"><input type="text" ng-model="country" size="30"></td>
					</tr>	
					<tr>
                                            <td><button ng-click="addNew(title,year,genre,summary,country)" class="btn btn-primary btn-sm" >
						<span class="glyphicon glyphicon-plus" ></span> Add New </button></td>
                                                <td>  <h3><a href="index.jsp" class="btn btn-info btn-sm">View</a></h3></td>
					</tr>
					
					
				</table>
			</form>
		</div>
        
    </body >
</html>
