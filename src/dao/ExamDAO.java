package dao;
import java.util.List;
import domain.*;
public interface ExamDAO {
	public void insertExam(ExamBean exam);
	public List<ExamBean> selectAllList();
	public List<ExamBean> selectExamById(String name);
	public ExamBean selectExamById(ExamBean exam);
	public int examCount();
	public void updateExamInformation(ExamBean exam);
	public void deleteExamInformation(ExamBean exam);
}
