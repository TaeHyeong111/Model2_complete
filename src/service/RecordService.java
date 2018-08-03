package service;

import java.util.List;

import domain.RecordBean;

public interface RecordService {
	public void createRecord(RecordBean record); 
	public List<RecordBean> recordBeanList();
	public List<RecordBean> findRecordByName(String name);
	public RecordBean findRecordTeamById(RecordBean record);
	public int recordCount();
	public void updateRecord(RecordBean record);
	public void deleteRecord(RecordBean record);
}
