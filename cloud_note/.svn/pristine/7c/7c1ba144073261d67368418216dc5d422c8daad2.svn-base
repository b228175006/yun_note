function recycleList(){
	//显示列表
	$("#pc_part_2").hide();
	$("#pc_part_4").show();
	$("#pc_part_6").hide();
	$("#pc_part_7").hide();
	$("#pc_part_8").hide();
	//加载数据
	$.ajax({
		url:"http://localhost:8080/cloud_note/note/loadrecycle.do",
		type:"post",
		data:{"userId":userId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				var notes = result.data;
				for(var i=0;i<notes.length;i++){
					var title = notes[i].cn_note_title;
					var noteId = notes[i].cn_note_id;
					var li = '<li class="disable">';
						li+='	<a >';
						li+='		<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
						li+=		title;
						li+='		<button type="button" class="btn btn-default btn-xs btn_position btn_delete">';
						li+='			<i class="fa fa-times"></i>';
						li+='		</button>';
						li+='		<button type="button" class="btn btn-default btn-xs btn_position_2 btn_replay">';
						li+='			<i class="fa fa-reply"></i>';
						li+='		</button>';
						li+=	'</a>';
						li+='</li>';
					var $li = $(li);
					$li.data("noteId",noteId);
					$("#recycles").append($li);
				}
			}else{
				alert(result.msg);
			}
		},
		error:function(){
			alert("加载回收站失败");
		}
	});
}