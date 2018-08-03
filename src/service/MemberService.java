package service;
import java.util.List;
import domain.MemberBean;

public interface MemberService {
	public void createMember(MemberBean member);
	public List<MemberBean> listMember();
	public List<MemberBean> findMemberByTeamName(String name);
	public int memberCount();
	public MemberBean findById(String id);
	public void updateMemberInformation(MemberBean member);
	public void deleteMemberInformation(MemberBean member);
	public boolean login(MemberBean member);
}