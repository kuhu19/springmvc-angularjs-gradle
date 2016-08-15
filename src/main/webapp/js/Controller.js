var loginApp = angular.module('loginApp',[]);
loginApp.controller('loginController', ['$scope','$http','$window',function($scope,$http,$window) {

  $scope.login = function() {
		  var formData= {"username":$scope.username,"password":$scope.password};
		  $http.post('/test/rest/dologin',formData).success(function(response){
              switch(response) {
              case "admin":
                  $window.location.href = '/test/pages/success.html';
                  break;
              case "test":
            	  $window.location.href = '/test/pages/success.html';
                  break;
              default:
            	  console.log("default");
        	  	  $window.location.href = '/test/pages/failure.html';
          }
          });
  };
}]);