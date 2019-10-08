$(document).ready(function(){

	$("#id").change(function(){
		$("#btn-checkid").show();
		$("#img-checkid").hide();
	});	
	
	$("#btn-checkid").click(function(){
		var id = $("#id").val();
		if(id == ""){
			alert("아이디를 입력해주세요.")
			return;
		}
	
		// ajax 통신
		$.ajax({
			url: "/jblog3/api/user/checkid?id=" + id,
			type: "get",
			dataType: "json",
			data: "",
			success: function(response){
				if(response.result == "fail"){
					console.error(response.message);
					return;
				}
				
				if(response.data == true){
					alert("이미 존재하는 아이디입니다.");
					$("#id").val("");
					$("#id").focus();
					return;
				}
				
				$("#btn-checkid").hide();
				$("#img-checkid").show();
			},
			error:function(xhr, error) {
				console.error("error : " + error);
			}
		});
	});
});