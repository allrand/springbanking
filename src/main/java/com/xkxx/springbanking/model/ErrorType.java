package com.xkxx.springbanking.model;

public enum  ErrorType {
    DB_ADD_ERROR("40001","数据库添加失败！"),
    DB_DELETE_ERROR("40003","删除数据失败！"),
    CRYPT_DATA_ERROR("40004","请求密文数据被破坏！"),
    QUERY_ERROR("40005","查询数据异常"),
    REQ_ERROR("40006","请求数据异常！"),
    GET_CPSCARD_AUTH_FAIL("40007","抱歉，请求一卡通进行身份验证失败，请联系管理员！"),
    GET_MSG_CODE_FAIL("40008","抱歉，请求短信验证码失败，请联系管理员！"),
    OPEN_AND_FRZNCD_FAIL("40009","抱歉，请求开户、冻结失败，请联系管理员！"),
    LOGIN_FAIL("40010","系统异常，登录失败！"),
    LOGIN_INFO_ERROR("40011","用户名或密码错误！"),
    NO_PEMISSION_ERROR("40012","对不起，您无操作权限！"),
    NO_USER_ERROR("40013","用户不存在！"),
    OPENID_DIFF_ERROR("40014","抱歉，您的用户名密码已被其他公众号用户绑定，若需使用，请先解绑！"),
    QUERY_NO_DATA_ERROR("40015","抱歉，该条件下无记录！"),
    NO_FILEADDRESS_ERROR("40016","图片地址不能为空！"),
    NO_FILEDIR_ERROR("40017","图片存储根文件夹不存在，请联系管理员！"),
    NO_FILE_ERROR("40018","文件不存在，请联系管理员！"),
    NO_ST_OR_ET_ERROR("40019","起始日期、截止日期必须同时选择！"),
    ST_BIGGER_ET_ERROR("40020","起始日期不能大于截止日期！"),
    NO_USERNAME_ERROR("40021","用户编号不能为空！"),
    NO_CNNAME_ERROR("40022","用户姓名不能为空！"),
    NO_DEPTCODE_ERROR("40023","机构编号不能为空！"),
    NO_LGSTEL_ERROR("40024","联系电话不能为空！"),
    DB_ALTER_ERROR("40025","抱歉，修改信息失败！"),
    NO_ALTERPWD_PERMIS_ERROR("40026","抱歉，您不能修改他人密码！"),
    OLD_PWD_ERROR("40027","抱歉，原始密码验证错误！"),
    NO_DEPT_ERROR("40028","抱歉，该部门信息不存在！"),
    USER_REPEAT_ERROR("40029","抱歉，该用户号已经存在！"),
    CNNAME_LEN_ERROR("40030","用户姓名长度不能超过40！"),
    NO_IMGFILE_ERROR("40031","图片存储文件夹不存在，请联系管理员！"),
    REQ_ACCTINFO_FAIL("40032","抱歉，请求一卡通获取账户信息失败，请联系管理员！"),
    REQ_ATTNREC_FAIL("40033","抱歉，请求一卡通获取考勤数据失败，请联系管理员！"),
    REQ_CONSDETAIL_FAIL("40034","抱歉，请求一卡通获取消费明细失败，请联系管理员！"),
    REQ_RLACRL_FAIL("40035","抱歉，请求一卡通执行挂失/解挂失败，请联系管理员！"),
    NO_OPENID_ERROR("40036","抱歉，请从融e联客户端进入！"),
    NO_APPLY_ADDRESS_ERROR("40037","抱歉，报修地址不能为空"),
    NO_APPLY_USERNAME_ERROR("40038","抱歉，报修人员编号不能为空"),
    NO_APPLY_CNNAME_ERROR("40039","抱歉，报修人员姓名不能为空"),
    NO_APPLY_REASON_ERROR("40040","抱歉，报修原因不能为空"),
    REPAIRS_REPEAT_ERROR("40041","抱歉，该报修信息已经存在！"),
    NO_REJECT_INFO_ERROR("40042","抱歉，驳回时驳回原因不能为空！"),
    NO_PIC_ERROR("40043","请至少上传一张图片！"),
    PIC_DATA_ERROR("40044","数据不合法！"),
    PIC_PRIX_ERROR("40045","上传图片格式不合法！"),
    PIC_DATA_NULL_ERROR("40046","上传图片格式不合法！"),
    PIC_SAVE_ERROR("40047","上传图片失败,请稍后再试！"),
    SAME_PIC_ERROR("40048","添加失败，存在相同图片，请检查！"),
    NO_REPAIR_USER_ERROR("40049","请指定维修人员！"),
    NO_REPAIR_USERNAME_ERROR("40050","抱歉，维修人员编号为空！"),
    NO_REPAIR_CNNAME_ERROR("40051","维修人员姓名不能为空！"),
    NO_REPAIR_DESC_ERROR("40052","维修描述不能为空！"),
    CANCEL_BIND_ERROR("40053","抱歉，发生异常，解除绑定失败！"),
    NO_BIND_ERROR("40054","抱歉，不存在用户绑定信息！"),
    REASON_LEN_ERROR("40055","说明或描述长度不能超过200！"),
    ADDRESS_LEN_ERROR("40056","地址长度不能超过200！"),
    RLACRL_FAIL("40057","挂失解挂失败！"),
    LOG_IN_FAILURE("40058",""),
    ACCT_INFO_ERROR("40059","用户信息错误，请检查输入项！"),
    REQ_TOKEN_FAIL("40060","抱歉，请求一卡通获取token失败，请联系管理员！"),
    REQ_TOKEN_REPEAT_ERROR("40061","抱歉，网络阻塞，请稍后再试！"),

    LOGIN_ERROR("40002","用户名或密码错误");

    private String error;
    private String errMsg;

    public String getError() {
        return error;
    }

    public String getErrMsg() {
        return errMsg;
    }

    ErrorType(String error, String errMsg) {
        this.error = error;
        this.errMsg = errMsg;
    }
}
