define(["jquery"], function($) {
	var blog = {},
	URL_PREFIX = "http://localhost:8080";
	blog.init = function(){
		bindEvent();
	};
	function bindEvent(){
		//ajax
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
		//load
		$(".post:eq(1)").unbind("click").bind("click", function(){
			$(".content").load(URL_PREFIX+"/article.action", function(){
				console.log("load is ok");
			});
		});
		//get
		$(".post:eq(2)").click(function(){
			$.get(URL_PREFIX+"/getJSON.action", function(data, status){
				var user = JSON.parse(data);
				$(".post:eq(2)").find("a").html(user.pwd);
			});
		});
		//post
		
	}
	
	function successCallback(response){
		$(".content").html(response);
	}
	
	return blog;
});