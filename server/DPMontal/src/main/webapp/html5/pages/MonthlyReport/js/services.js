angular.module('starter.services', [])
    .directive("navBackButton", function () {
        return {
            restrict: "A",
            link: function ($scope, element, attrs) {
                element.bind('click', function () {
                    console.log(1)
                    $ionicNavBarDelegate.back();
                });
            }
        }
    })
;