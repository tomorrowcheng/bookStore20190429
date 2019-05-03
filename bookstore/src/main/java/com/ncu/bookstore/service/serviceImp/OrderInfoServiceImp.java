package com.ncu.bookstore.service.serviceImp;

import com.ncu.bookstore.dao.OrderInfoMapper;
import com.ncu.bookstore.entity.OrderInfo;
import com.ncu.bookstore.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tomorrow on 2019/5/1/001
 */
@Service
public class OrderInfoServiceImp implements OrderInfoService {
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Override
    public int insertOrderInfo(OrderInfo orderInfo) {
        return orderInfoMapper.insertOrderInfo(orderInfo);
    }

    @Override
    public int deleteOrderInfo(OrderInfo orderInfo) {
        return orderInfoMapper.deleteOrderInfo(orderInfo);
    }

    @Override
    public int updateOrderInfo(OrderInfo orderInfo) {
        return orderInfoMapper.updateOrderInfo(orderInfo);
    }

    @Override
    public List<OrderInfo> selectOrderInfo(OrderInfo orderInfo) {
        return orderInfoMapper.selectOrderInfo(orderInfo);
    }
}
