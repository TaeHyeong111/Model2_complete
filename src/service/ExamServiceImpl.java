package service;

import java.util.ArrayList;
import java.util.List;

import dao.ExamDAOImpl;
import dao.MemberDAOImpl;
import dao.RecordDAOImpl;
import dao.SubjectlDAOImpl;
import domain.ExamBean;
import domain.MemberBean;
import domain.RecordBean;
import domain.SubjectBean;

public class ExamServiceImpl implements ExamService {
	private static ExamService instance = new ExamServiceImpl();
	public static ExamService getInstance() {return instance;}
	private ExamServiceImpl() {}
	List<ExamBean> examList;
	
	
	@Override
	public void createExam(ExamBean exam) {
		System.out.println("===== ExamService =====");
        System.out.println(exam);
        // 과목SEQ=null,
        // 성적표SEQ=null
        System.out.println("----- RECORD TABLE INSERT ------");
        RecordBean rec = new RecordBean();
        rec.setAvg("80");
        rec.setGrade("");
        RecordDAOImpl.getInstance().insertRecord(rec);
        System.out.println("------ Exam TABLE INSERT ------");
        exam.setScore(exam.getScore().split("/")[0]);
        exam.setSubSeq(
                SubjectlDAOImpl.getInstance().
                selectSubjectByName("JAVA").get(0)
                .getSubSeq())
                ;
        exam.setRecordSeq(RecordDAOImpl.getInstance()
                .selectFirstRownum());    
        ExamDAOImpl.getInstance().insertExam(exam);
	}

	@Override
	public List<ExamBean> examlist() {
		return examList;
	}

	
	
	@Override
	public List<ExamBean> findExamById(String id) {
		List<ExamBean> temp =new ArrayList<>();
		for(ExamBean e: examList) {
			if(id.equals(e.getMemId())) {
				temp.add(e);
			}
		}
		return temp;
	}


	@Override
	public ExamBean findExamById(ExamBean exam) {
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

	@Override
	public int examCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String toString() {
		return "ExamServiceImpl [examList=" + examList + ", toString()=" + super.toString() + "]";
	}

}
