<%@ page isELIgnored="false" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="/css/gdgl/mygd_jedate.css">
<link href="/js/select2/css/select2.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="../js/zTreev3.5.15/css/zTreeStyle/zTreeStyle.css" />
<link rel="stylesheet" type="text/css"
	href="../js/zTreev3.5.15/css/demo.css" />
<link rel="stylesheet" type="text/css"
	href="../css/sys/user/user_index.css" />
<link rel="stylesheet" type="text/css" href="/css/mkgl/mkgl.css" />
<script type="text/javascript" src="/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/js/jquery.jedate.js"></script>
<script type="text/javascript" src="/js/paging.js"></script>
<script type="text/javascript" src="/js/mkgl/mkgl.js"></script>
<script type="text/javascript" src="/js/select2/js/select2.full.js"></script>
<script type="text/javascript" src="/js/select2/js/i18n/zh-CN.js"></script>
<script type="text/javascript"
	src="../js/zTreev3.5.15/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="../js/tree/common_tree.js"></script>
<!-- <script type="text/javascript">
	$(function() {
		initCompanyTree("treeDemo", "moduleTree", [ 2, 0, 0, 0 ], 9, "",
				"", "nodeId");//模块树
	});
</script> -->
</head>
<style type="text/css">
.input2 {
    background-position: right 5px center;
    background-repeat: no-repeat;
    border: 1px solid #dddddd;
    height: 22px;
    text-indent: 3px;
    line-height: 34px;
}
.divcss5{text-align:center} 
</style>
<body>
<!--content-->
	<div class="content">
		<!--position-->
		<div class="position clearfix">
			<div class="fl sub-tit">报账笺</div>
			<div class="fr menu-src">
				当前位置：<span> 华之杰报账笺</span>
			</div>
		</div>
		<div class="clearfix cont-box">
			<div class="fl tree">
				<div class="tree-cont"  id="moduleTree"></div>
			</div>
			<div class="fr mk-tree">
				<div class="table-top clearfix">
					<div class="fl btn clearfix">
					   <!--  <span id="btn-search" class="btn-search">查询</span>	
						<span id="btn_insert" class="btn-insert">新增</span> 
						<span id="btn_update" class="btn-insert">编辑</span>  -->
						<!-- <a href="findRes">新增</a> -->
					
						<!-- <span id="btn_delete" class="btn-delete">删除</span>	
						<span id="btn_insert_gn" class="btn-insert">添加功能</span>  -->
						
						
					</div>
				</div>
				<!--search-->
		<div class="table-top clearfix">
		   	<div class="fl btn clearfix">
				        <span id="btn_insert" class="btn-insert">新增</span>
				 
			            </div>	
			<form action="/search" method="post" id="queryForm">
				<div class="fr search clearfix">
				    <div class="fl search-item clearfix">
						<label class="label">时间：</label>
				        <div class="inpbox">
				               <input class="input2" padding="0" id="FUNCTIONNAME" type="text" name="FUNCTIONNAME" value="" height="30px" >
				        </div>
					</div>
					<span class="btn-search" id="btn-search">查询</span>
					  <!-- <input type="submit" value="查找" style="color:#BC8F8F"action="跳转的页面" method="post"  onsubmit="return check()">
					 -->
				</div>
			</form>
		</div>
				<!--table-->
				<table class="table">
					<tr>
						<th class="index">序号</th>
						<th class="date">事由</th>
						<th class="date">金额</th>
						<th class="date">验收</th>
						<th class="date">时间</th>
						<th class="date">工号</th>
						<th class="class">操作</th>
					</tr>
					<tbody id="tableTbody">
						<c:forEach items="${mkPage}" var ="row" varStatus="status">
						<tr>
						<td class="index">${status.index+1}</td>
						<td class="gd-name">${row.shiyou}</td>
						<td class="date">${row.jine}</td>
						<td class="week">${row.yanshou}</td>
						<td class="week">${row.shijian}</td>
						<td class="week">${row.id}</td>
						<td class="operate">
						
						<a class="operate-edit" href="javascript:void(showMaskb('${row.shiyou}','${row.jine}','${row.yanshou}','${row.shijian}','${row.id}'))">编辑</a>
						<a class="operate-del" href="javascript:void(showMask_del('${row.id}'))">删除</a>
					</td> 
						</tr>
					</c:forEach>
					</tbody>
				</table>
				<!-- <div class="clearfix">
				#if(nodeId!=null) #set(append ="?&nodeId="+nodeId) #end
				 #@paginate(mkPage.pageNumber,mkPage.totalPage,mkPage.totalRow, "/mkgl/")</div> -->
			</div>
		</div>
	</div>
	<!--mask-->
	<!--新增-->
	<div id="mask" class="mask">
		<div class="mask-bg"></div>
		<div class="mask-cont">
			<form action="res3" method="post"  id="insertForm"
				style="display:none">
				<div class="mask-top">
					<span id="tkTitle">添加模块</span> <span id="close_mask_insert"
						class="close-mask"></span>
				</div>
				<div class="clearfix">
				
      </div>
				<div class="clearfix">
					<div class="fl info-item clearfix">
						<label class="label">事由：</label>
						<div class="inpbox">
							<input type="text" id="shiyou" name="shiyou">
						</div>
					</div>
					<div class="fl info-item clearfix">
						<label class="label">金额：</label>
						<div class="inpbox">
							<input type="text" id="jine" name="jine">
						</div>
					</div>
				</div>

				<div class="clearfix">
					
				</div>
				<div class="clearfix">
					<div class="fl info-item clearfix">
						<label class="label">验收：</label>
						<div class="inpbox">
							<input type="text" id="yanshou" name="yanshou">
						</div>
					</div>
					<div class="fl info-item clearfix">
						<label class="label">时间：</label>
						<div class="inpbox">
							<input type="text" id="shijian" name="shijian">
						</div>
					</div>
				<div class="fl info-item clearfix">
						<label class="label">工号：</label>
						<div class="inpbox">
							<input type="text" id="id" name="id">
						</div>
					</div>
				</div>
				<div class="clearfix">
					<div class="fr btn clearfix">
						<a id="btn_save" class="btn-save">保存</a> <a id="btn_cancel"
							class="btn-cancel">取消</a>
					</div>
				</div>
			</form>
		</div>
	</div>

	<div id="mask_del" class="mask">
		<div class="mask-bg"></div>
		<div class="mask-cont">  
			<form action="/delete" method="post" id="deleteForm"
				style="display:none">

				<div class="mask-top">
					提示 <span id="close_mask_delete" class="close-mask"></span>
				</div>
				<input id="deleteNodeId" name="deleteNodeId" value="" type="hidden">
				<div style="text-align: center;margin-top:40px;margin-bottom:30px;">
					确定要删除该信息 ？</div>
				<div class="clearfix">
					<div class="fr btn clearfix">
						<a id="btn_del_ok" class="btn-save" >保存</a> <a id="btn_cancel_del"
							class="btn-cancel">取消</a>
					</div>
				</div>
			</form>
		</div>
  </div>

