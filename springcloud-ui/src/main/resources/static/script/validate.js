var arrError = new Array(
    "该项不能为空",
    "请输入有效的手机号码",
    "只能输入汉字",
    "只能输入英文",
    "只能输入数字",
    "邮箱格式错误",
    "对不起，密码只能使用字母、数字、横线、下划线、点",
    "密码长度不符合要求",
    "请输入140~230之间的整数",
    "请输入正确的网址",
    "您输入的电子邮箱已经存在，请重新输入，或 <a href='/personal/sys/login'>点此登录</a> 或 <a href='/personal/sys/GetPassword' target='_blank'>取回密码</a>",
    "两次输入的密码不相同，请重新输入",
    "邮箱长度不能大于50字符")
var strError = '<img src="/Images/IconF.gif" />';
var strSuccess = '<img src="/Images/IconT.gif" />';
var strWaiting = '<img src="/Images/IconWait.gif" />';

function WordCount(obj)
{
    var maxlen = obj.getAttribute("maxlength");
    var minlen = obj.getAttribute("minlength");
    var strInput = obj.value;
    var strLen = trim(strInput).length;
    if(strLen > 19){
        var ss = strInput.replace(/</g, "&lt;").replace(/>/g, ">");
        strLen = ss.length;
    }
    if(strInput)
    {
        if(maxlen == null){
            maxlen = 3000;
        }
        if(strLen <= maxlen)
            return '已输入' + strLen + '个字。';
        else
        {
            obj.value = strInput.slice(0,maxlen);
            return '已输入' + maxlen + '个字，不能继续输入。';
        }
    }
    else
        return "";
}

function CheckRule(rule,data)
{
    var regValidator = "";
    switch(rule){
        case "mobile":
            if(data){
                regValidator = /^1{1}\d{10}$/;
                if(regValidator.exec(data))
                    return true;
                return false
            }
            break;
        case "chinese":
            regValidator = /^[\u4E00-\u9FFF]+$/;
            if(!regValidator.exec(data))
                return false;
            break;
        case "telephone":
            regValidator = /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/;
            if(!regValidator.exec(data))
                return false;
            break;
        case "english":
            regValidator = /^[a-zA-Z]+$/;
            if(!regValidator.exec(data))
                return false;
            break;
        case "engname":
            regValidator = /^[0-9 \'\.a-zA-Z]+$/;
            if(!regValidator.exec(data))
                return false;
            break;
        case "avail":
            regValidator = "*/_-\!@#$%^=|?~<>,"
            var arrChar = regValidator.split("");
            for(var i = 0;i<arrChar.length;i++)
                if(data.indexOf(arrChar[i])>=0) return false;
            break;
        case "number":
            regValidator = /^[0-9]+$/;
            if(!regValidator.exec(data))
                return false;
            break;
        case "email":
            return checkIsEmail(data);
            break;
        case "account":
            regValidator=/^[a-zA-Z0-9-_.]+$/;
            if(!regValidator.exec(data))
                return false;
            break;
        case "password":
            regValidator=/^[a-zA-Z0-9-_.]+$/;
            if(!regValidator.exec(data))
                return false;
            break;
        case "eqpwd":
            if(data != document.getElementById("txtPassword").value)
                return false;
            break;
        case "url":
            if(data){
                regValidator = /^((http|https):\/\/)?[\-_A-Za-z0-9]+\.[\-_A-Za-z0-9]+[\/=\?%&~`@[\]\':+!]*([^<>\"\"])*$/;
                if(!regValidator.exec(data))
                    return false;
                break;
            }
        case "rmaccount":
            regValidator=/^[a-zA-Z0-9-_.]{6,20}$/;
            if(!regValidator.exec(data))
                return false;
            break;
        default:
    }
    return true;
}

function TrimSpace(obj)
{
    if(obj.value != obj.value.replace(/ /g,""))
        obj.value = obj.value.replace(/ /g,"");
    if(obj.value != obj.value.replace(/　/g,""))
        obj.value = obj.value.replace(/　/g,"");
}

function CtoH(obj)
{
    var str=obj.value;

    var result = "";

    for (var i = 0; i < str.length; i++) {
        if (str.charCodeAt(i) == 12288) {
            result += String.fromCharCode(str.charCodeAt(i) - 12256);
            continue;
        }
        if (str.charCodeAt(i) > 65280 && str.charCodeAt(i) < 65375)
            result += String.fromCharCode(str.charCodeAt(i) - 65248);
        else
            result += String.fromCharCode(str.charCodeAt(i));
    }
    result = result.replace(/——/g,"_");
    result = result.replace(/\(/g, "（");
    result = result.replace(/\)/g, "）");
    if(obj.value != result)
        obj.value = result;
}


//删除左右两端的空格
function trim(str)
{

    return str.replace(/(^\s*)|(\s*$)/g, "");
}
//删除左边的空格　
function ltrim(str)
{

    return str.replace(/(^\s*)/g, "");
}
//删除右边的空格
function rtrim(str)
{

    return str.replace(/(\s*$)/g, "");
}
function checkIsEmail(value) {
    var result = value.split(",");
    for(var i = 0;i < result.length;i++)
        if(!validateEmail(result[i]))
            return false;
    return true;
}

function validateEmail(str){
    var arrs, temp, i,j, c;
    var validChars = "0123456789abcdefghijklmnopqrstuvwxyz_-.";
    arrs = str.split("@")
    if(arrs.length!=2)
        return false;
    for(j=0;j<arrs.length;j++){
        temp = arrs[j]
        if(temp.length <= 0)
            return false;
        for(i = 0;i< temp.length ; i++){
            c = temp.charAt(i).toLowerCase();
            if(validChars.indexOf(c) < 0)
                return false;
        }
        if(temp.charAt(0) == "." || temp.charAt(temp.length-1) == "." || temp.charAt(temp.length-1) == "_" || temp.charAt(temp.length-1) == "-")
            return false;
    }
    if(str.charAt(0) == "_" || str.charAt(0) == "-" || str.charAt(0) == "." )
        return false
    if(arrs[1].indexOf(".") <= 0)
        return false;
    i = arrs[1].length - arrs[1].lastIndexOf(".")
    if(i != 3&&i != 4&&i != 5)
        return false;
    if(str.indexOf("..") >= 0)
        return false;
    return true;
}