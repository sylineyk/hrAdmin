package com.hong.admin.service.customer;

import com.hong.admin.dao.mapper.customer.CustomerMapper;
import com.hong.admin.util.Constant;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by syline on 2017/7/22.
 */
@Service
public class CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 获取经纪人信息
     *
     * @return
     */
    public Map selectBrokerInfos(String param, int currPage) {
        Map result = new HashMap<>();
        PageList<Map> map = customerMapper.selectCustomerInfoByParam(param, new PageBounds(currPage, Constant.PageKey.LIMIT));
        int currpage = map.getPaginator().getPage();
        int total = map.getPaginator().getTotalPages();

        result.put("results", (List) map);
        result.put("total", total);
        result.put("currpage", currpage);
        return result;
    }

}
