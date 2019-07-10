var CommonSelect = {
  newSelect: function (aNaIn, width, isNecessary) {
    var commonSelect = {};
    var aIdIn = aNaIn + "ID";
    commonSelect._arrID = aIdIn;
    commonSelect._aNa = aNaIn;
    var aId = eval(aIdIn);
    var aNa = eval(aNaIn);
    commonSelect.GenBodyHtml = function () {
      var objId = BodyClass.objId;
      var strWidth = '', bh = '';
      if (width != null) {
        strWidth = ' style="cursor:pointer;width:' + width + 'px"';
      }
      bh = '<div class="DivShowB BgIcon">';
      bh += '<div class="NDivCl1"><ul>';
      if (isNecessary == 0) {
        if (location.pathname.indexOf("/Company") == 0)
          bh += '<li' + strWidth + ' onMouseOver="this.style.backgroundColor=\'#d3e9ff\';" onMouseOut="this.style.backgroundColor=\'\'" onclick="BodyClass.saveInt(\'\',\'请选择\')">请选择</li>';
        else
          bh += '<li' + strWidth + ' onMouseOver="this.style.backgroundColor=\'#fc7f33\';this.style.color=\'#fff\';" onMouseOut="this.style.backgroundColor=\'\';this.style.color=\'#000\';" onclick="BodyClass.saveInt(\'\',\'请选择\')">请选择</li>';
      }
      for (i = 0; i < aId.length; i++) {
        if (location.pathname.indexOf("/Company") == 0)
          bh += '<li' + strWidth + ' onMouseOver="this.style.backgroundColor=\'#d3e9ff\'" onMouseOut="this.style.backgroundColor=\'\'" onclick="BodyClass.saveInt(\'' + aId[i] + '\',\'' + aNa[i] + '\')" idvalue="' + aId[i] + '">' + aNa[i] + '</li>';
        else
          bh += '<li' + strWidth + ' onMouseOver="this.style.backgroundColor=\'#fc7f33\';this.style.color=\'#fff\';" onMouseOut="this.style.backgroundColor=\'\';this.style.color=\'#000\';" onclick="BodyClass.saveInt(\'' + aId[i] + '\',\'' + aNa[i] + '\')" idvalue="' + aId[i] + '">' + aNa[i] + '</li>';
      }
      bh += '<div style="clear:both"></div></ul></div>';
      bh += '<div style="clear:both"></div></div><div style="clear:both"></div></div>';
      if (popup.W - width <= 25)
        popup.W = width + 8;

      return bh;
    }
    return commonSelect;
  }
}