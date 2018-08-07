package service;
import java.util.List;
import java.util.Map;

import domain.MemberBean;

public interface MemberService {
	public void createMember(MemberBean member);
	public List<MemberBean> listMember();
	public List<MemberBean> getlist(Map<?,?>param);      //<?,?> 와일드카드(one의 의미) *는 all의 의미
	public List<MemberBean> findMemberByTeamName(String name);
	public int memberCount();
	public MemberBean findById(String id);
	public void updateMemberInformation(MemberBean member);
	public void deleteMemberInformation(MemberBean member);
	public boolean login(MemberBean member);
}