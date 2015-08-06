//验证QQ号码
function isqq(str) 
{ 
var result=str.match(/[1-9][0-9]{4,}/); 
if(result==null) return false; 
return true; 
} 
//验证电话号码（0511-4405222 或 021-87888822）
function istell(str) 
{ 
var result=str.match(/(^0\d{2,3}-\d{7,8}$)|(^1(3|5|8)\d{9}$)/); 
if(result==null) return false; 
return true; 
} 
//邮箱/MSN
function isemail(str) 
{ 
var result=str.match(/^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/); 
if(result==null) return false; 
return true; 
} 

//验证身份证号
function isIdCard(str) 
{ 
var result=str.match(/^\d{15}|\d{}18$/); 
if(result==null) return false; 
return true; 
} 
//手机号码
function ismovephone(str) 
{ 
var result=str.match(/(86)*0*13\d{9}$/); 
if(result==null) return false; 
return true; 
}
//不允许非法字符,只允许数字和26个字符
function checkKeyDown(e){
	var code=null;
	var e=false;
	if(window.event){
		e=true;
		code=event.keyCode;
	}else{
		code=e.keyCode;
	}
	//alert(code);
	if(!((code>=48&&code<=57)||(code>=96&&code<=105)||(code>=65&&code<=90))){
		if(e){
			window.event.returnValue=false;
		}else{
			e.preventDefault();
		}
	}
}
//非法字符的验证a-zA-Z_0-9\u4e00-\u9fa5
function checkInput(str){
	var result=str.match(/[\/\\@&%#$*]+$/); 
	if(result!=null)
		return false; 
	return true;
}
//为空验证
function checkNull(str)
{
	var ar;
}
//验证回车按钮，获取焦点,直接登录
function checkEnterKey(e){
	var code=null;
	var e=false;
	if(window.event){
		e=true;
		code=event.keyCode;
	}else{
		code=e.keyCode;
	}
	//alert(code);
	if(code==13){
		return true;
	}else{
		return false;
	}
}