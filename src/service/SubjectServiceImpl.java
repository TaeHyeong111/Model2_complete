package service;

import java.util.List;

import domain.SubjectBean;

public class SubjectServiceImpl implements SubjectService {
	private static SubjectService instance = new SubjectServiceImpl();
	public static SubjectService getInstance() {return instance;}
	private SubjectServiceImpl() {}

	@Override
	public void createSubject(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SubjectBean> subjectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectBean> findSubjectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubjectBean findSubjectById(SubjectBean subject) {
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
