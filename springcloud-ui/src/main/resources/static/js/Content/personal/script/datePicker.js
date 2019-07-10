var datePickerObj = null;
var datePickerPage = 0;
var datePickerNoMonth = 0;
function birthdayPicker(obj, headerTitle) {
    datePickerObj = obj;
    var index = 0;
    var strHtml = '<div class="SelectedMenu">\n';
    strHtml += '  <span onclick="fillBirthdayPickerYear(10, ' + index + ')">00后</span>\n'
    index = 1;
    for (var i = 9; i > 4; i--) {
        strHtml += '  <span onclick="fillBirthdayPickerYear(' + i + ', ' + index + ')">' + i + '0后</span>\n'
        index++;
    }
    strHtml += '</div>\n';
    strHtml += '<div class="yearPicker"></div>\n'
    strHtml += '<div class="monthPicker birthday" style="display:none;">\n';
    strHtml += '  <span onclick="pickMonth(this, 1)">一月</span>\n';
    strHtml += '  <span onclick="pickMonth(this, 2)">二月</span>\n';
    strHtml += '  <span onclick="pickMonth(this, 3)">三月</span>\n';
    strHtml += '  <span onclick="pickMonth(this, 4)">四月</span>\n';
    strHtml += '  <span onclick="pickMonth(this, 5)">五月</span>\n';
    strHtml += '  <span onclick="pickMonth(this, 6)">六月</span>\n';
    strHtml += '  <span onclick="pickMonth(this, 7)">七月</span>\n';
    strHtml += '  <span onclick="pickMonth(this, 8)">八月</span>\n';
    strHtml += '  <span onclick="pickMonth(this, 9)">九月</span>\n';
    strHtml += '  <span onclick="pickMonth(this, 10)">十月</span>\n';
    strHtml += '  <span onclick="pickMonth(this, 11)">十一月</span>\n';
    strHtml += '  <span onclick="pickMonth(this, 12)">十二月</span>\n';
    strHtml += '</div>\n'
    popup.clearData()
    popup.drag = 1;
    popup.H = 1;
    popup.W = 600;
    popup.dockObj = obj;
    popup.headerTitle = headerTitle;
    popup.isHeader = 1;
    popup.isMessageTip = 0;
    popup.mask = 3;
    popup.bodyHtml = strHtml;
    popup.creatDiv();
    fillBirthdayPickerYear(9, 1);
}

function datePicker(obj, headerTitle, noMonth) {
    datePickerPage = 0;
    datePickerObj = obj;
    datePickerNoMonth = typeof (noMonth) == "undefined" ? 0 : 1;
    var strHtml = '';
    strHtml += '<div class="yearPicker"></div>\n'
    strHtml += '<div class="monthPicker" style="display:none;">\n';
    strHtml += '  <span onclick="pickMonth(this, 1)">一月</span>\n';
    strHtml += '  <span onclick="pickMonth(this, 2)">二月</span>\n';
    strHtml += '  <span onclick="pickMonth(this, 3)">三月</span>\n';
    strHtml += '  <span onclick="pickMonth(this, 4)">四月</span>\n';
    strHtml += '  <span onclick="pickMonth(this, 5)">五月</span>\n';
    strHtml += '  <span onclick="pickMonth(this, 6)">六月</span>\n';
    strHtml += '  <span onclick="pickMonth(this, 7)">七月</span>\n';
    strHtml += '  <span onclick="pickMonth(this, 8)">八月</span>\n';
    strHtml += '  <span onclick="pickMonth(this, 9)">九月</span>\n';
    strHtml += '  <span onclick="pickMonth(this, 10)">十月</span>\n';
    strHtml += '  <span onclick="pickMonth(this, 11)">十一月</span>\n';
    strHtml += '  <span onclick="pickMonth(this, 12)">十二月</span>\n';
    strHtml += '</div>\n'
    popup.clearData()
    popup.drag = 1;
    popup.H = 1;
    popup.W = 380;
    popup.dockObj = obj;
    popup.headerTitle = headerTitle;
    popup.isHeader = 1;
    popup.isMessageTip = 0;
    popup.mask = 3;
    popup.bodyHtml = strHtml;
    popup.creatDiv();
    fillPickerYear();
    $("#msg1_head").html('\
	  <input type="button" class="datePickerSwitch Prev" onclick="prevPickerYear()" />\
	  <span class="datePickerTitle">' + headerTitle + '</span>\
	  <input type="button" class="datePickerSwitch Next" onclick="nextPickerYear()" />\
	');
}

