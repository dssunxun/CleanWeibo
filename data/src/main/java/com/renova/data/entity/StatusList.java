package com.renova.data.entity;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 微博列表结构。
 * Created by Renova on 2016/3/9.
 */
public class StatusList {

    /** 微博列表 */
    private ArrayList<Status> statusList;
    private Status statuses;
    private boolean hasvisible;
    private String previous_cursor;
    private String next_cursor;
    private int total_number;
    private Object[] advertises;

    public ArrayList<Status> getStatusList() {
        return statusList;
    }

    public void setStatusList(ArrayList<Status> statusList) {
        this.statusList = statusList;
    }

    public Status getStatuses() {
        return statuses;
    }

    public void setStatuses(Status statuses) {
        this.statuses = statuses;
    }

    public boolean isHasvisible() {
        return hasvisible;
    }

    public void setHasvisible(boolean hasvisible) {
        this.hasvisible = hasvisible;
    }

    public String getPrevious_cursor() {
        return previous_cursor;
    }

    public void setPrevious_cursor(String previous_cursor) {
        this.previous_cursor = previous_cursor;
    }

    public String getNext_cursor() {
        return next_cursor;
    }

    public void setNext_cursor(String next_cursor) {
        this.next_cursor = next_cursor;
    }

    public int getTotal_number() {
        return total_number;
    }

    public void setTotal_number(int total_number) {
        this.total_number = total_number;
    }

    public Object[] getAdvertises() {
        return advertises;
    }

    public void setAdvertises(Object[] advertises) {
        this.advertises = advertises;
    }

    @Override
    public String toString() {
        return "StatusList{" +
                "statusList=" + statusList +
                ", statuses=" + statuses +
                ", hasvisible=" + hasvisible +
                ", previous_cursor='" + previous_cursor + '\'' +
                ", next_cursor='" + next_cursor + '\'' +
                ", total_number=" + total_number +
                ", advertises=" + Arrays.toString(advertises) +
                '}';
    }
}
