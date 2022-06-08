package com.jumstc.template.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * t_aws_account_flow
 * @author 
 */
@Data
public class TAwsAccountFlow implements Serializable {
    /**
     * 流水ID
     */
    private Long flowId;

    /**
     * 账户编号
     */
    private Long accountNo;

    /**
     * 基础账户编号
     */
    private Long baseAccountNo;

    /**
     * 付款外部成员编号
     */
    private String payPartNo;

    /**
     * 付款外部成员名称
     */
    private String payPartName;

    /**
     * 成员类型 1.货主 2.业务公司 3.司机 4. 货主超级管理 （自然人） 5.承运商 6.金融机构
     */
    private Byte payPartType;

    /**
     * 操作前余额
     */
    private BigDecimal beforeAmount;

    /**
     * 操作前总账户余额
     */
    private BigDecimal beforeTotalAmount;

    /**
     * 操作余额
     */
    private BigDecimal opsAmount;

    /**
     * 操作后余额
     */
    private BigDecimal afterAmount;

    /**
     * 操作后总账户余额
     */
    private BigDecimal afterTotalAmount;

    /**
     * 操作类型 1.收入 2.支出 3.其他
     */
    private Byte opsType;

    /**
     * 业务类型 1.企业充值、2.个人充值、3.微信充值、4.支付宝充值、5.司机提现、6.承运商提现、7.货主提现、8.运费支付、9.服务费支付、10.代理费支付、11.整车定金、12.油卡收入、13.油卡退款、14.油卡转账、15.优惠加油、16.开票返利、17.资金分配、18.资金回收、19.运费退款、20.服务费退款、21.代理费退款、22.货主奖励、23.货主罚款、24.营销业绩、25.邀请活动、26.邀请活动提现、27.承运商奖励、28.承运商罚款、31.金融机构充值、32.金融机构提现、33.信用支付、34.信用票据承兑、35.信用还款、36.信用退还、37.取消承兑、38.信用分配、39.信用回收、40.提现退回、41.白条利息
     */
    private Byte bizType;

    /**
     * 业务单据编号
     */
    private String outBizNo;

    /**
     * 交易流水号（涉及到账户金额变动的，都会走支付中心）
     */
    private String innerTransNo;

    /**
     * 业务性质,1.零担、2.整车、3.大宗、4.快捷订单、5.其它
     */
    private Byte bizNature;

    /**
     * 业务公司编码
     */
    private String businessCompanyCode;

    /**
     * 业务公司名称
     */
    private String businessCompanyName;

    /**
     * 收款账户编号
     */
    private Long receiveAccountNo;

    /**
     * 收款基础账户编号
     */
    private Long receiveBaseAccountNo;

    /**
     * 收款外部成员编号
     */
    private String receivePartNo;

    /**
     * 收款外部成员名称
     */
    private String receivePartName;

    /**
     * 成员类型 1.货主 2.业务公司 3.司机 4. 货主超级管理 （自然人） 5.承运商 6.金融机构
     */
    private Byte receivePartType;

    /**
     * 流水类型 1.收入、2.支出、3.冻结、4.解冻、5.在途、6.在途转收入
     */
    private Byte flowType;

    /**
     * 是否给用户展示 1.展示 2.不展示 
     */
    private Byte isShow;

    /**
     * 是否解冻 1. 是 2. 否 
     */
    private Byte freezeStatus;

    /**
     * 流水备注
     */
    private String remark;

    /**
     * 关联流水ID
     */
    private Long relatedFlowId;

    /**
     * 创建人用户编号
     */
    private String createUserCode;

    /**
     * 创建人类型
     */
    private Byte createUserType;

    /**
     * 创建人名称
     */
    private String createUserName;

    /**
     * 创建人手机号
     */
    private String createUserPhone;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除 1.有效 2.无效
     */
    private Byte valid;

    /**
     * 是否异步算余额 1是 2否
     */
    private Byte reckonStatus;

    private static final long serialVersionUID = 1L;
}