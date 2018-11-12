package com.battery.service.impl;

import com.battery.entity.Admin;
import com.battery.mapper.AdminMapper;
import com.battery.service.IAdminService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author ellen
 * @since 2018-11-01
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {
	
}
