'use strict';

angular.module('myAppRename.View1Ctrl', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {
    templateUrl: 'app/view1/view1.html'
  });
    $routeProvider.when('/reservation', {
        templateUrl: 'app/view1/reservation.html'
    });
}])

    .controller('View1Ctrl', ['$scope','$routeParams','getAllRouteSummaries','getDepartures','getDeparture',function ($scope,$routeParams,getAllRouteSummaries,getDepartures,getDeparture) {
      $scope.departures = [];
        $scope.routes = [];
        getAllRouteSummaries.getData().success(function(data){
            $scope.routes = data;
        });

        $scope.browseDepatures = function() {
            console.log($scope.route.travellingDate);
            var str;
            var routeId = -1;
            for (var i = 0; i < $scope.routes.length; i++) {
                console.log($scope.routes[i]);
                str = $scope.routes[i].harbourOrigin += " - " + $scope.routes[i].harbourDestination;

                if (str == $scope.route.route) {
                    routeId = $scope.routes[i].routeId;
                }
            }
            if (routeId != -1) {
                console.log("leder efter departues");
                    getDepartures.getData(routeId, $scope.route.travellingDate).success(function (data) {
                    if(data.length < 1){
                        $scope.noDepaturesFound ="No departures found";
                    }
                    else {
                        $scope.noDepaturesFound ="";
                        $scope.departures = data;
                    }
                    }).error(function (errormsg) {
                        console.log(errormsg);
                        $scope.noDepaturesFound ="Something went Wrong";
                    })
                }
            }





// reservation page
        var depatureId = $routeParams.id;
        if(depatureId != undefined )
        {
            getDeparture.getData(depatureId).success(function(data){
                $scope.selectedDepature = data;
            }).error(function(error){
                console.log(error);
            })
        }
//reservation page done
    }]);