package dao;

import java.util.List;

import domain.SubjectBean;

public interface SubjectDAO {
	public void insertSubject(SubjectBean subject);
	public List<SubjectBean> selectSubjectList();
	public List<SubjectBean> selectSubjectByName(String name);
	public SubjectBean selectSubjectById(SubjectBean subject);
	public int countSubject();
	public void updateSubjectInformation(SubjectBean subject);
	public void deleteSubjectInformation(SubjectBean subject);
}
