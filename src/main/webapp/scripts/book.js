//发送Ajax请求获取笔记本列表
function loadUserBooks(){
	$.ajax({
		url:"http://localhost:8080/cloud_note/book/loadbooks.do",
		type:"post",
		data:{"userId":userId},
		dataType:"json",
		success:function(result){
			if(result.status == 0){
				//console.log(result.data);
				var books = result.data;
				for(var i=0;i<books.length;i++){
					var bookName = books[i].cn_notebook_name;
					var bookId = books[i].cn_notebook_id;
					//生成笔记本li元素
					var li = '<li class="online">';
					    li+= '	<a>'
					    li+= '		<i class="fa fa-book" title="online" rel="tooltip-bottom"></i>';
					    li+= 		bookName;
					    li+= '	</a>';
					    li+= '</li>';
					//将bookId绑定到li元素上
					var $li = $(li);
					$li.data("bookId",bookId);
					//添加到笔记本列表ul中
					$("#books").append($li);
				}
			}else{
				alert(result.msg);
			}
		},
		error:function(){
			alert("加载用户笔记本列表失败");
		}
	});
}