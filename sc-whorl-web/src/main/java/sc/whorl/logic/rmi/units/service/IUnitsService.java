package sc.whorl.logic.rmi.units.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sc.whorl.logic.rmi.units.response.UnitsResponse;


/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public interface IUnitsService {
    @RequestMapping(value = "/invoke", method = RequestMethod.POST)

    public UnitsResponse invoke();
}
