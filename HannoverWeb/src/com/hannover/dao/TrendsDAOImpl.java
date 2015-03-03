package com.hannover.dao;

import com.hannover.model.PO;
import com.hannover.model.Trends;



public class TrendsDAOImpl extends DAOImpl<Trends> implements TrendsDAO {
	@Override
	protected Class<? extends PO> getPOClass() {
		return Trends.class;
	}
}
