package org.junwoo.coding.assignment1.global.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Response<T> {

  private String msg;
  private T data;

  public static <T> Response<T> ok(final T data) {
    return new Response<>("success", data);
  }

}
