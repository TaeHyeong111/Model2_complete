package dao;
import java.util.List;
import domain.ExamBean;

public class ExamDAOImpl implements ExamDAO {
	private static ExamDAO instance = new ExamDAOImpl();
	public static ExamDAO getInstance() {return instance;}
	private ExamDAOImpl() {}
	
	List<ExamBean> examList;
	@Override
	public void insertExam(ExamBean exam) {
		
	}
	@Override
	public List<ExamBean> selectAllList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ExamBean> selectExamById(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int examCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ExamBean selectExamById(ExamBean exam) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateExamInformation(ExamBean exam) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteExamInformation(ExamBean exam) {
		// TODO Auto-generated method stub
		
	}

}
