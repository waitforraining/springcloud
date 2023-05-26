package cn.zuoye.order.mapper;

import cn.zuoye.order.pojo.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import java.util.List;

public interface OrderMapper {

    @Select("select * from tb_order where id = #{id}")
    Order findById(Long id);

    @Select("select * from tb_order")
    List<Order> getAllOrders();

    @Insert("insert into tb_order(user_id,name,price,num)\n" +
            "values(#{userId},#{name},#{price},#{num}) ")
    boolean addOrder(Order order);

    @Delete("delete from tb_order where id = #{orderId}")
    boolean deleteOrderById(Long orderId);

}
