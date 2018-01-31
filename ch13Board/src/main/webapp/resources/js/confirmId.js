$(function(){
	var checkId = 0;
	
	//아이디 중복 체크
	$('#confirmId').click(function(){
		if($('#id').val()==''){
			alert("ID를 입력하세요!");
			$('#id').focus();
			return;
		}
		
		$('#message_id').text();//메시지 초기화
		$('#loading').show(); //로딩이미지 노출
		
		$.ajax({
			url:'confirmId.do',
			type:'post',
			data:{id:$('#id').val()},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				$('#loading').hide();
				
				if(data.result == 'idNotFound'){
					$('#message_id').css('color','blue').text('등록 가능 ID');
					checkId=1;
				}else if(data.result == 'idDuplicated'){
					$('#message_id').css('color','red').text('중복된 ID');
					$('#id').val('').focus();
					checkId=0;
				}else{
					alert('ID중복체크 오류');
				}
			},
			error:function(){
				$('#loading').hide();
				alert('네트워크 오류 발생!');
			}
		});
	});
	
	//id 중복 안내 메시지 초기화 및 아이디 중복 값 초기화
	$('#register_form #id').keyup(function(){
		checkId=0;
		$('#message_id').text('');
	});
	
	//submit 이벤트 발생시 아이디 중복 체트 여부 확인
	$('#register_form').submit(function(){
		if(checkId==0){
			alert('ID 중복 체크 필수!');
			if($('#id').val()==''){
				$('#id').focus();
			}else{
				$('#confirmId').focus();
			}
			return false;
		}
	});
	
	
});