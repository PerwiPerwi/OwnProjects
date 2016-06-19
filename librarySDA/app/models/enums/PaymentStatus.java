package models.enums;

import com.avaje.ebean.annotation.EnumValue;

/**
 * Created by RENT on 2016-06-14.
 */
public enum PaymentStatus {

    @EnumValue("PAYED")
    PAYED,

    @EnumValue("NOT_PAYED")
    NOT_PAYED,
}
