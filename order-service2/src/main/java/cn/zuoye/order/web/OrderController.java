package cn.zuoye.order.web;

import cn.zuoye.order.client.UserClient;
import cn.zuoye.order.pojo.Order;
import cn.zuoye.order.pojo.User;
import cn.zuoye.order.service.OrderService;
import org.apache.ibatis.session.ResultContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

   @Autowired
   private OrderService orderService;
   @Autowired
   private UserClient userClient;
    @GetMapping("getOrder/{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        // 根据id查询订单并返回
        Order order = orderService.queryOrderById(orderId);
        Long userId = order.getUserId();
        User user = userClient.getById(userId);
        order.setUser(user);
        return order;
    }
    @GetMapping("/getAllOrder")
    public List<Order> queryAllOrder() {
        // 根据id查询订单并返回
        return orderService.getAllOrder();
    }
    @DeleteMapping("delete/{orderId}")
    public String deleteOrder(@PathVariable("orderId") Long orderId) {
        // 根据id查询订单并返回
        if(orderService.deleteOrder(orderId)) return "seccess";
        return "false";
    }
    @PostMapping("addOrder")
    public String addOrder(@RequestBody Order order){
        if(orderService.addOrder(order)) return "success";
        return "false";
    }

}
