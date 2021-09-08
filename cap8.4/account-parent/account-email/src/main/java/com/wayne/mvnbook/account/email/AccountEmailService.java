package com.wayne.mvnbook.account.email;

/**
 * @author wayne
 */
public interface AccountEmailService {

    /**
     * 发送邮件
     * @param to 收件人
     * @param subject 邮件主题
     * @param htmlText  邮件内容
     * @throws AccountEmailException 发送邮件出错抛出的异常
     */
    void sendMail( String to, String subject, String htmlText ) throws AccountEmailException;
}
