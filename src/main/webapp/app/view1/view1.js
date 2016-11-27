'use strict';

angular.module('myAppRename.view1', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {
    templateUrl: 'app/view1/view1.html'
  });
    $routeProvider.when('/reservation', {
        templateUrl: 'app/view1/reservation.html'
    });
}])

    .controller('View1Ctrl', ['$scope','$routeParams', '$filter',function ($scope,$routeParams,$filter) {
      $scope.departures = [];
      var departures = [];
      departures.push({"id": 1,"from": "Havn 1", "to": "havn2", "date": "20-11-2016", "time": "18.04"});
      departures.push({"id": 2,"from": "Havn 3", "to": "havn4", "date": "20-11-2016", "time": "18.04"});
      departures.push({"id": 3,"from": "Havn 5", "to": "havn6", "date": "20-11-2016", "time": "18.04"});
      departures.push({"id": 4,"from": "Havn 7", "to": "havn8", "date": "20-11-2016", "time": "18.04"});
      $scope.departures = departures;

       // $filter('searchDepature')("tis","mis");
// reservation page
        var depatureId = $routeParams.id;
      //  console.log("depatureId :"+depatureId);
        for(var i =0; i< $scope.departures.length; i++){
          //  console.log("$scope.departures[i].id ;"+$scope.departures[i].id);
            if($scope.departures[i].id == depatureId    )
            {
                $scope.selectedDepature = $scope.departures[i];
                break;
            }
        }
//reservation page done
    }]);