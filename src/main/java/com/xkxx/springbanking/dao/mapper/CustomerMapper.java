package com.xkxx.springbanking.dao.mapper;

import com.xkxx.springbanking.entity.Customer;
import com.xkxx.springbanking.util.ListProperties;

import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(String customerId);
    int insert(Customer record);
    int insertSelective(Customer record);
    Customer selectByPrimaryKey(String customerId);
    List<Customer> selectAll();
    int countAll();
    /**
     * This method corresponds to the database table TSP30.CUSTOMER
     *
     * @mbg.generated Fri Aug 02 11:31:22 CST 2019
     */
    int updateByPrimaryKeySelective(Customer record);

    /**
     * This method corresponds to the database table TSP30.CUSTOMER
     *
     * @mbg.generated Fri Aug 02 11:31:22 CST 2019
     */
    int updateByPrimaryKey(Customer record);
}
