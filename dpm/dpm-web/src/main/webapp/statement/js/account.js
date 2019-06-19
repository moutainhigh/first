//var ip = 'https://dpm.deppon.com:8881';// 生产
//var ip = 'http://192.168.68.117:8080'; //测试
// var ip = 'http://10.224.195.93:8080'; //李波
// var ip = 'http://10.226.76.172:8080';

//var ADDR = ip + '/dpm/dpm-doc/';
var ADDR ='/dpm/dpm-doc/';
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
    laydate.render({
        elem: '#test13'
        , format: 'yyyyMM'
        , type: 'month'
        , value: new Date(),
    });
    laydate.render({
        elem: '#test14'
        , format: 'yyyyMM'
        , value: new Date()
        , type: 'month'
    });
    //上传文件  开始导入
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
                if (data.msg !== "success"){
                    if(data.msg == "请上传正确的文件"){
                        layer.msg('请上传正确的文件');
                    }else{
                        layer.msg('上传失败');
                    }
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
    form.on('submit(demo2)', function (data) {
        var formData = new FormData();
        if (!$("#files")[0].files[0]) {
            layer.msg('请选择要上传的文件');
            return false;
        }
        formData.append("financialFile", $("#files")[0].files[0]);
        formData.append("getDate", data.field.date);
        formData.append("sessionId", sessionId);
        formData.append("casCookie", casCookie);
        // for (var key of formData.keys()) {
        //     console.log(key + ":" + formData.getAll(key));
        // }
        $.ajax({
            url: ADDR + '/file_uploadFinancialFile.action',
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
                if (data.msg != 'success') {
                    layer.msg('上传失败');
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
        console.log('obj :', obj.tr); //obj.trigger
        console.log('obj-- tr :', obj.tr[0].children[3].childNodes[0].childNodes[3]); //obj.trigger
        console.log('this :', this);
        var self = this;
        var data = obj.data //获得当前行数据
        , layEvent = obj.event; //获得 lay-event 对应的值
        
        console.log(layEvent);

        if (layEvent === 'detail') {
            console.log('对应财务子公司的对账单明细:',data);
            var company = document.getElementsByClassName('company')[0].innerText = '财务子公司：' + (data.company);
            var money = document.getElementsByClassName('money')[0].innerText = '金额：' + (data.money);
            var workflow_status = document.getElementsByClassName('workflow_status')[0].innerText = '状态：' + (data.workFlowStatus);
            $.ajax({
                url: ADDR + 'file_queryStatementByCompany.action?pageNum=1&limit=10&company=' + data.company+'&offTime=' + data.offTime,
                type: 'POST', //GET
                async: true,    //或false,是否异步
                timeout: 60000,       //超时时间
                dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
                success: function (data, textStatus, jqXHR) {
                    console.log('data.List',data.List);
                    layer.open({
                        type: 1,
                        title: ['子对账单'],
                        skin: 'recordDataOperationLayer', //加上边框
                        area: ['840px', '600px'], //宽高
                        content: $('.viewDetails')
                    });
                    // var loadLayer = layer.load();
                    $('.queryResultBox6').show();
                    table.render({
                        elem: '#demo5'
                        // , url: ADDR + 'file_queryStatementByCompany.action?company=' + data.company//数据接口
                        , where: {
                            // getDate: data.field.date1,    // 查询的日期
                            // ,pageNum:1
                            sessionId: sessionId,
                            casCookie: casCookie,
                        },
                        data:data.List
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
                        , limits: [10]
                        , page: true //开启分页
                        , cols: [[ //表头
                            { field: 'id', title: '对账单号', sort: true, width: '150' }
                            , { field: 'sameOrDifference', title: '异同订单', sort: true, width: '100' }
                            , { field: 'bizOccurDate', title: '业务时间', sort: true, width: '180', align: 'center' }
                            , { field: 'billno', title: '订单号', sort: true, width: '160' }
                            , { field: 'fromName', title: '起始地', sort: true, width: '120' }
                            , { field: 'toName', title: '目的地', sort: true, width: '120' }
                            , { field: 'depponPrice', title: '德邦金额', sort: true, width: '100' }
                            , { field: 'didiPrice', title: '滴滴金额', sort: true, width: '100' }
                            , { field: 'difference', title: '差值(德邦金额-滴滴金额)', sort: true, width: '100' }
                            , { field: 'lowerPrice', title: '两者取小', sort: true, width: '100' }
                            , { field: 'costCenterName', title: '成本中心(费用承担部门) ', sort: true, width: '200' }
                            , { field: 'company', title: '财务所属子公司 ', sort: true, width: '160' }
                        ]]
                        , text: {
                            none: '未查询到相关数据'
                        }
                        , done: function (res) {                            
                            res = [];
                        }
                    });
                    return false;
                },
                error: function (data, xhr, textStatus) {
                    layer.msg('查看详情失败');
                }
            });
        }
        else if (layEvent === 'yes') {
        	console.log('生成工作流:', data.company + "=" + data.offTime);
        	$.ajax({
                url: ADDR + '/file_sendStatement.action?company=' + data.company+'&offTime=' + data.offTime, 
                async: true,
                type: 'POST',
                timeout: 200000,       //超时时间
                success: function (data) {
                    objs = JSON.parse(data);
                    if (objs.msg === "success") {
                        layer.msg('已生成工作流');
                        var elm = obj.tr[0].children[3].childNodes[0].childNodes[3];
                        elm.classList.add("layui-btn-disabled");
                        elm.removeAttribute('lay-event');
                        // $(".l_work").addClass("layui-btn-disabled");
                    }else{
                        layer.msg('工作流生成失败');
                    }
                },
                error: function (err) {
                    layer.msg('网络异常上传失败,请稍后重试');
                    console.log('上传失败', err);
                }
            });
        }
        else if (layEvent === 'edit') {

            //表单初始赋值
            console.log(data.depponPrice);
            console.log(data.lowerPrice);
            form.val('example', {
                "depponPrice": data.depponPrice,
                "lowerPrice": data.lowerPrice,
                "id": data.id,
                "amount1": '',
                "amount2": '',

            })
            layer.open({
                type: 1,
                title: ['修改金额'],
                skin: 'recordDataOperationLayer', //加上边框
                area: ['840px', '440px'], //宽高
                content: $('.operationLayer')
            });

        } else if (layEvent === 'del') {
            layer.confirm('真的删除行么', function (index) {
                obj.del(); //删除对应行（tr）的DOM结构
                layer.close(index);
                $.ajax({
                    url: ADDR + 'file_updateStatement.action?identifice=1&id=' + data.id + '&sessionId=' + sessionId + '&casCookie=' + casCookie,
                    type: 'POST', //GET
                    async: true,    //或false,是否异步
                    timeout: 60000,       //超时时间
                    dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
                    success: function (data, textStatus, jqXHR) {
                            layer.closeAll();
                            layer.msg('删除成功');
                    },
                    error: function (data, xhr, textStatus) {
                        layer.closeAll();
                        layer.msg('删除失败');

                    }
                });
            });
        }
    });
    //汇总
    form.on('submit(summary)', function (data) {
        var time = data.field.date1;
        $.ajax({
            url: ADDR + 'file_addStatementSummary.action?getDate=' + time,
            type: 'POST',
            async: true,
            timeout: 200000,       //超时时间
            success: function (data) {
                var data = JSON.parse(data);
                if(data.msg == 'success'){
                    layer.msg('汇总成功');   
                }else if (data.msg == '重复') {
                    layer.msg('本月数据已汇总');
                } else if(data.msg =='没有数据请查看是否全部对账完成') {
                    layer.msg('请检查是否已上传本月数据或请查看是否全部对账完成');
                }
            },
            error: function (err) {
                layer.msg('网络异常上传失败,请稍后重试');
                console.log('上传失败', err);
            }
        });
        return false;
    });
    //获取对账汇总后的Excel数据
    form.on('submit(getSummaryExcel)', function (data) {
        var time = data.field.date1;
        window.open(ADDR + 'file_exportStatementSummary.action?offTime=' + time);
        /*$.ajax({
            url: ADDR + 'file_exportStatementSummary.action?offTime=' + time,
            type: 'GET',
            async: true,
            timeout: 200000,       //超时时间
            success: function (data) {
                
            },
            error: function (err) {
                
            }
        });*/
        return false;
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
                sessionId: sessionId,
                casCookie: casCookie,
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
            , limits: [10]
            , page: true //开启分页
            , cols: [[ //表头
                // { field: 'phone', title: '异同类别', sort: true, width: '100' }
                { field: 'id', title: 'ID', sort: true, width: '100' }
                , { field: 'billno', title: '单号', sort: true, width: '160' }
                , { field: 'totalPrice', title: '费用', sort: true, width: '80', align: 'center' }
                , { field: 'name', title: '姓名', sort: true, width: '90' }
                , { field: 'employeeno', title: '工号', sort: true, width: '80' }
                , { field: 'fromName', title: '出发地', sort: true, width: '120' }
                , { field: 'toName', title: '目的地', sort: true, width: '230' }
                , { field: 'taxidate', title: '打车日期', sort: true, width: '180' }
                , { field: 'boardingtime', title: '上车时间', sort: true, width: '180' }
                , { field: 'offtime', title: '下车时间', sort: true, width: '180' }
                , {
                    field: 'orderstatus', title: '单号状态', sort: true, width: '120',
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
                , { field: 'normalDistance', title: '打车总里程', sort: true, width: '80' }
                , { field: 'dept', title: '部门', sort: true, width: '120' }
                , { field: 'financedept', title: '所属财务部', sort: true, width: '120' }
                , { field: 'estimateprice', title: '预估价', sort: true, width: '120' }
                // , { field: 'newmeetingstart', title: '开始时间', sort: true, width: '120' }
                // , { field: 'newmeetingend', title: '结束时间', sort: true, width: '120' }
                // , { fixed: 'right', title: '操作', width: 140, align: 'center', toolbar: '#barDemo' }
            ]]
            , text: {
                none: '未查询到相关数据'
            }
            , done: function (res) {
                console.log('第一次查询', res);
                layer.close(loadLayer);
                
                res = [];
            }
        });
        return false;
    });
    //生成对账单
    form.on('submit(account_Statement)', function (data) {
        console.log('查询', data);
        var loadLayer = layer.load();
        $.ajax({
            url: ADDR + 'file_statementByTime.action?offTime=' + data.field.date,
            type: 'POST',
            async: true,
            timeout: 200000,       //超时时间
            success: function (data) {
            	layer.close(loadLayer);
                var data = JSON.parse(data);
                if(data.msg == 'success'){
                    layer.msg('对账成功');   
                }else{
                    layer.msg('对账失败');
                }
            },
            error: function (err) {
            	layer.close(loadLayer);
                layer.msg('网络异常上传失败,请稍后重试');
                console.log('上传失败', err);
            }
        }); 
        return false;
    });
    //查询对账单
    form.on('submit(search_Statement)', function (data) {
        console.log('查询', data);
        var loadLayer = layer.load();
        $('.queryResultBox1').show();
        table.render({
            elem: '#demo3'
            , url: ADDR + 'file_queryStatement.action?getDate=' + data.field.date //数据接口
            , where: {
                getDate: data.field.date1,    // 查询的日期
                // ,pageNum:1
                sessionId: sessionId,
                casCookie: casCookie,
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
            , limits: [10]
            , page: true //开启分页
            , cols: [[ //表头
                { field: 'id', title: '对账单号', sort: true, width: '100' }
                , { field: 'sameOrDifference', title: '异同订单', sort: true, width: '100' }
                , { field: 'bizOccurDate', title: '业务时间', sort: true, width: '180', align: 'center' }
                , { field: 'billno', title: '订单号', sort: true, width: '160' }
                , { field: 'fromName', title: '起始地', sort: true, width: '120' }
                , { field: 'toName', title: '目的地', sort: true, width: '230' }
                , { field: 'depponPrice', title: '德邦金额', sort: true, width: '100' }
                , { field: 'didiPrice', title: '滴滴金额', sort: true, width: '100' }
                , { field: 'difference', title: '差值(德邦金额-滴滴金额)', sort: true, width: '200' }
                , { field: 'lowerPrice', title: '两者取小', sort: true, width: '100' }
                , { field: 'costCenterName', title: '成本中心(费用承担部门) ', sort: true, width: '200' }
                , { field: 'company', title: '财务所属子公司 ', sort: true, width: '160' }
                , { fixed: 'right', title: '操作', width: 200, align: 'center', toolbar: '#barDemo' }
            ]]
            , text: {
                none: '未查询到相关数据'
            }
            , done: function (res) {
                console.log('第一次查询', res);
                layer.close(loadLayer);
                
                res = [];
            }
        });
        return false;
    });
    // 表单编辑
    form.on('submit(editDate)', function (data) {
        var subDate = data.field;
        console.log('修改的数据:', data);
        $.ajax({
            url: ADDR + 'file_updateStatement.action?identifice=0&id=' + subDate.id + '&depponPrice=' + subDate.amount1 + '&lowerPrice=' + subDate.amount2 + '&sessionId=' + sessionId + '&casCookie=' + casCookie,
            type: 'POST', //GET
            async: true,    //或false,是否异步
            timeout: 60000,       //超时时间
            dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
            success: function (data, textStatus, jqXHR) {
            	$(".layui-laypage-btn").click();//刷新父页面数据
                layer.closeAll();
            },
            error: function (data, xhr, textStatus) {
                layer.closeAll();
                layer.msg('修改失败');
            }
        });
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });
    //模糊查询
    form.on('submit(fuzzyQuery)', function (data) {
        console.log('查询', data);
        var val = data.field.fuzzy;
        var state = data.field.state;
        var time = data.field.time;
        var loadLayer = layer.load();

        $('.queryResultBox4').show();
        // return false;
        table.render({
            elem: '#demo4'
            , url: ADDR + 'file_fuzzySearchStatement.action?company=' + val + '&workFlowStatus=' + state + '&offTime=' + time//数据接口
            , where: {
                getDate: data.field.date1,    // 查询的日期
                // ,pageNum:1
                sessionId: sessionId,
                casCookie: casCookie,
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
            , limits: [10]
            , page: true //开启分页
            , cols: [[ //表头
                { field: 'company', title: '财务子公司', sort: true, width: '30%', align: 'center' }
                , { field: 'money', title: '金额', sort: true, width: '30%', align: 'center' }
                , { field: 'workFlowStatus', title: '状态', sort: true, width: '20%', align: 'center' }
                , { fixed: 'right', title: '是否生成工作流', width: '20%', align: 'center', toolbar: '#barDemo1' }
            ]]
            , text: {
                none: '未查询到相关数据'
            }
            , done: function (res) {
                console.log('第一次查询', res);
                layer.close(loadLayer);
                
                res = [];
            }
        });
        return false;
    });
    //一键批量生成工作流
    form.on('submit(batchGenerateWorkFlow)', function (data) {
    	var val = data.field.fuzzy;
        var state = data.field.state;
        var time = data.field.time;
        $.ajax({
            url: ADDR + 'file_batchSendStatementSummary.action?company=' + val + '&workFlowStatus=' + state + '&offTime=' + time,//数据接口
            type: 'POST',
            async: true,
            timeout: 200000,       //超时时间
            success: function (data) {
            	objs = JSON.parse(data);
                if (objs.code === "200") {
                    layer.msg(objs.msg);
                }else{
                    layer.msg(objs.msg);
                }
            },
            error: function (err) {
                layer.msg('一键批量生成工作流失败:网络异常,请稍后重试');
                console.log('一键批量生成工作流失败', err);
            }
        });
        return false;
    });
});