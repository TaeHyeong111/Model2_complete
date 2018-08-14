package dao;

import java.util.List;
import java.util.Map;

import domain.ImageBean;

public interface ImageDAO {
	public List<ImageBean> insert(Map<?,?>param);
}
