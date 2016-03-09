package com.renova.data.entity;

import java.util.ArrayList;

/**
 * 微博列表结构。
 * Created by Renova on 2016/3/9.
 */
public class StatusList {

    /** 微博列表 */
    public ArrayList<Status> statusList;
    public Status statuses;
    public boolean hasvisible;
    public String previous_cursor;
    public String next_cursor;
    public int total_number;
    public Object[] advertises;
}
