package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.MemberBean;
import template.AddQuery;
import template.PstmtQuery;
import template.QueryTemplate;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	private MemberDAOImpl() {}
	private QueryTemplate q;
	@Override
	public void insert(MemberBean member) {
		q = new AddQuery();
		Map<?,?> param = new HashMap<>();
		param.put("insert", member);
		q.play(param);
	}
	@Override
	public List<MemberBean> selectSome(Map<?, ?> param) {
		
        return null;
	}
	@Override
	public MemberBean selectOne(String id) {
		return null;
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
		return null;
	}
	
}
