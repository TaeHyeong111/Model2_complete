package dao;

import java.util.List;

import domain.RecordBean;

public interface RecordDAO {
	public void insertRecord(RecordBean record); 
	public List<RecordBean> selectRecordBeanList();
	public List<RecordBean> selectRecordByName(String name);
	public RecordBean findRecordTeamById(RecordBean record);
	public int recordCount();
	public void updateRecord(RecordBean record);
	public void deleteRecord(RecordBean record);
	public String selectFirstRownum();  // rownum 자동으로 생성되는 인덱스
}
