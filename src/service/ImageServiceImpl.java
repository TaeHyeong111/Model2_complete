package service;

import java.util.List;
import java.util.Map;

import dao.ImageDAOImpl;
import domain.ImageBean;


public class ImageServiceImpl implements ImageService{
	private static ImageService instance = new ImageServiceImpl();
	public static ImageService getInstance() {return instance;}
	private ImageServiceImpl(){}
	@Override
	public List<ImageBean> add(Map<String, Object> param) {
		return null;
	}
	
}