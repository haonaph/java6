app.controller("product-ctrl", function($scope, $http) {

    $scope.items = [];
    $scope.cates = [];
    $scope.form = {};

    $scope.initialize = function() {
        //load products
        $http.get("/rest/products").then(function(response) {
                $scope.items = response.data;
                $scope.items.forEach(item => {
                    item.createdate = new Date(item.createdate);
                })
            })
            //load categories
        $http.get("/rest/categories").then(function(response) {
            $scope.cates = response.data;
        })
    }

    //Khởi đầu
    $scope.initialize();

    //Xóa form
    $scope.reset = function() {
        $scope.form = {
            createdate: new Date(),
            image: '',
            available: true
        };

    }

    //Hiển thị lên form
    $scope.edit = function(item) {
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show');

    }

    //Thêm sản phẩm mới
    $scope.create = function() {
        var item = angular.copy($scope.form);
        $http.post('/rest/products', item).then(response => {
            response.data.createdate = new Date(response.data.createdate)
            $scope.items.push(response.data);
            $scope.reset();
            alert('create sp success');
        }).catch(error => {
            alert('error creating sp');
            console.log("error", error);
        })

    }

    //Cập nhật sản phẩm
    $scope.update = function() {
        var item = angular.copy($scope.form);
        $http.put('/rest/products/${item.id}', item).then(response => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;
            alert('update sp success');
        }).catch(error => {
            alert('error update sp');
            console.log("error", error);
        })
    }

    //Xóa sản phẩm
    $scope.delete = function(item) {
        $http.delete('/rest/products/${item.id}', item).then(response => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items.splice(index, 1);
            $scope.reset();
            alert('delete sp success');
        }).catch(error => {
            alert('error delete sp');
            console.log("error", error);
        })
    }

    //Upload hình ảnh
    $scope.imageChanged = function(files) {
        alert("Change ");

        var data = new FormData();
        data.append('file', files[0]);
        $http.post('rest/upload/images', data, {
            transformRequest: angular.identity,
            headers: { 'Content-Type': undefined }
        }).then(response => {
            $scope.form.image = response.data.name;
        }).catch(err => {
            alert('Error uploading');
            console.log("Error", err);
        })

    }

    $scope.pager = {
        page: 0,
        size: 3,
        get items() {
            var start = this.page * this.size;
            return $scope.items.slice(start, start + this.size);
        },
        get count() {
            return Math.ceil(1.0 * $scope.items.length / this.size);
        },
        first() {
            this.page = 0;
        },
        prev() {
            this.page--;
            if (this.page < 0) {
                this.last();
            }
        },
        next() {
            this.page++;
            if (this.page >= this.count) {
                this.first();
            }
        },

        last() {
            this.page = this.count - 1;
        }


    }
});