$(function()
	{
	
	var delId='';
	    //分页
		$("#page").paging({
			pageNo:5,
			totalPage: 9,
			totalSize: 300,
			callback: function(num) {
			}
		});	
		//查询
		$("#btn-search").click(function(){  
			alert("333");
			$("#queryForm").submit();
				});
		//弹出新增框
		$("#btn_insert").click(function()
				
		{
			
			$("#tkTitle").html("添加模块");
			showMask();
			$("#btn_save").show();
			$("#insertForm").attr("action","/res3");
			$("#insertForm").css("display","block");
			
		});
		
		//弹出编辑框
		$("#btn_update").click(function()
		{
			//校验是否只选择了一条
			if(isSelected()){
				$("#tkTitle").html("编辑模块");
				//初始化编辑弹框
				initMask();
				showMask();
				$("#btn_save").show();
				$("#insertForm").attr("action","/mkgl/update");
				$("#insertForm").css("display","block");
			}
		});
		
		//弹出删除框
		$("#btn_delete").click(function()
		{
			if(isSelected()){
				//初始化删除数据
				initDelData();
				showMask_del();
			}
		});
		//弹出添加功能
		$("#btn_insert_gn").click(function()				
		{
		
			$("#tkTitle").html("添加模块功能");		
			showMask_gn();	
			initgn();
			$("#btn_gnsave").show();
			$("#insertgnForm").attr("action","/mkgl/savegn");
			$("#insertgnForm").css("display","block");
		});
		//弹出框保存
		$("#btn_gnsave").click(function()
		{  
			if(window.confirm('是否确定删除原有模块功能后再添加新功能？')){
			initgnMask();
			$("#insertgnForm").submit();
			}
		});
		//弹出框保存
		$("#btn_save2").click(function()
		{
			
			$("#insertForm2").submit();
		});
		//弹出框保存
		$("#btn_save").click(function()
		{
			
			$("#insertForm").submit();
		});
		
		//删除框保存
		$("#btn_del_ok").click(function()
		{
			$("#deleteForm").submit();
		});
		
		$("#btn_cancel").click(function()
				{
					closeMask();
				});
		//关闭删除框
		$("#btn_cancel2").click(function()
				{
			closeMask_gn();
				});
		$("#btn_cancel_del").click(function()
		{
			closeMask_del();
			
		});
		
		$("#btn_gncancel").click(function()
				{
					closeMask_gn();
					
				});
		//界面关闭
		$("#close_mask_insertgn").click(function()
				{
					closeMask_gn();
					
				});
		
		$("#close_mask_insert").click(function()
				{
			closeMask();
					
				});
		$("#close_mask_delete").click(function()
				{
			closeMask_del();
					
				});

	});

//展示弹出框
function showMask()
{
	$("#mask").show();
	$("body").css("overflowY","hidden");
	$("#insertForm").css("display","block");
	
}
function FormatDate (strTime) {
    var date = new Date(strTime);
     var formatedMonth = ("0" + (date.getMonth() + 1)).slice(-2);
     var formatedDate = ("0" + (date.getDate())).slice(-2);
    return date.getFullYear()+"-"+formatedMonth+"-"+formatedDate;
}

function exp()
{  //href
	document.getElementById("expExcel").href="/hello1/expExcel";
	//window.location.reload();
	//window.location.href="/gngl/expExcel/";
	//document.getElementById("myIframe").src="sdsdb/showTable/" +a+"-"+T_DATE1 ;
	//window.location.href

	
		}


function showMaskb(val,val2,val3,val4,val5)
{
	
	//var dodate = val4;
	//dodate=dodate.replace(/-/g,"/");
	//var now = new Date(dodate); 
	//格式化日
	//var day = ("0" + now.getDate()).slice(-2);
	//var month = ("0" + (now.getMonth() + 1)).slice(-2);
	//var today = now.getFullYear()+"-"+(month)+"-"+(day) ;
	//拼装日期格式  
	
	
	var psel = document.getElementById("shiyou1");
	var psel2 = document.getElementById("jine1");  
	var psel3 = document.getElementById("yanshou1");  
	var psel4 = document.getElementById("shijian1");
	var psel5 = document.getElementById("id1");  
	$("#mask_gn").show();
	$("body").css("overflowY","hidden");
	$("#insertForm2").css("display","block");

	psel.value=val;
	psel2.value=val2;
	psel3.value=val3;
	psel4.value=val4;
	psel5.value=val5;
	
	
}
//关闭弹出框
function closeMask()
{
	$("#mask").hide();
	$("body").css("overflowY","auto");
}
var delId='';
//展示弹出框--删除
function showMask_del(val)
{  
	
	$("#mask_del").show();
	$("#deleteForm").css("display","block");
	$("body").css("overflowY","hidden");
	$("#deleteNodeId").val(val);

}
//确定删除
function delOk()
{
	document.getElementById("btn_ok").href="/delete/"+delId;
}

