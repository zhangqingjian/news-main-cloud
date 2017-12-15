package com.yo.news.sale.bill.mapper;

import com.yo.news.sale.bill.domain.BillDO;

public interface BillDOMapper {
    int deleteByPrimaryKey(String billId);

    int insert(BillDO record);

    int insertSelective(BillDO record);

    BillDO selectByPrimaryKey(String billId);

    int updateByPrimaryKeySelective(BillDO record);

    int updateByPrimaryKey(BillDO record);
}