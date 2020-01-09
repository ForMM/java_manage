package com.xiaoyuan.manage.content;

/**
 * 
 * 全局状态码表
 * 
 * @auther tangqing
 * 
 */
public class Status {  
	public static final int 	success_status 	= 10000;
	public static final String 	success_info 	= "操作成功";
	
	
	public static final int 	appkey_error_status 	= 10001;
	public static final String 	appkey_error_info 	= "参数错误";//缺少appkey
	
	public static final int 	appsecurity_error_status 	= 10002;
	public static final String 	appsecurity_error_info 	= "参数错误";//非法的key值
	
	/*public static final int 	sign_success_status 	= 10003;
	public static final String 	sign_success_info 	= "验证签名成功";*/
	
	public static final int 	sign_error_status 	= 10004;
	public static final String 	sign_error_info 	= "参数错误";//签名验证失败
	
	public static final int 	time_error_status 	= 10005;
	public static final String 	time_error_info 	= "请求已过有效时限";
	
	public static final int 	timeFormat_error_status 	= 10006;
	public static final String 	timeFormat_error_info 	= "非法的时间参数";
	
	public static final int 	login_error_status 	= 10007;
	public static final String 	login_error_info 	= "用户名或密码错误！";
	
	public static final int 	account_error_status 	= 10008;
	public static final String 	account_error_info 	= "请输入账号";
	
	public static final int 	pwd_error_status 	= 10009;
	public static final String 	pwd_error_info 	= "请输入密码";
	
	public static final int 	send_checkcode_error_status 	= 10010;
	public static final String 	send_checkcode_error_info 	= "验证码发送失败";
	
	public static final int 	phone_fmt_error_status 	= 10011;
	public static final String 	phone_fmt_error_info 	= "手机号码格式错误";
	
	public static final int 	checkcode_empty_error_status 	= 10012;
	public static final String 	checkcode_empty_error_info 	= "验证码不能为空";
	
	public static final int 	checkcode_error_status 	= 10013;
	public static final String 	checkcode_error_info 	= "验证码错误";
	
	public static final int 	usertype_error_status 	= 10014;
	public static final String 	usertype_error_info 	= "用户角色错误";
	
	public static final int 	company_empty_error_status 	= 10015;
	public static final String 	company_empty_error_info 	= "请输入公司名称";
	
	public static final int 	position_empty_error_status 	= 10016;
	public static final String 	position_empty_error_info 	= "请输入职位名称";
	
	public static final int 	realname_empty_error_status 	= 10017;
	public static final String 	realname_empty_error_info 	= "请输入真实姓名";
	
	public static final int     phone_empty_error_status = 10018;
	public static final String 	phone_empty_error_info 	= "请输入手机号";
	
	public static final int     phone_exist_error_status = 10019;
	public static final String 	phone_exist_error_info 	= "该手机号已被注册";
	
	public static final int 	checkcode_type_error_status 	= 10020;
	public static final String 	checkcode_type_error_info 	= "验证码类型错误";
	
	public static final int     phone_not_exist_error_status = 10021;
	public static final String 	phone_not_exist_error_info 	= "该手机号未注册";
	
	public static final int     token_empty_error_status = 10022;
	public static final String 	token_empty_error_info 	= "token不能为空";
	
	public static final int     token_error_status = 10023;
	public static final String 	token_error_info 	= "无效的token";
	
	public static final int     user_not_exist_error_status = 10025;
	public static final String 	user_not_exist_error_info 	= "用户不存在";
	
	public static final int     img_type_error_status = 10026;
	public static final String 	img_type_error_info 	= "图片格式错误";
	
	public static final int     upload_error_status = 10027;
	public static final String 	upload_error_info 	= "文件上传失败";
	
	public static final int     file_empty_status = 10028;
	public static final String 	file_empty_info 	= "请选择文件";
	
	public static final int     oldtoken_empty_status = 10029;
	public static final String 	oldtoken_empty_info 	= "oldtoken不能为空";
	
	public static final int     reqid_empty_status = 10030;
	public static final String 	reqid_empty_info 	= "reqid不能为空";
	
