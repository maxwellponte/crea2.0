package br.com.nestec.crea20.annotacion;

import org.aspectj.lang.annotation.Around;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface UserActive {
}
