package template;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.MemberBean;

import java.util.Iterator;

import enums.Vendor;
import factory.DatabaseFactory;
import lombok.Data;
import pool.DBConstant;
@Data
public abstract class QueryTemplate { //abstract 추상
	int number;
	Object o;
	List<Object> list;
	Map<String,Object> map;
	PreparedStatement pstmt;
	ResultSet rs = null;
	MemberBean mem;
	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();
   
    public final void play(Map<?, ?> param){
	   this.number = 0;
	   this.o = null;
	   this.list = new ArrayList<>();
	   this.map = new HashMap<>();
	   this.pstmt = null;
	   this.map.put("vendor", Vendor.ORACLE);
	   this.map.put("username", DBConstant.USERNAME);
	   this.map.put("password", DBConstant.PASSWORD);
	   Iterator<?> keys = param.keySet().iterator(); //keys : java.util.HashMap$KeyIterator@3bf63604
	   // param 에 담긴 key값을 모두 Iterator<?> keys 에 담음
	   while(keys.hasNext()) {
		   String key = (String) keys.next();
		   this.map.put(key, param.get(key));
	   }
	   
	   initialize();
	   pStmtInit();
	   startPlay();
	   endPlay();
   }
    public void pStmtInit() {
    	try {
			this.pstmt = DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement((String)map.get("sql"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
   
}
// PreparedStatement 준비된 스테이트먼트라 빠름 (Prepared:준비됨)
