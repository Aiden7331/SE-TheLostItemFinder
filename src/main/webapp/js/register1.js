var ctx="TheLostItemFinder";

$(document).ready(function(){
  var passwdCheckResult=false;
  var idCheckResult=false;
  var nicknameCheckResult=false;

  $(".btn btn primary").click(function() {
    var input_id=$("#inputEmail3").val();

    $.ajax({
      data : {
        input_id : input_id
      },

      url=ctx+"/checkDouble",

      success : function(data) {
        if(input_id=="") {
          $("#text").css("color", "red");
          $("#text").text("아이디를 입력해주세요.");
          idCheckResult=false;
        } else if(data=='0') {
          $("#text").css("color", "green");
          $("#text").text("사용가능한 아이디입니다.");
          idCheckResult=true;
        } else if(data=='1') {
          $("#text").css("color", "red");
          $("#text").text("이미 사용중인 아이디입니다.");
          idCheckResult=false;
        }
      },

      error : function(error) {
        alert("에러가 발생했습니다.\n에러내용: " + error);
      }
    });
  });

  $("#pw_check").keyup(fucntion() {
    var passwd1=$("#pw").val();
    var passwd2=$("#pw_check").val();

    if(passwd1=passwd2) {
      $("#checkresult").empty();
      $("#checkresult").append("비밀번호가 일치합니다.").css("color", "green");
      passwdCheckResult=true;
    }
    else {
      $("#checkresult").empty();
      $("#checkresult").append("비밀번호가 일치하지 않습니다.").css("color", "red");
      passwdCheckResult=false;
    }

    if(password.pw_check.value.length==0) {
      $("#checkresult").empty();
    }
  });
  
  $("#nickname").keyup(function() {
	    var input_nickname=$("#nickname").val();

	    $.ajax({
	      data: {
	        input_nickname : input_nickname
	      },

	      url=ctx+"/checkdouble",

	      success : function(data) {
	        if(input_id=="") {
	          $("#nicknamecheckresult").empty();
	          $("#nicknamecheckresult").append("닉네임을 입력해주세요.").css("color", "red");
	          nicknameCheckResult=false;
	        } else if(data=='0') {
	          $("#nicknamecheckresult").empty();
	          $("#nicknamecheckresult").append("멋진 닉네임이네요!").css("color", "green");
	          nicknameCheckResult=true;
	        } else if(data=='1') {
	          $("#nicknamecheckresult").empty();
	          $("#nicknamecheckresult").append("이미 사용중인 닉네임입니다.").css("color", "red");
	          nicknameCheckResult=false;
	        }
	      },

	      error : function(error) {
	        alert("에러가 발생했습니다.\n에러내용: " + error);
	      }
	    });
	  });

  $(".form-horizontal").submit(fucntion(event) {
	    if(idCheckResult==false) {
	      event.preventDefault();
	      alert("아이디 중복확인을 하시기 바랍니다.");
	    }

	    if(passwdCheckResult==false) {
	      event.preventDefault();
	      alert("비밀번호가 일치하지 않습니다.");
	    }
	  });
});
