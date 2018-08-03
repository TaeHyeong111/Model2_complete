package service;

import java.util.List;

import domain.ProjectTeamBean;

public class ProjectTeamServiceImpl implements ProjectTeamService {
	private static ProjectTeamService instance = new ProjectTeamServiceImpl();
	public static ProjectTeamService getInstance() {return instance;}
	private ProjectTeamServiceImpl() {}
	
	@Override
	public void createProjectTeam(ProjectTeamBean projectTeam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProjectTeamBean> projectTeamList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectTeamBean> findProjectTeamByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int projectTeamCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProjectTeamBean findProjectTeamById(ProjectTeamBean projectTeam) {
		// TODO Auto-generated method stub
		return null;
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
