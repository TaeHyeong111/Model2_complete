package template;

import java.sql.SQLException;

import domain.ImageBean;
import enums.*;
import factory.DatabaseFactory;

public class ImageSql extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", String.format(ImageQuery.INSERT.toString()));
	}

	@Override
	void startPlay() {
		try {
			pstmt.setString(1, ((ImageBean) map.get("Image")).getImgName());
			pstmt.setString(2, ((ImageBean) map.get("Image")).getExtension());
			pstmt.setString(3, ((ImageBean) map.get("Image")).getUserid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