function fillPickerYear() {
    var isNow = $(datePickerObj).attr("id").toLowerCase().indexOf("end") > -1 && datePickerPage == 0;
    var strHtml = '';
    var date = new Date();
    var beginYear = date.getFullYear() + 2 - (datePickerPage * 12) + ($(datePickerObj).attr("id").toLowerCase().indexOf("end") > -1 && datePickerPage > 0 ? 2 : 1);
    for (var i = beginYear - (isNow ? 11 : 12); i < beginYear; i++) {
        strHtml += '  <span onclick="pickYear(this)">' + i + '</span>\n';
    }
    if (isNow) {
        strHtml += '  <span onclick="pickYear(this)">至今</span>\n';
    }
    $(".yearPicker").html(strHtml);
}

function prevPickerYear() {
    if (datePickerPage == 4) return;
    datePickerPage++;
    fillPickerYear();
}

function nextPickerYear() {
    if (datePickerPage == 0) return;
    datePickerPage--;
    fillPickerYear();
}

function fillBirthdayPickerYear(age, index) {
    $(".SelectedMenu span").removeClass("selected");
    $(".SelectedMenu span").eq(index).addClass("selected");
    var strHtml = '';
    for (var i = 0; i < 10; i++) {
        var date = new Date;
        if (1900 + age * 10 + i > date.getFullYear() - 15) {
            break;
        }
        strHtml += '  <span onclick="pickYear(this)">' + (1900 + age * 10 + i) + '</span>\n';
    }
    $(".yearPicker").html(strHtml);
}

function pickYear(obj) {
    if ($(obj).text() == "至今") {
        $(datePickerObj).val($(obj).text());
        $("#" + $(datePickerObj).attr("id").replace("txt", "id")).val("999999");
        popup.ibClose();
        $(datePickerObj).removeClass("Required");
        return;
    }
    else if (datePickerNoMonth == 1) {
        $(datePickerObj).val($(obj).text() + "年");
        $("#" + $(datePickerObj).attr("id").replace("txt", "id")).val($(obj).text());
        popup.ibClose();
        $(datePickerObj).removeClass("Required");
        return;
    }
    $(".yearPicker span").removeClass("Selected");
    $(obj).addClass("Selected");
    $(".monthPicker").show();
}

function pickMonth(obj, month) {
    var year = $(".yearPicker .Selected").text();
    $(datePickerObj).val(year + "年" + month + "月");
    $("#" + $(datePickerObj).attr("id").replace("txt", "id")).val(year + (month < 10 ? "0" + month : month));
    popup.ibClose();
    $(datePickerObj).removeClass("Required");
    if ($(datePickerObj).attr("id").toLowerCase().indexOf("end") > 0) {
        if ($(datePickerObj).parent().parent().find("[id^='id']").length == 2) {
            var beginDate = $(datePickerObj).parent().parent().find("[id^='id']").eq(0).val();
            var endDate = $(datePickerObj).parent().parent().find("[id^='id']").eq(1).val();
            if (beginDate.length != 0 && endDate.length != 0 && beginDate > endDate) {
                alert("开始时间不能小于结束时间");
                $(datePickerObj).val("");
                $("#" + $(datePickerObj).attr("id").replace("txt", "id")).val("");
            }
        }
    }
    else {
        if ($(datePickerObj).parent().find("[id^='id']").length == 2) {
            var beginDate = $(datePickerObj).parent().find("[id^='id']").eq(0).val();
            var endDate = $(datePickerObj).parent().find("[id^='id']").eq(1).val();
            if (beginDate.length != 0 && endDate.length != 0 && beginDate > endDate) {
                alert("开始时间不能小于结束时间");
                $(datePickerObj).val("");
                $("#" + $(datePickerObj).attr("id").replace("txt", "id")).val("");
            }
        }
    }
}