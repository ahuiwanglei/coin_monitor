/**
 * Created by admin on 2017/3/30.
 */
angular.module('app', ['ngMaterial']);
angular.module("app").controller(
    'marketlistCtr',
    function ($scope, $http, $rootScope, $interval,$mdToast,$mdDialog) {

        $scope.init = function () {
            $scope.queryList();
        };

        $scope.list = [];
        $scope.remindList = [];

        $scope.queryList = function () {
            $scope.pause();
            $http({
                method: "POST",
                url: "/api/marketlist/list",
                data: {},
                timeout: 20000
            }).then(function (result) {

                if (result.data.resultStatus != 0) {
                    $scope.tip(result.data.msg);
                } else {
                    $scope.list = result.data.resultData;
                    for(var i=0;i< $scope.list.length; i++){
                        var item = $scope.list[i];
                        if(item.is_remind == 1){
                            $scope.updateRemind(item);
                        }
                    }
                }
            }, function (error) {
                $scope.tip("网络错误");
            });
        };


        $scope.updateRemind = function (item) {
            $http({
                method: "POST",
                url: "/api/marketlist/updateRemind",
                data: JSON.stringify(item),
                timeout: 20000
            }).then(function (result) {
                if (result.data.resultStatus != 0) {
                    $scope.tip(result.data.msg);
                } else {
                    $mdDialog.show(
                        $mdDialog.alert()
                            .parent(angular.element(document.body))
                            .clickOutsideToClose(true)
                            .title('提示')
                            // .layout("98%", "99%")
                            .textContent(item.symbol+  "排名从" + item.history_rank +" 变为" + item.rank)
                            .ariaLabel('Welcome to TutorialsPoint.com')
                            .ok('OK')
                    );
                    $scope.remindList.push(item);
                    $scope.play();


                }
            }, function (error) {
                $scope.tip("网络错误");;
            });
        };


        $interval($scope.queryList, 10000);
        
        $scope.play = function () {
            var music = document.getElementById('music');
            music.play();
        };
        $scope.pause = function () {
            var music = document.getElementById('music');
            music.pause();
        }

        $scope.tip = function (msg) {
            $mdToast.show (
                $mdToast.simple()
                    .textContent(msg)
                    .hideDelay(3000).position("bottom right")
            );
        }

    });