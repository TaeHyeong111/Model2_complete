package dao;

import java.util.List;

import domain.SubjectBean;

public class SubjectlDAOImpl implements SubjectDAO {
	private static SubjectDAO instance = new SubjectlDAOImpl();
	public static SubjectDAO getInstance() {return instance;}
	private SubjectlDAOImpl() {}
	@Override
	public void insertSubject(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<SubjectBean> selectSubjectList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SubjectBean> selectSubjectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SubjectBean selectSubjectById(SubjectBean subject) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countSubject() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void updateSubjectInformation(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteSubjectInformation(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}


}
