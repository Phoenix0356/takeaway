package com.phoenix.takeaway.context;

public class ThreadContext {
    public static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static long getCurrentId(){
        return threadLocal.get();
    }

    public static void setCurrentId(long id){
        threadLocal.set(id);
    }

    public static void removeCurrentId(){
        threadLocal.remove();
    }

}
