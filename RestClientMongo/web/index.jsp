<%-- 
    Document   : index
    Created on : 13 déc. 2015, 22:43:55
    Author     : Abdallah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="app">
	<head>
		<title>Crud Mongo</title>
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
			<h1 class="custom">Movie Management Interface</h1>
		</div>
<div class="RightPanel">
		    <form>
		    	<table>
					<tr>
						<td><input type="text" ng-model="searchName" size="30"></td>
						<td><button type="button" ng-click="searchMovie(searchName)" class="btn btn-primary btn-sm">
      					<span class="glyphicon glyphicon-search"></span> Search </button></td>
						
						<td><button ng-click="resetSearch()"  class="btn btn-info btn-sm">
						<span class="glyphicon glyphicon-refresh"></span> Reset Search </button></td>
                                                
                                                <tr><h3><a href="insert.jsp" class="btn btn-primary btn-sm">NewMovie</a></h3></tr>
					</tr>
				</table>
		    </form>
    
			
		</div>
		<div class="leftPanel">
                    <div class="LeftPanelHeader"><strong>{{navTitle}}</strong></div>
      <table class="side" border="2">
       
          <tr><center><th>title</th>
           <th>genre</th>
           <th>summary</th></center>
       </tr>
       <tr ng-repeat="m in movies"  >
         <td class="side">{{m.title}}</td>
                             <td class="side">{{m.genre}}</td>
                              <td class="side">{{m.summary}}</td>
     
     
						<td>
						  <table>						  	
						  	<tr>
                                                            <td><input type="text" ng-model="saveName" size="15" ng></td>
           
						  	  <td><button ng-click="saveMovie(m.title,saveName);" class="btn btn-success btn-sm" title="Save movie's details..."  onclick="javascript:afficher_cacher(saveName);">
						  	  <span class="glyphicon glyphicon-plus"></span> Save </button></td>
                                                          </br>
                                                          </tr>
                                                          <tr>
							  <td><button ng-click="deleteMovie(m.title)" class="btn btn-danger btn-sm" >
							  <span class="glyphicon glyphicon-trash"></span> Delete </button></td>  	  
						  	</tr>
						  </table>
						</td>
	</tr>
   </table>
  </div>

		
		

            <div class="footer"><center>Crud Mongo</center></div>
	</div>
            
	</body>
        
</html>