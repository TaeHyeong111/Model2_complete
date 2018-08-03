package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	public void insertMember(MemberBean member) {
		try {
			DatabaseFactory.createDatabase(
					Vendor.ORACLE, 
					DBConstant.USERNAME, 
					DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeUpdate(
							String.format(MemberQuery.INSERT_MEMBER.toString(),
						              member.getUserId(),
						              member.getPassword(), 
						              member.getSsn(),
						              member.getName(),
						              member.getTeamId(),
						              member.getAge(),
						              member.getRoll(),
						              member.getGender()));
		} catch (Exception e) {   
			e.printStackTrace();
		}
	}
	
	@Override
	public List<MemberBean> selectAllmemberList() {
		List<MemberBean> lst = new ArrayList<>();
		try {
			ResultSet rs = DatabaseFactory.createDatabase(
					Vendor.ORACLE, DBConstant.USERNAME,DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(MemberQuery.SELECT_ALL.toString());
			MemberBean mem =null;
			while(rs.next()) {
				mem = new MemberBean();
				mem.setUserId(rs.getString("USERID"));
				mem.setTeamId(rs.getString("TEAMID"));
				mem.setName(rs.getString("NAME"));
				mem.setAge(rs.getString("AGE"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setSsn(rs.getString("SSN"));
				mem.setGender(rs.getString("GENDER"));
				lst.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}
	@Override
	public List<MemberBean> selectMemberBySearchWord(String word) {
		System.out.println(word);
		QueryTemplate q = new PstmtQuery();
		List<MemberBean> list = new ArrayList<>();
		HashMap<String,Object> map = new HashMap<>();
		map.put("column", word.split("/")[0]);
		map.put("value", word.split("/")[1]);
		map.put("table", Domain.MEMBER);
		q.play(map);
		for(Object s: q.getList()) {
			list.add((MemberBean)s);
		}
		return list;
		
		/*List<MemberBean> lst = new ArrayList<>();
		try {
			ResultSet rs = DatabaseFactory.createDatabase(
					Vendor.ORACLE, DBConstant.USERNAME,DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(String.format(MemberQuery.SELECT_SOME.toString(),
							word.split("/")[0],word.split("/")[1]));
			MemberBean mem =null;
			while(rs.next()) {
				mem = new MemberBean();
				mem.setUserId(rs.getString("MEM_ID"));
				mem.setTeamId(rs.getString("TEAM_ID"));
				mem.setName(rs.getString("NAME"));
				mem.setAge(rs.getString("AGE"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setSsn(rs.getString("SSN"));
				mem.setGender(rs.getString("GENDER"));
				lst.add(mem);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("리이스트"+lst);
		return lst;
		*/
	}
	@Override
	public int countMember() {
		int count = 0;
		try {
/*			Class.forName(DBConstant.ORACLE_DRIVER);
			Connection conn = DriverManager.getConnection(DBConstant.CONNECTION_URL, DBConstant.USERNAME, DBConstant.PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("");*/
			ResultSet rs =  DatabaseFactory.createDatabase(
					Vendor.ORACLE, 
					DBConstant.USERNAME, 
					DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(String.format(MemberQuery.COUNT_MEMBER.toString()));
						
			while(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return count;
	}
	@Override
	public MemberBean selectFindById(String id) {
		MemberBean member = null;
		try {
			System.out.println("이건 아이디:"+id);
			ResultSet rs = DatabaseFactory.createDatabase(
					Vendor.ORACLE, 
					DBConstant.USERNAME, 
					DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(
							String.format(MemberQuery.FINDBYID.toString(),
						              id));

			while(rs.next()) {
				member = new MemberBean();
                member.setUserId(rs.getString("USERID"));
                member.setTeamId(rs.getString("TEAMID"));
                member.setName(rs.getString("NAME"));
                member.setAge(rs.getString("AGE"));
                member.setRoll(rs.getString("ROLL"));
                member.setPassword(rs.getString("PASSWORD"));
                member.setSsn(rs.getString("SSN"));
                member.setGender(rs.getString("GENDER"));
                }
			System.out.println("나아는 멤버어야"+member);
		} catch (Exception e) {   
			e.printStackTrace();
		}
	return member;
	}
	@Override
	public void updateMemberInformation(MemberBean member) {
		try {
		DatabaseFactory.createDatabase(
				Vendor.ORACLE, 
				DBConstant.USERNAME, 
				DBConstant.PASSWORD)
				.getConnection()
				.createStatement()
				.executeUpdate(
						String.format(MemberQuery.UPDATE_MEMBER.toString(),
								member.getPassword(),member.getTeamId(),member.getRoll(),member.getUserId()));		
		
		} catch (Exception e) {  
			e.printStackTrace();
		}
	}
	@Override
	public void deleteMemberInformation(MemberBean member) {
		System.out.println("나는 딜리트의 멤버야"+member);
		try {
			DatabaseFactory.createDatabase(
					Vendor.ORACLE, 
					DBConstant.USERNAME, 
					DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeUpdate(String.format(
							MemberQuery.DELETE_MEMBER.toString(),member.getUserId(),member.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	@Override
	public MemberBean login(MemberBean member) {
		MemberBean m = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(
					Vendor.ORACLE, 
					DBConstant.USERNAME, 
					DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(
							String.format(MemberQuery.LOGIN.toString(),
						              member.getUserId(),member.getPassword()));
			System.out.println("겟 아이디 패스워드"+member.getUserId()+ member.getPassword());
			while(rs.next()) {
				m = new MemberBean();
                m.setUserId(rs.getString("USERID"));
                m.setTeamId(rs.getString("TEAMID"));
                m.setName(rs.getString("NAME"));
                m.setSsn(rs.getString("SSN"));                
                m.setRoll(rs.getString("ROLL"));
                m.setPassword(rs.getString("PASSWORD"));
                m.setAge(rs.getString("AGE"));
                m.setGender(rs.getString("GENDER"));
                m.setSubject(rs.getString("SUBJECT"));
                System.out.println("엠점갯패스워드"+m.getPassword());
                }
			System.out.println("엠"+m);
		} catch (Exception e) {   
			e.printStackTrace();
		}
	return m;
	}
	
}
