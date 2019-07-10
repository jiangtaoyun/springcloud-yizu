function Run() {
    document.body.onbeforeunload = function () { };
    window.clearInterval(intInterval);
    //var str = '<div class="Box"><p>您的简历已经保存成功，接下来...</p>'
    //  str = str + '  <table width="339" border="0" cellspacing="0" cellpadding="0"><tr>'
    //  str = str + '    <td width="121"><a href="http://www.shoudurc.com/Personal/cv/Resume/' + $("#hidcvMainID").val() + '"><img src="../images/Prompt_13.gif"/*tpa=http://www.shoudurc.com/Content/Personal/images/Prompt_13.gif*/ width="72" height="68" /></a></td><td width="121"><a href="http://www.shoudurc.com/Personal/js/search"><img src="../images/Prompt_15.gif"/*tpa=http://www.shoudurc.com/Content/Personal/images/Prompt_15.gif*/ width="72" height="68" /></a></td><td width="121"><a href="http://www.shoudurc.com/Personal/cvm/cvlist"><img src="../images/Prompt_17.gif"/*tpa=http://www.shoudurc.com/Content/Personal/images/Prompt_17.gif*/ width="72" height="68" /></a></td></tr>'
    //  str = str + '   <tr><td><a href="http://www.shoudurc.com/Personal/cv/Resume/' + $("#hidcvMainID").val() + '">进一步完善这份简历</a></td><td><a href="http://www.shoudurc.com/Personal/js/search">开始查找职位</a></td><td><a href="http://www.shoudurc.com/Personal/cvm/cvlist">返回简历列表</a></td></tr></table></div>'
    //  infoboxs("恭喜您！", 400, 1, "", 20, -300, str);

    popup.clearData();
    popup.isHeader = 0;
    popup.mask = 2;

    popup.H = 0;
    popup.isFilter = 1;
    popup.divClass = "popup";
    popup.dockObj = "";
    if (isMobileCer == 1) {
        popup.bodyHtml = '<div class="ResumeSucess"><span>恭喜您！</span><div onclick="popup.ibClose()"></div></div><div class="ResumeNext"><div class="NextTip">您的简历已经保存成功，接下来您可以：</div><div class="NextOperate"><span onclick="window.location.href=\'/Personal/cv/Resume/' + $("#hidcvMainID").val() + '\'">进一步完善简历</span><span onclick="window.location.href=\'http://www.shoudurc.com/Personal/js/search_pa\'" style="margin-left: 60px;background-position: 4px -1641px;">搜索心仪职位</span></div></div>';
        popup.W = 400;
    } else if (isMobileCer == 2) {
        popup.bodyHtml = '<div class="ResumeSucess" style="width:445px;">'
	   		+ '<span style="width: 350px">恭喜您简历已经成功保存</span>'
	   		+ '<div onclick="location.href=\'/Personal/cv/resume/'+cvMainID+'\'"></div>'
   		+ '</div>'

		+ '<div class="ResumeNext" style="width: 452px;text-align: center">'
			+ '<div style="color: #39c042;font-size: 14px;font-weight: bold;text-align: center">绑定微信服务号  接收面试通知</div>'
			+ '<div style="text-align: center;padding: 10px 0">'
				+ '<img id="imgWechat" src="" width="170px" height="170px"/>'
			+ '</div>'

			+ '<div style="font-size: 14px;font-weight: bold">'
			+ '<img src="../images/wx_ico.png"/*tpa=http://www.shoudurc.com/content/personal/images/wx_ico.png*/ style="position: relative;top: 8px;right:4px;width: 30px"/>微信扫一扫</div>'
		+ '</div>';
        popup.W = 480;
    } else {
        popup.bodyHtml = '<div class="ResumeSucess" style="width:445px;"><span style="width: 350px">恭喜您简历已经成功保存</span><div  onclick="location.href=\'/Personal/cv/resume/'+cvMainID+'\'"></div></div><div class="ResumeNext" style="    width: 452px;">'
        + '<div style="padding-top: 20px;    height: 200px;">'
        + '  <p style="color:red;text-align: center;">为保证您的求职顺利，请验证您的手机号</p>'
        + '  <div style="margin-top: 10px;    margin-left: 30px;">'
        + '    <span style="    vertical-align: middle;">您的手机号码：</span>'
        + '    <div style="padding: 0px 10px;border: 1px solid #DBDBDB;width: 240px;border-radius: 4px;height: 35px;line-height: 35px;font-size: 14px; display: inline-block;*display:inline;*zoom:1;    vertical-align: middle;padding-right:0px;">'
        + '      <input type="text" id="txtMobile" value="' + strMobile + '" style=" line-height:35px; border:none; height:35px;width: 120px;" maxlength="11" />'
        + '      <input type="button" id="spSecond" value="发送验证码" style="color:#fff; width:80px; background:#F34B09; font-size:12px; border:none; cursor:pointer; border-radius: 4px; height:31px; margin-top:2px; margin-right:2px;float:right;" onclick="GetMobileVerifyCode()" />'
        + '    </div>'
        + '  </div>'
        + '  <div style="margin-top: 15px;margin-left: 65px;">'
        + '    <span style="    vertical-align: middle;">验证码：</span>'
        + '    <div style="padding: 0px 10px;border: 1px solid #DBDBDB;width: 240px;border-radius: 4px;height: 35px;line-height: 35px;font-size: 14px; display: inline-block;*display:inline;*zoom:1;    vertical-align: middle;padding-right:0px;">'
        + '      <input id="VerifyCode" type="text" value="" style="width: 235px; height:35px; line-height:35px; border:none;" maxlength="6" />'
        + '    </div>'
        + '  </div>'
        + '  <input type="button" onclick="MobileCerConfirm()" value="确&nbsp;&nbsp;定" style=" background:#4EB440; color:#FFF; height:35px; width:100px; font-size:18px; margin-left:118px;cursor:pointer;border:none; border-radius: 4px;margin-top: 20px;" />'
        + '</div>'
        + ''
        + '</div>';
        popup.W = 480;
    }
    popup.creatDiv();
    if (isMobileCer == 2) {
        initWeXin();
        window.setInterval("CheckWeiXinBind()", 2 * 1000);
    }

}
function MobileCerSucc(Mobile) {
    var str = '<div class="ResumeSucess" style="width: 450px;"><span style="width:255px;margin-left: 65px;">恭喜您手机号已完成认证！</span><br /><p style=" float:left; text-align: center;width: 100%;">认证手机号：' + Mobile + '</p><div onclick="window.location.href=\'http://www.shoudurc.com/Personal/Cvm/CvList/\'" style="position: absolute;right: 20px;top: 20px;"></div></div><div class="ResumeNext" style="height: 158px;"><div class="NextTip">接下来您可以：</div><div class="NextOperate"><span onclick="window.location.href=\'/Personal/cv/Resume/' + $("#hidcvMainID").val() + '\'">进一步完善简历</span><span onclick="window.location.href=\'http://www.shoudurc.com/Personal/js/search_pa\'" style="margin-left: 60px;background-position: 4px -1641px;">搜索心仪职位</span></div></div>';
    popup.clearData();
    popup.isHeader = 0;
    popup.isMessageTip = 0;
    popup.drag = 1;
    popup.mask = 3;
    popup.W = 480;
    popup.H = 1;
    popup.isFilter = 1;
    popup.dockObj = "";
    popup.dockLeft = 0;
    popup.dockTop = -130;
    popup.bodyHtml = str;
    popup.creatDiv();
}
var second = 160;
var funcInterval;
function GetMobileVerifyCode() {
    var mobile = $("#txtMobile").val();
    if (mobile.length == 0) {
        alert("请输入手机号码");
        $("#txtMobile").focus();
        return;
    }
    if (!CheckRule("mobile", mobile)) {
        alert("手机号码格式不正确！");
        $("#txtMobile").focus();
        return;
    }

    $.post("/personal/Account/GetCettifMobileCode"
      , { Mobile: mobile }
      , function (data) {
          if (data == "-1") {
              alert("登录身份已经过期，请重新登录！");
              loaction.href = location.href;
              return;
          } else if (data == "-2") {
              alert("您在160秒内已经认证过，请稍候重试！");
              return;
          } else if (data == "-3") {
              alert("您今天已经认证超过4次，请明天重试！");
              return;
          } else if (data == "1") {
              funcInterval = window.setInterval(Countdown, 1000);
          } else if (data.substring(0, 2) == "-5") {
              second = 160 - Number(data.substring(3));
              funcInterval = window.setInterval(Countdown, 1000);
              alert("您在160s内发送过验证码，请等待时间结束后重新发送。");
          } else {
              alert("发送失败，请稍候重试！");
              return;
          }
      });
}
function Countdown() {
    $("#spSecond").css("color", "#777976");
    $("#spSecond").css("background", "#F2F2F4");
    $("#spSecond").css("border", "1px #DCDCDC solid");
    $("#spSecond").val(second + "秒后可重发");
    $("#spSecond").click(function () { });
    $("#spSecond").attr("onclick", "");
    if (second == 0) {
        $("#spSecond").addClass("Active");
        $("#spSecond").val("发送验证码");
        $("#spSecond").css("color", "#fff");
        $("#spSecond").css("background", "#F34B09");
        $("#spSecond").css("border", "1px #DCDCDC solid");
        document.getElementById("spSecond").innerHTML = "发送验证码";
        $("#spSecond").click(function () { GetMobileVerifyCode() });
        window.clearInterval(funcInterval);
    }
    second--;
}
function MobileCerConfirm() {
    var mobile = $("#txtMobile").val();
    if (mobile.length == 0) {
        alert("请输入手机号码");
        $("#txtMobile").focus();
        return;
    }
    if (!CheckRule("mobile", mobile)) {
        alert("手机号码格式不正确！");
        $("#txtMobile").focus();
        return;
    }
    var VerifyCode = $("#VerifyCode").val();
    if (VerifyCode.length == 0) {
        alert("请输入验证码");
        $("#VerifyCode").focus();
        return;
    }
    if (VerifyCode.length != 6) {
        alert("验证码为六位数字，请检查");
        $("#VerifyCode").focus();
        return;
    }
    $.post("/personal/account/PaMobileCerConfirm"
      , { Mobile: mobile, VerifyCode: VerifyCode }
      , function (data) {
          if (data == "-1") {
              alert("登录身份已经过期，请重新登录！");
              loaction.href = location.href;
              return;
          } else if (data == "-2") {
              alert("验证码不正确！");
              return;
          } else if (data == "1") {
              popup.ibClose();
              MobileCerSucc(mobile);
          }
      })
}
function NextStep(cvMainID) {
    intWrong = 0;
    var intI = 0;
    if ($("#Mobile.TipsError").html().indexOf("已注册过") > -1) {
        $("#Mobile.TipsError").html("");
        $("#Mobile.TipsError").hide();
    }
    if($("#txtImgVerifyCode").val() == ""){
        alert("图片验证码不能为空");
        return;
    }
    if ($("#txtVeriyCode").val() == "") {
        alert("短信验证码不能为空");
        return;
    }
    $("input[id^='btnSave']").each(function (i) {
        if ($(this).val() == "保存") {
            var typeFun = "Save" + this.name.substring(7) + "(this)";
            var typeFunResult = eval(typeFun);
            
            if (typeFunResult == false) {
                if (intI == 0) {
                    window.location.href = "#div" + $(this).attr("id").substring(7);
                    alert("您有未填写完成的信息");
                    intI++;
                }
            }
            if (typeFunResult == 'F') {
                if (intI == 0) {
                    intI++;
                }
            }
        }
    });
    if (intI == 0) {
        document.body.onbeforeunload = function () { };
        window.location.href = "http://www.shoudurc.com/Personal/cv/stepTwo/" + cvMainID + (applyUrl.length == 0 ? "" : "?applyurl=" + escape(applyUrl));
    }
}

