/*
*弹出层的公共Jquery 插件
*创建日期：2018-05-23
*创建人：Peter
*默认关联样式<link href="../Styles/popup.css"/*tpa=http://www.shoudurc.com/Content/2018/Public/Styles/popup.css*/ rel="stylesheet" type="text/css" />
*请每次修改后按照如下格式添加注释信息
*修改日期：xxxx-xx-xx
*修改人：xxx
*修改内容：xxxx
*
*
*/

; (function($) {
  /*
    *选择弹出层
    *使用方式：$("#xxx").showSelect({参数});
    *选择结果：会直接在选择的控件上加一个参数：selVal=选择项ID  然后选择控件的展示信息为选择项的内容。
    *参数：
    *intWidth：弹出层的宽度是否自适应最长的，可选参数：
    0：与控件宽度保持一致，超出显示…。 默认值
    >0：指定宽度，宽度会按照此数值，超出宽度显示… 
    *intColCnt:内部选项列数，可选参数：可以通过控件设置selcol参数设置
    1：单列显示。 默认值
    >0：多列显示，单列宽度为总宽度/列数，超出宽度显示…
    *isNecessary:该项是否必选，可选参数：
    0：非必选，会在弹出层最上方添加一个“请选择”，选择结果为-1  
    1：必选，没有“请选择” 选项  默认值
    *strArrData：弹出层选项内容js的参数名，注：字符串类型  参数对应JSON对象，无需传JSON，默认值为控件上取arrData的内容
    *strClass:额外的样式Class，默认Class为popupSelect 注：popupSelect长在，如果有该参数则附加额外的Class
    *selFun:选择结束后继续执行的方法 
    *
    */
  $.fn.showSelect = function(options) {
    var popupSelect = new PopupSelect(this, options);
    popupSelect.init();
  }

  var PopupSelect = function(ele, opt) { //构造函数
    this.$ele = ele,
    this.defaults = {
      arrData: [],
      intWidth: 0,
      intColCnt: 1,
      isNecessary: true,
      strArrData: this.$ele.attr('arrData'),
      strClass: '',
      selFun: function() {},
			postUrl:'',
			isAnim:true
    },
    this.options = $.extend({},
    this.defaults, opt);
    if (typeof(this.options.strArrData) != 'undefined' && this.options.strArrData.length > 0) {
      this.options.arrData = eval(this.options.strArrData);
    }
		var intColCnt=1;
		if(typeof(this.$ele.attr('selcol'))!='undefined' && this.options.intColCnt==1){
			if(parseInt(this.$ele.attr('selcol'))>1){
				intColCnt=parseInt(this.$ele.attr('selcol'));
			}
		}
		if(typeof(this.$ele.attr('selwidth'))!='undefined' && this.options.intWidth==0){
			if(parseInt(this.$ele.attr('selwidth'))>0){
				this.options.intWidth=parseInt(this.$ele.attr('selwidth'));
			}
		}
		if(typeof(this.$ele.attr('required'))=='undefined'){
			this.options.isNecessary=false;
		}
		this.options.intColCnt=intColCnt;
  }

  PopupSelect.prototype = {
		init:function(){
			if ($('#' + this.$ele.attr("id") + "Popup").is(":visible")) {
        return;
      }
			if(this.options.arrData.length==0){
				if(this.options.postUrl.length>0){
					this.options.isAnim=false;
					this.addTextChnagerLister();
					return;
				}else{
					return;
				}
			}
			this.show();
		},
    show: function() { //显示弹出层
      
      this.hide(); //隐藏其他弹出层
      var divMain = $('<div class="popupSelect"></div>'); //构建最外层弹出层
			this.$divMain=divMain;
      divMain.attr("id", this.$ele.attr("id") + "Popup");
      if (this.options.strClass.length > 0) { //有自定样式，额外添加
        divMain.addClass(this.options.strClass);
      }
      var intWidth = 0;
      if (this.options.intWidth == 0) { //与依附控件等宽
        intWidth = this.$ele.outerWidth();
      } else if (this.options.intWidth > 0) { //设定宽度
        intWidth = this.options.intWidth;
      }
      if (intWidth > 0) {
        divMain.width(intWidth - 2); //预留边框宽度
      }
      var ulMain=this.buildHtml();
      divMain.css('left', this.$ele.offset().left + 'px'); //定位到触发控件的下方
      divMain.css('top', (this.$ele.offset().top + this.$ele.outerHeight()) + 'px');
			ulMain.appendTo(divMain);
      divMain.appendTo($('body'));
			
      var bottomHeight = $(document).scrollTop() + $(window).height() - this.$ele.offset().top - this.$ele.outerHeight(); //获取控件底部距离屏幕显示底部高度
      if (bottomHeight < divMain.outerHeight()) { //底部高度不如弹出层高度高  则向上溢出。
        divMain.css('top', ($(document).scrollTop() + $(window).height() - divMain.outerHeight()) + 'px')
      }
			if(this.options.arrData.length==0){
				return;
			}
			if(this.options.isAnim){
				$('.popupSelect').slideDown('fast');
			}else{
				$('.popupSelect').show();
			}
      
    },
		addTextChnagerLister:function(){
			var that = this;
			that.$ele.on('keyup', function() {
				if($.trim(that.$ele.val()).length==0){
					that.hide();
					return;
				}
				$.post(that.options.postUrl,{
					keyword:that.$ele.val()
				},function(data){
					that.options.arrData=eval(data);
					that.show();
				});
			});
		},
		buildHtml:function(){
			var ulMain = $('<ul></ul>');
      if (this.options.isNecessary == 0 && this.options.arrData[0].value != '' && location.href.toLowerCase().indexOf("/cv/index")>-1) {
        var dataEmpty = {
          'value': '',
          'text': '请选择',
          'children': []
        };
        this.options.arrData.unshift(dataEmpty);
      }
      for (var i = 0; i < this.options.arrData.length; i++) { //遍历子元素
        var item = this.options.arrData[i].text;
        var itemID = this.options.arrData[i].value;
        var liItem = $('<li></li>');
        liItem.html(item);
        liItem.attr("selID", itemID);
        if (itemID == this.$ele.attr('selVal')) { //选中值
          liItem.addClass('Selected');
        }
        var intWidth = 0;
        if (this.options.intColCnt > 1) { //显示列数
          intWidth = this.$divMain.width() / this.options.intColCnt;
        } else {
          intWidth = this.$divMain.width();
        }
        liItem.width(intWidth - 8); //减去padding值
        var thisPopup = this;
        liItem.click( //点击保存
        function() {
          thisPopup.save($(this).attr('selID'), $(this).html());
        });
        liItem.appendTo(ulMain);
      }
			return ulMain;
		},
    hide: function() { //隐藏选择层
      $('.popupSelect').remove();
		},
    slideHide: function() {
      $('.popupSelect').slideUp('fast',
      function() {
        $('.popupSelect').remove();
      });
    },
    save: function(id, value) { //保存点击内容
      //var inputHid=$('<input type="hidden" id="id'+this.$ele.attr('id')+'" />')
      this.$ele.attr('selVal', id);
			if(value=="请选择"){
				value="";
			}
      if (this.$ele.is('input')) {
        this.$ele.val(value);
      } else {
        this.$ele.html(value); 
      }
			this.$ele.addClass("InputMode").removeClass("Error");
      this.options.selFun();
      this.slideHide();
    }
  }
  $.alert = function(options) {
		options.cancelText='';
		
		var popupWin = new PopupWin(options);
		popupWin.init();
		return popupWin;
	}
  $.confirm = function(options) {
    var popupWin = new PopupWin(options);
    popupWin.init();
		return popupWin;
  }
  $.notice = function(options) {
    console.log("notice");
  }
  $.dialog = function(options) {
		options.confirmText='';
		options.cancelText='';
		var popupWin = new PopupWin(options);
    popupWin.init();
		return popupWin;
  }
	$.birthdayPicker =function(options){
		options.confirmText='';
		options.cancelText='';
		options.intWidth = 0;
		options.intHeight = 0;
		
		var popupWin = new PopupWin(options);
		popupWin.init();
		return popupWin;
	}
	$.toastNotice=function(strContent){
		
		if(IEVersion()>=6 &&IEVersion()<=8) 
		{ 
			alert(strContent);
			return;
		}else{
			$.toast(strContent);
		}
	}
	$.toastError=function(strContent){
		if(IEVersion()>=6 &&IEVersion()<=8) 
		{ 
			alert(strContent);
			return;
		}else{
			$.toast({text:strContent,icon:'error',heading:'错误'});
		}
	}
	
	function IEVersion() {
		var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串  
		var isIE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1; //判断是否IE<11浏览器  
		var isEdge = userAgent.indexOf("Edge") > -1 && !isIE; //判断是否IE的Edge浏览器  
		var isIE11 = userAgent.indexOf('Trident') > -1 && userAgent.indexOf("rv:11.0") > -1;
		if(isIE) {
			var reIE = new RegExp("MSIE (\\d+\\.\\d+);");
			reIE.test(userAgent);
			var fIEVersion = parseFloat(RegExp["$1"]);
			if(fIEVersion == 7) {
				return 7;
			} else if(fIEVersion == 8) {
				return 8;
			} else if(fIEVersion == 9) {
				return 9;
			} else if(fIEVersion == 10) {
				return 10;
			} else {
				return 6;//IE版本<=7
			}   
		} else if(isEdge) {
			return 99;//edge
		} else if(isIE11) {
			return 11; //IE11  
		}else{
			return -1;//不是ie浏览器
		}
}
  /*
    *消息弹出层
    *参数：
    *title：标题栏显示，此项有值，则显示标题栏：
    *content: 内容，提示显示信息
    *contentHtml: 内部HTML 如果有content 则此项不起作用
    *isShowClose: 是否显示关闭 默认：1
    *intWidth:弹层宽度 默认：450
    *intHeight：弹层高度 默认：220
    *intMask：是否显示遮罩 默认：1
    *isHideAble：点击空白是否可被关闭 默认1
    *confirmText：确认按钮显示文字。默认确定
    *confirmClass：确认按钮的样式 额外添加
    *confirmFun：确认按钮点击触发事件
    *cancelText：取消按钮显示文字。默认取消
    *cancelClass：取消按钮样式，额外添加
    *cancelFun：取消按钮点击事件
    *isMultible：是否可多窗口同时显示 默认0 1则不会关闭以前打开的窗口
    *animation：弹窗打开动画 默认scale 扩大打开 具体其他动画可翻阅popup.css 198行
    *closeAnimation：弹窗关闭动画 默认scale 缩小关闭，具体其他动画可翻阅popup.css 198行
    *animationSpeed：动画速度，数字越小越快 默认值：500
    *animationBounce：回弹动画比例
    *className：弹窗样式，额外添加
    *
    */
  var PopupWin = function(opt) { //构造函数
    this.defaults = {
      title: '',
      content: '',
      contentHtml: '',
      isShowClose: 1,
      intWidth: 450,
      intHeight: 220,
      intMask: 1,
      isHideAble: 1,
      confirmText: '确定',
      confirmClass: '',
      confirmFun: function() {},
      cancelText: '取消',
      cancelClass: '',
      cancelFun: function() {},
      isMultible: 0,
      animation: 'scale',
      closeAnimation: 'scale',
      animationSpeed: 500,
      animationBounce: 1.2,
      className: '',
			dockObjId:'',
			closeFun:function() {},
			isConfirmClose:1,
			hideFun:function(){}
    },
    this.options = $.extend({},
    this.defaults, opt);
  }

  PopupWin.prototype = {
    show: function() { //显示
      var that = this;
      if (this.isClosed()) {
        return false;
      }
      that.$ele.find('.popupBg').addClass('seen'); //显示北京
      this.$b.removeClass(this.options.animation);
      setTimeout(function() {
        that.$b.css({
          'transition-property': that.$b.css('transition-property') + ', margin'
        });
        that._modalReady.resolve();
      },
      this.options.animationSpeed);
      this._lastFocused = $('body').find(':focus');
      return true;

    },
    hide: function() { //隐藏
      var that = this;
      if (this.isClosed()) {
        return false;
      }
      that.$ele.find('.popupBg').removeClass('seen');
      this.$b.addClass(this.options.closeAnimation);
      var closeTimer = (this.options.closeAnimation == 'anim-none') ? 0 : this.options.animationSpeed;
			that.options.closeFun();
      setTimeout(function() {
        that.$ele.remove();
      },
      closeTimer * 25 / 100);
      that._lastFocused.focus();
			
      return true;
    },
    init: function() { //初始化
			if(this.options.isMultible==0 && $(".popupMain").length>0){
				$(".popupMain").remove();
			}
      var that = this;
      this.buildFrame();
      this.buildEvents();
      setTimeout(function() {
        that.show();
      },
      0);
    },
    buildFrame: function() { //框架搭建
      var that = this;
      this.options.animation = 'anim-' + this.options.animation.toLowerCase();
      this.options.closeAnimation = 'anim-' + this.options.closeAnimation.toLowerCase();
      if (this.options.animation == 'anim-none') {
        this.options.animationSpeed = 0;
      }
			this.$ele = $('<div class="popupMain"><div class="popupBg"></div><div class="popupMask"><div class="popupBody"></div></div></div>');
			if(this.options.intMask==0){
				this.$ele.find(".popupMask").addClass("Hide");
			}
      
      var pLeft = ($(window).width() - this.options.intWidth - 14) / 2; //弹窗定位
			var pTop = ($(window).height() - this.options.intHeight - 14) / 2;
			if(this.options.intHeight==0){
				pTop=pTop-200;
			}
			if(this.options.dockObjId.length>0){
				pLeft=$("#"+this.options.dockObjId).offset().left;
				pTop=$("#"+this.options.dockObjId).offset().top+$("#"+this.options.dockObjId).outerHeight();
			}
      this.$ele.find(".popupMask").css('left', pLeft + 'px');
      this.$ele.find(".popupMask").css('top', pTop + 'px');
      this.$b = this.$ele.find(".popupMask").css(this.getCSS(this.options.animationSpeed, this.options.animationBounce)).addClass(this.options.animation);
      if (this.options.className.length > 0) {
        this.$ele.addClass(this.options.className);
      }
			this._contentReady = $.Deferred();
      this._modalReady = $.Deferred();
      this.$ele.find(".popupBody").append(this.initHeader());
      this.$ele.find(".popupBody").append(this.initBody());
      this.$ele.find(".popupBody").append(this.initBtn());
			this.$ele.find(".popupBody").width(this.options.intWidth);
			if(this.options.intHeight>0){
				this.$ele.find(".popupBody").height(this.options.intHeight);
				if ((this.options.confirmText + this.options.cancelText).length > 0){
      		this.$ele.find(".popupContent").height(this.options.intHeight - 32 - 60);
				}else if(this.options.title.length > 0){
					this.$ele.find(".popupContent").height(this.options.intHeight - 32); 
				}else{
					this.$ele.find(".popupContent").height(this.options.intHeight);
				}
			}
      this.$ele.appendTo($('body'));

    },
    initBody: function() { //初始化窗体内容
      var $content = $('<div class="popupContent"></div>');
      if (this.options.content.length > 0) {
        var pContent = $('<p class="pContent">' + this.options.content + '</p>');

        $content.append(pContent);
      } else if (this.options.contentHtml.length > 0) {
        $content.append($(this.options.contentHtml));
      }
      this.$content = $content;
      return $content;
    },
    initHeader: function() { //初始化头部信息
      if (this.options.title.length > 0) {
        var $header = $('<div class="popupHeader"></div>');
        $header.append($('<h1>' + this.options.title + '</h1>'));
        if (this.options.isShowClose == 1) { //是否显示关闭按钮
          $header.append($('<span class="spClose"></span>'));
        }
        this.$header = $header;
        return $header;
      } else {
        if (this.options.isShowClose == 1) { //是否显示关闭按钮
          return $('<span class="spClose bodyClose"></span>');
        } else {
          return $('');
        }
      }

    },
    initBtn: function() { //初始化按钮区域
      if ((this.options.confirmText + this.options.cancelText).length > 0) {
        var $btnArea = $('<div class="popupBtnArea"></div>');
        var $btnConfrim;
        var $btnCancel;
        if (this.options.confirmText.length > 0) {
          $btnConfrim = $('<input type="button" class="btnConfirm popupBtn" value="' + this.options.confirmText + '" />');
          if (this.options.confirmClass.length > 0) {
            $btnConfrim.addClass(this.options.confirmClass);
          }
          $btnArea.append($btnConfrim);
        }
        if (this.options.cancelText.length > 0) { //如果放弃按钮上无文字，不添加
          $btnCancel = $('<input type="button" class="btnCancel popupBtn" value="' + this.options.cancelText + '" />');
          if (this.options.cancelClass.length > 0) {
            $btnCancel.addClass(this.options.cancelClass);
          }
          $btnArea.append($btnCancel);
        }else{
					$btnConfrim.css("margin-left","70px");
				}
        this.$btnArea = $btnArea;
        return $btnArea;
      } else {
        return $('');
      }
    },
    buildEvents: function() { //点击事件以及其他事件
      var that = this;
      that.$ele.find('.spClose').click(function(event) {
        that.hide();
		  $("#popupCareerstatusPopup").remove();
				event.stopPropagation();
      });
      that.$ele.find('.btnCancel').click(function() {
				that.options.cancelFun();
        that.hide();
      });
			that.$ele.find('.btnConfirm').click(function() {
				that.options.confirmFun();
				if(that.options.isConfirmClose==1){
					that.hide();
				}
      });
			
			
      that.$ele.find('.popupHeader').mousedown( //标题拖动
      function(event) {
        if (event.button == 0) { //左键
					that.$dragX = event.clientX - that.$ele.find('.popupMask').offset().left;
          that.$dragY = event.clientY - that.$ele.find('.popupMask').offset().top+$(document).scrollTop();
          $(document).bind('mousemove', dragMove);
          $(document).bind('mouseup', dragStop);
        }

      });
			that.options.hideFun=function(){
				that.hide();
			}
			if(that.options.isHideAble==1){
				that.$ele.find(".popupBg").click(
					function(){
						that.hide();
					}
				);
			}
			
			
      function dragMove(event) {
				var dragX = event.clientX - that.$dragX;
        var dragY = event.clientY - that.$dragY;
        if (dragX < 0) { //超出屏幕左侧
          dragX = 0;
        }
        if (dragY < 0) { //超出屏幕右侧
          dragY = 0;
        }
        if (event.clientX - that.$dragX > $(window).width() - that.$ele.find('.popupMask').outerWidth()) { //超出屏幕底部 ,限定在屏幕底部
          dragX = $(window).width() - that.$ele.find('.popupMask').outerWidth(); //
        }
        if (event.clientY - that.$dragY > $(window).height() - that.$ele.find('.popupMask').outerHeight()) { //超出屏幕右侧,限定在屏幕右侧
          dragY = $(window).height() - that.$ele.find('.popupMask').outerHeight();
        }
				if(event.clientX)

        that.$ele.find('.popupMask').css({ //窗体移动的同时 背景也同时移动
          'left': dragX + 'px',
          'top': dragY + 'px'
        });
        return false;
      }
      function dragStop() { //松开鼠标去掉所有相关事件
        $(document).unbind('mousemove', dragMove);
        $(document).unbind('mouseup', dragStop);
        return false;
      }
		
    },
    isClosed: function() { //判断当前窗口是不是关闭状态
      return this.$ele.css('display') === '';
    },
    getCSS: function(speed, bounce) { //CSS3缩放动画
      return {
        '-webkit-transition-duration': speed / 1000 + 's',
        'transition-duration': speed / 1000 + 's',
        '-webkit-transition-timing-function': 'cubic-bezier(.36,1.1,.2, ' + bounce + ')',
        'transition-timing-function': 'cubic-bezier(.36,1.1,.2, ' + bounce + ')'
      };
    },
		showPopupMask:function(){
			var divPopMask=$('<div class="divMask"></div>');
			divPopMask.addClass('divPopup');
			divPopMask.css('background','url(/Content/Perosnal/Images/img_personalcvmain.png) 0px -1049px no-repeat #FFFF;');
			divPopMask.animate("widht")
			$('body').append(divPopMask);
		}
  }
})(jQuery);

$(function() {
  $("body").click(function() {
    $('.popupSelect').slideUp('fast',
    function() {
      $('.popupSelect').remove();
    });
  });
});