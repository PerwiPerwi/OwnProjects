package models.enums;

import com.avaje.ebean.annotation.EnumValue;

/**
 * Created by RENT on 2016-06-11.
 */
public enum AccountRole {
    @EnumValue("ADMIN")
    ADMIN,

    @EnumValue("USER")
    USER,
}
