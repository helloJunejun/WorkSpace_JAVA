package com.work.exception;

public class UserException extends Exception {
   public UserException() {
      super("사용자예외");
   }
   
   public UserException(String message) {
      super("사용자 예외 : " + message);
   }

}