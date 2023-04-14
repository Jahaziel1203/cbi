package com.cbi.cbi.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.cbi.cbi.models.entity.Rol;
import com.cbi.cbi.models.service.IRolService;

@Component
public class RolFormatter implements Formatter<Rol> {

    @Autowired
    private IRolService rolService;

    @Override
    public String print(Rol object, Locale locale) {
       return String.valueOf(object.getId());
    }

    @Override
    public Rol parse(String text, Locale locale) throws ParseException {
        return rolService.findById(Integer.valueOf(text));
    }
}