package service;

import java.util.List;

import dao.MemberDAOImpl;
import domain.MemberBean;


public class MemberServiceImpl implements MemberService {

	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {}
	List<MemberBean> memberList;
	
	
	@Override
	public void createMember(MemberBean member) {
		MemberDAOImpl.getInstance().insertMember(member);		
	}
	
	@Override
	public List<MemberBean> listMember() {
		return MemberDAOImpl.getInstance().selectAllmemberList();
	}

	@Override
	public List<MemberBean> findMemberByTeamName(String name) {
		return MemberDAOImpl.getInstance().selectMemberBySearchWord(name);
	}

	@Override
	public MemberBean findById(String id) {
		return  MemberDAOImpl.getInstance().selectFindById(id);
	}

	@Override
	public int memberCount() {
		return MemberDAOImpl.getInstance().countMember();
	}

	@Override
	public void updateMemberInformation(MemberBean member) {
		MemberDAOImpl.getInstance().updateMemberInformation(member);		
		
	}

	@Override
	public void deleteMemberInformation(MemberBean member) {
		MemberDAOImpl.getInstance().deleteMemberInformation(member);
		
	}
	@Override
	public boolean login(MemberBean member) {
		return(MemberDAOImpl.getInstance().login(member)!=null);
	}


}
