<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/context/mytags.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>活动信息</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 活动管理 <span class="c-gray en">&gt;</span> 活动信息 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="cl pd-5 bg-1 bk-gray"> <span class="l"> <a href="javascript:;" onclick="admin_role_dep(this,'ide')" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" href="javascript:;" onclick="admin_role_add('添加活动','saveController.do?addhdinfo=info','800')"><i class="Hui-iconfont">&#xe600;</i> 添加活动</a> </span> <span class="r">共有数据：<strong>${hdsize}</strong> 条</span> </div>
	<table class="table table-border table-bordered table-hover table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="6">活动管理</th>
			</tr>
			<tr class="text-c">
				<th width="25"><input type="checkbox" value="" name=""></th>
				<th width="40">活动ID</th>
				<th width="200">活动名称</th>
				<th>活动开始时间</th>
				<th width="300">活动结束时间</th>
				<th width="70">操作</th>
			</tr>
		</thead>
		<tbody>
	
		 <c:forEach items="${hdlist}" var="hd" varStatus="status">
			<tr class="text-c">
				<td><input type="checkbox" value="${hd.hdid}" name="hd_${status.index}"></td>
				<td>${hd.hdid}</td>
				<td>${hd.hdname}</td>
				<td>${hd.starttime}</td>
				<td>${hd.starttime}</td>
				<td class="f-14"><a title="编辑" href="javascript:;" onclick="admin_role_edit('活动编辑','updateController.do?adminadd=admin','1')" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a title="删除" href="javascript:;" onclick="admin_role_del(this,'${hd.hdid}')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
			</tr>
        </c:forEach>
        	
		</tbody>
	</table>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript">

/*管理员-角色-添加*/
function admin_role_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*管理员-角色-编辑*/
function admin_role_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*管理员-角色-删除*/
function admin_role_del(obj,id){
	layer.confirm('角色删除须谨慎，确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			data:{hdid:id},
			url: 'deleteController.do?let=hd',
			dataType: 'json',
			success: function(data){
				if(data.flag =="0"){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});

				}
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}
//批量删除
function admin_role_dep(obj,ide){
	layer.confirm('角色删除须谨慎，确认要删除吗？',function(index){
		 var hdlist="";
		$("tbody tr").find("input[type='checkbox']:checked").each(function(){
			 hdlist+=$(this).val();
			 console.log(hdlist);
			})
		
		$.ajax({
			type: 'POST',
			data:{hdidlist:hdlist},
			url: 'deleteController.do?del=tt',
			traditional:true,		
			dataType: 'json',
			success: function(data){
				if(data.flag =="0"){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
				window.location.reload(); //刷新页面
				var index = parent.layer.getFrameIndex(window.name);//获取窗口索引			
				parent.layer.close(index);  // 关闭layer
				}
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}

</script>
</body>
</html>