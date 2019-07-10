var MajorSelect = {
    newSelect: function (inum) {
        var majorSelect = {};
        majorSelect._arrID = "jsMajorID";
        majorSelect._aNa = "jsMajor";
        var aId = jsMajorID;
        var aNa = jsMajor;
        var majorId = "";
        if (inum != null)
            majorId = $("#iddcMajorID" + inum).val();
        else {
            majorId = $("#iddcMajorID").val();
            if (majorId == null) majorId = $("#iddcMajorID1").val();
        }
        majorSelect.GenBodyHtml = function () {
            var objId = BodyClass.objId;
            var category = new Array();
            var arrPos = new Array();
            var level1 = '';
            var level2 = '';
            category = ["工学", "理学", "医学", "农学", "经济学", "管理学", "文史类", "其他"];
            arrPos = [31, 46, 59, 66, 70, 79, 90, 108];
            var strWidth = ' style="overflow: hidden;white-space:nowrap;cursor:pointer;width:85px;';
            var bh = '<div class="DivShow"><div class="DivShowB">';

            for (var j = 0; j < arrPos.length; j++) {
                var sPos = (j > 0 ? arrPos[j - 1] : 0);
                var ePos = arrPos[j];
                bh += '<div class="NDivCl" style="' + (j % 2 == 0 ? "" : "background-color:#fff;") + 'height:' + (2 + Math.ceil((ePos - sPos) / 7) * 25) + 'px; line-height:' + (Math.ceil((ePos - sPos) / 7) * 25 + 2) + 'px;">\n';
                bh += '<div class="NDivClBig" style="width:70px">' + category[j] + '</div>\n';
                bh += '<div class="NDivClSmall" style="width:664px;padding-top:2px;"><ul>\n';
                for (i = sPos; i < ePos; i++) {
                    var _LiIdNi = objId + i;
                    if (location.pathname.indexOf("/Company") == 0)
                        bh += '<li' + strWidth + (aId[i] == majorId ? 'color:#f00' : '') + '" id="' + _LiIdNi + '" onMouseOver="this.style.backgroundColor=\'#d3e9ff\'" onMouseOut="this.style.backgroundColor=\'\'" onclick="BodyClass.saveInt(\'' + aId[i] + '\',\'' + aNa[i] + '\',\'' + objId + '\')" title="' + aNa[i] + '">' + aNa[i].substring(0, 7) + '</li>';
                    else
                        bh += '<li' + strWidth + (aId[i] == majorId ? 'color:#f00' : '') + '" id="' + _LiIdNi + '" onMouseOver="this.style.backgroundColor=\'#ffe9d3\'" onMouseOut="this.style.backgroundColor=\'\'" onclick="BodyClass.saveInt(\'' + aId[i] + '\',\'' + aNa[i] + '\',\'' + objId + '\')" title="' + aNa[i] + '">' + aNa[i].substring(0, 7) + '</li>';
                }
                bh += '</ul></div>';
                bh += '</div>';
            }
            bh += '</div><div style="clear:both;"></div></div></div>';
            bh += '<div id="SelectedDiv"><div class="showDivsub" id="popDivSub" onMouseOut="BodyClass.hideSub();"onMouseOver="BodyClass.showSub();" style="float:left;position:absolute;"></div></div>';
            return bh;
        };
        return majorSelect;
    },
    GetSearchItems: function (obj) {
        var keyword = obj.value;
        if (keyword.length == 0) {
            _("popDivSearch").style.display = "none";
            return;
        }
        var parm = "keyword=" + escape(keyword.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/g, ''));
        this.InnerAjax("post", "/common/GetMajorByKeyword", parm, GenJobTypeList, false);
        function GenJobTypeList(obj) {
            var jsonList = obj.responseText;
            if (jsonList.length > 0) {
                var strList = '<ul>';
                jsonList = eval('(' + jsonList + ')');
                var itemNum = 0;
                for (var i = 0; i < jsonList.MajorList.length; i++) {
                    if (this.IsMulti == 0) {
                        if (jsonList.MajorList[i].ID.length == 2) {
                            continue;
                        }
                        strList += '<li onMouseOver="this.style.backgroundColor=\'#ffe9d3\';" onMouseOut="this.style.backgroundColor=\'\';" onClick="BodyClass.saveInt(\'' + jsonList.MajorList[i].ID + '\',\'' + jsonList.MajorList[i].Name + '\',\'' + BodyClass.objId + '\');">' + jsonList.MajorList[i].Name + '</li>';
                    }
                    else {
                        strList += '<li onMouseOver="this.style.background=\'#ffe9d3\';" onMouseOut="this.style.background=\'\';" onClick="BodyClass.saveInt(\'' + jsonList.MajorList[i].ID + '\',\'' + jsonList.MajorList[i].Name + '\',\'' + BodyClass.objId + '\');"><input name="' + jsonList.MajorList[i].ID + '" value="' + jsonList.MajorList[i].Name + '" type="checkbox" onclick="this.checked=!this.checked;" />' + jsonList.MajorList[i].Name + '</li>';
                    }
                    itemNum++;
                    if (itemNum == 9) break;
                }
                //strList += '<li style="color:#999; list-style:none;"><span style="float:left">' + (this.IsMulti == 0 ? '选择合适的职位类别' : '最多选择5项') + '</span><span style="float:right"><img style="margin-top:8px" src="../Homepage/NewIndex/PopupNew/p6.gif"/*tpa=http://www.shoudurc.com/Homepage/NewIndex/PopupNew/p6.gif*/ onclick="_(\'popDivSearch\').style.display = \'none\';" /></span></li></ul>';
                strList += '</ul>';
                _("popDivSearch").innerHTML = strList;
                if (navigator.userAgent.indexOf("IE") > -1) {
                    if (navigator.userAgent.indexOf("IE 9") > -1) {
                        _("popDivSearch").style.marginLeft = "117px";
                    }
                    else {
                        _("popDivSearch").style.marginLeft = "117px";
                    }
                }
                else {
                    _("popDivSearch").style.marginLeft = "117px";
                }
                _("popDivSearch").style.display = "block";
                if (this.IsMulti == 1)
                    BodyClass.changeChecked(BodyClass.objId);
            }
            else {
                _("popDivSearch").innerHTML = '<p style="padding-left:3px; height:25px; line-height:25px; cursor:default">没有相关职位类别</p>';
                _("popDivSearch").style.display = "block";
            }
        }
    },
    InnerAjax: function Ajax(method, url, parm, callback, bool) {
        var xmlHttp = false;
        if (window.ActiveXObject) {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        else if (window.XMLHttpRequest) {
            xmlHttp = new XMLHttpRequest();
        }
        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState == 4) {
                if (xmlHttp.status == 200) {
                    callback(xmlHttp);
                    xmlHttp = null;
                }
                else {
                    document.write(xmlHttp.status + "：" + xmlHttp.responseText);
                }
            }
        }
        xmlHttp.open(method, url, bool);
        xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gb2312");
        xmlHttp.send(parm);
        if (navigator.userAgent.indexOf("Firefox") > 0)
            callback(xmlHttp);
    }

};