function DocResumeSave() {
    intWrong = 0;
    var intI = 0;
    if ($("#txtImgVerifyCode").val() == "") {
        alert("图片验证码不能为空");
        return;
    }
    if ($("#txtVeriyCode").val() == "") {
        alert("短信验证码不能为空");
        return;
    }
    $("input[id^='btnSave']").each(function (i) {
        if ($(this).val() == "保存") {
            var typeFun = "Save" + this.name.substring(7) + "(this)";
            var typeFunResult = eval(typeFun);
            if (typeFunResult == false) {
                if (intI == 0) {
                    window.location.href = "#div" + $(this).attr("id").substring(7);
                    alert("您有未填写完成的信息");
                    intI++;
                }
            }
            if (typeFunResult == 'F') {
                if (intI == 0) {
                    intI++;
                }
            }
        }
    });
    if ($("#ifmAttachment").contents().find(".DocView").length == 0) {
        alert("您还未上传附件简历");
        return;
    }
	
	//ajax word建立了保存完成  根据session记录log
	insertSourcelog($("#hidcvMainID").val());
	
    if (intI == 0) {
        if (applyUrl.length > 0) {
            window.location.href = applyUrl;
        }
        else {
            intInterval = window.setInterval(Run, 200);
        }
    }
}

function initWeXin() {
    if ($("#imgWechat").length > 0) {
        $.get("/personal/sys/AjaxGetBindTicket?source=index&t=" + new Date().getTime(), function (data) {
            $("#imgWechat").attr("src", "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + data);
        });
    }
}

//根据来源插入记录
function insertSourcelog(cvMainId){
		//设置session以及超时时间
		//alert(window.location.href);
		 $.post("/personal/jv/AjaxInsertLog",{url:window.location.href,cvMainId:cvMainId},function(data){
			 
         });
		
	}
