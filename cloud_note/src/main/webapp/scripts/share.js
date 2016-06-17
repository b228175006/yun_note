//笔记分享操作
function saveShare(){
	//获取笔记Id
	//var noteId = $(this).parents("li").data("noteId");
	var noteId = $("#notes .checked").parent().data("noteId");
	//发送ajax请求
	$.ajax({
		url:"http://localhost:8080/cloud_note/share/share.do",
		type:"post",
		data:{"noteId":noteId},
		dataType:"json",
		success:function(result){
				alert(result.msg);
		},
		error:function(){
			alert("分享笔记失败");
		}
	});
}
//搜索分享笔记
function searchShareNote(e){
	if(e.keyCode==13){
		//获取输入框数据
		var keyword = $("#search_note").val();
		//发送ajax请求
		$.ajax({
			url:"http://localhost:8080/cloud_note/share/search.do",
			type:"post",
			data:{"keyword":keyword},
			dataType:"json",
			success:function(result){
				if(result.status==0){
					var data = result.data;
					//显示搜索列表区
					$("#pc_part_2").hide();
					$("#pc_part_4").hide();
					$("#pc_part_6").show();
					$("#pc_part_7").hide();
					$("#pc_part_8").hide();
					//清空原有列表li
					$("#search").empty();
					for(var i=0;i<data.length;i++){
						var shareTitle = data[i].cn_share_title;
						var shareId = data[i].cn_share_id;
						var li ='<li class="online">';
						    li+='	<a>';
							li+='		<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
							li+=		shareTitle;
							li+='		<button type="button" class="btn btn-default btn-xs btn_position btn_star">';
							li+='			<i class="fa fa-star"></i>';
							li+='	 	</button>';
							li+='	</a>';
							li+='</li>';
						var $li = $(li);
						//给li元素绑定id值
						$li.data("shareId",shareId);
						//添加到笔记列表的ul元素中
						$("#search").append($li);
					}
				}
				
			},
			error:function(){
				alert("查询失败");
			}
		});
	}
}
//预览笔记
function loadShare(){
	//显示预览窗口
	$("#pc_part_3").hide();
	$("#pc_part_5").show();
	//显示选中效果
	$("#search a.checked").removeClass("checked");
	$(this).find("a").addClass("checked");
	//获取选中的li的Id值
	var shareId = $(this).data("shareId");
	//发送ajax请求，显示笔记预览
	$.ajax({
		url:"http://localhost:8080/cloud_note/share/load.do",
		type:"post",
		data:{"shareId":shareId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				var share = result.data;
				$("#noput_note_title").html(share.cn_share_title);
				$("#noput_note_body").html(share.cn_share_body);
			}else{
				alert(result.msg);
			}
		},
		error:function(){
			alert("预览笔记失败");
		}
	});
}
function favors(){
	//获取收藏笔记的Id
	var shareId = $(this).parents("li").data("shareId");
	//发送ajax请求
	$.ajax({
		url:"http://localhost:8080/cloud_note/share/favor.do",
		type:"post",
		data:{"shareId":shareId,"userId":userId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				alert(result.msg);
			}else{
				alert(result.msg);
			}
		},
		error:function(){
			alert("收藏失败");
		}
	});
}