	public static final int 	reqid_fmt_error_status 	= 10031;
	public static final String 	reqid_fmt_error_info 	= "reqid格式错误";
	
	public static final int     oldtoken_error_status = 10032;
	public static final String 	oldtoken_error_info 	= "oldtoken无效";
	
	public static final int     file_type_error_status = 10033;
	public static final String 	file_type_error_info 	= "文件格式错误";
	
	public static final int     balance_error_status = 10034;
	public static final String 	balance_error_info 	= "余额不足";
	
	public static final int     withdraw_error_status = 10035;
	public static final String 	withdraw_error_info 	= "提现金额不能为0";
	
	public static final int     no_ali_account_status = 10036;
	public static final String 	no_ali_account_info = "未设置支付宝账号";
	
	public static final int     no_withdraw_error_status=10037;
	public static final String  no_withdraw_error_info="未输入提现金额";
	
	public static final int     bpimg_error_status = 10038;
	public static final String 	bpimg_upload_error_info 	= "文件转图片失败";
	
	public static final int     advice_empty_error_status = 10039;
	public static final String 	advice_empty_error_info 	= "反馈内容不能为空";
	
	public static final int     project_not_exist_error_status = 10040;
	public static final String 	project_not_exist_error_info 	= "项目不存在";
	
	public static final int     project_id_empty_status = 10041;
	public static final String 	project_id_empty_info 	= "项目ID为空";
	
	public static final int     service_type_error_status = 10042;
	public static final String 	service_type_error_info 	= "服务类型错误";
	
	public static final int     service_type_empty_error_status = 10043;
	public static final String 	service_type_empty_error_info 	= "服务类不能为空";
	
	public static final int     service_welfare_error_status = 10045;
	public static final String 	service_welfare_error_info 	= "公益参数错误";
	
	public static final int     money_format_status = 10046;
	public static final String 	money_format_info 	= "金额格式错误";
	
	public static final int     service_error_status = 10047;
	public static final String 	service_error_info 	= "服务状态错误";
	
	public static final int     service_price_error_status = 10048;
	public static final String 	service_price_error_info 	= "服务价格不能小于0";
	
	public static final int     service_id_empty_status = 10049;
	public static final String 	service_id_empty_info 	= "服务ID不能为空";
	
	public static final int     service_no_exist_status = 10050;
	public static final String 	service_no_exist_info 	= "服务不存在";
	
	public static final int     finish_service_error_status = 10051;
	public static final String 	finish_service_error_info 	= "禁止完成他人的服务";
	
	public static final int     send_bp_error_status = 10052;
	public static final String 	send_bp_error_info 	= "已发送过BP，不能再次发送";
	
	public static final int     service_voice_no_public_status = 10053;
	public static final String 	service_voice_no_public_info 	= "语音通话服务未开通";
	
	public static final int     service_meet_no_public_status = 10054;
	public static final String 	service_meet_no_public_info 	= "见面约谈服务未开通";
	
	public static final int     service_not_self_status = 10055;
	public static final String 	service_not_self_info 	= "服务不是自己的";
	
	public static final int     service_score_error_status = 10056;
	public static final String 	service_score_error_info 	= "得分参数类型错误";
	
	public static final int     service_empty_error_status = 10057;
	public static final String 	service_empty_error_info 	= "得分不能为空";
	public static final int     service_zero_error_status = 10058;
	public static final String 	service_zero_error_info 	= "得分不能为0";

	public static final int     service_score_error_status_status = 10059;
	public static final String 	service_score_error_status_info 	= "服务未完成，不能评价";
	
	public static final int     service_evaluate_status = 10060;
	public static final String 	service_evaluate_info 	= "服务已评价，不能再次评价";
	
	public static final int     password_modify_error_status = 10061;
	public static final String 	password_modify_error_info = "输入的密码与当前设置密码不一致";
	
	public static final int     project_value_empty_status = 10062;
	public static final String 	project_value_empty_info 	= "项目估值为空";
	
	public static final int     project_value_format_error_status = 10063;
	public static final String 	project_value_format_error_info 	= "项目估值必须为数值";
	
