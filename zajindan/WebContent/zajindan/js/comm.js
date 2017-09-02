$(window).on('load',function(){
	//项目展示
	var aBusiness = $(".business").find(".show_list");

	aBusiness.hover(function(){
		aBusiness.stop().animate({'width':'80px'},500);
		$(this).stop().animate({'width':'500px'},500);

		aBusiness.find(".show_mask").show(500);
		$(this).find(".show_mask").hide();
	},function(){});

	//介绍
	var oBtn = $(".comm_btn");
	oBtn.hover(function(){
		$(this).toggleClass("blur");
		$(this).siblings().stop().toggle(700);
	},function(){});
});