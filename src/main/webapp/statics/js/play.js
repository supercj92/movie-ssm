$(document).ready(function(){
	var URL_PREFIX = $("#ip").val();
	var FILE_PREFIX = $("#path").val();
	
	//身份认证֤
	$('#auth_submit').click(function(){
		var pwd = $('#pwd').val();
		var res = $.ajax({
			url:URL_PREFIX+"auth.action?pwd="+pwd,
			async:true,
			success:authSuccessCallback,
			error:function(){
				alert('auth failed');
			}
			});
	});
	
	function authSuccessCallback(response){
		$('#container').html(response);
		if(response.trim() != "认证失败"){
			$('#auth').hide();
		}
		//对新dom绑定事件
		$('#getFiles').click(getVedioByPath);
	}
	
	
	function getVedioByPath(){
		var path = $('#path').val();
		$.ajax({
			url:URL_PREFIX+"list.action?path="+path,
			success:successCallback,
			error:function(response){
				console.log("获取列表失败");
			},
			async:true
			});
	}
	
	function successCallback(response){
		var fileArray = response.split(',');
		//拼接列表
		var fileList = "<ul>";
		for(var i=0;i<fileArray.length;i++){
			fileList = fileList + "<li>" +fileArray[i] + "</li>";
			}
		fileList + "</ul>";
		$("#myDiv").html(fileList);
		//为li绑定事件
		$('li').each(function(){
			$(this).click(function(){
				var absolutePath = $(this).html();
				
				if(isVedioFile(absolutePath)){
					var step1 = absolutePath.replace(FILE_PREFIX,'');
					var step2 = step1.replace(new RegExp('\\\\','gm'),'/');
					$('video').attr("src",step2);
					$('video').play();
				}else{
					$('#path').val(absolutePath);
					getVedioByPath();
				}
			});
		});
	}
	
	//判断是否是视频文件
	function isVedioFile(path){
		if(path.indexOf('.') != -1){
			return true;
		}else{
			return false;
		}
	}
});