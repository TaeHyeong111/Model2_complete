package template;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import enums.Vendor;
import lombok.Data;
import pool.DBConstant;
@Data
public abstract class QueryTemplate { //abstract 추상
	HashMap<String,Object>map;
	List<Object> list;
	PreparedStatement pstmt;
	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();
   
	   public final void play(HashMap<String,Object>map){ 
		   System.out.println("11.QueryTemPlete진입");
	   this.pstmt = null;
	   this.list = new ArrayList<>();
	   this.map = map;
	   this.map.put("vendor", Vendor.ORACLE);
	   this.map.put("username", DBConstant.USERNAME);
	   this.map.put("password", DBConstant.PASSWORD);
	   System.out.println("12. map : "+this.map);
	   initialize();
	   startPlay();
	   endPlay();
   }
   
}
// PreparedStatement 준비된 스테이트먼트라 빠름 (Prepared:준비됨)
