package com.dharbor.talent.managervacations.common;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Component
@AllArgsConstructor
public class Message {
    private final ResourceBundleMessageSource messageSource;
    public String decodeText (String input, Charset charset,
                              CodingErrorAction codingErrorAction) throws IOException {

        CharsetDecoder charsetDecoder = charset.newDecoder();
        charsetDecoder.onMalformedInput(codingErrorAction);

        return new BufferedReader(
                new InputStreamReader(
                new ByteArrayInputStream(input.getBytes()), charsetDecoder)) .readLine();

    }

    public String getMessage(String code){
        try{
            return decodeText(
                    messageSource.getMessage(code, null, LocaleContextHolder.getLocale()),
                    StandardCharsets.US_ASCII, CodingErrorAction.IGNORE
            );
        }catch (IOException ex){
            return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
        }
    }

    public String getMessage(MessageSourceResolvable resolvable){
        return messageSource.getMessage(resolvable, LocaleContextHolder.getLocale());
    }
}
