package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.MemberBean;
import template.AddQuery;
import template.LoginQuery;
import template.PstmtQuery;
import template.QueryTemplate;
import template.RetrieveQuery;
import template.SearchQuery;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	private MemberDAOImpl() {}
	private QueryTemplate q;
	@Override
	public void insert(MemberBean member) {
		q = new AddQuery();
		Map<String,Object> param = new HashMap<>();
		param.put("insert", member);
		q.play(param);
	}
	@Override
	public List<MemberBean> selectSome(Map<?, ?> param) {
		List<MemberBean> list = new ArrayList<>();
		q = new SearchQuery();
		q.play(param);
		for(Object s : q.getList()) {
			list.add((MemberBean)s);
		}
        return list;
	}
	@Override
	public MemberBean selectOne(String id) {
		System.out.println("셀렉트원들어옴");
		Map<String, Object> param = new HashMap<>();
		q = new RetrieveQuery();
		param.put("searchWord", id);
		q.play(param);
		return q.getMem();
	}
	@Override
	public int count() {
		q = new PstmtQuery();
		HashMap<String,Object> map = new HashMap<>();
		map.put("flag", "count");
		q.play(map);
		int count = 0;
		for(Object s: q.getList()) {
			count = (int)s;
        }
		return count;
	}
	@Override
	public void update(Map<?, ?> param) {
		
	}
	@Override
	public void delete(MemberBean member) {
		
	}
	@Override
	public MemberBean login(MemberBean member) {
		q = new LoginQuery();
		Map<String,Object> param = new HashMap<>();
		param.put("mem", member);
		q.play(param);
		return (MemberBean) q.getO();
	}
	
}
