package models.enums;

import com.avaje.ebean.annotation.EnumValue;

/**
 * Created by RENT on 2016-06-14.
 */
public enum RentalStatus {

    @EnumValue("RETURNED")
    RETURNED,

    @EnumValue("NOT_RETURNED")
    NOT_RETURNED,
}
