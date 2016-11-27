'use strict';

// Declare app level module which depends on views, and components
angular.module('myAppRename', [
  'ngRoute',
  'myAppRename.controllers',
  'myAppRename.directives',
  'myAppRename.services',
  'myAppRename.factories',
  'myAppRename.filters',
  'myAppRename.view1',
  'myAppRename.view2',
  'myAppRename.view3'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.when("/reservation/:id", {
      templateUrl : "app/view1/reservation.html",
      controller: "View1Ctrl"
  })

    .otherwise({redirectTo: '/view1'});

}])
.config(function ($httpProvider) {
    $httpProvider.interceptors.push('authInterceptor');
  });



