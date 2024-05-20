package org.junwoo.coding.assignment1.global.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class Response<T> {

  private String msg;
  private T data;

  public static <T> Response<T> ok(final T data) {
    return new Response<>("success", data);
  }

}
