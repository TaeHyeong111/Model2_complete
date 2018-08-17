package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.ImageBean;
import template.ImageQuery;
import template.QueryTemplate;

public class ImageDAOImpl implements ImageDAO{
	private static ImageDAO instance = new ImageDAOImpl();
	public static ImageDAO getInstance() {return instance;}
	private ImageDAOImpl() {}
	QueryTemplate q;
	Map<String,Object> param = new HashMap<>();
	@Override
	public void insert(ImageBean bean) {
		q = new ImageQuery();
		param.put("Image", bean);
		q.play(param);
		
	}
	
}
