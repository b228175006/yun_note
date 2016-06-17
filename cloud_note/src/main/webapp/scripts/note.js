//移动笔记至其他笔记本
function moveNote(){
	//获取移动前的笔记本
	var oldBookId = $("#books .checked").parent().data("bookId");
	//获取要移动到的笔记本Id
	//var bookId = $("#can :selected").val();
	var bookId = $("#moveSelect").val();
	//获取笔记Id
	var noteId = $("#notes .checked").parent().data("noteId");
	if(bookId!='none' && oldBookId != bookId){
		//发送ajax请求
		$.ajax({
			url:"http://localhost:8080/cloud_note/note/move.do",
			type:"post",
			data:{"noteId":noteId,"bookId":bookId},
			dataType:"json",
			success:function(result){
				if(result.status==0){
					alert(result.msg);
					//删除当前列表中移动的笔记li
					$("#notes .checked").parent().remove();
				}
			},
			error:function(){
				alert("移动失败");
			}
		});
	}else{
		alert("请选择要移动到哪个笔记本");
	}
}

//删除笔记
function sureRecycleNote(){
	var noteId = $("#notes .checked").parent().data("noteId");
	$.ajax({
		url:"http://localhost:8080/cloud_note/note/recycle.do",
		type:"post",
		data:{"noteId":noteId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				//弹出提示
				alert(result.msg);
				//删除li
				$("#notes .checked").remove();
				//清空编辑区内容
				um.setContent("");
				$("#input_note_title").val("");
			}
		},
		error:function(){
			alert("删除笔记失败");
		}
	});
	
}

//显示笔记菜单
function showNoteMenu(){
	//显示当前li菜单
	//$(this).parents("li").find(".note_menu"). toggle();
	var menu = $(this).parent().next();
	$("#notes .note_menu").slideUp(500);//隐藏其他的菜单
	menu.slideDown(500);//显示菜单div
	//设置当前li选中
	$("#notes a").removeClass("checked");
	$(this).parent().addClass("checked");
	//阻止后续body事件冒泡
	return false;
}

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
	var $li = $("#notes a.checked").parent();
	var noteId = $li.data("noteId");//笔记ID
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
					 var sli='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
						sli+= title;
						sli+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
					$li.find("a").html(sli);//替换<a>元素中的内容

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
	//切换列表显示
	$("#pc_part_2").show();
	$("#pc_part_4").hide();
	$("#pc_part_6").hide();
	$("#pc_part_7").hide();
	$("#pc_part_8").hide();
	$("#pc_part_5").hide();
	$("#pc_part_3").show();
	$("#input_note_title").val("");
	um.setContent("");//获取使用um.getContent()
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
	//显示编辑笔记窗口
	$("#pc_part_5").hide();
	$("#pc_part_3").show();
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
//新增笔记
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