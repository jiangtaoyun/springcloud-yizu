var IndustrySelect = {
    newSelect: function (width, isMulti) {
        var industrySelect = {};
        industrySelect._arrID = "jsIndustryID";
        industrySelect._aNa = "jsIndustry";
        var aId = jsIndustryID;
        var aNa = jsIndustry;
        industrySelect.GenBodyHtml = function () {
            var objId = BodyClass.objId;
            var bh = '';
            var industryTitle = new Array();
            industryTitle = ["IT|互联网|通信|电子", "金融业", "房产|建筑建设|物业", "广告|传媒|印刷出版", "消费零售|贸易|交通物流|租赁", "加工制造|设备仪表", "咨询中介|教育科研|专业服务", "医药生物|医疗保健", "服务业", "能源|矿产|石油化工|新能源", "政府|非赢利机构|其他"];
            var arrPos = [7, 11, 15, 18, 26, 31, 36, 39, 44, 48, 53];
            var strWidth = '';
            var strWidth = '';
            width = 170;
            if (width != null) {
                strWidth = ' style="overflow: hidden;white-space: nowrap;cursor:pointer;width:' + width + 'px"';
            }
            bh = '<div class="DivShow"><div class="DivShowB">';
            if (isMulti == 1) {
                bh += BodyClass.MutiHeadHtml(objId) + '<div id="SelectedDiv">';
            }
            for (var j = 0; j < arrPos.length; j++) {
                var sPos = 0;
                if (j > 0) {
                    sPos = arrPos[j - 1];
                }
                var ePos = arrPos[j];
                bh += '<div class="NDivCl" style="';
                if (j % 2 == 1) {
                    if (location.pathname.indexOf("/Company") == 0)
                        bh += 'background-color:#eef2ff;';
                    else
                        bh += 'background-color:#fff;';
                }
                if ((ePos - sPos) < 4) {
                    bh += 'height:26px; line-height:27px;';
                }
                else if ((ePos - sPos) < 7) {
                    bh += 'height:52px; line-height:53px;';
                }
                else {
                    bh += 'height:78px; line-height:79px;';
                }
                bh += '"><div class="NDivClBig" style="width:162px">' + industryTitle[j] + '</div>';
                bh += '<div class="NDivClSmall" style="width:575px;';
                if ((ePos - sPos) < 4) {
                    bh += 'padding-top:2px;';
                }
                else if ((ePos - sPos) < 7) {
                    bh += 'padding-top:5px;';
                }
                else {
                    bh += 'padding-top:7px;';
                }
                bh += '"><ul>';
                for (i = sPos; i < ePos; i++) {
                    var _LiIdNi = objId + i;
                    if (isMulti == 0) {
                        if (location.pathname.indexOf("/Company") == 0)
                            bh += '<li' + strWidth + 'id="' + _LiIdNi + '" onMouseOver="this.style.backgroundColor=\'#d3e9ff\'" onMouseOut="this.style.backgroundColor=\'\'" onclick="BodyClass.saveInt(\'' + aId[i] + '\',\'' + aNa[i] + '\',\'' + objId + '\')">' + aNa[i] + '</li>';
                        else
                            bh += '<li' + strWidth + 'id="' + _LiIdNi + '" onMouseOver="this.style.backgroundColor=\'#ffe9d3\'" onMouseOut="this.style.backgroundColor=\'\'" onclick="BodyClass.saveInt(\'' + aId[i] + '\',\'' + aNa[i] + '\',\'' + objId + '\')">' + aNa[i] + '</li>';

                    }
                    else {
                        if (location.pathname.indexOf("/Company") == 0) {
                            bh += '<li class="nobg"' + strWidth;
                            bh += ' onMouseOver="this.style.background=\'#d3e9ff\';" onMouseOut="this.style.background=\'\';" onClick="BodyClass.bcb(this, \'' + objId + '\', \'jsIndustryID\', \'jsIndustry\')"' + strWidth + '><input name="' + aId[i] + '" value="' + aNa[i] + '" type="checkbox" onclick="this.checked=!this.checked;" />' + jsIndustry[i] + '</li>';
                        }
                        else {
                            bh += '<li class="nobg"' + strWidth;
                            bh += ' onMouseOver="this.style.background=\'#ffe9d3\';" onMouseOut="this.style.background=\'\';" onClick="BodyClass.bcb(this, \'' + objId + '\', \'jsIndustryID\', \'jsIndustry\')"' + strWidth + '><input name="' + aId[i] + '" value="' + aNa[i] + '" type="checkbox" onclick="this.checked=!this.checked;" />' + jsIndustry[i] + '</li>';
                        }
                    }
                }
                if (isMulti == 1) {
                    bh += '<input type="hidden" id="' + objId + 'ProvisionalData">';
                }
                bh += '</ul></div>';
                bh += '</div>';
            }
            bh += '</div><div style="clear:both;"></div></div></div>';
            bh += '<div id="SelectedDiv"><div class="showDivsub" id="popDivSub" onMouseOut="BodyClass.hideSub();"onMouseOver="BodyClass.showSub();" style="float:left;position:absolute;"></div></div>';
            return bh;
        };
        return industrySelect;
    },
    GetSearchItems: function (obj) {
        var keyword = obj.value;
        if (keyword.length == 0) {
            _("popDivSearch").style.display = "none";
            return;
        }
        var parm = "keyword=" + escape(keyword.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/g, ''));
        this.InnerAjax("post", "/common/GetIndustryByKeyword", parm, GenIndustryList, false);
        function GenIndustryList(obj) {
            var jsonList = obj.responseText;
            if (jsonList.length > 0) {
                var strList = '<ul>';
                jsonList = eval('(' + jsonList + ')');
                var itemNum = 0;
                for (var i = 0; i < jsonList.IndustryList.length; i++) {
                    if (this.IsMulti == 0) {
                        if (jsonList.IndustryList[i].ID.length == 2) {
                            continue;
                        }
                        strList += '<li onMouseOver="this.style.backgroundColor=\'#ffe9d3\';" onMouseOut="this.style.backgroundColor=\'\';" onClick="BodyClass.saveInt(\'' + jsonList.IndustryList[i].ID + '\',\'' + jsonList.IndustryList[i].Name + '\',\'' + BodyClass.objId + '\');">' + jsonList.IndustryList[i].Name + '</li>';
                    }
                    else {
                        strList += '<li onMouseOver="this.style.background=\'#ffe9d3\';" onMouseOut="this.style.background=\'\';" onClick="BodyClass.bcb(this, \'' + BodyClass.objId + '\', \'jsIndustryID\', \'jsIndustry\',' + 0 + ');"><input name="' + jsonList.IndustryList[i].ID + '" value="' + jsonList.IndustryList[i].Name + '" type="checkbox" onclick="this.checked=!this.checked;" />' + jsonList.IndustryList[i].Name + '</li>';
                    }
                    itemNum++;
                    if (itemNum == 9) break;
                }
                strList += '<li style="color:#999; list-style:none;"><span style="float:left">' + (this.IsMulti == 0 ? '选择合适的职位类别' : '最多选择'+BodyClass.MultiNumber+'项') + '</span><span style="float:right"><img style="margin-top:8px" src="../content/Homepage/NewIndex/PopupNew/p6.gif"/*tpa=http://www.shoudurc.com/content/Homepage/NewIndex/PopupNew/p6.gif*/ onclick="_(\'popDivSearch\').style.display = \'none\';" /></span></li></ul>';
                _("popDivSearch").innerHTML = strList;
                if (navigator.userAgent.indexOf("IE") > -1) {
                    if (navigator.userAgent.indexOf("IE 9") > -1) {
                        _("popDivSearch").style.marginLeft = "146px";
                    }
                    else {
                        _("popDivSearch").style.marginLeft = "146px";
                    }
                }
                else {
                    _("popDivSearch").style.marginLeft = "146px";
                }
                _("popDivSearch").style.display = "block";
                if (this.IsMulti == 1)
                    BodyClass.changeChecked(BodyClass.objId);
            }
            else {
                _("popDivSearch").style.marginLeft = "146px";
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
    },
    textBoxFocus: function (obj, strText) {
        var strObjValue = obj.value;
        if (strObjValue == strText) {
            obj.value = "";
        }
    },
    textBoxBlur: function (obj, strText) {
        var strObjValue = obj.value;
        if (strObjValue == "") {
            obj.value = strText;
        }
    }
};