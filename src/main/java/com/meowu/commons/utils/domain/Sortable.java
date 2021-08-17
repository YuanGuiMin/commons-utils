package com.meowu.commons.utils.domain;

public interface Sortable extends Comparable{

    Integer getOrder();

    void setOrder(Integer order);
}
