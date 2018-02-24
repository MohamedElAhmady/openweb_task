var app = angular.module("myModule", [ 'ngRoute',
		'angularUtils.directives.dirPagination' ]);

// Controller Part
app.controller("myController", function($scope, $http) {
	
	// Now load the data from server
	getEmployeesData();
	
	function getEmployeesData() {
		$http({
			method : 'GET',
			url : 'http://localhost:45541/api/employees/'
		}).then(function successCallback(response) {
			$scope.employees = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}

});


