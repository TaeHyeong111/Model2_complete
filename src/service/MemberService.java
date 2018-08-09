package service;
import java.util.List;
import java.util.Map;

import domain.MemberBean;

public interface MemberService {
	public void add(MemberBean member);
	public List<MemberBean> search(Map<?,?>param);      //<?,?> 와일드카드(one의 의미) *는 all의 의미
	public MemberBean retreieve(String id);
	public int Count();
	public void modify(Map<?,?>param);
	public void remove(MemberBean member);
	public boolean login(MemberBean member);
	
}