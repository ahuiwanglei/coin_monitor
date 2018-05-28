/**
 * Created by admin on 2017/3/30.
 */
angular.module('app', ['ngMaterial']);
angular.module("app").controller(
    'orderbooksCtr',
    function ($scope, $http, $rootScope, $interval,$mdToast,$mdDialog) {

        $scope.init = function () {
            $scope.queryList();
        };

        $scope.list = [];
        $scope.remindList = [];

        $scope.queryList = function () {
            $http({
                method: "POST",
                url: "/api/marketlist/orderbooks",
                data: {},
                timeout: 20000
            }).then(function (result) {

                if (result.data.resultStatus != 0) {
                    $scope.tip(result.data.msg);
                } else {
                    $scope.list = result.data.resultData;

                }
            }, function (error) {
                $scope.tip("网络错误");
            });
        };
        $interval($scope.queryList, 10000);

        $scope.tip = function (msg) {
            $mdToast.show (
                $mdToast.simple()
                    .textContent(msg)
                    .hideDelay(3000).position("bottom right")
            );
        }
    });