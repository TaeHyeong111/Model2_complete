package template;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import enums.Vendor;
import lombok.Data;
import pool.DBConstant;
@Data
public abstract class QueryTemplate {
	HashMap<String,Object>map;
	List<Object> list;
	PreparedStatement pstmt;
	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();
   
	   public final void play(HashMap<String,Object>map){ //final을 붙이면 private처럼 수정이 불가함
	   this.pstmt = null;
	   this.list = new ArrayList<>();
	   this.map = map;
	   this.map.put("vendor", Vendor.ORACLE);
	   this.map.put("username", DBConstant.USERNAME);
	   this.map.put("password", DBConstant.PASSWORD);
	   initialize();
	   startPlay();
	   endPlay();
   }
   
}
// PreparedStatement 준비된 스테이트먼트라 빠름 (Prepared:준비됨)