	public static final int     commend_empty_status = 10064;
	public static final String 	commend_empty_info 	= "评论内容不能为空";
	
	public static final int     commend_id_empty_status=10065;
	public static final String 	commend_id_empty_info 	= "评论ID不能为空";
	
	public static final int     clicked_status=10066;
	public static final String 	clicked_info 	= "已赞过，不能继续点赞";
	
	public static final int     news_id_empty_error_status=10067;
	public static final String 	news_id_empty_error_info 	= "新闻ID不能为空";
	
	public static final int     news_not_exist_status=10068;
	public static final String 	news_not_exist_info 	= "新闻不存在";
	
	public static final int     comment_not_exist_status=10069;
	public static final String 	comment_not_exist_info 	= "评论不存在";
	
	public static final int     member_id_empty_status=10070;
	public static final String 	member_id_empty_info 	= "成员ID不能为空";
	
	public static final int     member_not_exist_error_status=10071;
	public static final String 	member_not_exist_error_info 	= "成员不存在";

	public static final int     proMongoId_empty_error_status=10072;
	public static final String 	proMongoId_empty_error_info 	= "项目MongoId不能为空";

	public static final int     sync_param_empty_error_status=10073;
	public static final String 	sync_param_empty_error_info 	= "参数不能为空";
	
	public static final int     invitation_code_empty_error_status=10074;
	public static final String  invitation_code_empty_error_info="邀请码不能为空";
	
	public static final int     invitation_code_invalid_status=10075;
	public static final String  invitation_code_invalid_info="邀请码无效";
	
	public static final int     email_format_error_status=10076;
	public static final String  email_format_error_info="邮箱格式错误";
	
	public static final int 	access_deny_status 	= 403;
	public static final String 	access_deny_info 	= "权限不足,请联系管理员";
	
	public static final int 	new_pwd_empty_error_status 	= 10078;
	public static final String 	new_pwd_empty_error_info 	= "新密码不能为空";
	
	public static final int 	repeat_pwd_empty_error_status 	= 10078;
	public static final String 	repeat_pwd_empty_error_info 	= "确认密码不能为空";
	
	public static final int 	pwd_deferent_error_status 	= 10079;
	public static final String 	pwd_deferent_error_info 	= "两次密码输入不一致";
	
	public static final int 	wechatRegister_status 	= 10080;
	public static final String 	wechatRegister_info 	= "该微信未绑定账号";
	
	public static final int 	login_timeout_status 	= 10081;
	public static final String 	login_timeout_info 	= "登录超时！";
	
	public static final int 	wechat_is_binded_error_status 	= 10082;
	public static final String 	wechat_is_binded_error_info 	= "该微信已经被绑定！";
	
	public static final int    param_error_status=10083;
	public static final String param_error_info="参数错误";
	
	public static final int    sex_error_status=10084;
	public static final String sex_error_info="性别参数错误";
	
	public static final int    currency_error_status=10085;
	public static final String currency_error_info="币种参数错误";
	
	public static final int    limit_min_error_status=10086;
	public static final String limit_min_error_info="额度最小值参数错误";
	
	public static final int    limit_max_error_status=10087;
	public static final String limit_max_error_info="额度最大值参数错误";
	
	public static final int    limit_error_status=10088;
	public static final String limit_error_info="额度最小值不得大于最大值";
	
	public static final int    phone_no_change_status=10089;
	public static final String phone_no_change_info="手机号未更改，无须变更操作";	
	
	public static final int     comment_type_empty_status=10090;
	public static final String 	comment_type_empty_info 	= "评论类型不能为空";
	
	public static final int     comment_type_value_status=10091;
	public static final String 	comment_type_value_info 	= "评论类型值必须是0或1";
	
	public static final int     comment_project_value_status=10092;
	public static final String 	comment_project_value_info 	= "项目ID不能为空";
	
	public static final int     comment_news_value_status=10093;
	public static final String 	comment_news_value_info 	= "新闻ID不能为空";
	
