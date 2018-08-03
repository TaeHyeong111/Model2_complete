package dao;

import java.util.List;

import domain.ProjectTeamBean;

public class ProjectTeamDAOImpl implements ProjectTeamDAO {
	private static ProjectTeamDAO instance = new ProjectTeamDAOImpl();
	public static ProjectTeamDAO getInstance() {return instance;}
	private ProjectTeamDAOImpl() {}
	@Override
	public void insertProjectTeam(ProjectTeamBean projectTeam) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<ProjectTeamBean> selectProjectTeamList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ProjectTeamBean> selectProjectTeamByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ProjectTeamBean selectProjectTeamById(ProjectTeamBean projectTeam) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int projectTeamCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void updateProjectTeamInformation(ProjectTeamBean projectTeam) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteProjectTeamInformation(ProjectTeamBean projectTeam) {
		// TODO Auto-generated method stub
		
	}
	


}