//关闭弹出框--删除
function closeMask_del()
{
	$("#mask_del").hide();
	$("#deleteForm").css("display","none");
	$("body").css("overflowY","auto");
	
}
function showMask_gn()
{
	
	$("#mask_gn").show();
	$("body").css("overflowY","hidden");
}

function closeMask_gn()
{
	$("#mask_gn").hide();
	$("body").css("overflowY","auto");
}

//初始化编辑弹框
function initMask(){
	var nodeId=$("#nodeId").val();
	$.ajax({
		url:'/mkgl/selectOne/',
		type:"post",
		async: false ,
		dataType:"text",
		data: {				
			nodeId : nodeId
		},
		success:function(data){ 
		
			var mkOne = JSON.parse(data);
			$("#mName").val(mkOne["mkOnePage"].MODULE_NAME);
			$("#mLink").val(mkOne["mkOnePage"].MODULE_LINK);
			$("#mDec").val(mkOne["mkOnePage"].MODULE_DESC);
			$("#mOrder").val(mkOne["mkOnePage"].MODULE_ORDER);
			
		},  
        error: function (err) { //如果执行不成功，那么执行此方法  
             alert("err:" + err);  
        }  
	 });
}

	
//初始化删除数据
function initDelData(){
	//将删除数据置空
	
	$("#deleteNodeId").val("");
	var nodeId=$("#nodeId").val();
	$("#deleteNodeId").val(nodeId);
	
}
//校验是否选择的了数据
function isSelected(){
	
	var nodeId=$("#nodeId").val();
	if(nodeId==""){
		alert("只能选择一条数据，请重新进行选择。");
		return false;
	}
	return true;
}//保存数据
function initgnMask(){
	$("#functionId").val("");
	$("#functionName").val("");
	var ids = "";
	var names = "";	
	var nodeId=$("#nodeId").val();
	$("#functionNodeId").val(nodeId);

	$.each($("#tableTbody2 tr "), function(i, o) {
	
		
		var h0 = $(o).find("td:eq(0) input[type='checkbox']");
		var h3 = $(o).find("td:eq(3) input[type='checkbox']");
		var h6 = $(o).find("td:eq(6) input[type='checkbox']");
		var h9 = $(o).find("td:eq(9) input[type='checkbox']");

		if($(h0).prop("checked")){
			names += $(o).find("td:eq(1)").html() + ",";
			ids += $(o).find("td:eq(2)").html() + ",";
			$("#functionId").val(ids);
			$("#functionName").val(names);

		}
		if($(h3).prop("checked")){
			names += $(o).find("td:eq(4)").html() + ",";
			ids += $(o).find("td:eq(5)").html() + ",";
			$("#functionId").val(ids);
			$("#functionName").val(names);

		}
		if($(h6).prop("checked")){
			names += $(o).find("td:eq(7)").html() + ",";
			ids += $(o).find("td:eq(8)").html() + ",";
			$("#functionId").val(ids);
			$("#functionName").val(names);

		}
		if($(h9).prop("checked")){
			names += $(o).find("td:eq(10)").html() + ",";
			ids += $(o).find("td:eq(11)").html() + ",";
			$("#functionId").val(ids);
			$("#functionName").val(names);

		
		}
	});
}

//重新刷新页面
function reLoadPage(){
	var nodeId=$("#nodeId").val();
	window.location.href="/mkgl/?nodeId="+nodeId;
}
function reads(obj) {
    var file = obj.files[0];
    var reader = new  FileReader();
    reader.readAsDataURL(file);
    reader.onload = function (ev) {
        $("#backimg").attr("src", ev.target.result);
     
    }


 }
function initgn(){
	var nodeId=$("#nodeId").val();
	$.ajax({
		url:'/mkgl/selectmkgn/',
		type:"post",
		async: false ,
		dataType:"text",
		data: {				
			nodeId : nodeId
		},
		success:function(data){ 
		
			var mkgn = JSON.parse(data);
			var mkgnArr;
			for(var i=0;i<mkgn["mkgnList"].length;i++){
			 mkgnArr= mkgn["mkgnList"][i].FUNCTION_ID;
			  document.getElementById(mkgnArr).checked=true;	
			}				
		},  
        error: function (err) { //如果执行不成功，那么执行此方法  
             alert("err:" + err);  
        }  
	 });
	
}
	