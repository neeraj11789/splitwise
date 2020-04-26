package com.springboot.mini.service;

import com.springboot.mini.model.User;
import com.springboot.mini.service.UserService;
import com.springboot.mini.service.impl.MemoryUserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserServiceTest {

  UserService service;

  @BeforeEach
  void setUp() {
    service = new MemoryUserServiceImpl();
  }

  @Test
  void test_success_for_create_and_find() {
    Long mobile = 9887898777L;

    User u = service.findByMobile(mobile);
    Assertions.assertThat(u).isNull();

    User u1 = new User("Neeraj", "neeraj11@g.com", mobile);
    service.create(u1);
    u = service.findByMobile(mobile);
    Assertions.assertThat(u).isNotNull().isInstanceOf(User.class);

  }
}