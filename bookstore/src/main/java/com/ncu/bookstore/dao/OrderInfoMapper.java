package com.ncu.bookstore.dao;

import com.ncu.bookstore.entity.OrderInfo;

import java.util.List;

/**
 * Created by Tomorrow on 2019/5/1/001
 */
public interface OrderInfoMapper {
    int insertOrderInfo(OrderInfo orderInfo);
    int deleteOrderInfo(OrderInfo orderInfo);
    int updateOrderInfo(OrderInfo orderInfo);
    List<OrderInfo> selectOrderInfo(OrderInfo orderInfo);
    List<OrderInfo> selectAllOrderInfo();
}
