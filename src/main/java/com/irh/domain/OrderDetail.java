package com.irh.domain;

import java.time.LocalDateTime;

/**
 * 订单表
 */
public class OrderDetail {

    /**
     * 实体唯一的标识符，用基本类型
     */
    private Integer id;
    /**
     * 实体或者对象的版本号，乐观锁，用基本类型<br>
     * 此处要注意，版本号的更新问题。
     */
    private Integer version;
    /**
     * 创建人
     */
    private Integer createdBy;
    /**
     * 创建时间
     */
    private LocalDateTime createdTime;
    /**
     * 记录更新操作者
     */
    private Integer updatedBy;
    /**
     * 记录更新时间
     */
    private LocalDateTime updatedTime;
    /**
     * 软删除标志 删除为0 启用为1
     */
    private Integer delFlag = 1;
    /**
     * 主订单编号
     */
    private String mainOrderCode;
    /**
     * 订单来源id
     */
    private Integer srcId;
    /**
     * 门店来源ID
     */
    private Integer srcShopId;
    /**
     * '如果delivery_type为'2'门店自提' 时为门店ID，否则为空'
     */
    private Integer shopId;

    /**
     * 微商城店铺id
     */
    private Integer busShopId;

    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 商户订单（外部订单号）
     */
    private String merchantId;
    /**
     * 配送站id
     */
    private Integer stationId;
    /**
     * 配送员id
     */
    private Integer deliverymanId;
    /**
     * 配送方式
     */
    private Integer deliveryType;
    /**
     * 支付方式
     */
    private Integer payModesId;
    /**
     * 配送开始时间
     */
    private LocalDateTime deliveryStartTime;
    /**
     * 配送结束时间
     */
    private LocalDateTime deliveryEndTime;
    /**
     * 下单人姓名
     */
    private String ownerName;
    /**
     * 下单人手机号
     */
    private String ownerMobile;
    /**
     * 商城用户id
     */
    private Integer userId;
    /**
     * 订单状态
     */
    private Integer orderStatus;
    /**
     * 支付状态
     */
    private Integer payStatus;

    /**
     * 用户操作状态
     */
    private Integer userOperStatus;

    /**
     * 用户侧的订单状态展示
     */
    private Integer userOrderStatus;
    /**
     * 团购券订单使用状态
     */
    private Integer grouponCouponUsed;
    /**
     * 团购券号
     */
    private String grouponCoupon;
    /**
     * 0 不要发票，1要发票
     */
    private Integer invoiceNeed;
    /**
     * 发票的相关备注信息
     */
    private String invoice;
    /**
     * 订单商品总金额(不包括优惠等金额)
     */
    private Integer goodsAmount;
    /**
     * 使用的卡券总金额
     */
    private Integer couponAmount;
    /**
     * 使用的卡券名称
     */
    private String couponName;
    /**
     * 该订单应收金额
     */
    private Integer receivableAmount;
    /**
     * 订单金额（应支付金额=订单商品总金额-卡券或者订单优惠金额）
     */
    private Integer orderAmount;
    /**
     * 订单优惠总金额（商品总优惠金额）
     */
    private Integer discountAmount;
    /**
     * 订单优惠名称
     */
    private String discountName;
    /**
     * 未签收时货到付款实收
     */
    private Integer codAmount;
    /**
     * 运费金额
     */
    private Integer freightAmount;
    /**
     * 支付金额
     */
    private Integer payAmount;

