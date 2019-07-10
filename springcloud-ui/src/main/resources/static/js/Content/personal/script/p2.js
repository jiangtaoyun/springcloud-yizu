var popup2 = {
  drag: 1,
  isHeader: 1,
  divClass: "popup",
  W: 0,
  H: 0,
  bodyHtml: "",
  headerTitle: "",
  mask: 1,
  dockObj: "",
  dockLeft: 0,
  dockTop: 0,
  keepLeft: 0,
  Overstep: 0,
  canClose: 1,
  isFilter: 0,                   //弹出层是否可以超出屏幕下边 默认为0不可以，1 为可以，
  construct: function (W, H, bodyHtml, headerTitle, dockObj, mask) {
    this.clearData();
    if (bodyHtml == "undefined" || bodyHtml == "") { bodyHtml = "" }
    if (headerTitle == "undefined" || bodyHtml == "") { headerTitle = "" }
    if (dockObj == null || dockObj == "undefined" || dockObj == "") { dockObj = "" };
    if (mask == null || mask == undefined) { mask = 0; }
    this.W = W;
    this.H = H;
    this.bodyHtml = bodyHtml;
    this.headerTitle = headerTitle;
    this.dockObj = dockObj;
    this.mask = mask;
    this.creatDiv();
  },
  creatDiv: function () {
    if (_("msg2")) {
      this.ibClose();
    }
    var objID = "msg2";
    var obj = document.createElement("div");
    var objHead = document.createElement("div");
    var objBody = document.createElement("div");
    obj.id = objID;
    objHead.id = objID + "_head";
    objBody.id = objID + "_body";
    obj.style.top = "0px";
    obj.className = this.divClass;
    objHead.className = "popuphead";
    objBody.className = "popupBody";
    obj.appendChild(objHead);
    obj.appendChild(objBody);
    document.body.appendChild(obj);
    var closeBtn = objID + "closeBtn";
    objBody.innerHTML = this.bodyHtml;
    objHead.style.cursor = "move";
    objHead.innerHTML = '<h1 style="width:' + (this.W - 60) + 'px; font-weight:normal;">' + this.headerTitle + '</h1><div id=' + closeBtn + ' class="closeBtn" onmouseover="$(this).attr(\'class\',\'closeBtnOver\')" onmouseout="$(this).attr(\'class\',\'closeBtn\')" />';
    //js样式设置
    if (this.W == undefined || this.W < 0 || this.W == "") { this.W = obj.clientWidth; }
    if (this.H == undefined || this.H < 0 || this.H == "") { this.H = obj.clientHeight; }
    if (this.W != 'auto') {
      objBody.style.width = obj.style.width = this.W + "px";
    }
    if (this.H > 10) obj.style.height = this.H + "px";
    obj.style.minHeight = 16 + "px";
    obj.style.cssText += ";position:absolute;z-index:99;";
    //如果没有依靠对象
    if (this.dockObj == "" || this.dockObj == undefined) {
      var clientHeight = obj.style.height.replace("px", "");
      if (clientHeight == null || clientHeight == "" || clientHeight == "undefined") { clientHeight = this.H; };
      var relTop = (document.documentElement.clientHeight - clientHeight) / 2 > 0 ? (document.documentElement.clientHeight - clientHeight) / 4 : 0;
      var objTop = parseInt(document.documentElement.scrollTop + document.body.scrollTop + relTop) + 'px';
      var objLeft = parseInt(document.documentElement.scrollLeft + (document.documentElement.clientWidth - this.W) / 2) + 'px';
      obj.style.left = objLeft;
      obj.style.top = objTop;
    }
    else {
      var tempObj = this.dockObj;
      while (tempObj = tempObj.parentElement) {
        if (tempObj.id == "ContentText") {
          this.dockTop = this.dockTop - document.getElementById("ContentText").scrollTop;
          break;
        }
      }
      var dockObj = this.dockObj;
      var x = dockObj.offsetLeft + this.dockLeft;
      while (dockObj = dockObj.offsetParent) x += dockObj.offsetLeft;
      var maxWidth = document.body.clientWidth;
      if (maxWidth < 800)
        maxWidth = 800;
      var maxLEft = maxWidth - this.keepLeft;
      if (x > maxLEft) { x = maxLEft }
      if (x < this.keepLeft) { x = this.keepLeft; }

      dockObj = this.dockObj;
      var y = dockObj.offsetTop;
      while (dockObj = dockObj.offsetParent) { y += dockObj.offsetTop; }
      try {
        obj.style.left = Math.max(x, 0) + "px";
      }
      catch (e) { }
      obj.style.left = $(this.dockObj).offset().left + "px";
      obj.style.top = y + this.dockTop + this.dockObj.clientHeight + "px";
      obj.style.top = ($(this.dockObj).offset().top + $(this.dockObj).height()) + "px";
      var clientHeight = obj.clientHeight;
      var styleTop = parseInt(y + this.dockTop + this.dockObj.clientHeight);
      var curScrollHeight = document.documentElement.scrollTop + document.body.scrollTop + document.documentElement.clientHeight;
      var clientWidth = obj.clientWidth;
      var styleLeft = parseInt(obj.style.left.substring(0, obj.style.left.length - 2));
      var curScrollWidth = document.documentElement.scrollLeft + document.documentElement.clientWidth;
      if (clientHeight + styleTop > curScrollHeight && this.Overstep == 0) {
        obj.style.top = Math.max((curScrollHeight - clientHeight - 5), 0) + 'px';
      }
      if (clientWidth + styleLeft > curScrollWidth)
        obj.style.left = Math.max((curScrollWidth - clientWidth - 25), 0) + 'px';
    }
    //是否创建遮罩层
    if (this.mask) {
      var objMask = document.createElement("div");
      objMask.id = "Mask2";
      if (this.mask > 2)
        objMask.style.cssText = "height:100%;width:100%;left:0; top:0; background:#000;opacity:0.0;filter:alpha(opacity=0)";
      else
        objMask.style.cssText = "height:100%;width:100%;left:0; top:0; background:#000;opacity:0.3;filter:alpha(opacity=30);";
      document.body.appendChild(objMask);
      objMask.style.cssText += ";position:absolute;z-index:50;";
      objMask.style.height = Math.max(document.body.scrollHeight, document.documentElement.scrollHeight) - 10 + "px";
      if (this.mask == 1 || this.mask == 3) { objMask.onclick = this.ibClose; }
    }
    _(closeBtn).onclick = this.ibClose; ; //关闭按钮
    //拖动功能	
    var w = obj.scrollWidth, h = obj.scrollHeight;
    var moveX = 0, moveY = 0, moveTop = 0, moveLeft = 0, moveable = false;
    var bodyH = this.H;
    if (this.drag == 1 && this.isHeader == 1)
      objHead.onmousedown = function (e) {
        e = window.event ? window.event : e;
        var e = e ? e : event;
        var mouseD = document.all ? 1 : 0;
        if (e.button == mouseD) {
          oDrag = obj;
          fDrag = document.getElementById('msg2_filter');
          ox = e.clientX;
          oy = e.clientY;
        }
      }
    else
      objHead.style.cursor = "default";
    if (this.isHeader != 1)
      obj.removeChild(objHead);
    if (this.canClose == 0)
      objHead.removeChild(_(closeBtn));
    function _(name) {
      return document.getElementById(name);
    }
    if (this.isFilter == 1) {
      var objFilter = document.createElement("div");
      objFilter.id = objID + "_filter";
      document.body.appendChild(objFilter);
      objFilter.style.cssText += "opacity:0.3;filter: alpha(opacity=30); position: absolute; z-index: 90; min-height: 100px; top: 0px; background-image: none; background-attachment: scroll; background-repeat: repeat; background-position-x: 0%; background-position-y: 0%; background-color: rgb(0, 0, 0);";
      objFilter.style.width = obj.offsetWidth + 20 + 'px';
      objFilter.style.height = obj.offsetHeight + 20 + 'px';
      objFilter.style.left = obj.offsetLeft - 10 + 'px';
      objFilter.style.top = obj.offsetTop - 10 + 'px';
    }
  },
  beforeClose: function () { },
  afterClose: function () { },
  ibClose: function () {
    popup2.beforeClose();
    var objMask = document.getElementById("Mask2");
    if (document.getElementById("msg2_head")) {
      document.getElementById("msg2_head").onmousemove = null;
      document.getElementById("msg2_head").onmousedown = null;
      document.getElementById("msg2_head").onmouseup = null;
      document.getElementById("msg2").removeChild(document.getElementById("msg2_head"));
    }

    if (document.getElementById("popupIframe"))
      document.body.removeChild(document.getElementById("popupIframe"));
    if (objMask)
      document.body.removeChild(objMask);
    if (document.getElementById('calendar'))
      _('calendar').style.display = 'none';
    if (document.getElementById('calendar_year'))
      _('calendar_year').style.display = 'none';
    if (document.getElementById('calendar_month'))
      _('calendar_month').style.display = 'none';
    if (document.getElementById("msg2_filter")) {
      document.body.removeChild(document.getElementById("msg2_filter"));
      popup2.isFilter = 0;
    }
    if (document.getElementById("msg2")) {
      document.body.removeChild(document.getElementById("msg2"));
    }
    popup2.afterClose();
    //popup2.clearData();
  },
  clearData: function () {
    this.drag = 1;
    this.isHeader = 1;
    this.divClass = "popup";
    this.W = 0;
    this.H = 0;
    this.bodyHtml = "梧桐果";
    this.headerTitle = "";
    this.mask = 1;
    this.dockObj = "";
    this.dockLeft = 0;
    this.dockTop = 0;
    this.keepLeft = 0;
    this.beforeClose = function () { }
    this.afterClose = function () { }
    if (window.addEventListener)
      document.removeEventListener("click", popup2.HideMessageTip, false);
    else
      document.detachEvent("onclick", popup2.HideMessageTip);
  },
  HideMessageTip: function (e) {
    var Element = arguments[0].target || event.srcElement;
    if (Element != popup2.dockObj) {
      popup2.ibClose();
      if (window.addEventListener)
        document.removeEventListener("click", popup2.HideMessageTip, false);
      else
        document.detachEvent("onclick", popup2.HideMessageTip);
    }
  },
  ResetPopPostion:function(){
	  var obj=document.getElementById('msg2');
	  var clientHeight = obj.style.height.replace("px", "");
      if (clientHeight == null || clientHeight == "" || clientHeight == "undefined") { clientHeight = this.H; };
      var relTop = (document.documentElement.clientHeight - clientHeight) / 2 > 0 ? (document.documentElement.clientHeight - clientHeight) / 4 : 0;
      var objTop = parseInt(document.documentElement.scrollTop + document.body.scrollTop + relTop) + 'px';
      var objLeft = parseInt(document.documentElement.scrollLeft + (document.documentElement.clientWidth - obj.style.width.replace("px", "")) / 2) + 'px';
      obj.style.left = objLeft;
      obj.style.top = objTop;
	  var objFilter=document.getElementById('msg2_filter');
	  objFilter.style.left = obj.offsetLeft - 10 + 'px';
      objFilter.style.top = obj.offsetTop - 10 + 'px';
  }
}