package cn.appsys.service.developer;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.Promotion.PromotionMapper;
@Service
public class PromotionServiceImpl implements  PromotionService {
	@Resource
	private PromotionMapper promotionMapper;
}
