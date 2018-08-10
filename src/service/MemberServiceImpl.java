package service;

import java.util.List;
import java.util.Map;

import dao.MemberDAOImpl;
import domain.MemberBean;


public class MemberServiceImpl implements MemberService {

	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {}
	List<MemberBean> memberList;
	@Override
	public void add(MemberBean member) {
	  MemberDAOImpl.getInstance().insert(member);
	}
	@Override
	public List<MemberBean> search(Map<?, ?> param) {
		return MemberDAOImpl.getInstance().selectSome(param);
	}
	@Override
	public MemberBean retreieve(String id) {
		return null;
	}
	@Override
	public int Count() {
		return MemberDAOImpl.getInstance().count();
	}
	@Override
	public void modify(Map<?, ?> param) {
		
	}
	@Override
	public void remove(MemberBean member) {
		
	}
	@Override
	public boolean login(MemberBean member) {
		return false;
	}
	
	
	
}
