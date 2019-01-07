package sc.whorl.logic.service.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import sc.whorl.logic.domain.dao.system.MenuMapper;
import sc.whorl.logic.domain.model.system.Menu;
import sc.whorl.logic.domain.model.system.ext.ExtMenu;
import sc.whorl.logic.pojo.system.ChildMenuInfo;
import sc.whorl.logic.pojo.system.MenuInfo;
import sc.whorl.system.commons.base.BaseService;
import sc.whorl.system.config.springsecurity.utils.UserAuthInfoUtils;
import sc.whorl.system.utils.ScUtils;
import sc.whorl.system.utils.mapper.BeanMapper;

/**
 * 菜单相关管理服务
 *
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
@Slf4j
public class MenuService extends BaseService<MenuMapper, Menu> {
    @Autowired
    private MenuMapper menuMapper;

    public List<MenuInfo> getMenu() {
        List<MenuInfo> menuInfos = new ArrayList<>();
        if (!ScUtils.isEmpty(UserAuthInfoUtils.getUserId())) {
            List<ExtMenu> menuList = menuMapper.selectMenuByUserId(UserAuthInfoUtils.getUserId());
            if (!ScUtils.isEmpty(menuList)) {
                Map<Long, MenuInfo> parMenuInfo = new HashMap<>();
                for (ExtMenu menu : menuList) {
                    if (parMenuInfo.containsKey(menu.getParnetId())) {
                        MenuInfo menuInfo = parMenuInfo.get(menu.getParnetId());
                        menuInfo.getChildMenuList().add(BeanMapper.map(menu, ChildMenuInfo.class));
                    } else {
                        MenuInfo menuInfo = new MenuInfo();
                        menuInfo.setParentId(menu.getParnetId());
                        menuInfo.setParentMenuName(menu.getParentMenuName());
                        menuInfo.setChildMenuList(ScUtils.transList(BeanMapper.map(menu, ChildMenuInfo.class)));
                        parMenuInfo.put(menu.getParnetId(), menuInfo);
                    }
                }
                menuInfos.addAll(parMenuInfo.values());
            }
        }
        return menuInfos;
    }
}
