package dao;
import java.util.List;
import domain.*;

public interface ProjectTeamDAO {
	public void insertProjectTeam(ProjectTeamBean projectTeam);
	public List<ProjectTeamBean> selectProjectTeamList();
	public List<ProjectTeamBean> selectProjectTeamByName(String name);
	public ProjectTeamBean selectProjectTeamById(ProjectTeamBean projectTeam);
	public int projectTeamCount();
	public void updateProjectTeamInformation(ProjectTeamBean projectTeam);
	public void deleteProjectTeamInformation(ProjectTeamBean projectTeam);
}
