(function() {
  var app = angular.module("app", []);
  
  app.controller("HttpCtrl", function($scope, $http) {
    var app = this;
    $scope.navTitle = 'All Movies';
    $scope.operation="";
    //$scope.isSaveDisabled = true;
    //$scope.isDeleteDisabled = true;
     
    var response = $http.get('http://localhost:50177/RESTMongo/webresources/API/');
    response.success(function(data) {
      $scope.movies = data;
      console.log("[main] # of items: " + data.length)
      angular.forEach(data, function(element) {
        console.log("[main] movie: " + element.name);
      });
    })
    response.error(function(data, status, headers, config) {
      alert("AJAX failed to get data, status=" + status);
    })
     
    $scope.getMovie = function(title) {
      var response = $http.get('http://localhost:50177/RESTMongo/webresources/API/'+ title );
       
      response.success(function(data) {
        $scope.movie = data;
        $scope.operation="update";
        //$scope.isSaveDisabled = false;
        //$scope.isDeleteDisabled = false;
        })
       
      response.error(function(data, status, headers, config) {
        alert("AJAX failed to get data, status=" + status);
      })
    };
     
    $scope.searchMovie = function(title) {
      var app = this;
      //$scope.navTitle = 'Search Criteria';
       
      var response = $http.get('http://localhost:50177/RESTMongo/webresources/API/' + title);
      response.success(function(data) {
        $scope.movies = data;
        $scope.$apply();
 
        console.log("[searchMovie] # of items: " + data.length)
        angular.forEach(data, function(element) {
          console.log("[searchMovie] movie: " + element.namae);
        });
 
        });
       
      response.error(function(data, status, headers, config) {
        alert("AJAX failed to get data, status=" + status);
      })
    };
     
    $scope.clearForm = function() {
      $scope.title = '';
          $scope.year='';
          $scope.genre='';
          $scope.summary='';
          $scope.country='';
          
      
    }
     
    $scope.addNew = function(title,year,genre,summary,country) {
     
      var response = $http.post('http://localhost:50177/RESTMongo/webresources/API/'+title+'/'+year+'/'+genre+'/'+summary+'/'+country, $scope.jsonObj);
        response.success(function(data, status, headers, config) {
          $scope.clearForm();
          alert("success=" + status);
         $scope.resetSearch();
          });
      
      main.id.focus();
      $scope.isSaveDisabled = true;
      $scope.isDeleteDisabled = false;
     
    }
     
    $scope.saveMovie = function(title,titleTo) {
      $scope.jsonObj = angular.toJson($scope.movie, false);
      console.log("[update] data: " + $scope.jsonObj);
 
        var response = $http.put('http://localhost:50177/RESTMongo/webresources/API/'+title+'/'+titleTo,$scope.jsonObj);
       
        response.success(function(data, status, headers, config) {
         alert("success=" + status);
        $scope.resetSearch();
          });
         
        response.error(function(data, status, headers, config) {
          alert("AJAX failed to get data, status=" + status);
        })
     
   };
     
    $scope.deleteMovie = function(title) {
      var response = $http.delete('http://localhost:50177/RESTMongo/webresources/API/'+title);
      response.success(function(data, status, headers, config) {
           alert("success=" + status);
        $scope.resetSearch();
      });
         
      response.error(function(data, status, headers, config) {
        alert("AJAX failed to get data, status=" + status);
      })
    };
     
    $scope.resetSearch = function() {
      var app = this;
      $scope.operation="";
      $scope.clearForm();
      //$scope.isSaveDisabled = true;
      //$scope.isDeleteDisabled = true;
      $scope.navTitle = 'All movies';
      $scope.searchName = '';
       
      var response = $http.get('http://localhost:50177/RESTMongo/webresources/API/');
      response.success(function(data) {
        $scope.movies = data;
        $scope.$apply();
        console.log("[resetSearch] # of items: " + data.length)
        });
       
      response.error(function(data, status, headers, config) {
        alert("AJAX failed to get data, status=" + status);
      })
    };
  }); 
  function afficher_cacher(id)
{
    if(document.getElementById(id).style.visibility=="hidden")
    {
        document.getElementById(id).style.visibility="visible";
        document.getElementById('bouton_'+id).innerHTML='Cacher le texte';
    }
    else
    {
        document.getElementById(id).style.visibility="hidden";
        document.getElementById('bouton_'+id).innerHTML='Afficher le texte';
    }
            return true;
}
})();