var TheYear = new Date().getFullYear() - 16 - 7
var strYear = '';
strYear = strYear + '<div id="YearSel" name="divYear" style="cursor:pointer;">';
strYear = strYear + '<div style="background:#fff; height:128px; width:200px;border:1px solid #ccc;padding:1px;height:1%;float:left">';
strYear = strYear + '  <table border="0" cellpadding="0" cellspacing="0" >';
strYear = strYear + '    <tr>';
strYear = strYear + '	  <td height=30 valign="top">';
strYear = strYear + '	    <table class="top-title" id="tbYearGuide" name="tbYearGuide" border=0 cellspacing=0 cellpadding=0 width=200  style="height:26px" >';
strYear = strYear + '		  <tr align=center>';
strYear = strYear + '		    <td width=34 align=right style="color:#fff" valign="middle"><span class="arrow-left"><i class="i-left"></i></span></td>';
strYear = strYear + '		    <td align=center style="font-size:12px"><b>请选择年份</b></td>';
strYear = strYear + '		    <td width=34 align=left style="color:#fff" valign="middle"><span class="arrow-right"><i class="i-right"></i></span></td>';
strYear = strYear + '		  </tr>';
strYear = strYear + '	    </table>';
strYear = strYear + '	  </td>';
strYear = strYear + '    </tr>';
strYear = strYear + '    <tr>';
strYear = strYear + '      <td>';
strYear = strYear + '	    <table id="tbYearSel" name="tbYearSel" width="200" border="0" cellspacing="0">';
var n = 0;
for (i = 0; i < 3; i++) {
    strYear = strYear + '		  <tr>';
    for (j = 0; j < 4; j++) {
        strYear = strYear + '		    <td align="center" id=tdPerYear' + n + ' height=24 width=25% style="border-radius:3px;">' + TheYear + '</td>';
        n++;
        TheYear++;
    }
    strYear = strYear + '		  </tr>';
}
strYear = strYear + '	    </table>';
strYear = strYear + '<div id="timeNow" style="hieght:26px; display:none; line-height:26px; text-align:center">至今</div>';
strYear = strYear + '	  </td>';
strYear = strYear + '    </tr>';
strYear = strYear + '  </table>';
strYear = strYear + '</div>';
strYear = strYear + '</div>';

var strMonth = '';
strMonth = strMonth + '<div id="MonthSel" name="divMonth" style="cursor:pointer;" >';
strMonth = strMonth + '<div style="background:#fff;height:112px; width:200px;border:1px solid #ccc;padding:1px;height:1%;background:#fff;"';
strMonth = strMonth + '  <table width="200" border="0" cellpadding="0" cellspacing="0">';
strMonth = strMonth + '    <tr>';
strMonth = strMonth + '	  <td height=30 valign="top">';
strMonth = strMonth + '	    <table id="tbMonthGuide" name="tbMonthGuide" border=0 cellspacing=0 cellpadding=0 width=200 class="top-title">';
strMonth = strMonth + '		  <tr align=center>';
strMonth = strMonth + '		    <td align=center style="font-size:12px"><b>请选择月份</b></td>';
strMonth = strMonth + '		  </tr>';
strMonth = strMonth + '	    </table>';
strMonth = strMonth + '	  </td>';
strMonth = strMonth + '    </tr>';
strMonth = strMonth + '    <tr>';
strMonth = strMonth + '      <td>';
strMonth = strMonth + '	    <table id="tbMonthSel" name="tbMonthSel" width="200" border="0" cellspacing="0">';
var m = 1;
for (i = 0; i < 3; i++) {
    strMonth = strMonth + '		  <tr>';
    for (j = 0; j < 4; j++) {
        strMonth = strMonth + '		    <td height=24 style="border-radius:3px;" align="center" width="50" id=tdPerMonth' + m + '>' + m + '</td>';
        m++;
    }
    strMonth = strMonth + '		  </tr>';
}
strMonth = strMonth + '	    </table>';
strMonth = strMonth + '	  </td>';
strMonth = strMonth + '    </tr>';
strMonth = strMonth + '  </table>';
strMonth = strMonth + '</div>';
strMonth = strMonth + '</div>';