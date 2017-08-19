package org.tvos.exception;

/**
 * 上传图片异常（运行期异常）
 */
public class UploadException extends RuntimeException {

    /**
     * 上传异常
     * @param message
     */
    public UploadException(String message) {
        super(message);
    }

    public UploadException(String message, Throwable cause) {
        super(message, cause);
    }
}
