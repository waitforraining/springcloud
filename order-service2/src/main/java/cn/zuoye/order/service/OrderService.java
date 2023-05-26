package cn.zuoye.order.service;

import cn.zuoye.order.mapper.OrderMapper;
import cn.zuoye.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 4.返回
        return order;
    }
    public List<Order> getAllOrder(){
        return orderMapper.getAllOrders();
    }

    public boolean deleteOrder(Long orderId){
        if(orderMapper.deleteOrderById(orderId)) return true;
        else return false;
    }

    public boolean addOrder(Order order){
        if(orderMapper.addOrder(order)) return true;
        else return false;
    }

}
