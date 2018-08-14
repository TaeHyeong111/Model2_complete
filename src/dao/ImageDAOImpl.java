package dao;

import java.util.List;
import java.util.Map;

import domain.ImageBean;

public class ImageDAOImpl implements ImageDAO{
	private static ImageDAO instance = new ImageDAOImpl();
	public static ImageDAO getInstance() {return instance;}
	private ImageDAOImpl() {}
	@Override
	public List<ImageBean> insert(Map<?, ?> param) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
