// JavaScript Document
function sAjax(method,url,parm,callback,bool){
  var xmlHttp = false;
  if(window.ActiveXObject)
  {
    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
  }
  else if(window.XMLHttpRequest)
  {
    xmlHttp = new XMLHttpRequest();
  }  
  xmlHttp.onreadystatechange = function () 
  {
    if (xmlHttp.readyState == 4) 
    {
      if(xmlHttp.status == 200){
        callback(xmlHttp); 
        xmlHttp = null;
      }
	  else {
        document.write(xmlHttp.status+"："+xmlHttp.responseText);
      }
    }
  } 
  xmlHttp.open(method,url,bool);
  xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gb2312");
  xmlHttp.send(parm);
  if(navigator.userAgent.indexOf("Firefox")>0)
  callback(xmlHttp);
} 
function CheckLockStatus()
{  
  var myDate = new Date();
  sAjax("get","/company/ca/AjaxCheckLockStatus?t="+myDate.getTime(),"",function(obj){AccountLockStatus=obj.responseText},true);
}
if(!window.AccountLockStatus)
{
  var AccountLockStatus="-1";
  CheckLockStatus();
}
var strPasswordAction = "";
function DoCheckPasswordAction(action)
{
  strPasswordAction = action;  
  if(AccountLockStatus=="-1")
  {
    showPasswordTip();
  }
  else if(AccountLockStatus=="0")
  {
    showPasswordTip2();
  }
  else
  {
    if(action=="")
    {
      showPasswordTip2();
    }
    else
    {
      eval(strPasswordAction);  
    }
  }
}
function showPasswordTip() {
  var str = "<div style='padding:20px'><span style='font-size:14px;font-family:\"Microsoft YaHei\"'> &nbsp; &nbsp; &nbsp; &nbsp;为了您的帐号安全，请设置一个保护密码，用于锁定您的帐号，未解锁状态不能查看简历联系方式及下载简历、修改\删除职位、删除应聘简历、重置用户名密码、修改企业\用户信息。</span><br /><br />输入密码：<input type='password' id='txtSafePassword' style='width: 200px;height: 14px;padding: 10px 5px;border: 1px #CCCCCC solid;' maxlength='6'> <span style='color:#f00'>请输入6位数字</span><br /><br />确认密码：<input maxlength='6' type='password' id='txtSafePasswordConfirm' style='width: 200px;height: 14px;padding: 10px 5px;border: 1px #CCCCCC solid;'><br /><br /></div><p style='text-align:center;padding-bottom:15px'><input type='button' onclick='SaveSafePass()' value='确 定' class='showBtn' /> <input type='button' onclick='popup.ibClose()' value='取 消' class='showBtn' /> </p>";
  popup.clearData();
  popup.isHeader = 1;
  popup.isMessageTip = 0;
  popup.drag = 1;
  popup.mask = 2;
  popup.isFilter = 1;
  popup.headerTitle = "设置保护密码";
  popup.W = 450;
  popup.H = 1;
  popup.bodyHtml = str;
  popup.creatDiv();
}
function showPasswordTip2() {
  popup.clearData();
  popup.isHeader = 1;
  popup.isMessageTip = 0;
  popup.drag = 1;
  popup.mask = 2;
  popup.isFilter = 1;
  popup.headerTitle = "解锁";
  popup.W = 350;
  popup.H = 1;
  var strText= "请输入保护密码，解锁后才能继续操作";
  var strActionText= "解 锁";
  if(strPasswordAction=="")
  {
    strText="请输入保护密码解锁"
  }
  if(AccountLockStatus=="1" && strPasswordAction=="")
  {
    strText= "请输入保护密码锁定帐号，未解锁状态不能查看简历联系方式及下载简历、修改\删除职位、删除应聘简历、重置用户名密码、修改企业\用户信息。";
    popup.W = 370;
    strActionText= "锁 定";
  }
  popup.headerTitle = strActionText.replace(' ','');
  var str = "<div style='padding:20px;text-align:left'><span style='font-size:14px;font-family:\"Microsoft YaHei\";'>　　"+strText+"</span><br /><br /><input type='password' id='txtSafePass' maxlength='6' style='width: 200px;height: 14px;padding: 10px 5px;border: 1px #CCCCCC solid;margin-left:30px'><br /><br /><a href='http://www.shoudurc.com/company/sys/GetSafePassword' target='_blank' style='float: right;margin-right: 41px;'>忘记密码？</a><br /><br /></div><p style='text-align:center;padding-bottom:15px'><input type='button' onclick='CheckSafePass()' value='"+strActionText+"' class='showBtn' />&nbsp; <input type='button' onclick='popup.ibClose()' value='取 消' class='showBtn' /> </p>";

  popup.bodyHtml = str;
  popup.creatDiv();
}
function CheckSafePass(type)
{  var passwordObj = document.getElementById("txtSafePass")
  if(type)
  {
    if(type==2)
    {
      passwordObj = document.getElementById("txtSafePass2")
    }
    strPasswordAction="AjaxReloadCvView()";
    
  }
  var strPassText = passwordObj.value;
  if(strPassText.length!=6 || isNaN(strPassText))
  {
    alert("保护密码格式错误，请输入6位数字");  
    passwordObj.focus();
    return;
  }
  
  sAjax("post","/company/ca/AjaxCheckSecondPassword","Password="+strPassText,
    function(obj){
      if(isNaN(obj.responseText))
      {
        if(obj.responseText=="保护密码输入错误")
          passwordObj.focus();
        alert(obj.responseText);          
      }
      else if(obj.responseText!="-101")
      {
        if(AccountLockStatus!="1" || strPasswordAction!="")
        {
          AccountLockStatus="1";
          if(document.getElementById("imgHeadLock"))
          {
            document.getElementById("imgHeadLock").src="../images/UnLock.png"/*tpa=http://www.shoudurc.com/Content/company/images/UnLock.png*/          
          }
          popup.ibClose();        
          eval(strPasswordAction);  
        }
        else
        {
          AccountLockStatus="0";
          if(document.getElementById("imgHeadLock"))
          {
            document.getElementById("imgHeadLock").src="../images/Lock.png"/*tpa=http://www.shoudurc.com/Content/company/images/Lock.png*/
          }
          popup.ibClose();                  
        }
      }
      else
      {
        alert("登录超时，请重新登录");  
        popup.ibClose();
      }      
    }
  ,true);
}
function SaveSafePass()
{  
  var strPassText = document.getElementById("txtSafePassword").value;
  
  if(strPassText.length!=6 || isNaN(strPassText))
  {
    alert("密码格式错误，请输入6位数字");  
    document.getElementById("txtSafePassword").focus();
    return;
  }
  if(strPassText=="123456" || strPassText=="012345" || strPassText=="987654" || strPassText=="098765" || strPassText.split(strPassText.substr(0,1)).length==7)
  {
    alert("密码过于简单，请重新输入");  
    document.getElementById("txtSafePassword").focus();
    return;    
  }
  if(strPassText!=document.getElementById("txtSafePasswordConfirm").value)
  {
    alert("两次密码输入不一致");  
    document.getElementById("txtSafePassword").focus();
    return;    
  }
  
  sAjax("post","/company/ca/AjaxSaveSecondPassword","Password="+strPassText,
    function(obj){
      if(isNaN(obj.responseText))
      {
        alert(obj.responseText);          
      }
      else if(obj.responseText!="-101")
      {
        alert("设置成功");
        AccountLockStatus="1";
        if(document.getElementById("imgHeadLock"))
        {
          document.getElementById("imgHeadLock").src="../images/UnLock.png"/*tpa=http://www.shoudurc.com/Content/company/images/UnLock.png*/
          document.getElementById("imgHeadLock").style.display="block";          
          if(document.getElementById("btnUserLock"))
            document.getElementById("btnUserLock").style.display="none";
        }
        popup.ibClose();        
        eval(strPasswordAction);  
      }
      else
      {
        alert("登录超时，请重新登录");  
        popup.ibClose();
      }      
    }
  ,true);
}
function AjaxReloadCvView()
{
  var jobid="";
  if(_("showJobID")!=null)
  {
    jobid = _("showJobID").value;
  }
  Ajax("POST", "/Company/resume/ajaxGetCvInfo", "JobID="+jobid+"&cvMainID=" + _("showCvMainID").value + "&isEng=" + IsEng, AjaxReloadCvViewCallback, false)
}
function AjaxReloadCvViewCallback(obj) {
  eval(obj.responseText);
  SetDivText(_("showCvMainID").value);
  clearCvText();
}