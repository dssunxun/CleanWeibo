package com.renova.data.entity;

/**
 * 微博可见性结构体。
 * Created by Renova on 2016/3/9.
 */
public class Visible {
    public static final int VISIBLE_NORMAL  = 0;
    public static final int VISIBLE_PRIVACY = 1;
    public static final int VISIBLE_GROUPED = 2;
    public static final int VISIBLE_FRIEND  = 3;

    /** type 取值，0：普通微博，1：私密微博，3：指定分组微博，4：密友微博 */
    public int type;
    /** 分组的组号 */
    public int list_id;
}
