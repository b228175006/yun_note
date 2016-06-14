//新增笔记
function saveNote(){
	//获取userId
	//获取笔记本Id
	var bookId = $("#books .checked").parent().data("bookId");
	//获取笔记名称
	var name = $("#input_note").val();
	if(name==""){
		alert("请输入笔记本名称");
		return;
	}
	//ajax异步提交
	$.ajax({
		url:"http://localhost:8080/cloud_note/note/add.do",
		type:"post",
		data:{"userId":userId,"bookId":bookId,"name":name},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				var noteId = result.data;
				addNoteList(noteId,name);
				alert(result.msg);
			}
		},
		error:function(){
			alert("新增笔记失败");
		}
	});
}
//“保存笔记”按钮处理
function updateNote(){
	//获取要保存的参数
	var title = $("#input_note_title").val();//笔记标题
	var body = um.getContent();//笔记内容
	//获取笔记Id(选中被选中的a标签，找到父元素li，获取id值)
	var noteId = $("#notes a.checked").parent().data("noteId");
	//格式检查
	if(title==null){
		alert("请填写标题");
	}else if(body==null){
		alert("请填写笔记内容");
	}else if(noteId==null){
		alert("请选择笔记");
	}else{
		//发送Ajax
		$.ajax({
			url:"http://localhost:8080/cloud_note/note/update.do",
			type:"post",
			data:{"title":title,"body":body,"noteId":noteId},
			dataType:"json",
			success:function(result){
				if(result.status==0){
					//更新列表标题名称
					var li ='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
						li+= title;
						li+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down">';
					$("#notes a.checked").html(li);
					
					//var bookId = $("#books a.checked").parent().data("bookId");
					//loadAjax(bookId);
					//$("#input_note_title").val("");
					//um.setContent("");
					//提示保存完成
					alert(result.msg);
				}
			},
			error:function(){
				alert("保存笔记失败");
			}
		});
	}
}


//根据笔记本加载笔记列表
function loadBookNotes(){
	//将点击的笔记本设置为选中状态
	$("#books a.checked").removeClass("checked");
	$(this).find("a").addClass("checked");
	//获取点击的笔记本的li的Id值
	var bookId = $(this).data("bookId");
	//alert(bookId);8
	//发送请求加载笔记
	$.ajax({
		url:"http://localhost:8080/cloud_note/note/loadnotes.do",
		type:"post",
		data:{"bookId":bookId},
		dataType:"json",
		success:function(result){
			if(result.status==0){//成功
				var notes = result.data;
				//清除之前的列表内容
				$("#notes").empty();
				//显示选中的笔记本中的笔记列表
				for(var i=0;i<notes.length;i++){
					var noteTitle = notes[i].cn_note_title;//笔记标题
					var noteId = notes[i].cn_note_id;//笔记id
					addNoteList(noteId,noteTitle);
				}
			}
			
			
		},
		error:function(){
			alert("加载笔记列表失败");
		}
	});
}
//点击笔记加载笔记内容
function loadNoteContent(){
	//增加点击样式
	$("#notes a.checked").removeClass("checked");
	$(this).find("a").addClass("checked");
	//获取点击li的id
	var noteId = $(this).data("noteId");
	//发送请求
	$.ajax({
		url:"http://localhost:8080/cloud_note/note/load.do",
		type:"post",
		data:{"noteId":noteId},
		dataType:"json",
		success:function (result) {
			if(result.status==0){
				var note = result.data;
				$("#input_note_title").val(note.cn_note_title);
				um.setContent(note.cn_note_body);//获取使用um.getContent()
			}
		},
		error:function () {
			alert("加载笔记内容失败");
		}
	});
}
function addNoteList(noteId,noteTitle){
	var li ='<li class="online">';
    li+='	<a>';
	li+='		<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
	li+=		noteTitle;
	li+='		<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down">';
	li+='			<i class="fa fa-chevron-down"></i>';
	li+='		</button>';
	li+='	</a>';
	li+='	<div class="note_menu" tabindex="-1">';
	li+='		<dl>';
	li+='			<dt>';
	li+='				<button type="button" class="btn btn-default btn-xs btn_move" title="移动至...">';
	li+='					<i class="fa fa-random"></i>';
	li+='				</button>';
	li+='			</dt>';
	li+='			<dt>'
	li+='				<button type="button" class="btn btn-default btn-xs btn_share" title="分享">';
	li+='					<i class="fa fa-sitemap"></i>';
	li+='				</button>';
	li+='			</dt>';
	li+='			<dt>';
	li+='				<button type="button" class="btn btn-default btn-xs btn_delete" title="删除">';
	li+='					<i class="fa fa-times"></i>';
	li+='				</button>';
	li+='			</dt>';
	li+='		</dl>';
	li+='	</div>';
	li+='</li>';
	var $li = $(li);
	//给li元素绑定id值
	$li.data("noteId",noteId);
	//添加到笔记列表的ul元素中
	$("#notes").append($li);
}