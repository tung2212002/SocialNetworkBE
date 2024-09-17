package com.tungong.socialnetwork.common.customException;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCode {
    POST_NOT_EXISTED(9992, "Post is not existed", HttpStatus.NOT_FOUND),
    CODE_VERIFY_INCORRECT(9993, "Code verify is incorrect", HttpStatus.BAD_REQUEST),
    NO_DATA_OR_END_OF_LIST_DATA(9994, "No Data or end of list data", HttpStatus.NOT_FOUND),
    USER_IS_NOT_VALIDATED(9995, "User is not validated", HttpStatus.FORBIDDEN),
    USER_EXISTED(9996, "User existed", HttpStatus.BAD_REQUEST),
    METHOD_IS_INVALID(9997, "Method is invalid", HttpStatus.BAD_REQUEST),
    TOKEN_IS_INVALID(9998, "Token is invalid", HttpStatus.UNAUTHORIZED),
    EXCEPTION_ERROR(9999, "Exception error", HttpStatus.INTERNAL_SERVER_ERROR),
    CAN_NOT_CONNECT_TO_DB(1001, "Can not connect to DB", HttpStatus.INTERNAL_SERVER_ERROR),
    PARAMETER_IS_NOT_ENOUGH(1002, "Parameter is not enough", HttpStatus.BAD_REQUEST),
    PARAMETER_TYPE_IS_INVALID(1003, "Parameter type is invalid", HttpStatus.BAD_REQUEST),
    PARAMETER_VALUE_IS_INVALID(1004, "Parameter value is invalid", HttpStatus.BAD_REQUEST),
    UNKNOWN_ERROR(1005, "Unknown error", HttpStatus.INTERNAL_SERVER_ERROR),
    FILE_SIZE_IS_TOO_BIG(1006, "File size is too big", HttpStatus.BAD_REQUEST),
    UPLOAD_FILE_FAILED(1007, "Upload File Failed!", HttpStatus.INTERNAL_SERVER_ERROR),
    MAXIMUM_NUMBER_OF_IMAGES(1008, "Maximum number of images", HttpStatus.BAD_REQUEST),
    NOT_ACCESS(1009, "Not access", HttpStatus.FORBIDDEN),
    ACTION_HAS_BEEN_DONE_PREVIOUSLY_BY_THIS_USER(1010, "Action has been done previously by this user", HttpStatus.BAD_REQUEST),
    RESOURCE_NOT_FOUND(1011, "Resource not found", HttpStatus.NOT_FOUND),
    NOT_FOUND(1012, "Not found", HttpStatus.NOT_FOUND),
    INVALID_REQUEST(1013, "Invalid request", HttpStatus.BAD_REQUEST),
    MAXIMUM_NUMBER_REQUEST_OTP(1014, "Maximum number request otp", HttpStatus.BAD_REQUEST),
    EMAIL_NOT_EXISTED(1015, "Email not existed", HttpStatus.BAD_REQUEST),
    AUTHENTICATION_FAILED(1016, "Password is incorrect", HttpStatus.BAD_REQUEST),
    ;


    ErrorCode(int code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    final int code;

    final String message;

    final HttpStatus httpStatus;
}
