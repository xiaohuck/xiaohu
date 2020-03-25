package com.bai.xiaohu.pojo;

import com.bai.xiaohu.utlis.DateUtils;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Author xiaohu
 * @Date 2020/3/24 10:19
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class Orders {
    public String id;
    private String orderNum;
    private Date orderTime;
    private String orderTimeStr;
    private int orderStatus;
    private String orderStatusStr;
    private Product product;
    private String productId;
    private Integer payType;
    private String payTypeStr;
    private String orderDesc;
    private String user;
    private String address;

    public String getOrderStatusStr() {
        //订单状态(0 未支付 1 已支付)
        if(orderStatus==0){
            orderStatusStr="未支付";
        }else if(orderStatus==1){
            orderStatusStr="已支付";
        }
        return orderStatusStr;
    }
    public String getOrderTimeStr() {
        if(orderTime!=null){
            orderTimeStr= DateUtils.date2String(orderTime,"yyyy-MM-dd HH:mm");
        }
        return orderTimeStr;
    }
    public String getPayTypeStr() {
        //支付方式(0 支付宝 1 微信 2其它)
        if(payType==0){
            payTypeStr="支付宝";
        }else if(payType==1){
            payTypeStr="微信";
        }else if(payType==2){
            payTypeStr="其它";
        }
        return payTypeStr;
    }

}
