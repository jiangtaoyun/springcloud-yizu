function Ajax(method,url,parm,callback,bool){
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