$("#send").on("click", function() {
	$.ajax({
		type : "GET",
		url : "infoupdate",
		data : $('#form').serialize(),
		dataType : "json",
		success : function(data) {
			if (data == "OK") {
				alert("修改成功");
				window.location.href = "modify";
			} else if (data == "ERROR") {
				alert("修改失败");
			}
		},
		error : function(data) {
			alert("对不起，修改失败");
		}
	});
});
