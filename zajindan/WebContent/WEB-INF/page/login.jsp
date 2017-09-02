<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/context/mytags.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="style/layui/css/layui.css"  media="all">
<script type="text/javascript" src="style/jquery/jquery.min.js"></script>
<script type="text/javascript" src="style/layui/layui.js" ></script>
<link href="style/css/login.css" rel="stylesheet">
	<title>砸金蛋活动</title>
</head>
<body>
      <div class="boxs">

                <c:if test="${flag eq 0}">
					活动没有开始
				</c:if>          
          
               <c:if test="${flag eq 1}">      
	       <div class="top">活动时间: <fmt:formatDate value="${huodong.starttime}" pattern="yyyy年MM月dd日" /> - <fmt:formatDate value="${huodong.endtime}" pattern="yyyy年MM月dd日" /></div>
	       </c:if>
	       
           
                
	        <div class="main">
	            <div class="main-top">
	             	  立即登录赢大奖，精美礼品等你来拿！
	            </div>
           

	            <div class="main-center1">
	            	<form class="layui-form" action="loginContorller.do?hd=saveuser" method="post" >
				     <div class="layui-form-item">
				        <div class="layui-inline">
					      	<label class="layui-form-label " style="color:yellow;width:100px; padding:5px 0px;margin-left:10px;text-align:center;">手机号码:</label>
					      	<div class="layui-input-inline">
					        	<input type="tel" name="usertel" lay-verify="phone" autocomplete="off" class="layui-input" placeholder="请输入您的手机号码" style="width:150px;height:30px;">
					      		<input type="hidden" name="hdid" value="${huodong.hdid}" />
					      	</div>
					     </div>
						<button class="layui-btn layui-btn-primary layui-btn-radius cen" lay-submit="" lay-filter="login1;" >参与活动</button>
				   	 </div>
				   	 
					</form>
					
	            </div>
	        </div>

      </div>  
     

</body>
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form()
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  //自定义验证规则
  form.verify({
	 usertel: [/1[0-9]{10}$/, '请输入正确的手机号码']
  });
 
  
  //监听提交
  form.on('submit(login1)', function(data){
    
	/*layer.alert(JSON.stringify(data.field), {
      title: '最终的提交信息'
    })*/
    return true;
  });
  
  
});
</script>

</html>