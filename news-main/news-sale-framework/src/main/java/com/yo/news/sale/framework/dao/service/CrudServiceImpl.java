package com.yo.news.sale.framework.dao.service;

import com.google.common.base.Preconditions;
import com.yo.news.sale.framework.domain.IdentityDomain;

import java.time.OffsetDateTime;

/**
 * 支持泛型注入的CrudService的默认实现
 *
 */
public class CrudServiceImpl<T extends IdentityDomain> implements CrudService<T>
{

	private final CrudMapper<T> mapper;

	public CrudServiceImpl(CrudMapper<T> mapper)
	{
		this.mapper = mapper;
	}

	@Override
	public T selectByPrimaryKey(String id)
	{
		Preconditions.checkNotNull(id, "type of id should not be NULL");
		return getMapper().selectByPrimaryKey(id);
	}

	@Override
	public int insertSelective(T entity)
	{
		Preconditions.checkNotNull(entity, "persisting entity should not be NULL");
		initializeOffsetDateTime(entity);
		return getMapper().insertSelective(entity);
	}
  

	@Override
	public int updateByPrimaryKeySelective(T entity)
	{
		Preconditions.checkNotNull(entity, "entity in updating should not be NULL");
		entity.setUpdateTime(OffsetDateTime.now());
		return getMapper().updateByPrimaryKeySelective(entity);
	}

	@Override
	public int deleteByPrimaryKey(String id)
	{
		Preconditions.checkNotNull(id, "type of id should not be NULL");
		return getMapper().deleteByPrimaryKey(id);
	}

	private CrudMapper<T> getMapper()
	{
		return mapper;
	}

	private void initializeOffsetDateTime(T entity)
	{
		entity.setCreateTime(OffsetDateTime.now());
		if (entity.getUpdateTime() == null)
		{
			entity.setUpdateTime(IdentityDomain.DEFAULT_DATE_TIME);
		}
		if (entity.getDeleteTime() == null)
		{
			entity.setDeleteTime(IdentityDomain.DEFAULT_DATE_TIME);
		}
	}

}