    /**
     * 固定支付金额
     */
    private Integer fixPayAmount;
    /**
     * 订单转换时间
     */
    private LocalDateTime exchangeTime;
    /**
     * 订单打印时间
     */
    private LocalDateTime printTime;
    /**
     * 所有的祝福贺卡集合
     */
    private String greetingCard;
    /**
     * 分配配送站的客服人员id
     */
    private Integer lastOptCsId;
    /**
     * 订单取消原因类型，1为取消，2为异常
     */
    private Integer reasonType;
    /**
     * 订单取消理由具体描述
     */
    private String cancelReason;
    /**
     * 订单取消原因code（map迁移到数据字典）
     */
    private String reasonCode;
    /**
     * 收货人名称
     */
    private String recipientName;
    /**
     * 收货人电话
     */
    private String recipientMobile;
    /**
     * 收货人地址
     */
    private String recipientAddress;
    /**
     * 区域id
     */
    private Integer regionId;
    /**
     * 城市id
     */
    private Integer cityId;
    /**
     * 标志性建筑
     */
    private String landmark;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 发货时间
     */
    private LocalDateTime shipTime;
    /**
     * 打包时间
     */
    private LocalDateTime packTime;
    /**
     * 订单完成时间
     */
    private LocalDateTime finishTime;
    /**
     * 客服操作人员点击“提交”按钮时间
     */
    private LocalDateTime submitTime;
    /**
     * 订单组合类型
     */
    private Integer orderCombinationTypeId;
    /**
     * 订单自动确认完成时间(单位:小时)
     */
    private Integer confirmCompleteTime;

    /**
     * 订单类型 {
     * 默认为普通订单
     */
    private Integer orderType;

    private Integer bindStatus;

    private String clientId;

    private Integer isDivision;

    /**
     * 最晚打包时间
     */
    private LocalDateTime latestPackTime;

    /**
     * 生产晚点 0-否 1-是
     */
    private int latestFlag;

    /**
     * 旧订单号标示 0-旧订单，1-新订单
     */
    private Integer oldOrderFlag;

    public String getMainOrderCode() {
        return mainOrderCode;
    }

    public void setMainOrderCode(String mainOrderCode) {
        this.mainOrderCode = mainOrderCode;
    }

    public Integer getSrcId() {
        return srcId;
    }

