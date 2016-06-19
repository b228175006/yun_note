//移动笔记对话框
function alertMoveNoteWindow(){
	//弹出对话框
	$("#can").load("alert/alert_move.html",function(){
		//获取笔记本列表
		var books = $("#books li");
		for(var i=0;i<books.length;i++){
			var opName = $(books[i]).text().trim();//获取笔记本名称
			var opId = $(books[i]).data("bookId");//获取笔记本Id
			//新建option
			var op = "<option value='"+opId+"'>"+opName+"</option>";
			//加入到select中
			$("#moveSelect").append(op);
			$('.opacity_bg').show();//弹出对话框背景色
		}
	});
	
}

//点击"+"按钮弹出创建笔记本对话框
function alertAddBookWindow(){
	$("#can").load("alert/alert_notebook.html");//弹出对话框
	$('.opacity_bg').show();//弹出对话框背景色
}
//关闭对话框
function closeAlertWindos(){
	$("#can").empty();//清空对话框div
	$('.opacity_bg').hide();//隐藏背景色
}
//双击弹出重命名笔记本
function alertRename(){
	//加载重命名笔记本窗口
	$("#can").load("alert/alert_rename.html",function(){
		//获取修改前名称并显示
		var name = $("#books .checked").text().trim();
		$("#input_notebook_rename").val(name);
	});
	//弹出对话框背景色
	$('.opacity_bg').show();
}
//弹出新增笔记对话框
function alertAddNoteWindow(){
	//检查是否选中笔记本
	var $li = $("#books a.checked").parent();
	if($li.length==0){
		alert("请先选择笔记本");
		return;
	}	
	//加载对话框
	$("#can").load("alert/alert_note.html");
	$('.opacity_bg').show();//弹出对话框背景色
}
//点击X号弹出删除对话框
function alertDeleteNoteWindow(){
	$("#can").load("alert/alert_delete_note.html");
	$('.opacity_bg').show();//弹出对话框背景色
}