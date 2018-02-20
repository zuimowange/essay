/**
 * 登录方式切换
 */
$(".title_ul li").click(function(){
	$(this).siblings().removeClass("choose_li")
	$(this).addClass("choose_li")
	$(".login_ul").hide();
	$("."+ $(this).attr("tabindex")).show();
})
/**
 * 二维码生成
 */
qrcodelib.toCanvas(document.getElementById('erWeiMao'), 'http://www.baidu.com', function(error) {
	if(error) console.error(error)
})
/**
 * 登录方法
 */
$("#loginBtn").click(function(){
	var account = $("#account").val();
	var pwd = $("#pwd").val();
	$.ajax({
		type:"post",
		url:"/userRest/login",
		data:{
			"po.account":account,
			"po.pwd":pwd
		},
		success:function(data){
			CookieUtil.set("token",data.token);
			if(data.msgCode == 1){
				layer.msg(data.msg, {icon: 6},function(){
					location.href = "/user/register";
				});
			}
			else{
				layer.msg(data.msg, {icon: 5},function(){
					/*location.href = "/user/register";*/
				});
			}
		}
	});
})
