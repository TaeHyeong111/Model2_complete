package service;

import java.util.List;

import domain.*;

public interface ExamService {
	public void createExam(ExamBean exam);
	public List<ExamBean> examlist();
	public List<ExamBean> findExamById(String name);
	public int examCount();
	public ExamBean findExamById(ExamBean exam);
	public void updateExamInformation(ExamBean exam);
	public void deleteExamInformation(ExamBean exam);
}
