package com.alex.blog.api.result;

import java.util.List;

import com.alex.blog.api.domain.User;
import com.alex.common.utils.BasicPageResult;

public class UserPageResult extends BasicPageResult<User> {

  public UserPageResult(List<User> data) {
    super(data);
  }

}