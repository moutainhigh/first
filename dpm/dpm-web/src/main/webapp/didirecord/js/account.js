var ip = 'https://dpm.deppon.com:8881';
//     var ip = 'http://192.168.68.117:8080';
    var ADDR = ip + '/dpm/dpm-doc/';
    var sessionId = sessionStorage.getItem('sessionId');
    var casCookie = sessionStorage.getItem('casCookie');
    layui.use(['form', 'layedit', 'laydate', 'upload', 'table'], function () {
        var form = layui.form
            , layer = layui.layer
            , $ = layui.jquery
            , layedit = layui.layedit
            , upload = layui.upload
            , table = layui.table
            , laydate = layui.laydate;

        $(".btn-upload").on("change", "input[type='file']", function () {
            var filePath = $(this).val();
            if (filePath.indexOf("xlsx") != -1) {
                // $(".fileerrorTip").html("").hide();
                var arr = filePath.split('\\');
                var fileName = arr[arr.length - 1];
                $(".showFileName").html(fileName);
            } else {
                $(".showFileName").html("");
                // $(".fileerrorTip").html("您未上传文件，或者您上传文件类型有误！").show();
                layer.msg('您未上传文件，或者您上传文件类型有误！');
                return false
            }
        })
        //日期
        laydate.render({
            elem: '#date',
            type: 'month',
            format: 'yyyy-MM',
            value: new Date(),
            btns: ['confirm'],
            done: function (value, date, endDate) {
                console.log(value); //得到日期生成的值，如：2017-08-18
                dataMonth = value;
            }
        });
        //日期
        laydate.render({
            elem: '#date1',
            type: 'month',
            format: 'yyyy-MM',
            value: new Date(),
            btns: ['confirm'],
            done: function (value, date, endDate) {
                console.log(value); //得到日期生成的值，如：2017-08-18
                dataMonth = value;
            }
        });


        //上传文件
        form.on('submit(demo1)', function (data) {
            var formData = new FormData();
            if (!$("#files")[0].files[0]) {
                layer.msg('请选择要上传的文件');
                return false;
            }
            formData.append("file", $("#files")[0].files[0]);
            formData.append("getDate", data.field.date);
            formData.append("sessionId", sessionId);
            formData.append("casCookie", casCookie);
            // for (var key of formData.keys()) {
            //     console.log(key + ":" + formData.getAll(key));
            // }
            $.ajax({
                url: ADDR + '/file_uploadFile.action',
                type: 'POST',
                data: formData,
                async: false,
                cache: false,
                timeout: 200000,       //超时时间
                contentType: false,
                processData: false,
                success: function (data) {
                    var data = JSON.parse(data);
                    console.log('上传成功', data);
                    if (data.errorCode != 0) {
                        alert('上传失败');
//                        window.location.href = 'login.html'
                    } else {
                        if (data.msg === "success") {
                            $(".showFileName").html("");
                            $('#files').val('');
                            layer.msg('上传成功');
                        }
                    }
                },
                error: function (err) {
                    layer.msg('网络异常上传失败,请稍后重试');
                    console.log('上传失败', err);
                }
            });
            return false;
        });
        table.on('tool(tableTool)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                , layEvent = obj.event; //获得 lay-event 对应的值
                console.log(data);
                console.log(layEvent);
                
            if (layEvent === 'detail') {
                layer.msg('查看操作');
            } else if (layEvent === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    obj.del(); //删除对应行（tr）的DOM结构
                    layer.close(index);
                    $.ajax({
                        url: ADDR + 'file_delChgMethord.action?identifice=1&id=' + data.id + '&sessionId=' + sessionId + '&casCookie=' + casCookie,
                        type: 'POST', //GET
                        async: true,    //或false,是否异步
                        timeout: 60000,       //超时时间
                        dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
                        success: function (data, textStatus, jqXHR) {
//                            if (data.errorCode != 0) {
//                                alert('删除失败');
////                                window.location.href = 'login.html'
//                            } else {
                            layer.closeAll();
                            layer.msg('删除成功');
//                            }
                        },
                        error: function (data, xhr, textStatus) {
                            layer.closeAll();
                            layer.msg('删除失败');

                        }
                    });
                });
            } else if (layEvent === 'edit') {
                //表单初始赋值
                form.val('example', {
                    "totalPrice": data.totalPrice,
                    "id": data.id, 
                    "amount": '' ,
                })
                layer.open({
                    type: 1,
                    title: ['修改金额'],
                    skin: 'recordDataOperationLayer', //加上边框
                    area: ['840px', '250px'], //宽高
                    content: $('.operationLayer')
                });
            }
        });
        // 进行查询
        form.on('submit(query)', function (data) {
            console.log('查询', data);
            var loadLayer = layer.load();
            $('.queryResultBox').show();
            table.render({
                elem: '#demo'
                , url: ADDR + 'file_queryFileMsg.action' //数据接口
                , where: {
                    getDate: data.field.date1,    // 查询的日期
                    // ,pageNum:1
                    sessionId : sessionId,
                    casCookie : casCookie,
                }
                , request: {
                    pageName: 'pageNum' //页码的参数名称，默认：page
                    // ,limitName: 'limit' //每页数据量的参数名，默认：limit
                }
                , response: {
                    statusCode: 200 //成功的状态码，默认：0
                    , countName: 'totalnum' //数据总数的字段名称，默认：count
                    , dataName: 'List' //数据列表的字段名称，默认：data
                }
                , limit: 10
                , limits: [10, 15, 20]
                , page: true //开启分页
                , cols: [[ //表头
                    { field: 'phone', title: '异同类别', sort: true, width: '100' }
                    , { field: 'id', title: 'ID', sort: true, width: '80' }
                    , { field: 'billno', title: '单号', sort: true, width: '160' }
                    , { field: 'totalPrice', title: '费用', sort: true, width: '80',align: 'center' }
                    , { field: 'name', title: '姓名', sort: true, width: '90' }
                    , { field: 'employeeno', title: '工号', sort: true, width: '80' }
                    , { field: 'fromName', title: '出发地', sort: true, width: '120' }
                    , { field: 'toName', title: '目的地', sort: true, width: '120' }
                    , { field: 'taxidate', title: '打车日期', sort: true, width: '120' }
                    , { field: 'boardingtime', title: '上车时间', sort: true, width: '120' }
                    , { field: 'offtime', title: '下车时间', sort: true, width: '120' }
                    , { field: 'orderstatus', title: '单号状态', sort: true, width: '120',
                            templet: function (i) {
                                var orderstatus = i.orderstatus;
                                var statustext;
                                switch (orderstatus) {
                                    case 300:
                                        statustext = '等待应答';
                                        break;
                                    case 311:
                                        statustext = '订单超时';
                                        break;
                                    case 400:
                                        statustext = '等待接驾';
                                        break;
                                    case 410:
                                        statustext = '司机已到达';
                                        break;
                                    case 500:
                                        statustext = '行程中';
                                        break;
                                    case 600:
                                        statustext = '行程结束';
                                        break;
                                    case 610:
                                        statustext = '行程异常结束';
                                        break;
                                    case 700:
                                        statustext = '已支付';
                                        break;
                                    default:
                                        statustext = ''
                                        break;
                                }
                                return statustext
                            } 
                      }
                    , { field: 'normalDistance', title: '打车总里程', sort: true, width: '120' }
                    , { field: 'dept', title: '部门', sort: true, width: '120' }
                    , { field: 'financedept', title: '所属财务部', sort: true, width: '120' }
                    , { field: 'estimateprice', title: '预估价', sort: true, width: '120' }
                    , { field: 'newmeetingstart', title: '开始时间', sort: true, width: '120' }
                    , { field: 'newmeetingend', title: '结束时间', sort: true, width: '120' }
                    , { fixed: 'right', title: '操作', width: 140, align: 'center', toolbar: '#barDemo' }
                ]]
                , text: {
                    none: '未查询到相关数据'
                }
                , done: function (res) {
                    console.log('第一次查询', res);
                    layer.close(loadLayer);
                    if (res.errorCode != 0) {
//                        alert('请重新登录');
//                        window.location.href = 'login.html'
                    }
                    res = [];
                }
            });
            return false;
        });
        // 表单编辑
        form.on('submit(editDate)', function (data) {
           var subDate = data.field;
           
            $.ajax({
                url: ADDR + 'file_delChgMethord.action?identifice=0&id='+ subDate.id +'&amount=' + subDate.amount + '&sessionId=' + sessionId + '&casCookie=' + casCookie,
                type: 'POST', //GET
                async: true,    //或false,是否异步
                timeout: 60000,       //超时时间
                dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
                success: function (data, textStatus, jqXHR) {
//                    if (data.errorCode != 0) {
//                        alert('修改失败');
////                        window.location.href = 'login.html'
//                    } else {
                    layer.closeAll();
                    layer.msg('修改成功');
                    table.reload('demo')
//                    }
                },
                error: function (data, xhr, textStatus) {
                    layer.closeAll();
                    layer.msg('修改失败');

                }
            });
            return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
        });

    });