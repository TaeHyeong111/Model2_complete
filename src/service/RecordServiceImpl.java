package service;

import java.util.List;

import domain.RecordBean;

public class RecordServiceImpl implements RecordService{

	private static RecordService instance = new RecordServiceImpl();
	public static RecordService getInstance() {return instance;}
	private RecordServiceImpl() {}
	
	@Override
	public void createRecord(RecordBean record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RecordBean> recordBeanList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecordBean> findRecordByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecordBean findRecordTeamById(RecordBean record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int recordCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateRecord(RecordBean record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRecord(RecordBean record) {
		// TODO Auto-generated method stub
		
	}

}
