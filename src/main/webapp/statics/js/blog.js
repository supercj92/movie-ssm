define(["jquery"], function($) {
	var blog = {},
	URL_PREFIX = "http://localhost:8888";
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
			console.log("ddddd");
		});
		//load
		$(".post:eq(1)").unbind("click").bind("click", function(){
			$(".content").load(URL_PREFIX+"/article.action", function(){
				console.log("load is ok");
			});
		});
		//get
		$(".post:eq(2)").click(function(){
			$.get(URL_PREFIX+"/getJSON.action?type=get", function(data, status){
				var user = JSON.parse(data);
				$(".post:eq(2)").find("a").html(user.pwd);
			});
		});
		//post
		$(".post:eq(3)").click(function(){
			$.post(URL_PREFIX+"/getJSON.action?type=post", 
					{"userName":"jack"}, 
					function(data,status){
						var user = JSON.parse(data);
						$(".post:eq(3)").find("a").html(user.userName + user.pwd);
					},
					"EE");
		});
		//getJSON
		$(".post:last").click(function(){
			$.getJSON(URL_PREFIX+"/getJSON.action?type=getJSON", function(data){
				var userInfo = "";
				$.each(data, function(i, value){
					userInfo += value.userName + "：" + value.pwd + "\n";
				});
				$(".post:last").find("a").html(userInfo);
			});
		});
	}
	
	function successCallback(response){
		
		$(".content").html(response);
	}
	
	return blog;
});