	public static final int     get_jsticket_error_status=10094;
	public static final String 	get_jsticket_error_info 	= "获取jsticket失败";
	
	public static final int 	phone_is_binded_error_status 	= 10095;
	public static final String 	phone_is_binded_error_info 	= "该手机号已绑定微信！";
	
	public static final int     bind_phone_error_status = 10095;
	public static final String 	bind_phone_error_info 	= "该手机号已注册，不能绑定！";
	
	public static final int useraccount_empty_status=10096;
	public static final String useraccount_empty_info="请输入用户名";
	
	public static final int pwd_confirm_error_status=10097;
	public static final String pwd_confirm_error_info="两次输入密码不一致";
	
	public static final int role_empty_error_status=10098;
	public static final String role_empty_error_info="请选择用户组";
	
	public static final int useraccount_exist_status=10099;
	public static final String useraccount_exist_info="用户名已存在";
	
	public static final int old_pwd_error_status=10100;
	public static final String old_pwd_error_info="旧密码错误";
	
	public static final int group_name_empty_status=10101;
	public static final String group_name_empty_info="请输入管理组名称";
	
	public static final int group_desc_empty_status=10102;
	public static final String group_desc_empty_info="请输入管理组描述";
	
	public static final int group_permission_empty_status=10103;
	public static final String group_permission_empty_info="请选择管理组权限";
	
	public static final int group_name_exist_status=10104;
	public static final String group_name_exist_info="管理组已经存在，请勿重复添加";
	
	public static final int group_no_exist_status=10105;
	public static final String group_no_exist_info="管理组不存在或已被删除";
	
	public static final int admin_no_exist_status=10106;
	public static final String admin_no_exist_info="管理员不存在或已被删除";
	
	public static final int validcode_empty_status=10107;
	public static final String validcode_empty_info="请输入图形验证码";
	
	public static final int validcode_error_status=10108;
	public static final String validcode_error_info="图形验证码错误";
	
	public static final int ip_limit_status=10109;
	public static final String ip_limit_info="禁止访问";
	
	public static final int tag_error_status=10110;
	public static final String tag_error_info="标签名称不能为空";
	
	public static final int tag_exist_status=10111;
	public static final String tag_exist_info="标签已经存在,请勿重复添加";
	
	public static final int system_role_opera_error_status=10112;
	public static final String system_role_opera_error_info="超级管理组权限，禁止操作";
	
	public static final int remarkName_empty_status=10113;
	public static final String remarkName_empty_info="请输入会员备注名称";
	
	public static final int remarkName_exist_status=10114;
	public static final String remarkName_exist_info="会员备注已经存在";
	
	public static final int message_receive_empty_status=10115;
	public static final String message_receive_empty_info="请选择收件人员";
	
	public static final int message_type_error_status=10116;
	public static final String message_type_error_info="私信类型错误";
	
	public static final int message_content_empty_status=10117;
	public static final String message_content_empty_info="私信内容不能为空";
	
	public static final int remark_empty_error_status=10118;
	public static final String remark_empty_error_info="请选择会员备注";
	
	public static final int user_empty_error_status=10119;
	public static final String user_empty_error_info="请选择会员";
	
	public static final int invalid_date_empty_status=10120;
	public static final String invalid_date_empty_info="时效时间未设置";
	
	public static final int invalid_date_error_status=10121;
	public static final String invalid_date_error_info="时效时间不能小于当前时间";
	
	public static final int hot_word_empty_status=10122;
	public static final String hot_word_empty_info="请输入热门词汇";
	
	public static final int sms_length_empty_status=10123;
	public static final String sms_length_empty_info="验证码长度不能为空！";
	
	public static final int sms_length_format_error_status=10124;
	public static final String sms_length_format_error_info="验证码长度必须为正整数";
	
	public static final int sms_time_empty_status=10125;
	public static final String sms_time_empty_info="验证码有效时间不能为空！";
	
	public static final int sms_time_format_error_status=10126;
	public static final String sms_time_format_error_info="验证码有效时间必须为正整数";
	
	public static final int role_not_exist_status=10127;
	public static final String role_not_exist_info="群组不存在";
	
}  

