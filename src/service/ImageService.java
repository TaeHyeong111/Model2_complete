package service;

import java.util.List;
import java.util.Map;

import domain.ImageBean;

public interface ImageService {
	public List<ImageBean> add(Map<String,Object>param);
}
