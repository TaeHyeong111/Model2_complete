package service;
import java.util.List;
import domain.*;

public interface ProjectTeamService {
	public void createProjectTeam(ProjectTeamBean projectTeam);
	public List<ProjectTeamBean> projectTeamList();
	public List<ProjectTeamBean> findProjectTeamByName(String name);
	public ProjectTeamBean findProjectTeamById(ProjectTeamBean projectTeam);
	public int projectTeamCount();
	public void updateProjectTeamInformation(ProjectTeamBean projectTeam);
	public void deleteProjectTeamInformation(ProjectTeamBean projectTeam);
}
