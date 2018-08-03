package service;

import java.util.List;

import domain.SubjectBean;

public interface SubjectService {
	public void createSubject(SubjectBean subject);
	public List<SubjectBean> subjectList();
	public List<SubjectBean> findSubjectByName(String name);
	public SubjectBean findSubjectById(SubjectBean subject);
	public int countSubject();
	public void updateSubjectInformation(SubjectBean subject);
	public void deleteSubjectInformation(SubjectBean subject);
}
