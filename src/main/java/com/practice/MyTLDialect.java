package com.practice;

import org.springframework.stereotype.Component;
import org.thymeleaf.context.IProcessingContext;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionEnhancingDialect;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JunyaShirahama on 2018/01/23.
 */
@Component
public class MyTLDialect extends AbstractDialect implements IExpressionEnhancingDialect {

    private static final Map<String, Object> EXPRESSION_OBJECTS;

    static {
        HashMap<String, Object> objects = new HashMap<>();
        objects.put("myTLHelper", new MyTLUtility());
        EXPRESSION_OBJECTS = Collections.unmodifiableMap(objects);
    }

    public MyTLDialect() {
        super();
    }

    @Override
    public Map<String, Object> getAdditionalExpressionObjects(IProcessingContext processingContext) {
        return EXPRESSION_OBJECTS;
    }

    @Override
    public String getPrefix() {
        return null;
    }
}
