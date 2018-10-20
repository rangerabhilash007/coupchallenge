(function() {
	"use strict";
	angular.module("coupApp").controller("CoupController", getCoupController);

	function getCoupController($scope, $http) {
		$scope.title = "Coup Application"
		$scope.status = false;
		$scope.getResponse = function(coup) {
			if (angular.isDefined(coup)) {
				if (!coup.scooters || coup.scooters && coup.scooters === "") {
					$scope.errorStatus = true;
					$scope.success = false;
					$scope.message = "Please provide Scooter Districts.";
					return;
				} else if (!coup.C || coup.C && coup.C === "") {
					$scope.errorStatus = true;
					$scope.success = false;
					$scope.message = "Please provide Manager Capacity";
					return;
				} else if (!coup.P || coup.P && coup.P === "") {
					$scope.errorStatus = true;
					$scope.success = false;
					$scope.message = "Please provide Engineer Capacity";
					return;
				}
			} else {
				$scope.errorStatus = true;
				$scope.success = false;
				$scope.message = "All Details are mandatory.";
				return;
			}

			if (typeof coup.scooters.split(',') === "defined") {
				coup.scooters = coup.scooters.split(',');
			}

			console.log("Object : " + JSON.stringify(coup));
			var requestConfig = {
				method : "GET",
				url : "/coup?scooters=" + coup.scooters + "&C=" + coup.C
						+ "&P=" + coup.P,
			};

			$http(requestConfig).then(function(response) {
				console.log(response.data);
				console.log("Response : " + JSON.stringify(response));
				if (response.status = 200) {
					$scope.success = true;
					$scope.errorStatus = false;
					$scope.message = response.data.fleet_engineers;
				}

			}, function errorCallback(response) {
				console.log("Response : " + JSON.stringify(response));
				$scope.errorStatus = true;
				$scope.success = false;
				$scope.message = response.data.message;
			});
		};

	}
	;

})();