</body>

<!--编辑-->
	<div id="mask_gn" class="mask">
		<div class="mask-bg"></div>
		<div class="mask-cont">
			<form action="res2" method="post"   id="insertForm2" style="display:none">
				<div class="mask-top">
					<span id="tkTitle">编辑</span> <span id="close_mask_insert"
						class="close-mask"></span>
				</div>
				<div class="clearfix">
					<div class="fl info-item clearfix">
						<label class="label">事由：</label>
						<div class="inpbox">
							<input type="text" id="shiyou1" name="shiyou1">
						</div>
					</div>
					<div class="fl info-item clearfix">
						<label class="label">金额：</label>
						<div class="inpbox">
							<input type="text" id="jine1" name="jine1">
						</div>
					</div>
				</div>

				
				<div class="clearfix">
					<div class="fl info-item clearfix">
						<label class="label">验收：</label>
						<div class="inpbox">
							<input type="text" id="yanshou1" name="yanshou1">
						</div>
					</div>
				<div class="fl info-item clearfix">
						<label class="label">时间：</label>
						<div class="inpbox">
							<input type="text" id="shijian1" name="shijian1">
						</div>
					</div>
				</div>
				<div class="clearfix">
					<div class="fl info-item clearfix">
						<label class="label">工号：</label>
						<div class="inpbox">
							<input type="text" id="id1" name="id1">
						</div>
					</div>
					</div>
	    					
				<input id="nodeId" name="nodeId" value="" type="hidden"> 
				<div class="clearfix">
					<div class="fr btn clearfix">
						<a id="btn_save2" class="btn-save">保存</a> <a id="btn_cancel2"
							class="btn-cancel">取消</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</html>