package com.server.module.system.replenishManage.machinesReplenishStatement;

import java.util.List;
import com.server.util.ReturnDataUtil;

/**
 * author name: why create time: 2018-04-24 11:53:01
 */
public interface ReplenishmentReportDao {

	/**
	 * 补货报表列表查询
	 * @param condition
	 * @return
	 */
	public ReturnDataUtil listPage(ReplenishmentReportForm condition);
	
	/**
	 * 补货报表列表查询
	 * @param condition
	 * @return
	 */
	public ReturnDataUtil visionListPage(ReplenishmentReportForm condition);
	

	/**
	 * 补货人员列表查询
	 * @param replenishmentReportForm
	 * @return
	 */
	public ReturnDataUtil userListPage(ReplenishmentReportForm replenishmentReportForm);
	
	public ReturnDataUtil userlistPageDetail(ReplenishmentReportForm replenishmentReportForm);
	
	public ReturnDataUtil changeListPage(ReplenishmentReportForm changeListPage);

}
