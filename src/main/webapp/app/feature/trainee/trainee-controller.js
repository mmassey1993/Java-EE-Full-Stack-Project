"use strict";

(function() {

    var TraineeController =  function(traineeService, $log) {
        
    	var vm = this;
        
        vm.isHidden = false;
        
        vm.hideTable = function()
        {
        	vm.isHidden = !vm.isHidden
        };
        
        function init() {
        	traineeService.getTrainees().then(function (results) {
           	vm.trainees = results;
           	$log.log("In the trainee controller the value of the result promise is ");
        	$log.log(JSON.stringify(vm.trainees));
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
       }
       
       init();
            
    };

    angular.module('traineeApp').controller('traineeController', ['traineeService','$log', TraineeController]);
}());