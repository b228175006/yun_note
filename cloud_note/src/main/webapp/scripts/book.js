//新增笔记本
function saveBook(){
	var bookName = $("#input_notebook").val();//新增笔记本名称
	//笔记本名称空值检查
	if(bookName != null && bookName !=""){
		//发送ajax请求
		$.ajax({
			url:"http://localhost:8080/cloud_note/book/save.do",
			type:"post",
			data:{"bookName":bookName,"userId":userId},
			dataType:"json",
			success:function(result){
				if(result.status == 0){
					alert(result.msg);
					//重新加载笔记本列表，或者添加笔记本li并绑定回调中的bookId
//					loadUserBooks();
					var bookId = result.data;
					createBookLi(bookName,bookId);
				}else{
					alert(result.msg);
				}
			},
			error:function(){
				alert("新增笔记本失败");
			}
		});
	}else{
		alert("请输入笔记本名称");
	}
}
//发送Ajax请求获取笔记本列表
function loadUserBooks(){
	$("#books").empty();
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
					createBookLi(bookName,bookId);
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
//笔记本重命名
function renameBook(){
	//获取修改后的名称
	var rename = $("#input_notebook_rename").val();
	//获取要修改的笔记本id
	var bookId = $("#books .checked").parent().data("bookId");
	//非空检查
	if(rename==""){
		alert("请输入笔记本名称");
	}else{
		//ajax提交修改
		$.ajax({
			url:"http://localhost:8080/cloud_note/book/rename.do",
			type:"post",
			data:{"bookId":bookId,"rename":rename,"userId":userId},
			dataType:"json",
			success:function(result){
				if(result.status==0){
					alert(result.msg);
					//重新加载笔记本列表
					loadUserBooks();
				}else{
					alert(result.msg);
				}
			},
			error:function(){
				alert("重命名笔记本失败")
			}
		});
	}
}
//创建笔记列表的li
function createBookLi(bookName,bookId){
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