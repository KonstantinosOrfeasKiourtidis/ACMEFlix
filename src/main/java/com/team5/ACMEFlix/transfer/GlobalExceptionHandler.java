package com.team5.ACMEFlix.transfer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String URI_PATH_STR = "uri=";

//    @ExceptionHandler(Exception.class)
//    public final ResponseEntity<?> handleException(final Exception ex, final WebRequest webRequest){
//        return new ResponseEntity<>(ApiResponse.builder().apiError(getApiError(ex, HttpStatus.INTERNAL_SERVER_ERROR, webRequest, "General Error")).build(),   HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<?> handleValidException(final Exception ex, final WebRequest webRequest){
        return new ResponseEntity<>(ApiResponse.builder().apiError(getApiError(ex, HttpStatus.BAD_REQUEST, webRequest, null)).build(),  HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(IllegalStateException.class)
    public final ResponseEntity<ApiResponse<?>> handleIllegalStateException(final Exception ex, final WebRequest webRequest){
        return new ResponseEntity<>(ApiResponse.builder().apiError(getApiError(ex, HttpStatus.BAD_REQUEST, webRequest, null)).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<ApiResponse<?>> handleNotFoundException(final Exception ex, final WebRequest webRequest){
        return new ResponseEntity<>(ApiResponse.builder().apiError(getApiError(ex, HttpStatus.NOT_FOUND, webRequest, null)).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public final ResponseEntity<ApiResponse<?>> handleNoSuchElementException(final Exception ex, final WebRequest webRequest){
        return new ResponseEntity<>(ApiResponse.builder().apiError(getApiError(ex, HttpStatus.NOT_FOUND, webRequest, null)).build(), HttpStatus.NOT_FOUND);
    }


    private ApiError getApiError(final Exception ex, final  HttpStatus httpStatus, final WebRequest webRequest, String customMessage){
        String path = webRequest.getDescription(false);

        if(path.indexOf(URI_PATH_STR) == 0){
            path = StringUtils.replace(path, URI_PATH_STR, "");
        }
        return new ApiError(httpStatus.value(), customMessage != null ? customMessage : ex.getMessage(), path);
    }
}