    public void setSrcId(Integer srcId) {
        this.srcId = srcId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Integer getDeliverymanId() {
        return deliverymanId;
    }

    public void setDeliverymanId(Integer deliverymanId) {
        this.deliverymanId = deliverymanId;
    }

    public Integer getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Integer deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Integer getPayModesId() {
        return payModesId;
    }

    public void setPayModesId(Integer payModesId) {
        this.payModesId = payModesId;
    }

    public LocalDateTime getDeliveryStartTime() {
        return deliveryStartTime;
    }

    public void setDeliveryStartTime(LocalDateTime deliveryStartTime) {
        this.deliveryStartTime = deliveryStartTime;
    }

    public LocalDateTime getDeliveryEndTime() {
        return deliveryEndTime;
    }

    public void setDeliveryEndTime(LocalDateTime deliveryEndTime) {
        this.deliveryEndTime = deliveryEndTime;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerMobile() {
        return ownerMobile;
    }

    public void setOwnerMobile(String ownerMobile) {
        this.ownerMobile = ownerMobile;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getUserOrderStatus() {
        return userOrderStatus;
    }

    public void setUserOrderStatus(Integer userOrderStatus) {
        this.userOrderStatus = userOrderStatus;
    }

    public Integer getGrouponCouponUsed() {
        return grouponCouponUsed;
    }

    public void setGrouponCouponUsed(Integer grouponCouponUsed) {
        this.grouponCouponUsed = grouponCouponUsed;
    }

    public String getGrouponCoupon() {
        return grouponCoupon;
    }

    public void setGrouponCoupon(String grouponCoupon) {
        this.grouponCoupon = grouponCoupon;
    }

    public Integer getInvoiceNeed() {
        return invoiceNeed;
    }

    public void setInvoiceNeed(Integer invoiceNeed) {
        this.invoiceNeed = invoiceNeed;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public Integer getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(Integer goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public Integer getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(Integer couponAmount) {
        this.couponAmount = couponAmount;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Integer getReceivableAmount() {
        return receivableAmount;
    }

    public void setReceivableAmount(Integer receivableAmount) {
        this.receivableAmount = receivableAmount;
    }

    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Integer discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public Integer getCodAmount() {
        return codAmount;
    }

    public void setCodAmount(Integer codAmount) {
        this.codAmount = codAmount;
    }

    public Integer getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(Integer freightAmount) {
        this.freightAmount = freightAmount;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    public LocalDateTime getExchangeTime() {
        return exchangeTime;
    }

    public void setExchangeTime(LocalDateTime exchangeTime) {
        this.exchangeTime = exchangeTime;
    }

    public LocalDateTime getPrintTime() {
        return printTime;
    }

    public void setPrintTime(LocalDateTime printTime) {
        this.printTime = printTime;
    }

    public String getGreetingCard() {
        return greetingCard;
    }

    public void setGreetingCard(String greetingCard) {
        this.greetingCard = greetingCard;
    }

    public Integer getLastOptCsId() {
        return lastOptCsId;
    }

    public void setLastOptCsId(Integer lastOptCsId) {
        this.lastOptCsId = lastOptCsId;
    }

    public Integer getReasonType() {
        return reasonType;
    }

    public void setReasonType(Integer reasonType) {
        this.reasonType = reasonType;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientMobile() {
        return recipientMobile;
    }

    public void setRecipientMobile(String recipientMobile) {
        this.recipientMobile = recipientMobile;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDateTime getPackTime() {
        return packTime;
    }

    public void setPackTime(LocalDateTime packTime) {
        this.packTime = packTime;
    }

    public LocalDateTime getShipTime() {
        return shipTime;
    }

    public void setShipTime(LocalDateTime shipTime) {
        this.shipTime = shipTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public LocalDateTime getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(LocalDateTime submitTime) {
        this.submitTime = submitTime;
    }

    public Integer getOrderCombinationTypeId() {
        return orderCombinationTypeId;
    }

    public void setOrderCombinationTypeId(Integer orderCombinationTypeId) {
        this.orderCombinationTypeId = orderCombinationTypeId;
    }

    public Integer getConfirmCompleteTime() {
        return confirmCompleteTime;
    }

    public void setConfirmCompleteTime(Integer confirmCompleteTime) {
        this.confirmCompleteTime = confirmCompleteTime;
    }

    public Integer getSrcShopId() {
        return srcShopId;
    }

    public void setSrcShopId(Integer srcShopId) {
        this.srcShopId = srcShopId;
    }


    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Integer getIsDivision() {
        return isDivision;
    }

    public void setIsDivision(Integer isDivision) {
        this.isDivision = isDivision;
    }

    public Integer getFixPayAmount() {
        return fixPayAmount;
    }

    public void setFixPayAmount(Integer fixPayAmount) {
        this.fixPayAmount = fixPayAmount;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getUserOperStatus() {
        return userOperStatus;
    }

    public void setUserOperStatus(Integer userOperStatus) {
        this.userOperStatus = userOperStatus;
    }

    public LocalDateTime getLatestPackTime() {
        return latestPackTime;
    }

    public void setLatestPackTime(LocalDateTime latestPackTime) {
        this.latestPackTime = latestPackTime;
    }

    public int getLatestFlag() {
        return latestFlag;
    }

    public void setLatestFlag(int latestFlag) {
        this.latestFlag = latestFlag;

    }

    public Integer getBindStatus() {
        return bindStatus;
    }

    public void setBindStatus(Integer bindStatus) {
        this.bindStatus = bindStatus;
    }

    public Integer getOldOrderFlag() {
        return oldOrderFlag;
    }

    public void setOldOrderFlag(Integer oldOrderFlag) {
        this.oldOrderFlag = oldOrderFlag;
    }

    public Integer getBusShopId() {
        return busShopId;
    }

    public void setBusShopId(Integer busShopId) {
        this.busShopId = busShopId;
    }
}