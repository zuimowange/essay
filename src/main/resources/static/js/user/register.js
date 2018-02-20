var regType = "reg_email";
var formList = {
	email: {
		pd: false,
		reg: /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/,
		msg: "请输入正确的邮箱",
		tips:null
	},
	pwd: {
		pd: false,
		reg: /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$/,
		msg: "密码必须包含大小写字母和数字的组合，不能使用特殊字符，长度在8-16之间",
		tips:null
	},
	qrPwd: {
		pd: false,
		msg: "请与密码保持一致",
		tips:null
	},
	telephone:{
		pd:false,
		reg:/^[1][3,4,5,7,8][0-9]{9}$/,
		msg:"请输入正确的手机号",
		tips:null
	},
	vCode:{
		pd:false,
		reg:/^\d{4}$/,
		msg:"请输入四位的验证码",
		tips:null
	}
}
var myTips = null; //弹出层
var code = 1234;//验证码

/**
 * 注册方式切换
 */
$(".title_ul li").click(function() {
	$(this).siblings().removeClass("choose_li")
	$(this).addClass("choose_li")
	
	$("." + $(this).attr("tabindex")).show();
	$("." + $(this).attr("notabindex")).hide();
	
	$(".reg_ul input").val("");
	$(".reg_ul input").removeClass("error_input");
	
	layer.close(myTips);
	//遍历 ，全部改为false
	for(var p in formList){
		formList[p].pd = false;
		formList[p].tips = null;
	}
	layer.closeAll();
	
	
	regType = $(this).attr("tabindex");
})

/**
 * 校验
 */

//邮箱校验
$("#email").focus(function() {
	check($(this), "email")
})
$("#email").keyup(function() {
	check($(this), "email")
})
//密码验证
$("#pwd").focus(function() {
	check($(this), "pwd")
})
$("#pwd").keyup(function() {
	check($(this), "pwd")
})
//确认密码验证
$("#qr_pwd").focus(function() {
	check($(this),"qrPwd")
})
$("#qr_pwd").keyup(function() {
	check($(this),"qrPwd")
})
//电话号码校验
$("#telephone").focus(function() {
	check($(this), "telephone")
})
$("#telephone").keyup(function() {
	check($(this), "telephone")
})
//点击获取验证码
$("#codeLabel").click(function(){
	if(formList["telephone"].pd){
		//showMessage("telephone", $(this));
		layer.tips("<span style='color:red'>验证码为1234</span>", $(this), {
			tips: [2, "white"],
			time: 2000,
			tipsMore: true//允许多个同时存在
		})
	}
	else{
		showMessage("telephone", $("#telephone"),0);
	}
})
//验证码校验
$("#vCode").keyup(function() {
	check($(this), "vCode")
})
$("#vCode").change(function(){
	if($(this).val() == code){
		formList.vCode.pd = true;
	}
	else{
		formList.vCode.pd = false;
	}
})
/**
 * 通用校验方法
 * @param {Object} obj
 * @param {Object} name
 */
function check(obj, name) {
	//确认密码校验
	if(name == "qrPwd") {
		if($(obj).val() == $("#pwd").val()) {
			formList[name]["pd"] = true;
			$(obj).removeClass("error_input");
			layer.close(formList[name].tips);
			formList[name].tips = null;
		} else {
			formList[name]["pd"] = false;
			$(obj).addClass("error_input");
			if(formList[name].tips == null) {
				showMessage(name, $(obj),0);
			}
		}
		return false;
	}
	//修改密码时，同时需要判断确认密码
	if(name == "pwd"){
		if($(obj).val() == $("#qr_pwd").val()){
			formList["qrPwd"]["pd"] = true;
			$("#qr_pwd").removeClass("error_input");
			layer.close(formList.qrPwd.tips);
			formList.qrPwd.tips = null;
		}
		else{
			formList["qrPwd"]["pd"] = false;
			$("#qr_pwd").addClass("error_input");
			if(formList.qrPwd.tips == null && $("#qr_pwd").css('display')!="none") {
				showMessage("qrPwd", $("#qr_pwd"),0);
			}
		}
	}
	//校验通过
	if(formList[name]["reg"].test($(obj).val())) {
		formList[name]["pd"] = true;
		$(obj).removeClass("error_input");
		layer.close(formList[name].tips);
		formList[name].tips = null;
		if(name == "pwd") {
			$("#qr_pwd").show();
		}
	}
	//校验不通过
	else {
		formList[name]["pd"] = false;
		$(obj).addClass("error_input");
		if(formList[name].tips == null) {
			showMessage(name, $(obj),0);
		}
	}
}

function showMessage(name,obj,time) {
	formList[name].tips = layer.tips("<span style='color:red'>"+formList[name].msg+"</span>", obj, {
		tips: [2, "white"],
		time: time,
		tipsMore: true//允许多个同时存在
	}); //弹出框加回调函数  
}

/**
 * 注册方法
 */
/*$("#loginBtn").click(function() {
	var account = $("#account").val();
	var pwd = $("#pwd").val();
	$.ajax({
		type: "post",
		url: "/userRest/reg",
		data: {
			"po.account": account,
			"po.pwd": pwd
		},
		success: function(data) {
			alert(data.msg)
		}
	});
})*/

$("#regBtn").click(function() {
	var data;
	//邮箱注册
	if(regType == "reg_email"){
		if(formList.email.pd && formList.pwd.pd && formList.qrPwd.pd){
			data = {
				"po.email": $("#email").val(),
				"po.pwd": $("#pwd").val()
			}
		}
	}
	//电话号码注册
	else{
		if(formList.telephone.pd && formList.pwd.pd && formList.qrPwd.pd && formList.vCode.pd){
			data = {
				"po.telephone": $("#telephone").val(),
				"po.pwd": $("#pwd").val()
			}
		}
	}
	$.ajax({
		type: "post",
		url: "/userRest/reg",
		data: data,
		success: function(data) {
			if(data.msgCode == 1){
				layer.msg(data.msg, {icon: 6},function(){
					location.href = "/user/login";
				});
			}
			else{
				layer.msg(data.msg, {icon: 5},function(){
				});
			}
		}
	});
})