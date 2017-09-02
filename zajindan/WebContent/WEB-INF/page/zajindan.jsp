<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/context/mytags.jsp" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>砸金蛋</title>	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="style/layui/css/layui.css"  media="all">
	<script type="text/javascript" src="style/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="style/layui/layui.js" ></script>	
	
	
	<link rel="stylesheet" href="style/css/style.css">
	<link rel="stylesheet" href="style/css/main_response.css">
	<style type="text/css">


	
	.cen{
	  width:160px;
	  font-weight: bolder;
	}
	.ziti{
	   color:red;
	   font-weight: bolder;
	   text-align:center;
	}
		
	.usaddr{
	  font-family:"宋体";
	}	
	</style>
	
</head>



<body>

	<!-- <div class="jiangPinResult">
		<img class="gongxi" src="style/images/gx.png" alt="恭喜你" title="恭喜">
		<p>获得500元现金</p>
		<img class="imgJiangPin" src="style/images/jiangpin.png" alt="奖品" title="奖品">
		<a href="https://www.hmyd.com/"><input class="btn_Get" value="领取奖品" type="button"></a>
		<img class="colseJiangPin" src="style/images/close.png" alt="关闭" title="关闭">
	</div> -->
  

	<div class="goldContent">
		<div class="headPage">
			<img class="headPage_Img" src="style/images/6.jpg" alt="砸金蛋" title="砸金蛋">
		</div>

		<div class="goldEggsDiv">
			
			<img class="centerPage_Img" src="style/images/3.png" alt="砸金蛋" title="砸金蛋">
			<div class="list_EggsDiv"  id="carousel">
				<div>
					<ul class="jinDanUl" id="jinDanUl1">
						<li><img src="style/images/egg.png" alt="egg1" title="砸金蛋！"/></li>
						<li><img src="style/images/egg.png" alt="egg2" title="砸金蛋！"/></li>
						<li><img src="style/images/egg.png" alt="egg3" title="砸金蛋！"/></li>
					</ul>	
				</div>
	            
				<div>
					<ul class="jinDanUl1" id="jinDanUl2">
						<li><img src="style/images/egg.png" alt="egg4" title="砸金蛋！"/></li>
						<li><img src="style/images/egg.png" alt="egg5" title="砸金蛋！"/></li>
						<li><img src="style/images/egg.png" alt="egg6" title="砸金蛋！"/></li>
					</ul>	
				</div>
			</div>
		</div>

		
		<div class="rulesActivity list_Content">
			<div class="titleDiv">
				<div class="title_Div">
					<h3>活动细则</h3>
				</div>
				<span class="line_1px"></span>
			</div>

			<div class="list_Rules">
				<i class="right_img"></i>
				<i class="left_img"></i>
				<ul>
					<li>1.所有参与活动的用户，回答对问题后都有机会获得一次砸金蛋的机会</li>
					<li>2.奖项设置：现金券、小惠钱包和积分等，奖池内大奖含有现金券500元、小惠钱包100元、1000积分等；</li>
					<li>3.奖品为实时发放，请会员自行前往个人中心查看获取奖品；</li>
					<li>4.客服免费咨询热线：123456789、邮箱：185098535@qq.com（工作日：09：00-17：30）；</li>
					<li>5.本活动最终解释权归Ifmisswqq所有。</li>
				</ul>
			</div>
		</div>
         
		<div class="footerImg">
			<img src="style/images/bottom.png" alt="砸金蛋活动">
		</div>
	</div>
	
	<script type="text/javascript" src="style/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="style/layui/layui.js" ></script>
    <script type="text/javascript">
 
 
         var zjlist =${zhongjiang};
       
		
				    if(zjlist >0){
				        $(".jinDanUl").click(function(){
				        	/*$(".cuizi").addClass("flash");*/
				        	layui.use('layer',function(layer){
				        		layer.open({
				        			  type: 1,
				        			  title: false,
				        			  closeBtn: 0,
				        			  shadeClose: true,
				        			  skin: 'yourclass',
				        			  content: '<div class="bg-mask"></div>'+
				        			           '<div class="chouJiang">'+
				        			           '<p class="chouJiangTishi">请稍等...</p>'+
				        			           '<img class="caiDai" src="style/images/caidai.png" alt="彩带">'+
				        			           '<img class="imgDan" src="style/images/egg.png" alt="砸蛋" title="砸蛋">'+
				        			           '<img class="imgChuiZi" src="style/images/chuizi.png" alt="锤子">'+
				        			           '</div>'
				        			           
				        			});				        		
				        		
				        		
				        	})
				        	
				         setTimeout(function(){
				        	 $(".chouJiang").remove();
				     	   layui.use('layer',function(layer){	  
				     		   layer.open({
				         		   type:1,
				         		   skin:'layui-layer-rim',
				         		   area:['320px','480px'],
				         		   content:'<form class="layui-form" action="ZaDanController.do?zadan=save" method="post" >'+
		         				           '<p><img src="style/images/zjl.png"></p>'+
		         				           '<p class="ziti">恭喜您获得了'+zjlist+'等奖</p></br>'+
		         				           '<div class="layui-form-item">'+
		         				             '<div class="layui-inline">'+
		         				             '<label class="layui-form-label " style="color:black;width:100px; padding:5px 0px;margin-left:10px;text-align:center;">您的姓名:</label>'+
		         				             '<div class="layui-input-inline">'+
		         				             '<input type="text" name="usname" lay-verify="title" autocomplete="off" class="layui-input" placeholder="请输入您的姓名" style="width:150px;height:30px;";>'+
		         				             '</div>'+
		         				             '</div>'+
		         				             '<div class="layui-inline">'+
		         				             '<label class="layui-form-label usaddr " style="color:black;width:100px; padding:5px 0px;margin-left:10px;text-align:center;">您的地址:</label>'+
		         				             '<div class="layui-input-inline">'+
		         				             '<input type="text" name="usaddr" lay-verify="title" autocomplete="off" class="layui-input" placeholder="请输入您的地址" style="width:150px;height:30px;">'+
		         				             '</div>'+
		         				             '</div>'+
		         				             '<div class="layui-btnyb" >'+
		         				             '<button class="layui-btn layui-btn-radius cen" lay-submit="" lay-filter="demo2" style="position:relative;left:50%; margin-left:-80px;margin-top:10px;">领取奖品</button>'+
		         				             '</div>'+
		         				             '</div>'+
		         				             '<input type="hidden" name="jiangx" value="${zhongjiang}" />'+
		         				             '</form>'	
		         				             
				         				   	   
				         	   });
				     	   });
				         },3000);

				     	   
				        });

				      
				    }
				        else{
				    	$(".jinDanUl").click(function(){
				    		
				        	layui.use('layer',function(layer){
				        		layer.open({
				        			  type: 1,
				        			  title: false,
				        			  closeBtn: 0,
				        			  shadeClose: true,
				        			  skin: 'yourclass',
				        			  content: '<div class="bg-mask"></div>'+
				        			           '<div class="chouJiang">'+
				        			           '<p class="chouJiangTishi">请稍等...</p>'+
				        			           '<img class="caiDai" src="style/images/caidai.png" alt="彩带">'+
				        			           '<img class="imgDan" src="style/images/egg.png" alt="砸蛋" title="砸蛋">'+
				        			           '<img class="imgChuiZi" src="style/images/chuizi.png" alt="锤子">'+
				        			           '</div>'
				        			           
				        			});				        		
				        		
				        		
				        	})
				    		setTimeout(function(){
				    			$(".chouJiang").remove();
					     	   layui.use('layer',function(layer){	  
					     		   layer.open({
					         		   type:1,
					         		   skin:'layui-layer-rim',
					         		   area:['150px','170px'],
					         		   content:'<p>很遗憾您没能中奖</p>'+
					         		            '<p><img src="style/images/q1.png"></p>'
					         	   });
					     	   });
				    		},3000);
					        });
				    }
		
				    
				        
				    layui.use(['form'], function(){
				    	  var form = layui.form()
  
				    	  //监听提交
				    	  form.on('submit(demo2)', function(data){
				    	    
				    		/*layer.alert(JSON.stringify(data.field), {
				    	      title: '最终的提交信息'
				    	    })*/
				    	    return true;
				    	  });
				    	  
				    	  
				    	});		
				    
	       
    </script>	
	
	
</body>
 

</html>