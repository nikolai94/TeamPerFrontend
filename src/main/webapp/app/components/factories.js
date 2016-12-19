'use strict';

/* Factories */

angular.module('myAppRename.factories', []).
  factory('InfoFactory', function () {
    var info = "Hello World from a Factory";
    var getInfo = function getInfo(){
      return info;
    }
    return {
      getInfo: getInfo
    }
  })
  .factory('authInterceptor', function ($rootScope, $q, $window) {
    return {
      request: function (config) {
        config.headers = config.headers || {};
        if ($window.sessionStorage.token) {
          config.headers.Authorization = 'Bearer ' + $window.sessionStorage.token;
        }
        return config;
      },
      responseError: function (rejection) {
        if (rejection.status === 401) {
          // handle the case where the user is not authenticated
        }
        return $q.reject(rejection);
      }
    };
  }).factory('getAllRouteSummaries', ['$http', function($http)
    {
  var url = "http://localhost:8080/TeamPerFrontend-1.0-SNAPSHOT/api/user/getAllRouteSummaries";
  var dataFactory = {};
  dataFactory.getData = function()
  {
    return $http.get(url);
  }
  return dataFactory;}])
.factory('getDepartures', ['$http', function($http)
{
    var url = "http://localhost:8080/TeamPerFrontend-1.0-SNAPSHOT/api/user/getDepartures/";
    var dataFactory = {};
    dataFactory.getData = function(routeId, travellingDate)
    {
        return $http.get(url+routeId+"/"+travellingDate);
    }
    return dataFactory;}])
    .factory('getDeparture', ['$http', function($http)
    {
        var url = "http://localhost:8080/TeamPerFrontend-1.0-SNAPSHOT/api/user/getDeparture/";
        var dataFactory = {};
        dataFactory.getData = function(depatureId)
        {
            return $http.get(url+depatureId);
        }
        return dataFactory;}]);



;