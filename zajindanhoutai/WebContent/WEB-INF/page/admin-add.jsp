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
<title>编辑活动信息</title>
</head>
<body>
<article class="page-container" style="height: 200px">
	<form class="form form-horizontal" id="form-admin-add" method="post">
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>活动ID：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="活动ID" id="hdid" name="hdid">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>活动名称：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" autocomplete="off" value="" placeholder="活动名称" id="hdname" name="hdname">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>活动开始时间：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" onfocus="WdatePicker({ dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'commentdatemax\')||\'%y-%M-%d\'}' })" id="commentdatemin" name="starttime" class="input-text Wdate" placeholder="活动开始时间">
		</div>
	</div>	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>活动结束时间：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" onfocus="WdatePicker({ dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'commentdatemin\')}' })" id="commentdatemax" name="endtime" class="input-text Wdate" placeholder="活动结束时间">
		</div>
	</div>	
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius " type="submit" id="tijiao" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
		</div>
	</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去--> 
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript">


$(document).ready(function(){  
    $(":submit[id=tijiao]").click(function(check){  
    	console.log("11111");
		$.ajax({
		    // 请求发送方式
		    type:"POST",
		    // 验证文件
		    url:"updateController.do?hdinfo=hd",
		    // 用户输入的帐号密码
		    data: {hdid: $("#hdid").val(), hdname: $("#hdname").val(),commentdatemin:$("#commentdatemin").val(),commentdatemax:$("#commentdatemax").val()},
		    // 异步，不写默认为True
		    async: true,
		    //请求成功后的回调
		    dataType:"Json",
		   
		    success: function(data){
		    	console.log(data.tflag);
		        if (data.flag == "0"){		        	
		        	layer.msg('修改成功!',{icon:1,time:1000});
		        	setTimeout(function(){
		        	$("#form-admin-add").submit();
					window.parent.location.reload(); //刷新父页面
					var index = parent.layer.getFrameIndex(window.name);//获取窗口索引			
					parent.layer.close(index);  // 关闭layer
		        	},2000);
		        }else{
		        	layer.msg('修改成功!',{icon:1,time:1000});
		        	return false;
		        }
		    },
		    error: function(data){
		    	
		    }
		
		});
		return false;
	  });
});



</script> 

</body>
</html>