function MajorAutoComplete(obj) {
    if ($(obj).val().length > 0) {
        $.ajax({
            type: "GET",
            url: "/Personal/cv/AjaxGetMajor?searchText=" + escape($(obj).val()),
            data: null,
            async: false,
            success: function (data) {
                var array = data.split("\n");
                var li = "";
                var w = obj.clientWidth;
                iKey = 0;
                for (var i = 0; i < array.length; i++) {
                    var strMajor = array[i];
                    if (strMajor.length == 0) { continue; }
                    var strMajorName = strMajor.split("|")[0];
                    var strMajorId = strMajor.split("|")[1];
                    if (strMajorId.length == 0) { continue; }
                    li += "<li id = 'liMajor" + strMajorId + "' style='width:" + (w - 8) + "px;padding:0 4px;line-height:30px;list-style-type:none;cursor:pointer;'>" + strMajorName + "</li>";
                    iKey++;
                }
                if (li.length > 0) {
                    popup.clearData()
                    popup.isHeader = 0;
                    popup.drag = 0;
                    popup.mask = 3;
                    popup.H = 1;
                    popup.divClass = "";
                    popup.W = w;
                    popup.dockObj = obj;
                    popup.dockTop = 2;
                    popup.Overstep = 1;
                    popup.bodyHtml = '<div id="divCollegeName" style="width:' + w + 'px; border:solid #ccc; border-width:0 1px 1px 1px;line-height:20px; background:#fff url(/Images/BgDiv.jpg) repeat-x bottom;filter:alpha(opacity=90); opacity: 0.9; font-family:Arial"><ul id="ulMajorName">' + li + '</ul></div>';
                    popup.creatDiv();
                    var seq = $(obj).attr("id").replace("txtMajorName", "");
                    $("#ulMajorName li").each(function () {
                        $(this).hover(
                            function () { $("#ulCollegeName li").removeClass(); $(this).addClass('Over') },
                            function () { $("#ulCollegeName li").removeClass(); $(this).removeClass() }
                        ).click(function () {
                            $(obj).val($(this).html());
                            MajorFill(this, seq);
                            popup.ibClose();
                        });
                    });
                }
                else { popup.ibClose(); }
            }
        });
    }
    else {
        popup.ibClose();
    }
    var objTarget = $(obj);
    switch (event.keyCode) {
        case 38:
            if (iPos <= 0) { iPos = iKey - 1 } else { iPos-- };
            $("#ulCollegeName li").removeClass();
            $("#ulCollegeName li:eq(" + iPos + ")").addClass("Over");
            break;
        case 40:
            if (iPos >= iKey - 1) { iPos = 0 } else { iPos++ };
            $("#ulCollegeName li").removeClass();
            $("#ulCollegeName li:eq(" + iPos + ")").addClass("Over");
            break;
    }
    objTarget.unbind("keydown");
    objTarget.keydown(function (e) {
        switch (e.keyCode) {
            case 13:
                if ($(".Over").html() > "") {
                    objTarget.val($(".Over").html());
                    popup.ibClose();
                }
                i = -1;
                return false;
        }
    });
}

function MajorFill(obj, seq) {
    var majorIndex = -1;
    var majorId = obj.id.replace("liMajor", "");
    if (majorId.length == 0)
        return;
    for (var i = 0; i < jsMajorID.length; i++) {
        if (jsMajorID[i] == majorId) {
            majorIndex = i;
            break;
        }
    }
    if (majorIndex < 0)
        return;
    $("#iddcMajorID" + seq).val(majorId);
    $("#txtdcMajorID" + seq).val(jsMajor[majorIndex]);
}