'use strict';

/* Filters */

angular.module('myAppRename.filters', []).
  filter('checkmark', function () {
    return function(input) {
      return input ? '\u2713' : '\u2718';
    };
  })
    .filter('searchDepature',function () {
      return function(input){
        console.log("filter")
        console.log(input);
       // console.log(input[1]);
        return "tismis";
      }
    });

