package com.ncu.bookstore.service.serviceImp;

import com.ncu.bookstore.dao.ShoppingMapper;
import com.ncu.bookstore.entity.Shopping;
import com.ncu.bookstore.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tomorrow on 2019/5/1/001
 */
@Service
public class ShoppingServiceImp implements ShoppingService{
    @Autowired
    private ShoppingMapper shoppingMapper;

    @Override
    public int insertShopping(Shopping shopping) {
        return shoppingMapper.insertShopping(shopping);
    }

    @Override
    public int deleteShopping(Shopping shopping) {
        return shoppingMapper.deleteShopping(shopping);
    }

    @Override
    public int updateShopping(Shopping shopping) {
        return shoppingMapper.updateShopping(shopping);
    }

    @Override
    public List<Shopping> selectShopping(Shopping shopping) {
        return shoppingMapper.selectShopping(shopping);
    }
}
