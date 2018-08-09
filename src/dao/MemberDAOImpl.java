package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.MemberBean;
import enums.Domain;
import enums.MemberQuery;
import enums.Vendor;
import factory.DatabaseFactory;
import pool.DBConstant;
import template.PstmtQuery;
import template.QueryTemplate;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	private MemberDAOImpl() {}
	@Override
	public void insert(MemberBean member) {
		
	}
	@Override
	public List<MemberBean> selectSome(Map<?, ?> param) {
		System.out.println("8.DAOimpl(selectSome)진입");
		System.out.println("9.selectSome param : " + param);
		QueryTemplate q = new PstmtQuery();
        List<MemberBean> list = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("beginRow", param.get("beginRow"));
        map.put("endRow", param.get("endRow"));
        map.put("flag", "list");
        System.out.println("10.map : "+map);
        q.play(map);
        for(Object s: q.getList()) {
            list.add((MemberBean)s);
        }
        System.out.println("16.리스트 : "+list);
        System.out.println("큐리스트 : "+q.getList());
        return list;
	}
	@Override
	public MemberBean selectOne(String id) {
		return null;
	}
	@Override
	public int count() {
		QueryTemplate q = new PstmtQuery();
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
