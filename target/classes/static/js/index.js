var totalpage=null
function timestampToTime (dateTime) {
    if (dateTime == null) {
        return "";
    }
    var date = new Date(dateTime);
    Y = date.getFullYear();
    M = (date.getMonth() + 1) < 10 ? ("0" + (date.getMonth() + 1)) : (date.getMonth() + 1);
    D = date.getDate() < 10 ? ("0" + date.getDate()) : date.getDate();
    var hh = date.getHours() < 10 ? ("0" + date.getHours()) : date.getHours();
    var mm = date.getMinutes() < 10 ? ("0" + date.getMinutes()) : date.getMinutes();
    var ss = date.getSeconds() < 10 ? ("0" + date.getSeconds()) : date.getSeconds();
    return Y + '-' + M + '-' + D + ' ' + hh + ':' + mm + ':' + ss;
}

function queryMockByUrl(page) {
    var url = $("#urlStr").val();
    $.ajax({
        url: "/api/mock/queryMockByDto",
        type: "POST",
        dataType: "JSON",
        contentType: "application/json;charset=UTF-8",
        async: false,
        data: JSON.stringify({
            "url": url,
            "page": page,
            "size": 10
        }),
        success: function (res) {
            if (res.success) {
                showDataAndPageTable1(res.data);
            } else {
                alert(res.msg);
            }
        }
    })
}

function search(page) {
    $.ajax({
        url: "/api/mock/queryMockByDto",
        type: "POST",
        dataType: "JSON",
        contentType: "application/json;charset=UTF-8",
        async: false,
        data: JSON.stringify({
            "url":$.trim($("#urlStr").val()),
            "page": page,
            "size": 10
        }),
        success: function (res) {
            if (res.success) {
                totalpage=res.data.totalRecord;
                showDataAndPageTable1(res.data);
            } else {
                alert(res.msg);
            }
        }
    })
}

function showDataAndPageTable1(data) {
    var dataList = data.dataList;
    var dataTable = "";
    if (dataList.length > 0) {
        dataList.forEach(function (v,i) {
            dataTable += '\
                <tr>\
                <td>' + dataList[i].id +'</td>\
                <td>' + dataList[i].url +'</td>\
                <td>' + dataList[i].data +'</td>\
                <td>' + timestampToTime(dataList[i].createdAt) +'</td>\
                <td>\
                <button class="layui-btn" onclick="updateMock(' + dataList[i].id +')" lay-filter="formDemo">修改</button>\
                <button class="layui-btn" onclick="deleteMock(' + dataList[i].id +')" lay-filter="formDemo">删除</button>\
                </td>\
                </tr>\
				';
        })
    }
    $("#dataTable").empty().html(dataTable);
}

function insertMock() {
    $("#url").val("");
    $("#data").val("");
    layer.open({
        type: 1,
        content: $('#window-div') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
        ,area: ['570px', '250px']
        ,btn: ['yes', 'no']
        ,yes: function(index, layero){
            insertMockData();
        }
        ,btn2: function(index, layero){
            closeWindow();
        }
        ,cancel : function(){
            closeWindow();
        }
    });
}

function updateMock(id) {
    $.ajax({
        url: "/api/mock/queryMockByDto",
        type: "POST",
        dataType: "JSON",
        contentType: "application/json;charset=UTF-8",
        async: false,
        data: JSON.stringify({
            "url": $("#url").val(),
            "id" : id,
            "page": 1,
            "size": 10
        }),
        success: function (res) {
            if (res.success) {
                updateData(res.data.dataList);
            } else {
                alert(res.msg);
            }
        }
    })
}

function deleteMock(id) {
    $.ajax({
        url: "/api/mock/deleteMockByDto",
        type: "POST",
        dataType: "JSON",
        contentType: "application/json;charset=UTF-8",
        async: false,
        data: JSON.stringify({
            "id" : id
        }),
        success: function (res) {
            if (res.success) {
                layer.alert(res.msg, {
                    icon: 1,
                    title: "提示"
                });
                search(1);
                page();
            } else {
                layer.alert(res.msg, {
                    icon: 2,
                    title: "提示"
                });
            }
        }
    })
}

function updateData(data) {
    $("#url").val(data[0].url);
    $("#data").val(data[0].data);
    $('#url').attr("disabled",true);
    layer.open({
        type: 1,
        content: $('#window-div') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
        ,area: ['570px', '250px']
        ,btn: ['yes', 'no']
        ,yes: function(index, layero){
            updateMockData(data[0].id)
            $('#url').attr("disabled",false);
        }
        ,btn2: function(index, layero){
            closeWindow();
            $('#url').attr("disabled",false);
        }
        ,cancel : function(){
            closeWindow();
            $('#url').attr("disabled",false);
        }
    });
}

function updateMockData(id) {
    $.ajax({
        url: "/api/mock/updateMockByDto",
        type: "POST",
        dataType: "JSON",
        contentType: "application/json;charset=UTF-8",
        async: false,
        data: JSON.stringify({
            "id": id,
            "data": $("#data").val(),
        }),
        success: function (res) {
            if (res.success) {
                layer.closeAll();//关闭信息框
                layer.alert(res.msg, {
                    icon: 1,
                    title: "提示"
                });
                closeWindow();
                search(1);
                page();
            } else {
                layer.alert(res.msg, {
                    icon: 2,
                    title: "提示"
                });
            }
        }
    })
}

function closeWindow() {
    $("#window-div").hide();
    $("#url").val("");
    $("#data").val("");
}

function insertMockData() {
    $.ajax({
        url: "/api/mock/queryMockByDto",
        type: "POST",
        dataType: "JSON",
        contentType: "application/json;charset=UTF-8",
        async: false,
        data: JSON.stringify({
            "url": $("#url").val(),
            "page": 1,
            "size": 10
        }),
        success: function (res) {
            if (res.success) {
                if (res.data.dataList.length > 0) {
                    layer.alert("url唯一！", {
                        icon: 2,
                        title: "提示"
                    });
                } else {
                    $.ajax({
                        url: "/api/mock/insertMockByDto",
                        type: "POST",
                        dataType: "JSON",
                        contentType: "application/json;charset=UTF-8",
                        async: false,
                        data: JSON.stringify({
                            "url": $("#url").val(),
                            "data": $("#data").val(),
                        }),
                        success: function (res) {
                            if (res.success) {
                                layer.closeAll();//关闭信息框
                                layer.alert(res.msg, {
                                    icon: 1,
                                    title: "提示"
                                });
                                closeWindow();
                                search(1);
                                page();
                            } else {
                                layer.alert(res.msg, {
                                    icon: 2,
                                    title: "提示"
                                });
                            }
                        }
                    })
                }
            }
        }
    })
}

$(function () {
    $("#window-div").hide();
    search(1);
    page();
});

function page() {
    layui.use(['laypage', 'layer'], function() {
        var laypage = layui.laypage
        laypage.render({
            elem: 'bootpag'
            , count: totalpage
            , layout: ['prev','page', 'count', 'next',]
            ,jump: function(obj){
                search(obj.curr);
            }
        });
    })
}


