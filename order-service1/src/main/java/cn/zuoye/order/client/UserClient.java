package cn.zuoye.order.client;

import cn.zuoye.order.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="user-service",path="/user",url="http://localhost:8081")
public interface UserClient {
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id);

}
