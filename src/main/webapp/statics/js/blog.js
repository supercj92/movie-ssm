define(["jquery"], function($) {
	var blog = {},
	URL_PREFIX = "http://10.161.163.163:8888";
	blog.init = function(){
		bindEvent();
	};
	function bindEvent(){
		$(".post:first").off("click").on("click",function(){
			$.ajax({
				url:URL_PREFIX+"/article.action",
				success:successCallback,
				error:function(response){
					console.log("获取列表失败");
				},
				async:true
			});
		});
	}
	
	function successCallback(response){
		$(".content").html(response);
	}
	
	return blog;
});