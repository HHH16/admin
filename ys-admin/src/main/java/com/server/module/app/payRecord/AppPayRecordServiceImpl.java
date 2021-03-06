package com.server.module.app.payRecord;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.server.util.stateEnum.PayStateEnum;

@Service("aliPayRecordService")
public class AppPayRecordServiceImpl implements AppPayRecordService{

	public static Logger log = LogManager.getLogger(AppPayRecordServiceImpl.class); 
	@Autowired
	@Qualifier("aliPayRecordDao")
	private AppPayRecordDao payRecordDao;
	@Override
	public boolean booleanIsArrearage(Long customerId) {
		log.info("<AliPayRecordServiceImpl--booleanIsArrearage--start>");
		boolean booleanIsArrearage = payRecordDao.booleanIsArrearage(customerId);
		log.info("<AliPayRecordServiceImpl--booleanIsArrearage--end>");
		return booleanIsArrearage;
	}
	@Override
	public boolean updatePayRecord(String payCode, String ptCode) {
		log.info("<AliPayRecordServiceImpl--updatePayRecord--start>");
		PayRecordBean payRecord = payRecordDao.findPayRecordByPayCode(payCode);
		if(payRecord!=null){
			payRecord.setState(PayStateEnum.PAY_SUCCESS.getState());
			payRecord.setPtCode(ptCode);
			payRecord.setPayTime(new Date());
			if(payRecordDao.updatePayRecord(payRecord)){
				return true;
			}
		}
		return false;
	}
	@Override
	public List<PayRecordDto> findPayRecord(PayRecordForm payRecordForm) {
		log.info("<AliPayRecordServiceImpl--findPayRecord--start>");
		List<PayRecordDto> findPayRecord = payRecordDao.findPayRecord(payRecordForm);
		log.info("<AliPayRecordServiceImpl--findPayRecord--end>");
		return findPayRecord;
	}
	@Override
	public List<PayRecordDto> findPayRecord(String vmCode,int day) {
		List<PayRecordDto> findPayRecord = payRecordDao.findPayRecord(vmCode,day);
		return findPayRecord;
	}
	@Override
	public PayRecordDto findPayRecordById(Long payRecordId) {
		log.info("<AliPayRecordServiceImpl--findPayRecordById--start>");
		PayRecordDto findPayRecordById = payRecordDao.findPayRecordById(payRecordId);
		log.info("<AliPayRecordServiceImpl--findPayRecordById--end>");
		return findPayRecordById;
	}
	@Override
	public boolean updatePayState(String ptCode,String payCode, Integer state) {
		log.info("<AliPayRecordServiceImpl--updatePayState--start>");
		boolean updatePayState = payRecordDao.updatePayState(ptCode,payCode, state);
		log.info("<AliPayRecordServiceImpl--updatePayState--end>");
		return updatePayState;
	}
	@Override
	public PayRecordBean findPayRecordByPayCode(String payCode) {
		log.info("<AliPayRecordServiceImpl--findPayRecordByPayCode--start>");
		PayRecordBean findPayRecordByPayCode = payRecordDao.findPayRecordByPayCode(payCode);
		log.info("<AliPayRecordServiceImpl--findPayRecordByPayCode--end>");
		return findPayRecordByPayCode;
	}
	@Override
	public boolean update(PayRecordBean payRecordBean) {
		log.info("<AliPayRecordServiceImpl--findPayRecordByPayCode--start>");
		boolean updatePayRecord = payRecordDao.updatePayRecord(payRecordBean);
		log.info("<AliPayRecordServiceImpl--findPayRecordByPayCode--start>");
		return updatePayRecord;
	}
	@Override
	public SumPayRecordDto findPayRecordNum(PayRecordForm payRecordForm) {
		log.info("<AliPayRecordServiceImpl--findPayRecordNum--start>");
		SumPayRecordDto findPayRecordNum = payRecordDao.findPayRecordNum(payRecordForm);
		log.info("<AliPayRecordServiceImpl--findPayRecordNum--end>");
		return findPayRecordNum;
	}

}
