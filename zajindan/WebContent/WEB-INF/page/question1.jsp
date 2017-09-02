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
<link href="style/css/question1.css" rel="stylesheet">
<title>请问答问题</title>
</head>
<body>


	<div class="boxs">
		<div class="header">
			<img src="zajindan/images/3.jpg">
		</div>
		<div class="content">
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 5px; text-align:center; ">
 				 <legend>本次活动所有题目全部是单项选择</legend>
			</fieldset>
			<form class="layui-form layui-form-pane" action="QuestionController.do?panduan=save" method="post" id="qform">
			 <div class="layui-form-item" pane="">
			  
			 
			  <input type="hidden" name="uid" value="${u.id}"/>
			  <input type="hidden" name="hdid" value="${huodong.hdid}"/>
			  <c:forEach items="${wentilist}" var="wt" varStatus="status">
			  
				   <div class="layui-collapse">
				   		<div class="layui-colla-item">
				    		<h2 class="layui-colla-title">${wt.title}</h2>
				    		
				    		<div class="layui-colla-content layui-show">
				    		    <input class="wentisize" type="hidden" value="${wentisize}"/>
				    			<div class="layui-input-block" style="margin-left:50px;">
				    				<c:forEach items="${wt.xuanxiang}" var="xx" >
				    			     	
							    	<input  type="radio" name="xuanx_${status.index}" value="${xx.tflag}" title="${xx.tflag}.${xx.txuanxiang}">
							        
							        
							       </c:forEach>
							         
							         
							         
							       
							    </div>
				    		
				    		</div>
				  		</div>
				  </div>
			  </c:forEach>
			  
			  </div>
			  <div class="layui-form-item">
			      <div class="layui-btnyb" >
			       <button class="layui-btn" lay-submit="" lay-filter="demo2" style="position:relative;left:50%; margin-left:-46px;margin-top:10px;">提交答案</button>
			      </div>
			  </div> 
			  
		<!--  <script type="text/javascript" >	
			var length= "${fn:length(wentilist)}";	
			$(".layui-btn").click(function(){
				 for(var i=1;i<=length;i++){		 
			     var val=$('input:radio[name='+i+']:checked').val();
			     var daan =  $(".daan").eq(i-1).val();
			     if(val== daan){
			    	 console.log(true);
			     }
			     else{
			    	 console.log(false);
			     }			     
				 }			
			})			
			</script>  
			  -->
			  
			</form>	
		</div>
	</div>
	<script>
	
	layui.use('form', function(){
	  var form = layui.form();
	  
	  //监听提交
	  form.on('submit(demo2)', function(data){
		
		  //获取值
		  var wtsize =$(".wentisize").val();//数组长度
		  var bdsize =$("input[type='radio']:checked").length;//被选长度
		  console.log("wtsize=" + wtsize +   "  bdsize=" + bdsize);
		  if(bdsize<wtsize){
			  for(var i=0;i<wtsize;i++){
				  var inputstr= "input[name='xuanx_"+i+"']:checked";
				  var s=$(inputstr).val();
				  console.log(s);
				  if(s==undefined){
					  layer.alert("亲，第"+(i+1)+"题没有回答，请选择");
					  return false;
				  }				  
			  }			  
			  return false;			
		  }
		  
		  //获取所有答案
		  
		  var daan=[];
		  for(var j=0;j<wtsize;j++){
			  var inputstr1="input[name='xuanx_"+j+"']:checked";
			  var t=$(inputstr1).val();
			  console.log(t);
			  daan[j]=t;
			  
		  }
		  console.log(daan);
		  
		  
		  //后台判断答案是否正确
		  $.ajax({
			  url:"QuestionController.do?question=qt",
			  type:"POST",
			  data:{daan:daan},
			  traditional:true,
			  dataType:"Json",
			   success:function(data){ 
				  console.log(data);
				    if(data.flag == "0"){
				    	layer.alert("恭喜您回答正确");
				    	setTimeout(function(){
				    		$("#qform").submit();
				    	},2000);
				    	
				    }else{
				    	layer.alert("您的回答有错误，请重新回答");
				    	return false;
				    }
			  },
			  error:function(data){}		  
		  });
   
	    return false;
	  });
	});
	</script>
	


</body>
</html>