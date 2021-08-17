package com.meowu.commons.utils.domain;

import java.util.Date;

public interface Deletable{

    Date getDeleteTime();

    void setDeleteTime(Date deleteTime);

    Boolean getDeleted();

    void setDeleted(Boolean deleted);
}
