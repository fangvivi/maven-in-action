package com.wayne.mvnbook.account.email;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author wayne
 */
public class AccountEmailServiceImpl implements AccountEmailService{
    private JavaMailSender javaMailSender;

    /**
     * 发件人
     */
    private String systemEmail;
    /**
     * 发送邮件
     *
     * @param to       收件人
     * @param subject  邮件主题
     * @param htmlText 邮件内容
     * @throws AccountEmailException 发送邮件遇到的异常
     */
    @Override
    public void sendMail(String to, String subject, String htmlText) throws AccountEmailException {
        try {
            // 对应了要发送的邮件
            MimeMessage msg = javaMailSender.createMimeMessage();
            // 邮件相关设置
            MimeMessageHelper msgHelper = new MimeMessageHelper(msg);

            msgHelper.setFrom(systemEmail);
            msgHelper.setTo(to);
            msgHelper.setSubject(subject);
            msgHelper.setText(htmlText, true);

            javaMailSender.send(msg);
        } catch ( MessagingException e ) {
            throw new AccountEmailException( "Failed to send mail.", e );
        }
        }

        public JavaMailSender getJavaMailSender() {
            return javaMailSender;
        }

        public void setJavaMailSender( JavaMailSender javaMailSender ) {
            this.javaMailSender = javaMailSender;
        }

        public String getSystemEmail() {
            return systemEmail;
        }

        public void setSystemEmail( String systemEmail ) {
            this.systemEmail = systemEmail;
        }


}
